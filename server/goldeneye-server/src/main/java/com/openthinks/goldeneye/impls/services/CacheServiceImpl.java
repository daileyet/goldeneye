/**
 * 
 */
package com.openthinks.goldeneye.impls.services;

import org.springframework.stereotype.Service;

import com.openthinks.goldeneye.module.cache.Cache;
import com.openthinks.goldeneye.module.cache.CacheBuilder;
import com.openthinks.goldeneye.module.cache.CacheManager;
import com.openthinks.goldeneye.module.cache.DefaultCacheManager;
import com.openthinks.goldeneye.module.cache.Difference;
import com.openthinks.goldeneye.services.CacheService;
import com.openthinks.libs.utilities.EventListenerList;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Service
public class CacheServiceImpl implements CacheService {

	private final CacheManager cm;
	private final EventListenerList listeners;

	public CacheServiceImpl() {
		cm = new DefaultCacheManager();
		listeners = new EventListenerList();
	}

	@Override
	public void addCallback(Callback callback) {
		listeners.add(Callback.class, callback);
	}

	@Override
	public void removeCallback(Callback callback) {
		listeners.remove(Callback.class, callback);
	}

	@Override
	public <T> void put(String key, T target) {
		put(key, target, null);
	}

	@Override
	public <T> void put(String key, T target, Difference<T> differ) {
		Cache<T> cache = cm.pull(key);
		if (cache == null) {
			cache = CacheBuilder.createCache(key, differ);
			cm.push(cache);
			injectCallbacks(cache,target);
		}
		cache.update(target);
	}

	@SuppressWarnings("unchecked")
	private <T> void injectCallbacks(Cache<T> cache,T target) {
		Object[] listeners = this.listeners.getListenerList();
		int numListeners = listeners.length;
		for (int i = 0; i < numListeners; i += 2) {
			Callback callback = ((Callback) listeners[i + 1]);
			if (callback != null && callback.accept(target)) {
				cache.addCallback((com.openthinks.goldeneye.module.cache.Cache.Callback<T>) callback);
			}
		}
	}

	@Override
	public <T> T get(String key) {
		Cache<T> cache = cm.pull(key);
		return cache == null ? null : cache.value();
	}

	@Override
	public void remove(String key) {
		cm.purge(key);
	}

	@Override
	public void clear() {
		cm.purgeAll();
	}

}
