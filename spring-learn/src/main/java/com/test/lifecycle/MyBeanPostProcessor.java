package com.test.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @create 2021-07-02
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof LiveBean) {
			System.out.println("run MyBeanPostProcessor postProcessBeforeInitialization method.");
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof LiveBean) {
			System.out.println("run MyBeanPostProcessor postProcessAfterInitialization method.");
		}
		return bean;
	}
}
