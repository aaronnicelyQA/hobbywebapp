package com.qa.persistence.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	
	@Entity
	public class People {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		
			
		private String name;
		private int age;
		private String address;
		
		
		//Empty Constructor
		
		public People() {
			super(); 
			}
		
		
		//Full Constructor
		public People(Long id, String name, int age, String address) {
			super();
			Id = id;
			this.name = name;
			this.age = age;
			this.address = address;
		}


		
		
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
			return "People [Id=" + Id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
		}

		
		
		
		
	}


