package com.spring.ex1;

public class Calculator {
	public int add(int x, int y) {
		System.out.println("add() �޼ҵ� ȣ��");
		return x+y;
	}
	
	public int subtract(int x, int y) {
		System.out.println("subtract() �޼ҵ� ȣ��");
        return x-y;
    }
	
	public int multiply(int x, int y){
	   System.out.println("multiply() �޼ҵ� ȣ��");
	   return x*y;
    }

	public int divide(int x, int y){
		System.out.println("divide() �޼ҵ� ȣ��");
        return x/y;
    }
}
