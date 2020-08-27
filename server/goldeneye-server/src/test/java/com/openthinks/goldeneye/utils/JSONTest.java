/**
 * 
 */
package com.openthinks.goldeneye.utils;

import org.junit.Assert;
import org.junit.Test;

import com.openthinks.goldeneye.web.api.APIResponse;
import com.openthinks.libs.utilities.json.JSON;
import com.openthinks.libs.utilities.json.JSONConverters;
import com.openthinks.libs.utilities.json.JSONObject;


/**
 * @author dailey.yet@outlook.com
 *
 */
public class JSONTest {

	@Test
	public void testJSONOutput() {
		APIResponse json= APIResponse.builder().rst(0).msg((Object)null).finish();
		JSONObject jsonObj = JSONConverters.perparedAndGet(json);
		String str = JSON.stringify(jsonObj);
		System.out.println(str);
		Assert.assertTrue(jsonObj.size()==1);
	}
}
