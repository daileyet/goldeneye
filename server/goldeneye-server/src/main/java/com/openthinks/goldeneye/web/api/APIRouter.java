/**
 * 
 */
package com.openthinks.goldeneye.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openthinks.goldeneye.utils.Constants;
import com.openthinks.goldeneye.utils.Constants.ErrorCode;
import com.openthinks.goldeneye.utils.SpringContextUtils;

/**
 * @author dailey.yet@outlook.com <BR>
 *         format: <b> /api/{version}/{metal}/{unit} </b> <BR>
 *         example:<BR>
 *         <code>
 * 	/api/v1/au/CNY.g
 * <BR>
 *  /api/v1/au/USD.oz
 *  <BR>
 *  /api/v1/au/
 * </code>
 */
@RestController
@RequestMapping(Constants.API_PREFIX)
public class APIRouter {
	private static final Logger LOGGER = LoggerFactory.getLogger(APIRouter.class);

	@RequestMapping("/{" + Constants.API_PATH_VERSION + "}/{" + Constants.API_PATH_METAL + "}/{"
			+ Constants.API_PATH_UNIT + "}")
	public Object process(@PathVariable(name = Constants.API_PATH_VERSION, required = true) String apiVersion,
			@PathVariable(name = Constants.API_PATH_METAL, required = true) String metal,
			@PathVariable(name = Constants.API_PATH_UNIT, required = false) String unit, HttpServletRequest req,
			HttpServletResponse res) {
		APIProcedure apiProcedure = null;
		try {
			ApplicationContext appContext = SpringContextUtils.getContext();
			apiProcedure = appContext.getBean(apiVersion, APIProcedure.class);
		} catch (Exception e) {
			LOGGER.warn("Failed to find instance of APIProcedure by reason:{}", e);
			return APIResponse.builder().rst(-1).msg(ErrorCode.NOT_SUPPORT_VERSION).finishAsJSON();
		}
		Constants.Units aunit = Constants.Units.toUnits(unit);
		if (aunit == null) {
			aunit = Constants.Units.CNY_G;
		}
		Constants.Metas ametal = Constants.Metas.toMetas(metal);
		if (ametal == null) {
			return APIResponse.builder().rst(-1).msg(ErrorCode.NOT_SUPPORT_CATEGORY).finishAsJSON();
		}
		APIContext apiContext = APIContext.build().put(Constants.API_PATH_METAL, ametal).put(Constants.API_PATH_UNIT,
				aunit);
		Object apiResponse = null;
		try {
			apiResponse = apiProcedure.execute(apiContext, req, res);
		} catch (Exception e) {
			LOGGER.warn("Failed to process API request for metal:{},unit:{} by reason:{}", metal, unit, e);
			return APIResponse.builder().rst(-1).msg(ErrorCode.UNKONW).finishAsJSON();
		}
		if (apiResponse == null) {
			return APIResponse.builder().rst(-1).msg(ErrorCode.UNKONW).finishAsJSON();
		}
		return apiResponse;
	}


	@RequestMapping("/{" + Constants.API_PATH_VERSION + "}/{" + Constants.API_PATH_METAL + "}")
	public Object process(@PathVariable(name = Constants.API_PATH_VERSION, required = true) String apiVersion,
			@PathVariable(name = Constants.API_PATH_METAL, required = true) String metal, HttpServletRequest req,
			HttpServletResponse res) {
		return process(apiVersion, metal, Constants.Units.CNY_G.value(), req, res);
	}

}
