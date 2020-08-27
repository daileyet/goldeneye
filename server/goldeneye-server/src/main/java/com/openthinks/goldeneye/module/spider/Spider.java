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
public interface Spider {
	/**
	 * request special URL as given resource name
	 * @param url {@link URL} request URL
	 * @param resourceName bind a resource name to given URL
	 * @return {@link SpiderResponse}
	 */
	public SpiderResponse fetch(URL url,String resourceName);
	
	/**
	 * handle special URL resource by given {@link SpiderHandler}
	 * @param url {@link URL} request URL
	 * @param handler {@link SpiderHandler} response handler
	 * @param resourceName bind a resource name to given URL
	 */
	public void handle(URL url,SpiderHandler handler,String resourceName);
	
	/**
	 * handle special URL resource by given {@link SpiderUrlHandler}
	 * @param handler {@link SpiderUrlHandler}
	 * @param resourceName bind a resource name to given {@link SpiderUrlHandler}
	 */
	public void handle(SpiderUrlHandler handler,String resourceName)  throws MalformedURLException;
	/**
	 * get {@link SpiderContext} for this instance
	 * @return {@link SpiderContext}
	 */
	public SpiderContext context();
	
	/**
	 * release all resources
	 */
	public void cleanUp();
	
}
