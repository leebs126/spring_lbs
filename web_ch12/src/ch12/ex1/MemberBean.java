package ch12.ex1;

public class MemberBean {
	private String id;
	private String name;
	private String age;
	private String weight;
	private String height;
	
	public MemberBean() {
		
	}
	
	
	public MemberBean(String id, String name, String age, String weight, String height) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	
	
}
