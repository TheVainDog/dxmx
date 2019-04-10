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

import com.thevaindog.mx.dxmx.document.Configuration;
import com.thevaindog.mx.dxmx.repository.ConfigurationRepository;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

	@Autowired
	private ConfigurationRepository repository;

	@GetMapping("/all")
	public Set<Configuration> getAll() {
		return repository.findAll(Configuration.class);
	}

	@GetMapping("/findBy/{field}/{value}")
	public Set<Configuration> getByField(@PathVariable("field") String field, @PathVariable("value") String value) {
		return repository.findByField(Configuration.class, field, value);
	}

	@PostMapping("/")
	public Configuration add(@Valid @RequestBody Configuration object) {
		return repository.add(Configuration.class, object);
	}

	@DeleteMapping("/")
	public void delete(@Valid @RequestBody Configuration object) {
		repository.remove(Configuration.class, object);
	}

	@GetMapping("/test")
	public Configuration test() {
		return new Configuration();
	}
}
