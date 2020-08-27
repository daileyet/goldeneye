/**
 * 
 */
package com.openthinks.goldeneye.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openthinks.goldeneye.core.model.GoldPriceHistory;
import com.openthinks.goldeneye.core.model.MetalPriceHistory;
import com.openthinks.goldeneye.services.CacheService;
import com.openthinks.goldeneye.utils.Constants;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Controller
@RequestMapping("/s")
public class SimpleController {
	@Autowired
	CacheService cacheService;

	@RequestMapping("/index.html")
	public String index(HttpServletRequest req) {
		final List<Object> metas = new ArrayList<>();
		for (Constants.Metas meta : Constants.Metas.values()) {
			String key = meta.value() + "#" + Constants.Units.CNY_G.value();
			Object model = null;
			switch (meta) {
			case AU:
				model = cacheService.get(key);
				if (model instanceof GoldPriceHistory) {
					req.setAttribute("mainAu", model);
				}
				break;
			default:
				model = cacheService.get(key);
				if (model instanceof MetalPriceHistory) {
					metas.add(model);
				}
				break;
			}
		}
		req.setAttribute("otherMetas", metas);
		return "index";
	}

}
