package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties init_prop() throws FileNotFoundException
	{
		
		prop = new Properties();
		FileInputStream fin = new FileInputStream("src/test/resources/configfiles/config.properties");
        try {
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return prop;
	}
	

}
