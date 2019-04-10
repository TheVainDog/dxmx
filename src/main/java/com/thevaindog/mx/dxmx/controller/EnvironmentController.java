package com.thevaindog.mx.dxmx.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thevaindog.mx.dxmx.document.Environment;
import com.thevaindog.mx.dxmx.repository.EnvironmentRepository;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

	@Autowired
	private EnvironmentRepository repository;

	@GetMapping("/all")
	public Set<Environment> getAll() {
		return repository.findAll(Environment.class);
	}
	
	@GetMapping("/findBy/{field}/{value}")
	public Set<Environment> getByField(@PathVariable("field") String field, @PathVariable("value") String value) {
		return repository.findByField(Environment.class, field, value);
	}
	
	@PostMapping("/")
	public Environment add(@Valid @RequestBody Environment object) {
		return repository.add(Environment.class, object);
	}
	
	@DeleteMapping("/")
	public void delete(@Valid @RequestBody Environment object) {
		repository.remove(Environment.class, object);
	}
	
	@GetMapping("/test")
	public Environment test() {
		return new Environment("0","tst","Test Environement"); 
	}
}
