package com.wipro.TestCase;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wipro.Dataprovider.dataprovider;
import com.wipro.Utility.commonFunctions;

public class Demo extends commonFunctions{

	
	
	@BeforeTest
	public void Setup() throws Exception{
		Addlog=Logger.getLogger("root Logger");
		Addlog.info("Initialized Testing");
		initData();
		initBrowser();
										
	}
	
	
	@Test(dataProvider="LoginData",dataProviderClass=dataprovider.class)
	
	public void Registration(String FirstName, String LastName, String Email, String Phone,String Zipcode, String Password, String ConfirmPassword)
	{    
		Addlog.info("Test Starts");
		
		POM pom=new POM(driver);
		Addlog.info("Page object model instance has been created");
		
		pom.JoinNowClick( FirstName,LastName,Email,Phone,Zipcode,Password,ConfirmPassword);
		Addlog.info("initializing Register method of POM");
		
		
	}
}
