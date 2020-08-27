/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class DefaultSpiderContext implements SpiderContext {

	private Map<String, Object> data = new ConcurrentHashMap<>();

	@Override
	public Object get(String key) {
		return data.get(key);
	}

	@Override
	public void put(String key, Object value) {
		data.put(key, value);
	}

}
