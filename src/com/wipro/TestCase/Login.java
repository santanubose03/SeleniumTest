
package com.wipro.TestCase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import com.wipro.Utility.properties_Utility;
import com.wipro.Dataprovider.*;

import com.wipro.Utility.Read_XLS_utility;
import com.wipro.Utility.commonFunctions;

public class Login extends commonFunctions {
	
	
        
	String sheetname;
	Read_XLS_utility Filelocation;

	
	@BeforeTest
	public void Setup() throws Exception{
	  
		initData();
		
	    sheetname="TestData";
	    Filelocation=new Read_XLS_utility( properties_Utility.properties("./resources/TestBed.properties"),sheetname);
	
	    initBrowser();
	    driver.get("www.google.com");
	
	}
	
	@AfterTest
	
	public void Teardown(){
		
		CloseBrowser();
	}
	
	
	@Test(dataProvider="LoginData", dataProviderClass=dataprovider.class)
	
	public void LoginTest(String username, String password) throws InterruptedException{
		
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/form/div/input[1]")).sendKeys(username);
		Thread.sleep(2);
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/form/div/input[2]")).sendKeys(password);
		Thread.sleep(2);
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/form/div/input[3]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='welcome']/a[2]")).click();
		driver.findElement(By.xpath(".//*[@id='welcome']/a[1]")).click();
		
		
		
	}
	
}

