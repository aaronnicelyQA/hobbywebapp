package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.config.MyBeanUtils;
import com.qa.persistence.domain.PeopleDomain;
import com.qa.persistence.dto.PeopleDTO;
import com.qa.repos.PeopleRepo;

@Service
public class PeopleService {
	
	private PeopleRepo repo;
	private ModelMapper mapper;
	
	@Autowired	
	public PeopleService(PeopleRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private PeopleDTO mapToDTO(PeopleDomain model) {
		return this.mapper.map(model, PeopleDTO.class);
	}
	
	// CRUD
	// Create
	public PeopleDTO create(PeopleDomain model) {
		return mapToDTO(this.repo.save(model));
	}
	
	// Read
	public PeopleDTO readOne(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}
	
	public List<PeopleDTO> readAll() {
		
		List<PeopleDomain> peopleList = this.repo.findAll();
		List<PeopleDTO> peopleListDTO = peopleList.stream().map(this::mapToDTO).collect(Collectors.toList());
		
		return peopleListDTO;
	}
	
	// Update
	public PeopleDTO update(long id, PeopleDomain people) {
		
		PeopleDomain updatedPerson = this.repo.findById(id).orElseThrow();
		MyBeanUtils.mergeNotNull(people, updatedPeople);
		
		return this.mapToDTO(this.repo.save(updatedPeople));
	}
	
	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}

}
