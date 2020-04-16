package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {

	@Test
	public void test_load() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans.xml"));
		TestBean testBean = (TestBean) beanFactory.getBean("testBean");
		Assert.assertEquals(testBean.getStr(), "hello world");
	}

}
