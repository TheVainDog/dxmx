package com.thevaindog.mx.dxmx.config;

import static com.thevaindog.mx.dxmx.util.Constant.FILE_CONFIGURATION;
import static com.thevaindog.mx.dxmx.util.Constant.JSON_CONFIG_FOLDER;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@ComponentScan({ "com.thevaindog.mx.dxmx.document", 
				 "com.thevaindog.mx.dxmx.service",
				 "com.thevaindog.mx.dxmx.controller",
				 "com.thevaindog.mx.dxmx.config",
				 "com.thevaindog.mx.dxmx.repository"})
@EnableMongoRepositories (basePackages = "com.thevaindog.mx.dxmx.repository")
@SpringBootApplication (exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class DxMxApplication {

	@Bean
	public Gson gson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}
	
	@Bean 
	public JsonParser jsonParser() {
		return new JsonParser();
	}
	
	@Bean
	public JsonElement jsonElement() {
		return jsonParser().parse(gson().toJson("[]"));
	}
	
	@Bean 
	public JsonObject jsonObject(){
		return new JsonObject();
	} 
	
	
	public static void main(String[] args) {
		createConfigFiles();
		SpringApplication.run(DxMxApplication.class, args);
	}
	
	public static void createConfigFiles() {
		
		if (Files.notExists(Paths.get(JSON_CONFIG_FOLDER))) {
			try {
				Files.createDirectories(Paths.get(JSON_CONFIG_FOLDER));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (Files.exists(Paths.get(JSON_CONFIG_FOLDER))) {
			FILE_CONFIGURATION.forEach(file -> {
				try{
					if (Files.notExists(Paths.get(JSON_CONFIG_FOLDER+file))){
						Files.createFile(Paths.get(JSON_CONFIG_FOLDER+file));
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}
}

