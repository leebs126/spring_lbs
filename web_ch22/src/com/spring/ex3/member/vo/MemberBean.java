
package com.spring.ex3.member.vo;

public  class MemberBean  {
	private String id;
	private String name;
	private int age;
	private int weight;
	private int height;

	public MemberBean(){
		System.out.println("MemberBean »ý¼ºÀÚ");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

}

