/**
 * 
 */
package com.openthinks.goldeneye.impls.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.openthinks.goldeneye.impls.module.spider.htmlutil.HUConfig;
import com.openthinks.goldeneye.impls.module.spider.htmlutil.HUSpider;
import com.openthinks.goldeneye.module.spider.DefaultSpiderContext;
import com.openthinks.goldeneye.module.spider.Spider;
import com.openthinks.goldeneye.module.spider.SpiderContext;
import com.openthinks.goldeneye.module.spider.SpiderUrlHandler;
import com.openthinks.goldeneye.services.SpiderService;
import com.openthinks.goldeneye.utils.AppConfig;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Service
public class SpiderServiceImpl implements SpiderService {

	@Autowired
	AppConfig appConfig;

	Spider spider;

	@PostConstruct
	void initialized() {
		HUConfig config = new HUConfig();
		config.setProxyEnabled(appConfig.isNeedProxy());
		if (appConfig.isNeedProxy()) {
			config.setProxyConfig(new ProxyConfig(appConfig.getProxyHost(), appConfig.getProxyPort()));
		}
		SpiderContext context = new DefaultSpiderContext();
		context.setConfig(config);
		spider = new HUSpider(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.goldeneye.services.SpiderService#execute(com.openthinks.
	 * goldeneye.module.spider.SpiderUrlHandler)
	 */
	@Override
	public void execute(SpiderUrlHandler handler) throws Exception {
		spider.handle(handler, handler.getClass().getName());
	}

}
