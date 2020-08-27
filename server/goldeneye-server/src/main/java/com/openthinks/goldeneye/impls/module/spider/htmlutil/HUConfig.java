/**
 * 
 */
package com.openthinks.goldeneye.impls.module.spider.htmlutil;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.openthinks.goldeneye.module.spider.SpiderConfig;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class HUConfig implements SpiderConfig {
	private BrowserVersion browserVersion=BrowserVersion.CHROME;
	private ProxyConfig proxyConfig;
	private boolean cookiesEnabled=true;
	private boolean javaScriptEnabled=false;
	private boolean cssEnabled=false;
	private boolean throwExceptionOnScriptError=false;
	private boolean throwExceptionOnFailingStatusCode=false;
	private int timeout=30000;
	private boolean proxyEnabled=false;
	
	public BrowserVersion getBrowserVersion() {
		return browserVersion;
	}
	
	public ProxyConfig getProxyConfig() {
		return proxyConfig;
	}

	public boolean isCookiesEnabled() {
		return cookiesEnabled;
	}
	

	public boolean isJavaScriptEnabled() {
		return javaScriptEnabled;
	}

	public boolean isCssEnabled() {
		return cssEnabled;
	}

	public boolean isThrowExceptionOnScriptError() {
		return throwExceptionOnScriptError;
	}

	public boolean isThrowExceptionOnFailingStatusCode() {
		return throwExceptionOnFailingStatusCode;
	}

	public int getTimeout() {
		return timeout;
	}

	public boolean isProxyEnabled() {
		return proxyEnabled;
	}

	public void setBrowserVersion(BrowserVersion browserVersion) {
		this.browserVersion = browserVersion;
	}

	public void setProxyConfig(ProxyConfig proxyConfig) {
		this.proxyConfig = proxyConfig;
	}

	public void setCookiesEnabled(boolean cookiesEnabled) {
		this.cookiesEnabled = cookiesEnabled;
	}

	public void setJavaScriptEnabled(boolean javaScriptEnabled) {
		this.javaScriptEnabled = javaScriptEnabled;
	}

	public void setCssEnabled(boolean cssEnabled) {
		this.cssEnabled = cssEnabled;
	}

	public void setThrowExceptionOnScriptError(boolean throwExceptionOnScriptError) {
		this.throwExceptionOnScriptError = throwExceptionOnScriptError;
	}

	public void setThrowExceptionOnFailingStatusCode(boolean throwExceptionOnFailingStatusCode) {
		this.throwExceptionOnFailingStatusCode = throwExceptionOnFailingStatusCode;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setProxyEnabled(boolean proxyEnabled) {
		this.proxyEnabled = proxyEnabled;
	}

}
