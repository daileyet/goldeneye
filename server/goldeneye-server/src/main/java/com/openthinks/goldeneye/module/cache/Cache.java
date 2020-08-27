/**
 * 
 */
package com.openthinks.goldeneye.module.cache;

import java.util.Date;
import java.util.EventListener;


/**
 * @author dailey.yet@outlook.com
 *
 */
public interface Cache<T> extends Difference<T>{
	public String key();
	
	public T value();
	
	public Date lastAccessTime();
	
	public Date lastUpdateTime();
	
	public void update(T newValue);
	
	public void addCallback(Callback<T> callBack );
	
	public void removeCallback(Callback<T> callBack );
	
	public interface Callback<T> extends EventListener{
		void updated(T newVuale);
	}
}
