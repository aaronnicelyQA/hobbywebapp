package com.qa.persistence.dto;

public class TrainDTO {
	private Long Id;
	private String name;
	
//Constructors
	public TrainDTO() {
		super();
	}

public TrainDTO(Long id, String name) {
	super();
	Id = id;
	this.name = name;
	
}

//Getters n Setters
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

}




