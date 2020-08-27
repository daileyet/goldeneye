/**
 * 
 */
package com.openthinks.goldeneye.impls.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openthinks.goldeneye.core.mapper.MetalPriceHistoryMapper;
import com.openthinks.goldeneye.core.model.MetalPriceHistory;
import com.openthinks.goldeneye.core.service.MetalPriceHistoryService;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Service
public class MetalPriceHistoryServiceImpl implements MetalPriceHistoryService {

	@Autowired
	MetalPriceHistoryMapper metalPriceHistoryMapper;

	@Override
	public void save(MetalPriceHistory record) {
		if (record.getId() == null) {
			metalPriceHistoryMapper.insert(record);
		} else {
			metalPriceHistoryMapper.updateByPrimaryKeySelective(record);
		}
	}

}
