/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface SpiderUrlHandler extends SpiderHandler {
	
	public URL getUrl() throws MalformedURLException;
}
