package com.openthinks.goldeneye.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import net.sourceforge.springframework.SpringContext;

@Component
public class SpringContextUtils implements ApplicationContextAware {

	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext c) throws BeansException {
		context = c;
		new SpringContext().setApplicationContext(context);
	}

	public static ApplicationContext getContext() {
		return context;
	}
}
