package com.luma.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility1 {

	public String toReadData(String key) throws IOException {
		
		FileInputStream file=new FileInputStream("./src/test/resources/lumaprojectdata.properties/");
		Properties pobj=new Properties();
		pobj.load(file);
		String value=pobj.getProperty(key);
		return value;
		
	}
}
