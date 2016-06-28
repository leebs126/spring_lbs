package com.spring.ex1;

public class Calculator {
	public int add(int x, int y) {
		System.out.println("add() 메소드 호출");
		return x+y;
	}
	
	public int subtract(int x, int y) {
		System.out.println("subtract() 메소드 호출");
        return x-y;
    }
	
	public int multiply(int x, int y){
	   System.out.println("multiply() 메소드 호출");
	   return x*y;
    }

	public int divide(int x, int y){
		System.out.println("divide() 메소드 호출");
        return x/y;
    }
}
