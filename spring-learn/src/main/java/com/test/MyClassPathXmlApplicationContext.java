package com.test;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2020-04-26
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathXmlApplicationContext(String... configLocations) throws BeansException {
		super(configLocations);
	}

	@Override
	protected void initPropertySources() {
		getEnvironment().setRequiredProperties("VAR");
	}
}
