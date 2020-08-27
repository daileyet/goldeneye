/**
 * 
 */
package com.openthinks.goldeneye.module.cache;

import java.util.Map;

import net.sf.ehcache.util.concurrent.ConcurrentHashMap;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class DefaultCacheManager implements CacheManager {
	private final Map<String, Cache<?>> cacheMap;

	public DefaultCacheManager() {
		cacheMap = new ConcurrentHashMap<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.goldeneye.module.cache.CacheManager#push(com.openthinks.
	 * goldeneye.module.cache.Cache)
	 */
	@Override
	public void push(Cache<?> cache) {
		cacheMap.put(cache.key(), cache);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.goldeneye.module.cache.CacheManager#pull(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> Cache<T> pull(String key) {
		return (Cache<T>) cacheMap.get(key);
	}

	@Override
	public void purge(String key) {
		cacheMap.remove(key);
	}

	@Override
	public void purgeAll() {
		cacheMap.clear();
	}


}
