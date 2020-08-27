/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.openthinks.goldeneye.impls.module.spider.handler.kitco.GoldSpiderHandler;
import com.openthinks.goldeneye.impls.module.spider.handler.kitco.MetalsSpiderHandler;
import com.openthinks.goldeneye.impls.module.spider.htmlutil.HUConfig;
import com.openthinks.goldeneye.impls.module.spider.htmlutil.HUSpider;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Ignore
public class HUSpiderTest {

	static HUSpider spider = null;

	@BeforeClass
	public static void setUp() {
		HUConfig config = new HUConfig();
		config.setProxyEnabled(true);
		config.setProxyConfig(new ProxyConfig("127.0.0.1", 12345));
		SpiderContext context = new DefaultSpiderContext();
		context.put(SpiderContext.CONFIG_KEY, config);
		spider = new HUSpider(context);
	}

	// @Test
	public void testfetch() throws MalformedURLException, InterruptedException {
		URL url = new URL(
				"http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY");
		SpiderResponse resp = spider.fetch(url, "SILVER");
		System.out.println(resp.getContentAsString());
		spider.cleanUp();
		Thread.sleep(60000);
		resp = spider.fetch(url, "SILVER");
		System.out.println(resp.getContentAsString());
	}

	@Test
	public void testMetalsSpiderHandler() throws MalformedURLException {
		MetalsSpiderHandler urlHandler = new MetalsSpiderHandler();
		spider.handle(urlHandler, "METAL");
		spider.cleanUp();
	}
	
	@Test
	public void testGoldSpiderHandler() throws MalformedURLException {
		GoldSpiderHandler urlHandler = new GoldSpiderHandler();
		spider.handle(urlHandler, "GOLD");
		spider.cleanUp();
	}

}
