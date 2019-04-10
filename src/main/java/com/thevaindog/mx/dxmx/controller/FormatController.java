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

import com.thevaindog.mx.dxmx.document.Format;
import com.thevaindog.mx.dxmx.repository.FormatRepository;

@RestController
@RequestMapping("/format")
public class FormatController {

	@Autowired
	private FormatRepository repository;

	@GetMapping("/all")
	public Set<Format> getAll() {
		return repository.findAll(Format.class);
	}

	@GetMapping("/findBy/{field}/{value}")
	public Set<Format> getByField(@PathVariable("field") String field, @PathVariable("value") String value) {
		return repository.findByField(Format.class, field, value);
	}

	@PostMapping("/")
	public Format add(@Valid @RequestBody Format object) {
		return repository.add(Format.class, object);
	}

	@DeleteMapping("/")
	public void delete(@Valid @RequestBody Format object) {
		repository.remove(Format.class, object);
	}

	@GetMapping("/test")
	public Format test() {
		return new Format("id","type","description");
	}
}
