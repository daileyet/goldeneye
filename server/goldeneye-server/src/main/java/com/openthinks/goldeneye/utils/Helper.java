/**
 * 
 */
package com.openthinks.goldeneye.utils;

/**
 * @author dailey.yet@outlook.com
 *
 */
public final class Helper {
	private Helper() {}
	
	public static boolean isSame(Object oldVal,Object newVal) {
		if(oldVal==newVal)
			return true;
		if(oldVal==null || newVal==null)
			return false;
		if(oldVal.equals(newVal)) {
			return true;
		}
		return false;
	}
	
}
