package com.wipro.Dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.wipro.Utility.Read_XLS_utility;
import com.wipro.Utility.properties_Utility;

public class dataprovider {

	@DataProvider(name="LoginData")
	
	   public static Object[][] LoginData() throws IOException{
		
		String sheetname="TestData123";
		Read_XLS_utility Filelocation=new Read_XLS_utility(properties_Utility.properties("./resources/TestBed.properties"),sheetname);
		
	    return Filelocation.retrieveTestData(sheetname);
		 
	}
}
