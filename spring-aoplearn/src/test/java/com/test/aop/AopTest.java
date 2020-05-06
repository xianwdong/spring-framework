package com.test.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2020-04-29
 */
public class AopTest {

	@Test
	public void test_aop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		TestBean test = (TestBean) context.getBean("test");
		test.test();
	}

}
