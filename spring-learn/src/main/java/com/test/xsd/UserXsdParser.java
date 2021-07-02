package com.test.xsd;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @create 2021-06-30
 */
public class UserXsdParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return UserXsd.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		String idCard = element.getAttribute("idCard");
		builder.addPropertyValue("name", name);
		builder.addPropertyValue("idCard", idCard);
	}

}
