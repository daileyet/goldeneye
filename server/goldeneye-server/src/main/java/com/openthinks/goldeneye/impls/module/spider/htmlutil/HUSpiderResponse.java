/**
 * 
 */
package com.openthinks.goldeneye.impls.module.spider.htmlutil;

import com.gargoylesoftware.htmlunit.Page;
import com.openthinks.goldeneye.module.spider.SpiderResponse;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class HUSpiderResponse implements SpiderResponse {
	private final Page page;
	
	public HUSpiderResponse(Page page) {
		this.page=page;
	}

	public Page getPage() {
		return page;
	}

	@Override
	public boolean isError() {
		return page==null;
	}
	
	@Override
	public String getContentAsString() {
		return isError()?null:page.getWebResponse().getContentAsString();
	}
}
