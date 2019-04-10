package com.thevaindog.mx.dxmx.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constant {

	public static final String SQL_BASE_PATH = "";
	public static final String SPLITTER = "";
	public static final String JSON_EXTENSION_FILE = ".json";
	public static final String JSON_CONFIG_FOLDER = "./config/";
	public static final Set<String> FILE_CONFIGURATION = 
			new HashSet<>(Arrays.asList("configuration.json","environment.json", "field.json","format.json","implementation.json","sqlstatement.json"));
	
	
	private Constant() {super();}

}

