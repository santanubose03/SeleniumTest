package com.wipro.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	
	WebDriver driver=null;
	

//	@FindBy(xpath="//span[@class='js-account-first-name myLowesFirstName']")
//	private WebElement greetingNameText;
//	
//	@FindBy(xpath="//span[contains(text(),'Sign Out')]")
//	private WebElement signOutLink;
//	
	By by=By.xpath("//span[contains(text(),'Sign Out')]");
	
	public HomePage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
//	public void validateHomePage(String FirstName, String LastName, String Email, String Phone,String Zipcode, String Password, String ConfirmPassword){
//		
//		Logger HomePageLog=Logger.getLogger("HomePage_Log");
//		
////		String GreetingName=greetingNameText.getText();
//		
////		Assert.assertEquals(GreetingName,FirstName,"Verified Name");
//		HomePageLog.info("User FirstName Verified");
//		
//		signOutLink.click();
//		HomePageLog.info("Clicked Signout");
//		
//		
//	}
	
	public void validateHomePage(){
		
		retryingFindClick(by);
	} 
	
	public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 4) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
}
}
