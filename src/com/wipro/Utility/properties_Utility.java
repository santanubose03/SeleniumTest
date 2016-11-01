package com.wipro.Utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class properties_Utility {

	public static String properties( String path ) throws IOException{
		
		FileInputStream ipstm=new FileInputStream(path);
		Properties properties=new Properties();
		properties.load(ipstm);
		return properties.getProperty("excelpath");
		
	}
}
