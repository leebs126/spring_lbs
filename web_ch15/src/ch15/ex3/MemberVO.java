package ch15.ex3;

public class MemberVO {
	String id;
	String name;
	int height;
	int weight;
	int age;
	
	
	
	public MemberVO(String id, String name, int height, int weight, int age) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}
	public MemberVO() {
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
