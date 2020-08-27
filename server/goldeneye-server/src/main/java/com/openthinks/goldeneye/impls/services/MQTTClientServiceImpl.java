/**
 * 
 */
package com.openthinks.goldeneye.impls.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openthinks.goldeneye.services.MQTTClientService;
import com.openthinks.goldeneye.utils.AppConfig;

/**
 * Eclipse Paho Java Client impletation
 * 
 * @author dailey.yet@outlook.com
 *
 */
@Service
public class MQTTClientServiceImpl implements MQTTClientService {

	@Autowired
	AppConfig appConfig;
	
	/* (non-Javadoc)
	 * @see com.openthinks.goldeneye.services.MQTTClientService#publish(java.lang.Object)
	 */
	@Override
	public void publish(Object message) {
		// TODO Auto-generated method stub

	}

}
