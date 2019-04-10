package com.thevaindog.mx.dxmx.repository;

import java.util.Set;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JsonFileRepository<T> {
	
	public abstract Set<T> findAll(Class<T> clazz);
	
	public abstract Set<T> findByField(Class<T> clazz, String field, String value);
	
	public abstract T add(Class<T> clazz, T e);
	
	public abstract boolean remove(Class<T> clazz, T e);
	
}
