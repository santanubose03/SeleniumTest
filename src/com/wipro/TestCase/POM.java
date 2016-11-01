package com.wipro.TestCase;





import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.wipro.pages.SignUpPage;

public class POM {
   
	 WebDriver driver=null;
	
	private static Logger POM_log=null;
//	private String FirstName,LastName,Email,Phone,Zipcode,Password,ConfirmPassword;
	
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	private WebElement signInLink;
	
	@FindBy(xpath="//input[@id='email-input']")
	private WebElement textEmail;
	
	@FindBy(xpath="//input[@id='password-input']")
	private WebElement textPassword;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	
	@FindBy(xpath="//a[contains(text(),'JOIN NOW')]")
	private WebElement joinNowButton;
	
	
	
		
	public POM(WebDriver driver){
		this.driver=driver;
//		this.FirstName=FirstName;
//		this.LastName=LastName;
//		this.Email=Email;
//		this.Phone=Phone;
//		this.Zipcode=Zipcode;
//		this.Password=Password;
//		this.ConfirmPassword=ConfirmPassword;
		
		PageFactory.initElements(driver, this);
			
	}
	
	
	
	
	public void JoinNowClick(String FirstName, String LastName, String Email, String Phone,String Zipcode, String Password, String ConfirmPassword){
	    POM_log=Logger.getLogger("POM Logger");
        WebDriverWait wait=new WebDriverWait(driver,5);
		
		wait.until(ExpectedConditions.elementToBeClickable(signInLink));
		signInLink.click();
		POM_log.info("Clicked on SignIn Link");
		
		
        wait.until(ExpectedConditions.elementToBeClickable(joinNowButton));
		joinNowButton.click();
		
		SignUpPage signuppage=new SignUpPage(driver);
		signuppage.Register(FirstName,LastName,Email,Phone,Zipcode,Password,ConfirmPassword);
		
	}
	
	
}
