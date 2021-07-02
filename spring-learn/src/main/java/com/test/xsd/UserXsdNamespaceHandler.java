package com.test.xsd;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @create 2021-06-30
 */
public class UserXsdNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user_xsd", new UserXsdParser());
	}

}
