package com.qa.rest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.HobbyWebApplication;
import com.qa.repos.PeopleRepo;
import com.qa.services.PeopleService;

@SpringBootTest(classes = HobbyWebApplication.class)
public class PeopleServiceUnitTest {
	
	//InjectMocks
	@Autowired
	private PeopleService service;
	
	@MockBean
	private PeopleRepo repoMock;
	
	//Create
	@Test
	public void createTest() {
		//Rules
		Mockito.when(this.repoMock.save(any()))
		
		
		
		//Action
		this.service.create(model)
	}
}
