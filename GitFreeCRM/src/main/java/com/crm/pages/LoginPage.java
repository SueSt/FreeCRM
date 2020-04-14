package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {

	//Page factory: ORValidate 
	
	@FindBy(xpath="//span[text()='Log In']")
	WebElement LGBtn1;

	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement ForgotPasswdLink;
	
	//Initialize The page Objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Define the actions
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();	
	}
	
	public String ValidateLoginPageUrl() {
		return driver.getCurrentUrl();	
	}
	
	public boolean ValidateForgotPasswordLink() {
		return ForgotPasswdLink.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();	
		return new HomePage();
	}

	
}
