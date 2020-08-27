package com.openthinks.goldeneye.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.openthinks.libs.utilities.Converter;

/**
 * ClassName: AppConfig </br>
 */
@PropertySource("classpath:application.properties")
@Component
public class AppConfig {

	@Value("${app.version}")
	private String appVersion;
	//////////////////////////////////////////
	@Value("${spring.jackson.date-format}")
	private String dateFormatPattern;
	@Value("${app.proxy.enable}")
	private Boolean needProxy;
	@Value("${app.proxy.host}")
	private String proxyHost;
	@Value("${app.proxy.port}")
	private Integer proxyPort;
	
	///////////////////////////////////////////
	@Value("${app.mqtt.broker}")
	private String mqttBroker;
	@Value("${app.mqtt.maintopic}")
	private String mqttMainTopic;
	@Value("${app.mqtt.qos}")
	private String mqttQos;
	

	public String getAppVersion() {
		return appVersion;
	}
	
	public String getDateFormatPattern() {
		return dateFormatPattern;
	}
	
	public boolean isNeedProxy() {
		return needProxy==null?false:needProxy;
	}

	public String getProxyHost() {
		return proxyHost;
	}
	
	public Integer getProxyPort() {
		return proxyPort;
	}

	
	@Override
	public String toString() {
		return "AppConfig [appVersion=" + appVersion + ", dateFormatPattern=" + dateFormatPattern + ", needProxy="
				+ needProxy + ", proxyHost=" + proxyHost + ", proxyPort=" + proxyPort + "]";
	}

	public static AppConfig load() throws IOException, IllegalArgumentException, IllegalAccessException {
		Properties props = new Properties();
		props.load(AppConfig.class.getResourceAsStream("/application.properties"));
		AppConfig appConfig = new AppConfig();
		Field[] fields=AppConfig.class.getDeclaredFields();
		for(Field field:fields) {
			Value valueAnno=field.getAnnotation(Value.class);
			if(valueAnno!=null) {
				String propertyName = valueAnno.value();
				propertyName=propertyName.substring(2, propertyName.length()-2);
				String propertyValue = props.getProperty(propertyName);
				process(appConfig,field,propertyValue);
			}
		}
		return appConfig;
	}

	private static void process(AppConfig appConfig, Field field,String propertyValue) throws IllegalArgumentException, IllegalAccessException {
		if(propertyValue==null || StringUtils.isBlank(propertyValue)) {
			return;
		}
		Class<?> type=field.getType();
		Object fieldVal = Converter.source(propertyValue).convertToSingle(type);
		field.setAccessible(true);
		field.set(appConfig, fieldVal);
	}
	
}
