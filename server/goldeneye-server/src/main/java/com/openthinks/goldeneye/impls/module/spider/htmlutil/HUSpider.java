/**
 * 
 */
package com.openthinks.goldeneye.impls.module.spider.htmlutil;

import java.net.MalformedURLException;
import java.net.URL;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.openthinks.goldeneye.module.spider.DefaultSpiderContext;
import com.openthinks.goldeneye.module.spider.Spider;
import com.openthinks.goldeneye.module.spider.SpiderContext;
import com.openthinks.goldeneye.module.spider.SpiderHandler;
import com.openthinks.goldeneye.module.spider.SpiderResponse;
import com.openthinks.goldeneye.module.spider.SpiderUrlHandler;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class HUSpider implements Spider {
	private volatile WebClient webClient;
	private final SpiderContext context;

	public HUSpider() {
		this(new DefaultSpiderContext());
	}

	public HUSpider(SpiderContext context) {
		this.context = context;
		this.initialize();
	}

	synchronized void initialize() {
		HUConfig config = (HUConfig) context.getConfig();
		if (config == null) {
			config = new HUConfig();
			context.setConfig(config);
		}
		this.webClient = new WebClient(config.getBrowserVersion());
		if (config.isProxyEnabled()) {
			this.webClient.getOptions().setProxyConfig(config.getProxyConfig());
		}
		this.webClient.getCookieManager().setCookiesEnabled(config.isCookiesEnabled());// must enabled cookies
		this.webClient.getOptions().setJavaScriptEnabled(config.isJavaScriptEnabled());
		this.webClient.getOptions().setCssEnabled(config.isCssEnabled());
		this.webClient.getOptions().setThrowExceptionOnScriptError(config.isThrowExceptionOnScriptError());
		this.webClient.getOptions().setThrowExceptionOnFailingStatusCode(config.isThrowExceptionOnFailingStatusCode());
		this.webClient.getOptions().setTimeout(config.getTimeout());
	}

	@Override
	public SpiderResponse fetch(URL url, String resourceName) {
		WebWindow window = null;
		window = this.webClient.openWindow(url, resourceName);
		Page page = window.getEnclosedPage();
		HUSpiderResponse res = new HUSpiderResponse(page);
		return res;
	}

	@Override
	public void handle(URL url, SpiderHandler handler, String resourceName) {
		SpiderResponse resp = fetch(url, resourceName);
		if (handler != null) {
			handler.process(resp);
		}
	}

	@Override
	public void handle(SpiderUrlHandler handler, String resourceName) throws MalformedURLException {
		handle(handler.getUrl(), handler, resourceName);
	}

	@Override
	public SpiderContext context() {
		return context;
	}

	@Override
	public void cleanUp() {
		this.webClient.close();
	}

}
