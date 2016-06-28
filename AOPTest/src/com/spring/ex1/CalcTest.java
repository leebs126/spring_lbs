package com.spring.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class CalcTest {
	public static void main(String[] args){
		ApplicationContext context=new ClassPathXmlApplicationContext("aopTest.xml");
		Calculator cal=(Calculator)context.getBean("proxyCal");
		
		System.out.println(cal.add(100,20));
		System.out.println(cal.subtract(100,20));
		System.out.println(cal.multiply(100,20));
		System.out.println(cal.divide(100,20));
	}
}


