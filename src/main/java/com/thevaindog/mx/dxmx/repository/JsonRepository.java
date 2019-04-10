package com.thevaindog.mx.dxmx.repository;

import static com.thevaindog.mx.dxmx.util.Constant.JSON_CONFIG_FOLDER;
import static com.thevaindog.mx.dxmx.util.Constant.JSON_EXTENSION_FILE;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.thevaindog.mx.dxmx.document.JsonFile;


public abstract class JsonRepository<T> implements JsonFileRepository<T> {
	
	@Autowired
	Gson gson;
	
	@Autowired
	JsonParser jsonParser;
	
	@Autowired
	JsonObject jsonObject;
	
	@Autowired
	JsonElement jsonElement;
	
	public Set<T> findAll(Class<T> clazz){
		return readData(clazz);
	};
	
	public Set<T> findByField(Class<T> clazz, String field, String value){
		Set<T> tSet = new HashSet<T>();
		for (T t: readData(clazz)) {
		    jsonElement =  jsonParser.parse(gson.toJson(t));
		    jsonObject = jsonElement.getAsJsonObject();
		    if(jsonObject.get(field).getAsString().equals(value)){
		    	tSet.add(t);
		    }
		}	
		return tSet; 
	};
	
	public T add(Class<T> clazz, T e){
		Set<T> tSet = readData(clazz);
		tSet.add(e);
		writeData(clazz, tSet);
		return e;
	}
	
	public boolean remove(Class<T> clazz, T e){
		boolean removed = false;
		Set<T> tSet = readData(clazz);
	    jsonElement =  jsonParser.parse(gson.toJson(e));
		for (T t: tSet) {
		    if(jsonElement.equals(jsonParser.parse(gson.toJson(t)))) {
		    	removed = tSet.remove(t);
		    	break;
		    }
		}	
		writeData(clazz, tSet);
		return removed;
	}
	
	private String getFileName(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance().getClass().getAnnotation(JsonFile.class).value();
	}
	
	private Set<T> readData(Class<T> clazz) {
		Set<T> t = null;
		try(FileReader fileReader = new FileReader(JSON_CONFIG_FOLDER + getFileName(clazz) + JSON_EXTENSION_FILE)){
			JsonReader jsonReader = new JsonReader(fileReader);
			Type tType = new TypeToken<HashSet<T>>(){}.getType();
			t = gson.fromJson(jsonReader, tType);
			fileReader.close();
			jsonReader.close();
		} catch ( InstantiationException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	private void writeData(Class<T> clazz, Set<T> data) {
		try(FileWriter fileWriter = new FileWriter(JSON_CONFIG_FOLDER + getFileName(clazz) + JSON_EXTENSION_FILE)){
			gson.toJson(data,fileWriter);
			fileWriter.close();
		} catch ( InstantiationException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
