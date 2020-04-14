package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Sue Mc')]")
	//@CacheLookup //to improve the script performance but it is used if you know nothing will be change in the elements
	WebElement userLabel;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement TasksLink;
	
	@FindBy(xpath="//button[contains(text(), 'New')]")
	WebElement NewBtn;
	
	
	
	
	//Initialize The page Objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Define the actions
	
		public String ValidateHomePageTitle() {
			return driver.getTitle();	
		}
	
		public String ValidateHomePageUrl() {
			return driver.getCurrentUrl();	
		}
		
		public ContactsPage ClickOnContactsLink() {
			ContactsLink.click();
			return new ContactsPage();
		}
		
		

		public DealsPage ClickOnDealsLink() {
			DealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage ClickOnTasksLink() {
			TasksLink.click();
			return new TasksPage();
		}
		
		public NewContactPage ClickOnNewContacts() {
			NewBtn.click();
			return new NewContactPage();
		}
		
		

		
		
		
		
		
		
}
