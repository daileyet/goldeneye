/**
 * 
 */
package com.openthinks.goldeneye.impls.module.spider.handler.kitco;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.openthinks.goldeneye.core.model.GoldPriceHistory;
import com.openthinks.goldeneye.module.cache.CacheKeyer;
import com.openthinks.goldeneye.module.cache.Difference;
import com.openthinks.goldeneye.services.CacheService;
import com.openthinks.goldeneye.utils.Helper;
import com.openthinks.goldeneye.utils.Constants.Metas;
import com.openthinks.goldeneye.utils.Constants.Units;
import com.openthinks.libs.utilities.StringUtils;

/**
 * Spider for
 * URL:http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=GoldSpotPrice
 * <BR>
 * 黄金的实时价格
 * 
 * @author dailey.yet@outlook.com
 *
 */
@Component
public class GoldSpiderHandler extends AbstractKitcoSpiderHandler
		implements Difference<GoldPriceHistory>, CacheKeyer<GoldPriceHistory> {
	private static final long serialVersionUID = 2834220105598537465L;
	public static final String TARGET_URL = "http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=GoldSpotPrice";
	@Autowired
	CacheService cacheService;

	@Override
	public void setCacheServeice(CacheService service) {
		this.cacheService = service;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.goldeneye.module.spider.SpiderUrlHandler#getUrl()
	 */
	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL(TARGET_URL);
	}

	@Override
	protected int targetTrLength() {
		return 8;
	}

	@Override
	protected void doProcessModel(DomNodeList<DomElement> trlist, Units unit, Date priceDateTime) {
		GoldPriceHistory model = new GoldPriceHistory.Builder().unitCode(unit.value()).priceTime(priceDateTime).build();
		// 买入/卖出
		DomElement domElement = trlist.get(2);
		DomNodeList<HtmlElement> tdlist = domElement.getElementsByTagName("td");
		String buyPrice = StringUtils.trimBlank(tdlist.get(2).getTextContent());
		model.setBuyPrice(Float.valueOf(buyPrice));
		String sellPrice = StringUtils.trimBlank(tdlist.get(3).getTextContent());
		model.setSellPrice(Float.valueOf(sellPrice));

		// 最低/最高
		domElement = trlist.get(3);
		tdlist = domElement.getElementsByTagName("td");
		String lowest = StringUtils.trimBlank(tdlist.get(2).getTextContent());
		model.setLowestPrice(Float.valueOf(lowest));
		String highest = StringUtils.trimBlank(tdlist.get(3).getTextContent());
		model.setHighestPrice(Float.valueOf(highest));

		// 变动
		domElement = trlist.get(4);
		tdlist = domElement.getElementsByTagName("td");
		String change = StringUtils.trimBlank(tdlist.get(2).getTextContent());
		model.setChange(change);
		String changePercent = StringUtils.trimBlank(tdlist.get(3).getTextContent());
		model.setChangePercent(changePercent);

		// 30日变动
		domElement = trlist.get(5);
		tdlist = domElement.getElementsByTagName("td");
		String monChange = StringUtils.trimBlank(tdlist.get(2).getTextContent());
		model.setMonChange(monChange);
		String monChangePercent = StringUtils.trimBlank(tdlist.get(3).getTextContent());
		model.setMonChangePercent(monChangePercent);

		// 1年变动
		domElement = trlist.get(6);
		tdlist = domElement.getElementsByTagName("td");
		String yearChange = StringUtils.trimBlank(tdlist.get(2).getTextContent());
		model.setYearChange(yearChange);
		String yearChangePercent = StringUtils.trimBlank(tdlist.get(3).getTextContent());
		model.setYearChangePercent(yearChangePercent);
		LOG.debug("Get Gold info:{}", model);
		putCache(model);
	}

	void putCache(GoldPriceHistory model) {
		if (cacheService != null)
			cacheService.put(key(model), model, this);
	}

	@Override
	public String key(GoldPriceHistory model) {
		return Metas.AU.value() + "#" + model.getUnitCode();
	}

	@Override
	public boolean isDiff(GoldPriceHistory oldValue, GoldPriceHistory newValue) {
		if (oldValue == null && newValue != null) {
			return true;
		}
		if (oldValue != null && newValue == null) {
			return false;
		}
		return !(Helper.isSame(oldValue.getBuyPrice(), newValue.getBuyPrice())
				&& Helper.isSame(oldValue.getSellPrice(), newValue.getSellPrice()));
	}

}
