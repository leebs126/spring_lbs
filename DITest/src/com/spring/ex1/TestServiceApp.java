package com.spring.ex1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class TestServiceApp {
	public static void main(String[] args) throws Exception {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("test.xml"));
		TestService helloService = (TestService) factory.getBean("testService");
		helloService.sayHello();
		
	}
}
