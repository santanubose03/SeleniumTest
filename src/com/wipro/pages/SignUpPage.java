package com.wipro.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	 WebDriver driver=null;
	 
	 
	    @FindBy(xpath="//h1[contains(text(),'Sign Up')]")
		private WebElement signUpText;
		
		@FindBy(xpath="//input[@id='firstName']")
		private WebElement firstNameText;
		
		@FindBy(xpath="//input[@id='lastName']")
		private WebElement lastNameText;
		
		@FindBy(xpath="//input[@id='email1']")
		private WebElement emailAddressText;
		
		@FindBy(xpath="//input[@id='phoneUS']")
		private WebElement phoneNumber;
		
		@FindBy(xpath="//input[@id='password1']")
		private WebElement passwordText;
		
		@FindBy(xpath="//input[@id='password2']")
		private WebElement confirmPasswordText;
		
		@FindBy(xpath="//input[@id='prefStoreZipCode']")
		private WebElement zipCodeNumber;
		
		@FindBy(xpath="//button[@class='close js-zip-in-modal-close']")
		private WebElement popUpCrossIcon;
		
		@FindBy(xpath="//label[@class='error']")
		private WebElement errorText;
		
		@FindBy(xpath="//label[contains(@for,'signup-subscriptions')]")
		private WebElement checkBox;
		
		@FindBy(xpath="//a[@title='Terms and Conditions']")
		private WebElement TermsAndConditionsLink;
		
		@FindBy(xpath="//button[@id='createAccount']")
		private WebElement createAccountButton;
		
	 
	public SignUpPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Register(String FirstName, String LastName, String Email, String Phone,String Zipcode, String Password, String ConfirmPassword)
	{
		Logger SignUpLog=Logger.getLogger("SignUp_Logger");
		
		firstNameText.sendKeys(FirstName);
		SignUpLog.info("Entered First Name");
		
		lastNameText.sendKeys(LastName);
		SignUpLog.info(" Entered Last Name");
		
		emailAddressText.sendKeys(Email);
		SignUpLog.info("Entered Email Address");
		
		phoneNumber.sendKeys(String.valueOf(Phone));
		SignUpLog.info("Entered phone number");
		
		try{
	           popUpCrossIcon.click();
	           SignUpLog.info("PopUp Box Has Been handled");
			}
			catch(Exception e){
				System.out.println("PopUp box didn't  appear");
				SignUpLog.info("PopUp box didn't  appear");
			}
		
		zipCodeNumber.sendKeys(String.valueOf(Zipcode));
		SignUpLog.info("Entered ZipCode Number");
		
		passwordText.sendKeys(Password);
		SignUpLog.info("Entered Password");
		
		
		
		confirmPasswordText.sendKeys(ConfirmPassword);
		SignUpLog.info("Confirmed Password");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
        checkBox.click();
			
		
	
       String parentWindow = driver.getWindowHandle();
	
       SignUpLog.info("Clicked Terms & conditions link");
		TermsAndConditionsLink.click();
		
		Set<String> handles =  driver.getWindowHandles();
		
	
	for(String windowHandle  : handles)
	{
	    if(!windowHandle.equals(parentWindow))
	   {
		     
		     TermsAndConditions TC=new TermsAndConditions(driver);
		     
		     driver.switchTo().window(windowHandle);
		     
		     TC.Validate_TCPage();
		     
		     driver.close(); 
		     
		     driver.switchTo().window(parentWindow); 
		     
		     SignUpLog.info("Switched to Parent Window");
		    }
		}
		
      createAccountButton.click();
       SignUpLog.info("Clicked on Created Account Button");
       
       HomePage homepage=new HomePage(driver);
       homepage.validateHomePage();      
	    
	}
	
}
