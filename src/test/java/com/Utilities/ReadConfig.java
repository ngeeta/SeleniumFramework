package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	String path = System.getProperty("user.dir") + "/Configuration/config.properties";
	Properties properties;

	public ReadConfig()  {
		properties = new Properties();
		FileInputStream fs;
		try {
			fs = new FileInputStream(path);
			try {
				properties.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		if (value != null) {
			return value;
		} else
			throw new RuntimeException("url not specified");

	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		if (value != null) {
			return value;
		} else
			throw new RuntimeException("browser not specified");

	}
}
