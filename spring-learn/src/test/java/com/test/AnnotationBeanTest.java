package com.test;

import com.test.annotationcontext.TestController;
import com.test.annotationcontext.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @create 2020-08-24
 */
public class AnnotationBeanTest {

	@Test
	public void test_annotationBean() {
		// 初始化ApplicationContext之后，就已经有了几个xxxAnnotationProcessor的Bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.annotationcontext");
		context.refresh();
		Assert.assertNotNull(context.getBean(TestController.class));
		Assert.assertNotNull(context.getBean(TestService.class));
	}

}
