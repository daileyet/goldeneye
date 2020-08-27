/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

/**
 * @author dailey.yet@outlook.com
 *
 */
@FunctionalInterface
public interface SpiderHandler {

	/**
	 * process {@link SpiderResponse} after request
	 * @param resp {@link SpiderResponse}
	 */
	public void process(SpiderResponse resp);
	
}
