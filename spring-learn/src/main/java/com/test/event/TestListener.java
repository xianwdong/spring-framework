package com.test.event;

import org.springframework.context.ApplicationListener;

/**
 * @create 2020-04-26
 */
public class TestListener implements ApplicationListener<TestEvent> {
	@Override
	public void onApplicationEvent(TestEvent event) {
		event.print();
	}
}
