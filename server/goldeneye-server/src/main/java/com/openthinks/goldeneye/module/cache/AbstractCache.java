package com.openthinks.goldeneye.module.cache;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openthinks.libs.utilities.DateUtils;
import com.openthinks.libs.utilities.EventListenerList;

public abstract class AbstractCache<T> implements Cache<T> {
	private final EventListenerList listeners = new EventListenerList();
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());
	protected transient volatile T target;
	protected final String key;
	protected transient Date lastAccessTime;
	protected transient Date lastUpdateTime;

	protected AbstractCache(String key) {
		this(key,null);
	}
	
	protected AbstractCache(String key,T target) {
		this.key = key;
		this.target=target;
		lastAccessTime = (lastUpdateTime = DateUtils.now());
	}


	@Override
	public String key() {
		return key;
	}

	@Override
	public synchronized T value() {
		this.lastAccessTime = DateUtils.now();
		return target;
	}

	@Override
	public Date lastAccessTime() {
		return lastAccessTime;
	}

	@Override
	public Date lastUpdateTime() {
		return lastUpdateTime;
	}

	@Override
	public synchronized void update(T newValue) {
		if (isDiff(target, newValue)) {
			T oldValue = target;
			this.target = newValue;
			fireUpdate(oldValue, newValue);
		} else {
			doCleanUpdate(newValue);
		}
	}

	/**
	 * just make current target as new value, no callback
	 * 
	 * @param newValue
	 *            new value
	 */
	protected void doCleanUpdate(T newValue) {
		this.target = newValue;
		this.lastUpdateTime = DateUtils.now();
	}

	@Override
	public void addCallback(Callback<T> callBack) {
		listeners.add(Callback.class, callBack);
	}

	@Override
	public void removeCallback(Callback<T> callBack) {
		listeners.remove(Callback.class, callBack);
	}

	@SuppressWarnings("unchecked")
	protected void fireUpdate(T oldValue, T newValue) {
		Object[] listeners = this.listeners.getListenerList();
		int numListeners = listeners.length;
		for (int i = 0; i < numListeners; i += 2) {
			Callback<T> callback = ((Callback<T>) listeners[i + 1]);
			try {
				callback.updated(newValue);
			} catch (Exception e) {
				LOGGER.error("Failed to call {} for reason:{}", callback, e);
			}
		}
	}

}
