/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface SpiderConfig {

	/**
	 * timeout for request page
	 * @return timeout millisecond
	 */
	public default int getTimeout() {
		return 10000;
	}

	/**
	 * is need use proxy server
	 * @return true or false
	 */
	public default boolean isProxyEnabled() {
		return false;
	}
}
