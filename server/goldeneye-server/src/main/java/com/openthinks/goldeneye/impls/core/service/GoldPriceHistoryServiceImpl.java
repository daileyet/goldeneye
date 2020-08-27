/**
 * 
 */
package com.openthinks.goldeneye.impls.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openthinks.goldeneye.core.mapper.GoldPriceHistoryMapper;
import com.openthinks.goldeneye.core.model.GoldPriceHistory;
import com.openthinks.goldeneye.core.service.GoldPriceHistoryService;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Service
public class GoldPriceHistoryServiceImpl implements GoldPriceHistoryService {

	@Autowired
	GoldPriceHistoryMapper goldPriceHistoryMapper;
	
	/* (non-Javadoc)
	 * @see com.openthinks.goldeneye.core.service.GoldPriceHistoryService#save(com.openthinks.goldeneye.core.model.GoldPriceHistory)
	 */
	@Override
	public void save(GoldPriceHistory record) {
		if(record.getId()==null) {
			goldPriceHistoryMapper.insertSelective(record);
		}else {
			goldPriceHistoryMapper.updateByPrimaryKeySelective(record);
		}

	}

}
