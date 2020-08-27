/**
 * 
 */
package com.openthinks.goldeneye.module.cache;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface CacheManager {

	public void push(Cache<?> cache);

	public <T> Cache<T> pull(String key);

	public void purge(String key);
	
	public void purgeAll();

}
