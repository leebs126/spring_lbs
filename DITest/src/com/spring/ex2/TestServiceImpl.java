package com.spring.ex2;

public class TestServiceImpl implements TestService{
    private String strHello;
	private String hello; //test.xml�� hello�� ���� ����ȴ�.
    /*public void setHello(String hello) {
		this.hello = hello;
	}*/

/*	public TestServiceImpl() {
	}
*/
	public TestServiceImpl(String hello) {
		this.hello = hello;
	}

	public TestServiceImpl(String strHello, String hello) {
		this.strHello = strHello;
		this.hello = hello;
	}

	public void sayHello() {
		System.out.println("strHello : " + strHello);
		System.out.println(hello);
    }
}
