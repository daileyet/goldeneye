/**
 * 
 */
package com.openthinks.goldeneye.services;

import com.openthinks.goldeneye.module.cache.Cache;
import com.openthinks.goldeneye.module.cache.CacheManager;
import com.openthinks.goldeneye.module.cache.Difference;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface CacheService {

	/**
	 * put key and value into {@link CacheManager}
	 * 
	 * @param key
	 *            String key
	 * @param target
	 *            <T> value
	 */
	<T> void put(String key, T target);

	<T> void put(String key, T target, Difference<T> differ);

	<T> T get(String key);

	void remove(String key);
	
	void clear();

	void addCallback(Callback callback);

	void removeCallback(Callback callback);

	public interface Callback extends Cache.Callback<Object> {

		public boolean accept(Object updateVal);

		@Override
		default void updated(Object newValue) {
			if (accept(newValue)) {
				onUpdated(newValue);
			}
		}

		public void onUpdated(Object newValue);

	}
}
