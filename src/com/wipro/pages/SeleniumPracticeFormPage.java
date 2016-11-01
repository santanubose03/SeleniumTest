package com.wipro.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SeleniumPracticeFormPage {

          private static WebDriver driver;
		  
		  boolean dateNotFound;
		  
		  List<String>monthList=Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		   
		  List<WebElement>noOfColumns;
		  
		  int expMonth=7;
		  int expYear=2016;
		  String expDate="1";
		  String calMonth,calYear;
		  
		  
		 @FindBy(xpath="//Textarea[@id='vfb-10']") 
		private WebElement textAreaBox;
		 
		 @FindBy(xpath="//input[@id='vfb-9']")
		 private WebElement textBox;
		 
		 @FindBy(xpath="//input[@type='checkbox'][contains(@value,'Option')]")
		 List<WebElement>checkBoxes;
		 
		
		@FindBy(xpath="//input[@type='radio'][contains(@value,'Option')]")
		private List <WebElement> RadioButtons;
		
		@FindBy(xpath="//label[contains(text(),'Date')]/following-sibling::input[@type='text']")
		private WebElement dateBox;
		
		@FindBy(xpath="//div[@id='ui-datepicker-div']//following::a[@title='Next']")
		private WebElement calNext;
		
		@FindBy(xpath="//div[@id='ui-datepicker-div']//following::a[@title='Prev']")
		private WebElement calPrev;
		
		@FindBy(xpath="//div[@id='ui-datepicker-div']")
		private WebElement DatePick;
		
		@FindBy(xpath="//label[contains(text(),'URL')]/following::input[@type='url']")
		private WebElement urlBox;
		
		@FindBy(xpath="//label[contains(text(),'Select')]/following-sibling::select[@id='vfb-12']")
		private WebElement selectOption;
		
		@FindBy(xpath="//label[contains(text(),'Example: 12')]/preceding-sibling::input[@type='text']")
		private WebElement VerificationText;
		
		@FindBy(xpath="//input[@type='submit' and @name='vfb-submit']")
		private WebElement SubmitButton;
		
		
		public SeleniumPracticeFormPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void clickRadio(int i){
			
			RadioButtons.get(i).click();
			
		}
		
		public void clickCheckbox(int i){
			checkBoxes.get(i).click();
			
		}
		
		
		public void datePicker(int date,int mon,int year) throws InterruptedException{
			
			dateNotFound = true;
			
			while(dateNotFound){
				
				calMonth=calNext.getText();
				calYear=calPrev.getText();
				
				if((monthList.indexOf(calMonth)+1==expMonth) && (expYear==Integer.parseInt(calYear))){
					
					dateSelect(expDate);
					dateNotFound=false;
					
				}else if((monthList.indexOf(calMonth)+1<expMonth)&&(expYear==Integer.parseInt(calYear))){
					
					calNext.click();
					
				}
				else if ((monthList.indexOf(calMonth)+1>expMonth)&& (expYear==Integer.parseInt(calYear))){
					
					calPrev.click();
				}
				
				Thread.sleep(2000);
			}
			
		}
		
	public void dateSelect(String date){
		
			noOfColumns= DatePick.findElements(By.tagName("td"));
			
			for(WebElement cell: noOfColumns){
				
				if(cell.getText().equals(date)){
					cell.findElement(By.linkText(date)).click();
					break;
				}
			}	
		}
		
		
	public void enterUrl(){
			
			String urlText=driver.getCurrentUrl();
			urlBox.sendKeys(urlText);
		}	
		
	public void selectOptions(String Text){
		
			Select select=new Select(selectOption);
			
		    select.selectByVisibleText(Text);	
		}
		
	public void verification(String text){
		
		VerificationText.sendKeys(text);
	}
		
	public void submitForm(){
		
		SubmitButton.click();
	}
	
	
	}