/**
 * 
 */
package com.openthinks.goldeneye.module.cache;

/**
 * @author dailey.yet@outlook.com
 *
 */
@FunctionalInterface
public interface Difference<T> {
	public boolean isDiff(T oldValue, T newValue);
}
