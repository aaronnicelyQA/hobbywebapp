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

import com.qa.persistence.domain.PeopleDomain;
import com.qa.persistence.dto.PeopleDTO;
import com.qa.services.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {

	private PeopleService service;

	@Autowired
	public PeopleController(PeopleService service) {
		super();
		this.service = service;
	}

	// GET, POST, PUT, DELETE

	// READ
	@GetMapping("/readAll")
	public ResponseEntity<List<PeopleDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// READ
	@GetMapping("/read/{id}")
	public ResponseEntity<PeopleDTO> readPeople(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<PeopleDTO> create(@RequestBody PeopleDomain people) {
		return new ResponseEntity<PeopleDTO>(this.service.create(people), HttpStatus.CREATED);
	}

	// Update
	@PutMapping("update/{id}")
	public ResponseEntity<PeopleDTO> update(@PathVariable("id") Long id,  @RequestBody PeopleDomain people) {
		return new ResponseEntity<>(this.service.update(id, people), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PeopleDTO> deletePeople(@PathVariable("id") Long id){
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
