package com.qa.persistence.dto;

public class PeopleDTO {
	private Long Id;
	private String name;
	private int age;
	private String address;
	
	// Constructors
	public PeopleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PeopleDTO(Long id, String name, int age, String address) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	// Get/Set
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PeopleDTO [Id=" + Id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}