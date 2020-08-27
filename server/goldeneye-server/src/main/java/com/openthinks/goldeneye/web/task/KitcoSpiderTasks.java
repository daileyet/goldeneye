/**
 * 
 */
package com.openthinks.goldeneye.web.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.openthinks.goldeneye.core.model.GoldPriceHistory;
import com.openthinks.goldeneye.core.model.MetalPriceHistory;
import com.openthinks.goldeneye.core.service.GoldPriceHistoryService;
import com.openthinks.goldeneye.core.service.MetalPriceHistoryService;
import com.openthinks.goldeneye.impls.module.spider.handler.kitco.GoldSpiderHandler;
import com.openthinks.goldeneye.impls.module.spider.handler.kitco.MetalsSpiderHandler;
import com.openthinks.goldeneye.services.CacheService;
import com.openthinks.goldeneye.services.SpiderService;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Component
public class KitcoSpiderTasks implements InitializingBean {
	private static Logger LOG = LoggerFactory.getLogger(KitcoSpiderTasks.class);
	@Autowired
	GoldSpiderHandler goldSpiderHandler;

	@Autowired
	MetalsSpiderHandler metalsSpiderHandler;

	@Autowired
	SpiderService spiderService;

	@Autowired
	CacheService cacheService;
	
	@Autowired
	GoldPriceHistoryService goldPriceHistoryService;
	
	@Autowired
	MetalPriceHistoryService metalPriceHistoryService;

	private final CacheService.Callback goldenCallback = new GoldenCallback();

	private final CacheService.Callback metalsCallback = new MetalsCallback();

	@Override
	public void afterPropertiesSet() throws Exception {
		cacheService.addCallback(goldenCallback);
		cacheService.addCallback(metalsCallback);
	}

	@Scheduled(initialDelay = 10 * 1000, fixedDelay = 59 * 1000)
	void refreshGolden() {
		LOG.trace("refreshGolden...");
		try {
			spiderService.execute(goldSpiderHandler);
		} catch (Exception e) {
			LOG.error("Failed to refresh golden price for reason:{}", e);
		}
	}

	@Scheduled(initialDelay = 20 * 1000, fixedDelay = 59 * 1000)
	void metalsRefresh() {
		LOG.trace("metalsRefresh...");
		try {
			spiderService.execute(metalsSpiderHandler);
		} catch (Exception e) {
			LOG.error("Failed to refresh metals price for reason:{}", e);
		}
	}

	class GoldenCallback implements CacheService.Callback {

		@Override
		public boolean accept(Object updateVal) {
			return updateVal != null && updateVal.getClass() == GoldPriceHistory.class;
		}

		@Override
		public void onUpdated(Object newValue) {
			LOG.info("New update for Golden:{}",newValue);
			goldPriceHistoryService.save((GoldPriceHistory) newValue);
			//TODO
			// send MQTT message to MQTT Server 
		}

	}

	class MetalsCallback implements CacheService.Callback {

		@Override
		public boolean accept(Object updateVal) {
			return updateVal != null && updateVal.getClass() == MetalPriceHistory.class;
		}

		@Override
		public void onUpdated(Object newValue) {
			LOG.info("New update for Metal:{}",newValue);
			metalPriceHistoryService.save((MetalPriceHistory) newValue);
			//TODO
			// send MQTT message to MQTT Server 
		}

	}

}
