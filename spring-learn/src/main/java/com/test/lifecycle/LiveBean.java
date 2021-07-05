package com.test.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @create 2021-07-02
 */
public class LiveBean implements BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, InitializingBean, DisposableBean, BeanClassLoaderAware,
		EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
		ApplicationEventPublisherAware, MessageSourceAware {

	private String address;

	public LiveBean() {
		System.out.println("init LiveBean");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("run setBeanClassLoader method.");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("run setApplicationEventPublisher method.");

	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println("run setEmbeddedValueResolver method.");

	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("run Environment method.");

	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("run setMessageSource method.");

	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("run setResourceLoader method.");

	}

	@Override
	public void setBeanName(String name) {
		System.out.println("run setBeanName method.");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("run destroy method.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("run afterPropertiesSet method.");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("run setApplicationContext method.");
	}

	@PostConstruct
	public void springPostConstruct() {
		System.out.println("@PostConstruct");
	}

	@PreDestroy
	public void springPreDestroy() {
		System.out.println("@PreDestroy");
	}


	public void myPostConstruct() {
		System.out.println("run myPostConstruct method.");
	}

	public void myPreDestroy() {
		System.out.println("run myPreDestroy method.");
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("run setAddress method.");
		this.address = address;
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("run setBeanFactory method.");
	}

}
