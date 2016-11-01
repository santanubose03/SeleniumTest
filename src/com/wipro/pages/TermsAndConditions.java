package com.wipro.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TermsAndConditions {

	WebDriver driver=null;
	String ExpectedTermsConditions="Terms and Conditions of Use";
	
	@FindBy(xpath="//h1[contains(text(),'Terms and Conditions of Use')]")
	private WebElement TermsAndConditionsText;
	
	public TermsAndConditions(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Validate_TCPage(){
		Logger TCLog=Logger.getLogger("Terms&Conditions Logger");
		
		WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.textToBePresentInElement(TermsAndConditionsText, "Terms and Conditions of Use"));
		
		String ActualTermsConditions=TermsAndConditionsText.getText();
        Assert.assertEquals(ActualTermsConditions, ExpectedTermsConditions, "Terms & Conditions Window verified");
        
        TCLog.info("Terms & Conditions Window verified");
        
        
        
        
	}
}
