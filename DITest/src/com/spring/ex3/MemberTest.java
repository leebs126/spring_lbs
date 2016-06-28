package com.spring.ex3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest {
	public static void main(String[] args) throws Exception {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("config.xml"));
		MemberService service = (MemberService) factory.getBean("memberService");
		service.getMemberInfo();
	}
}


