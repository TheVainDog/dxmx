package com.thevaindog.mx.dxmx.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.thevaindog.mx.dxmx.document.SQLStatement;
import com.thevaindog.mx.dxmx.repository.SQLStatementRepository;

@RestController
@RequestMapping("/sqlstatement")
public class SQLStatementController {

	@Autowired
	private SQLStatementRepository repository;

	@GetMapping("/all")
	public Set<SQLStatement> getAll() {
		return repository.findAll(SQLStatement.class);
	}

	@GetMapping("/findBy/{field}/{value}")
	public Set<SQLStatement> getByField(@PathVariable("field") String field, @PathVariable("value") String value) {
		return repository.findByField(SQLStatement.class, field, value);
	}

	@PostMapping("/")
	public SQLStatement add(@Valid @RequestBody SQLStatement object) {
		return repository.add(SQLStatement.class, object);
	}

	@DeleteMapping("/")
	public void delete(@Valid @RequestBody SQLStatement object) {
		repository.remove(SQLStatement.class, object);
	}

	@GetMapping("/test")
	public SQLStatement test() {
		List<Field> fields = new ArrayList<Field>();
		fields.add(new Field("id_1","name_1","target_1","description_1"));
		fields.add(new Field("id_2","name_2","target_2","description_2"));
		return new SQLStatement("id", "type", fields, "description");
	}
}
