/**
 * 
 */
package com.openthinks.goldeneye.module.cache;

/**
 * @author dailey.yet@outlook.com
 *
 */
public final class CacheBuilder {
	private CacheBuilder() {
	}

	public static final <T> Cache<T> createCache(String key) {
		return new DefaultCache<T>(key);
	}

	public static final <T> Cache<T> createCache(String key, final Difference<T> differ) {
		return new DefaultCache<T>(key, null, differ);
	}

	public static final <T> Cache<T> createCache(String key, final T model, final Difference<T> differ) {
		return new DefaultCache<T>(key, model, differ);
	}

/*	public static final <T> Cache<T> createCache(final T model, final Difference<T> differ, final CacheKeyer<T> keyer) {
		String key = keyer.key(model);
		return new DefaultCache<T>(key, model, differ);
	}*/

	/**
	 * default implementation for {@link Cache}
	 * 
	 * @author dailey.yet@outlook.com
	 *
	 */
	static class DefaultCache<T> extends AbstractCache<T> {
		final Difference<T> differ;

		DefaultCache(String key) {
			this(key, null, null);
		}

		DefaultCache(String key, T target) {
			this(key, target, null);
		}

		DefaultCache(String key, T target, Difference<T> differ) {
			super(key, target);
			this.differ = differ;
		}

		@Override
		public boolean isDiff(T oldValue, T newValue) {
			if (differ == null) {
				return (oldValue != newValue) || (oldValue != null && !oldValue.equals(newValue));
			} else {
				return differ.isDiff(oldValue, newValue);
			}
		}
	}
}
