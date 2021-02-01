package com.qa.rest;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.HobbyWebApplication;
import com.qa.persistence.domain.PeopleDomain;
import com.qa.persistence.dto.PeopleDTO;

@SpringBootTest(classes = HobbyWebApplication.class)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "reg")
public class PeopleControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private final int TEST_ID ;
	
	private PeopleDTO mapToDTO(PeopleDomain model) {
		return this.mapper.map(model,  PeopleDTO.class);
	}
	
//	==========================
//	TESTS
//	==========================
	
	//CREATE
	@Test
	public void createPeople() throws Exception { 
			
			//Staged Resource // expectation
			PeopleDTO TEST_PEOPLE = new PeopleDTO(1L, "AARON", 23, "22 Draycote Road");
			PeopleDomain TEST_PEOPLEDOMAIN = new PeopleDomain(1L, "AARON", 23, "22 Draycote Road", null);
			
			//Prepared REST Request
			MockHttpServletRequestBuilder mockRequest
			
			= MockMvcRequestBuilders.request(HttpMethod.GET, "/people/create/"+TEST_ID)
			.contentType(MediaType.APPLICATION_JSON)
			//.content(this.jsonifier.writeValueAsString(TEST_PEOPLEDOMAIN))
			.accept(MediaType.APPLICATION_JSON);
			
			//Auto-Increment
			TEST_PEOPLEDOMAIN.setId(4L);
			
			
			//Assertion Checks
			 ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.jsonifier.writeValueAsString(TEST_PEOPLE));
			//ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.jsonifier.writeValueAsString(TEST_PEOPLE));
			ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
			
			//Perform & Assert
			this.mock.perform(mockRequest)
			.andExpect(matchStatus)
			.andExpect(matchContent);
		}
		
		

	
	//READ
	@Test
	public void readOnePeople() throws Exception { 
		
		//Staged Resource // expectation
		PeopleDTO TEST_PEOPLE = new PeopleDTO(1L, "AARON", 23, "22 Draycote Road");
		
		//Prepared REST Request
		MockHttpServletRequestBuilder mockRequest
		
		= MockMvcRequestBuilders.request(HttpMethod.GET, "/people/read/"+TEST_ID)
		.contentType(MediaType.APPLICATION_JSON)
		//.content(this.jsonifier.writeValueAsString(value))
		.accept(MediaType.APPLICATION_JSON);
		
		
		//Assertion Checks
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this,jsonifier.writeValueAsString(TEST_PEOPLE));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		
		//Perform & Assert
		this.mock.perform(mockRequest)
		.andExpect(matchStatus)
		.andExpect(matchContent);
	}
	
	@Test
	public void readAllPeople() throws Exception { 
		
		//Staged Resource // expectation
				PeopleDTO TEST_PEOPLE = new PeopleDTO(1L, "AARON", 23, "22 Draycote Road");
				
				//Prepared REST Request
				MockHttpServletRequestBuilder mockRequest
				
				= MockMvcRequestBuilders.request(HttpMethod.GET, "/people/readAll/"+TEST_ID)
				.contentType(MediaType.APPLICATION_JSON)
				//.content(this.jsonifier.writeValueAsString(value))
				.accept(MediaType.APPLICATION_JSON);
				
				
				//Assertion Checks
				ResultMatcher matchContent = MockMvcResultMatchers.content().json(this,jsonifier.writeValueAsString(TEST_PEOPLE));
				ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
				
				//Perform & Assert
				this.mock.perform(mockRequest)
				.andExpect(matchStatus)
				.andExpect(matchContent);
		
	}
	
	//UPDATE
	@Test
	public void updatePeople() { 
		
		//Staged Resource // expectation
				PeopleDTO TEST_PEOPLE = new PeopleDTO(1L, "AARON", 23, "22 Draycote Road");
				
				//Prepared REST Request
				MockHttpServletRequestBuilder mockRequest
				
				= MockMvcRequestBuilders.request(HttpMethod.GET, "/people/update/"+TEST_ID)
				.contentType(MediaType.APPLICATION_JSON)
				//.content(this.jsonifier.writeValueAsString(value))
				.accept(MediaType.APPLICATION_JSON);
				
				
				//Assertion Checks
				ResultMatcher matchContent = MockMvcResultMatchers.content().json(this,jsonifier.writeValueAsString(TEST_PEOPLE));
				ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
				
				//Perform & Assert
				this.mock.perform(mockRequest)
				.andExpect(matchStatus)
				.andExpect(matchContent);
		
	}
	
	//DELETE
	@Test
	public void deletePeople() throws Exception { 
		
		//Staged Resource // expectation
				PeopleDTO TEST_PEOPLE = new PeopleDTO(1L, "AARON", 23, "22 Draycote Road");
				
				//Prepared REST Request
				MockHttpServletRequestBuilder mockRequest
				
				= MockMvcRequestBuilders.request(HttpMethod.GET, "/people/delete/"+TEST_ID)
				.contentType(MediaType.APPLICATION_JSON)
				//.content(this.jsonifier.writeValueAsString(value))
				.accept(MediaType.APPLICATION_JSON);
				
				
				//Assertion Checks
				ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(TEST_PEOPLE));
				ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
				
				//Perform & Assert
				this.mock.perform(mockRequest)
				.andExpect(matchStatus)
				.andExpect(matchContent);
		
	}
	

}
