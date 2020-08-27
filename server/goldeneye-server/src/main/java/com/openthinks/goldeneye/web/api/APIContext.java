/**
 * 
 */
package com.openthinks.goldeneye.web.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class APIContext {
	private final Map<String, Object> data;

	public APIContext() {
		data = new ConcurrentHashMap<>();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		return (T) data.get(key);
	}
	
	public APIContext put(String key, Object value) {
		data.put(key, value);
		return this;
	}
	
	public static final APIContext build() {
		return new APIContext();
	}
}
