package com.test.element.lookup;

/**
 * @create 2020-04-27
 */
public abstract class GetBeanTest {

	public void showMe() {
		this.getBean().showMe();
	}

	public abstract User getBean();

}
