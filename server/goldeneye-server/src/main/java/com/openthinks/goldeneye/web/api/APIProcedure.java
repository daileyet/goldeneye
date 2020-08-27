/**
 * 
 */
package com.openthinks.goldeneye.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dailey.yet@outlook.com
 *
 */
public interface APIProcedure {

	public Object execute(APIContext apiContext, HttpServletRequest req, HttpServletResponse res);

}
