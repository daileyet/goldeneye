package com.openthinks.goldeneye.impls.module.spider.handler.kitco;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.openthinks.goldeneye.impls.module.spider.htmlutil.HUSpiderResponse;
import com.openthinks.goldeneye.module.cache.CacheSupported;
import com.openthinks.goldeneye.module.spider.SpiderResponse;
import com.openthinks.goldeneye.module.spider.SpiderUrlHandler;
import com.openthinks.goldeneye.utils.Constants;
import com.openthinks.goldeneye.utils.Constants.Units;
import com.openthinks.libs.utilities.DateFormatUtil;
import com.openthinks.libs.utilities.DateUtils;
import com.openthinks.libs.utilities.StringUtils;

public abstract class AbstractKitcoSpiderHandler implements SpiderUrlHandler, CacheSupported {
	public static final String DATEFORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	protected Logger LOG = LoggerFactory.getLogger(getClass());

	@Override
	public void process(SpiderResponse resp) {
		if (resp instanceof HUSpiderResponse) {
			try {
				doPorcess(((HUSpiderResponse) resp).getPage());
			} catch (Exception e) {
				LOG.error("Failed to process response:{} for reason:{}", resp, e);
			}
		} else {
			doProcess(resp.getContentAsString());
		}
	}

	protected void doProcess(String contentAsString) {
		// TODO Auto-generated method stub
	}

	/**
	 * process {@link HtmlPage}
	 * 
	 * @param page
	 *            {@link Page}
	 * @throws Exception
	 */
	protected void doPorcess(Page page) throws Exception {
		if (!page.isHtmlPage()) {
			doProcess(page.getWebResponse().getContentAsString());
			return;
		}
		HtmlPage htmlPage = (HtmlPage) page;
		DomNodeList<DomElement> trlist = htmlPage.getElementsByTagName("tr");
		if (trlist == null || trlist.size() != targetTrLength()) {
			LOG.warn("Illegal dom element size for tr when process page.");
			return;
		}
		final Units unit = parseUnit(getUnitDomElement(trlist));
		Date priceDateTime = null;
		DomElement domTr=null;
		try {
			domTr = getPriceTimeDomElement(trlist);
			priceDateTime = parsePriceTime(domTr);
		} catch (Exception e) {
			LOG.error("Failed to parse price time:{} for reason:{}, go to use current machine time", domTr, e);
			priceDateTime=DateUtils.now();
		}
		doProcessModel(trlist, unit, priceDateTime);
	}

	/**
	 * get {@link DomElement} which contain unit
	 * 
	 * @param trlist
	 *            {@link DomNodeList}
	 * @return {@link DomElement}
	 */
	protected DomElement getUnitDomElement(DomNodeList<DomElement> trlist) {
		return trlist.get(0);
	}

	/**
	 * get {@link DomElement} which contain price time
	 * 
	 * @param trlist
	 *            {@link DomNodeList}
	 * @return {@link DomElement}
	 */
	protected DomElement getPriceTimeDomElement(DomNodeList<DomElement> trlist) {
		return trlist.get(trlist.size() - 1);
	}

	/**
	 * get target DOM element tr length
	 * 
	 * @return DOM element tr length
	 */
	protected abstract int targetTrLength();

	/**
	 * process and create data model from DOM elements
	 * 
	 * @param trlist
	 *            {@link DomNodeList}
	 * @param unit
	 *            {@link Units}
	 * @param priceDateTime
	 *            {@link Date}
	 */
	protected abstract void doProcessModel(DomNodeList<DomElement> trlist, Units unit, Date priceDateTime);

	protected Date parsePriceTime(DomElement lastTrElement) throws ParseException {
		Date priceDateTime = null;
		String priceTime = StringUtils.trimBlank(lastTrElement.getTextContent());
		DateFormat dateFormat = DateFormatUtil.getDateFormat(DATEFORMAT_PATTERN, DateUtils.getTimeZone());
		String[] splitTimes = StringUtils.trimBlank(priceTime).split(" ");
		priceDateTime = dateFormat.parse(splitTimes[0] + " " + splitTimes[1]);
		return priceDateTime;
	}

	protected Units parseUnit(DomElement firstTrElement) {
		Units unit = null;
		String unitDisplayName = StringUtils.trimBlank(firstTrElement.getTextContent());
		unit = Constants.Units.toUnits(unitDisplayName);
		return unit;
	}

}