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
import com.openthinks.goldeneye.core.model.MetalPriceHistory;
import com.openthinks.goldeneye.module.cache.CacheKeyer;
import com.openthinks.goldeneye.module.cache.Difference;
import com.openthinks.goldeneye.services.CacheService;
import com.openthinks.goldeneye.utils.Constants;
import com.openthinks.goldeneye.utils.Helper;
import com.openthinks.goldeneye.utils.Constants.Units;
import com.openthinks.libs.utilities.StringUtils;

/**
 * Spider for URL:
 * http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY
 * <BR>
 * 白银、铂、钯、铑的实时价格
 * 
 * @author dailey.yet@outlook.com
 *
 */
@Component
public class MetalsSpiderHandler extends AbstractKitcoSpiderHandler
		implements Difference<MetalPriceHistory>, CacheKeyer<MetalPriceHistory> {
	private static final long serialVersionUID = 6405443504588694058L;

	public static final String TARGET_URL = "http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY";

	@Autowired
	CacheService cacheService;

	@Override
	public void setCacheServeice(CacheService service) {
		this.cacheService = service;
	}

	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL(TARGET_URL);
	}

	@Override
	public String key(MetalPriceHistory model) {
		return model.getMetalCode() + "#" + model.getUnitCode();
	}

	@Override
	public boolean isDiff(MetalPriceHistory oldValue, MetalPriceHistory newValue) {
		if (oldValue == null && newValue != null) {
			return true;
		}
		if (oldValue != null && newValue == null) {
			return false;
		}
		return !Helper.isSame(oldValue.getPrice(), newValue.getPrice());
	}

	@Override
	protected void doProcessModel(DomNodeList<DomElement> trlist, Units unit, Date priceDateTime) {
		for (int i = 2; i < 6; i++) {
			DomElement element = trlist.get(i);
			try {
				MetalPriceHistory model = parseModel(element);
				model.setPriceTime(priceDateTime);
				model.setUnitCode(unit.value());
				LOG.debug("Get Metal info:{}", model);
				putCache(model);
			} catch (Exception e) {
				LOG.warn("Failed to doProcessModel in {} dom element for reason:{}", i, e);
			}
		}
	}

	void putCache(MetalPriceHistory model) {
		if (cacheService != null)
			cacheService.put(key(model), model, this);
	}

	@Override
	protected int targetTrLength() {
		return 7;
	}

	MetalPriceHistory parseModel(DomElement trElement) {
		DomNodeList<HtmlElement> tdlist = trElement.getElementsByTagName("td");
		if (tdlist == null || tdlist.size() != 4) {
			return null;
		}
		String metalName = StringUtils.trimBlank(tdlist.get(1).getTextContent());
		String price = StringUtils.trimBlank(tdlist.get(2).getTextContent());
		String change = StringUtils.trimBlank(tdlist.get(3).getTextContent());
		return new MetalPriceHistory.Builder().change(change).price(Float.valueOf(price))
				.metalCode(Constants.Metas.toMetas(metalName).value()).build();
	}
}
