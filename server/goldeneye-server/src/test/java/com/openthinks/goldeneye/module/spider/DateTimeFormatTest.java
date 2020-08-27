/**
 * 
 */
package com.openthinks.goldeneye.module.spider;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.openthinks.libs.utilities.DateFormatUtil;
import com.openthinks.libs.utilities.DateUtils;

/**
 * @author dailey.yet@outlook.com
 *
 */
public class DateTimeFormatTest {
	public static void main(String[] args) throws ParseException {
		DateFormat dateFormat=DateFormatUtil.getDateFormat("yyyy-MM-dd HH:mm:ss", DateUtils.getTimeZone());
		Date date = dateFormat.parse("2018-11-19 14:52:19");
		System.out.println(date);
	}
}
