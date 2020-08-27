/**
 * 
 */
package com.openthinks.goldeneye.module.cache;

import java.io.Serializable;

/**
 * @author dailey.yet@outlook.com
 */
@FunctionalInterface
public interface CacheKeyer<T> extends Serializable {
	
	public String key(T model);
}
