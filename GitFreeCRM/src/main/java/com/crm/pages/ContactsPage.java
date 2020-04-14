package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase  {

	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	
	
	//Initialize The page Objects
	
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}	
		
		//Define the actions
		
		public boolean VerifyContactLabel() {
			return	contactsLabel.isDisplayed();
			}
		
		public void SelectContactsByName(String name) {
			driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td")).click();
		}
	
	
	
	
}
