package com.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @create 2020-04-29
 */
@Aspect
public class AspectJTest {

	@Pointcut("execution(* *.test(..))")
	public void test() {}

	@Before("test()")
	public void beforeTest() {
		System.out.println("before test");
	}

	@After("test()")
	public void afterTest() {
		System.out.println("after test");
	}

	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint p) {
		System.out.println("before1");
		Object o = null;
		try {
			o = p.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("after1");
		return o;
	}
}
