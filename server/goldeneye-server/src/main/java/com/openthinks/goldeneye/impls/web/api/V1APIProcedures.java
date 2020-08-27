/**
 * 
 */
package com.openthinks.goldeneye.impls.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openthinks.goldeneye.services.CacheService;
import com.openthinks.goldeneye.utils.Constants;
import com.openthinks.goldeneye.utils.Constants.ErrorCode;
import com.openthinks.goldeneye.utils.Constants.ErrorRst;
import com.openthinks.goldeneye.web.api.APIContext;
import com.openthinks.goldeneye.web.api.APIProcedure;
import com.openthinks.goldeneye.web.api.APIResponse;
import com.openthinks.libs.utilities.json.JSONConverters;

/**
 * @author dailey.yet@outlook.com
 *
 */
@Component("v1")
public class V1APIProcedures  implements APIProcedure {

	@Autowired
	CacheService cacheService;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.goldeneye.web.api.APIProcedure#execute(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Object execute(APIContext apiContext, HttpServletRequest req, HttpServletResponse res) {
		Constants.Metas metal = apiContext.get(Constants.API_PATH_METAL);
		Constants.Units unit = apiContext.get(Constants.API_PATH_UNIT);
		if (unit != Constants.Units.CNY_G) {
			return APIResponse.builder().rst(Constants.ErrorRst.ERROR).msg(Constants.ErrorCode.NOT_SUPPORT_UNIT);
		}
		String key = metal.value() + "#" + unit.value();
		Object model = cacheService.get(key);
		ErrorRst rst = model == null ? ErrorRst.ERROR : ErrorRst.SUCCESS;
		ErrorCode msg = model == null ? Constants.ErrorCode.NO_DATA_FETCH : null;
		if(model!=null) {
			model = JSONConverters.perparedAndGet(model);
		}
		return APIResponse.builder().rst(rst).msg(msg).data(model).finishAsJSON();
	}


}
