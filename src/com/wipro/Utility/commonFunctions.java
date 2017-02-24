package com.wipro.Utility;

import java.io.FileInputStream;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class commonFunctions extends properties_Utility{
    
	public static WebDriver driver=null;
	public boolean browserAlreadyOpen=false;
	public static Properties SysParam=null;
	public String PROXY="10.113.50.55:8080";
	public static Logger Addlog=null;
	public void initData() throws Exception{
		
		SysParam=new Properties();
		FileInputStream ipstrm= new FileInputStream("./resources/SysParam.properties");
		SysParam.load(ipstrm);
		
		Addlog.info("data read from SYSPARAM property file");
	}
		
	public void initBrowser(){
		Addlog.info("initBrowser method is initialized");
		if(!browserAlreadyOpen){
			Addlog.info("Setting Proxy");
//			Proxy proxy=new Proxy();
//			proxy.setFtpProxy(PROXY).setHttpProxy(PROXY).setSslProxy(PROXY).setSocksProxy(PROXY);
//			
//			DesiredCapabilities caps=new DesiredCapabilities();
//			caps.setCapability(CapabilityType.PROXY, proxy);
			
			Addlog.info("Proxy has been set");
			
			if(SysParam.getProperty("Browser").equals("MFF")){
				ProfilesIni profileinit= new ProfilesIni();
				FirefoxProfile webdriverprofile=profileinit.getProfile("Default");
				driver=new FirefoxDriver(webdriverprofile);
				Addlog.info("FirefoxDriver instance has been created");
			}else if(SysParam.getProperty("Browser").equals("CHRM")){
				System.getProperty("webdriver.chrome.driver","./BrowserDrivers/chromedriver.exe");
				driver=new ChromeDriver(); 
				Addlog.info("ChromeDriver instance has been created");
			}
			driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS );
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Addlog.info("Page is loaded");
			 
			driver.manage().window().maximize();
			driver.get("https://www.lowes.com/");
			Addlog.info("Launched the website");
		}
		
		
	}
	public void CloseBrowser(){
		driver.quit();
		browserAlreadyOpen=false;
		Addlog.info("The browser has been closed");
	}


	
}
