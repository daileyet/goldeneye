/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface SpiderContext {
	public static String CONFIG_KEY = "@SpiderConfig@";

	/**
	 * get {@link SpiderConfig} for this {@link Spider}
	 * 
	 * @return {@link SpiderConfig}
	 */
	public default SpiderConfig getConfig() {
		return (SpiderConfig) get(CONFIG_KEY);
	}

	public default void setConfig(SpiderConfig config) {
		put(CONFIG_KEY, config);
	}

	public Object get(String key);

	public void put(String key, Object value);

}
