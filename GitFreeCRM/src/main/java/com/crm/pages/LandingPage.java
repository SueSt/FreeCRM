package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LandingPage extends TestBase {
	
//Page factory: ORValidate 
	
	@FindBy(xpath="//span[text()='Log In']")
	WebElement LGBtn1;
	
	
	@FindBy(xpath="//div[@class='rd-navbar-brand']//a[@title='free crm home']")
	WebElement Logo;
	
	
	@FindBy(xpath="//div[@class='rd-navbar-nav-wrap toggle-original-elements']")
	WebElement NavBar;

//Initialize The page Objects
	
		public LandingPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Define the actions
		
		public String ValidateLandingPageTitle() {
			return driver.getTitle();	
		}
		
		public String ValidateLandingPageUrl() {
			return driver.getCurrentUrl();	
		}
		
		public boolean ValidateLogo() {
			return Logo.isDisplayed();
		}
		
		public boolean ValidateNavBar() {
			return NavBar.isDisplayed();
		}
	
		public LoginPage ClickOnLoginBtn1() {
			LGBtn1.click();
			return new LoginPage();
		}
	
		
		
		
}
