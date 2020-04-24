package com.test;

import com.test.inject.School;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
		TestBean testBean1 = (TestBean) beanFactory.getBean("testBean");
		Assert.assertEquals(testBean1.getStr(), "hello world");
		System.out.println(testBean1);

		TestBean testBean2 = (TestBean) beanFactory.getBean("testBean");
		System.out.println(testBean2);
	}

	@Test
	public void test_profile() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans-profile.xml"));
		//System.setProperty("Spring.profiles.active", "dev");
		TestBean testBean = (TestBean) beanFactory.getBean("testBean");
		System.out.println(testBean.getStr());
	}

	@Test
	public void test_factoryBean() throws Exception {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans.xml"));
		Car car1 = (Car) beanFactory.getBean("car");
		System.out.println(car1);

		CarFactoryBean carFactoryBean = (CarFactoryBean) beanFactory.getBean("&car");
		Car car2 = carFactoryBean.getObject();
		System.out.println(car2);
		// System.out.println(car1 == car2);
	}

	@Test
	public void test_school() {
//		 https://stackoverflow.com/questions/33840912/autowire-annotation-giving-null-value-in-spring
//		 https://blog.csdn.net/chenlong220192/article/details/46723561
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans-school.xml"));
		School school1 = (School) beanFactory.getBean("school");
		System.out.println(school1);

		/*ApplicationContext context = new ClassPathXmlApplicationContext("com.test/beans-school.xml");
		School school2 = (School) context.getBean("school");
		System.out.println(school2);*/
	}

}
