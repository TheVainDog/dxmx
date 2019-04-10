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

import com.thevaindog.mx.dxmx.document.Implementation;
import com.thevaindog.mx.dxmx.repository.ImplementationRepository;

@RestController
@RequestMapping("/implementation")
public class ImplementationController {

	@Autowired
	private ImplementationRepository repository;

	@GetMapping("/all")
	public Set<Implementation> getAll() {
		return repository.findAll(Implementation.class);
	}

	@GetMapping("/findBy/{field}/{value}")
	public Set<Implementation> getByField(@PathVariable("field") String field, @PathVariable("value") String value) {
		return repository.findByField(Implementation.class, field, value);
	}

	@PostMapping("/")
	public Implementation add(@Valid @RequestBody Implementation object) {
		return repository.add(Implementation.class, object);
	}

	@DeleteMapping("/")
	public void delete(@Valid @RequestBody Implementation object) {
		repository.remove(Implementation.class, object);
	}

	@GetMapping("/test")
	public Implementation test() {
		return new Implementation();
	}
}
