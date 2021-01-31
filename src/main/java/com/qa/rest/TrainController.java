package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.TrainDomain;
import com.qa.persistence.dto.PeopleDTO;
import com.qa.persistence.dto.TrainDTO;
import com.qa.services.PeopleService;
import com.qa.services.TrainService;


@RestController
@RequestMapping("/train")
public class TrainController {

	private TrainService service;

	@Autowired
	public TrainController(TrainService service) {
		super();
		this.service = service;
	}

	// GET, POST, PUT, DELETE

	// READ
	@GetMapping("/readAll")
	public ResponseEntity<List<TrainDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// READ
	@GetMapping("/read/{id}")
	public ResponseEntity<TrainDTO> readCat(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<TrainDTO> create(@RequestBody TrainDomain house) {
		return new ResponseEntity<TrainDTO>(this.service.create(house), HttpStatus.CREATED);
	}

	// Update
	@PutMapping("update/{id}")
	public ResponseEntity<TrainDTO> update(@PathVariable("id") Long id,  @RequestBody TrainDomain train) {
		return new ResponseEntity<>(this.service.update(id, train), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TrainDTO> deleteHouse(@PathVariable("id") Long id){
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
