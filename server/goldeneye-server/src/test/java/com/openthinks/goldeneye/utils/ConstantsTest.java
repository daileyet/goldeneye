/**
 * 
 */
package com.openthinks.goldeneye.utils;

import org.junit.Assert;
import org.junit.Test;

import com.openthinks.goldeneye.utils.Constants.Metas;


/**
 * @author dailey.yet@outlook.com
 *
 */
public class ConstantsTest {

	@Test
	public void testMetas() {
		String displayName = "ag";
		
		Metas metal=Constants.Metas.toMetas(displayName);
		
		Assert.assertEquals(Metas.AG, metal);
	}
}
