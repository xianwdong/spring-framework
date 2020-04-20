package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {

	@Test
	public void test_load() {
		/**
		 * 1.通过new ClassPathResource("com.test/beans.xml")来获取一个Resource
		 * 2.XmlBeanFactory的构造函数实现资源加载
		 * 		2.1 org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#AbstractAutowireCapableBeanFactory()
		 * 			构造函数会调用到上述父类的构造函数
		 * */
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans.xml"));
		TestBean testBean = (TestBean) beanFactory.getBean("testBean");
		Assert.assertEquals(testBean.getStr(), "hello world");
	}

	@Test
	public void test_profile() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans-profile.xml"));
		//System.setProperty("Spring.profiles.active", "dev");
		TestBean testBean = (TestBean) beanFactory.getBean("testBean");
		System.out.println(testBean.getStr());
	}

}
