package it.contrader.main;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

	public static boolean utils_conf() {
	Properties properties = new Properties();
    InputStream inputStream;
	try {
		inputStream = new FileInputStream("config.properties");
		properties.load(inputStream);
		return Boolean.parseBoolean( properties.getProperty("debug"));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
    
   
    
	}
}
