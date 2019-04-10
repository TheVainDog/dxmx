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

import com.thevaindog.mx.dxmx.document.Field;
import com.thevaindog.mx.dxmx.repository.FieldRepository;

@RestController
@RequestMapping("/Field")
public class FieldController {

	@Autowired
	private FieldRepository repository;

	@GetMapping("/all")
	public Set<Field> getAll() {
		return repository.findAll(Field.class);
	}

	@GetMapping("/findBy/{field}/{value}")
	public Set<Field> getByField(@PathVariable("field") String field, @PathVariable("value") String value) {
		return repository.findByField(Field.class, field, value);
	}

	@PostMapping("/")
	public Field add(@Valid @RequestBody Field object) {
		return repository.add(Field.class, object);
	}

	@DeleteMapping("/")
	public void delete(@Valid @RequestBody Field object) {
		repository.remove(Field.class, object);
	}

	@GetMapping("/test")
	public Field test() {
		return new Field("id","name","target","description");
	}
}
