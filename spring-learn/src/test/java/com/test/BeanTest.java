package com.test;

import com.test.element.lookup.GetBeanTest;
import com.test.event.TestEvent;
import com.test.inject.School;
import com.test.xsd.UserXsd;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
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
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans.xml"));
		TestBean testBean1 = (TestBean) beanFactory.getBean("testBean");
		Assert.assertEquals(testBean1.getStr(), "hello world");
		System.out.println(testBean1);

		TestBean testBean2 = (TestBean) beanFactory.getBean("testBean");
		System.out.println(testBean2);
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

	@Test(expected = BeanCurrentlyInCreationException.class)
	public void test_cycle() throws Throwable {
		try {
			new ClassPathXmlApplicationContext("com.test/cyclebeans.xml");
		} catch (Exception e) {
			Throwable e1 = e.getCause().getCause().getCause();
			e1.printStackTrace();
			throw e1;
		}
	}

	@Test
	public void test_school_withBeanFacotory() {
//		 https://stackoverflow.com/questions/33840912/autowire-annotation-giving-null-value-in-spring
//		 https://blog.csdn.net/chenlong220192/article/details/46723561
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com.test/beans-school.xml"));
		School school1 = (School) beanFactory.getBean("school");
		System.out.println(school1);

	}

	@Test
	public void test_school_withApplicationContext() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com.test/beans-school.xml");
		School school3 = (School) context.getBean("s");
		System.out.println(school3);
	}

	@Test
	public void test_listener() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com.test/listener.xml");
		TestEvent event = new TestEvent("hello", "world");
		context.publishEvent(event);
	}

	@Test
	public void test_lookup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com.test/beans-lookup.xml");
		GetBeanTest getBeanTest = (GetBeanTest) context.getBean("getBeanTest");
		getBeanTest.showMe();
	}

	@Test
	public void test_testBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com.test/beans-school.xml");
		TestBean bean = context.getBean(TestBean.class);
		System.out.println(bean);
	}

	@Test
	public void test_fileSystem() {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("G:\\code\\personal\\spring-framework\\spring-learn\\src\\test\\resources\\com.test\\beans.xml");

		// FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		TestBean bean = context.getBean(TestBean.class);
		System.out.println(bean);
	}

	@Test
	public void test_xsd() {
		// 参考 https://github.com/huifer/spring-analysis/blob/main/book/ioc/docs/ch-04/%E7%AC%AC%E5%9B%9B%E7%AB%A0-%E8%87%AA%E5%AE%9A%E4%B9%89%E6%A0%87%E7%AD%BE%E8%A7%A3%E6%9E%90.md
		// 注意 spring.handlers文件和spring.schemaas文件必须放在META-INF文件夹下
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com.test/user.xml");
		UserXsd testUserBean = context.getBean("testUserBean", UserXsd.class);
		System.out.println(testUserBean);
		assert testUserBean.getName().equals("huifer");
		assert testUserBean.getIdCard().equals("123");
		context.close();
	}

}
