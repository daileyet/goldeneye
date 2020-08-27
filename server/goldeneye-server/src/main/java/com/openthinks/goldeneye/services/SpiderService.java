/**
 * 
 */
package com.openthinks.goldeneye.services;

import com.openthinks.goldeneye.module.spider.SpiderUrlHandler;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface SpiderService {

	void execute(SpiderUrlHandler handler) throws Exception;

}
