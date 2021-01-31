package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.config.MyBeanUtils;
import com.qa.persistence.domain.TrainDomain;
import com.qa.persistence.dto.TrainDTO;
import com.qa.repos.TrainRepo;

@Service
public class TrainService {
	
	private TrainRepo repo;
	private ModelMapper mapper;
	
	@Autowired	
	public TrainService(TrainRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private TrainDTO mapToDTO(TrainDomain model) {
		return this.mapper.map(model, TrainDTO.class);
	}
	
	// CRUD
	// Create
	public TrainDTO create(TrainDomain model) {
		return mapToDTO(this.repo.save(model));
	}
	
	// Read
	public TrainDTO readOne(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow());
	}
	
	public List<TrainDTO> readAll() {
		
		List<TrainDomain> trainlist = this.repo.findAll();
		List<TrainDTO> trainListDTO = trainList.stream().map(this::mapToDTO).collect(Collectors.toList());
		
		return trainListDTO;
	}
	
	// Update
	public TrainDTO update(long id, TrainDomain house) {
		
		TrainDomain updatedHouse = this.repo.findById(id).orElseThrow();
		MyBeanUtils.mergeNotNull(house, updatedHouse);
		
		return this.mapToDTO(this.repo.save(updatedHouse));
	}
	
	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}

}


