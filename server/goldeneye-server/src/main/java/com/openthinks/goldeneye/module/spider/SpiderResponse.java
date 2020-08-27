/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface SpiderResponse {

	public boolean isError();
	
	public String getContentAsString();
}
