package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lgPage;
	HomePage hmPage;
	LandingPage	ldPage;

//1- Create Constructor
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		Initialization();
		//Create an Object of the LoginPage Class
		lgPage= new LoginPage();
		ldPage= new LandingPage();
		hmPage=new HomePage();
	}
	
	/*@Test(priority=4)
	public void  ClickOnLoginBtn1Test() {
	lgPage=ldPage.ClickOnLoginBtn1();
	}*/
	
	@Test(priority=1)
	public void ValidateLoginPageTitleTest() {
		ldPage.ClickOnLoginBtn1();
		String title=lgPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void ValidateLoginPageUrlTest() {
		ldPage.ClickOnLoginBtn1();
		String cururl=lgPage.ValidateLoginPageUrl();
		Assert.assertEquals(cururl, "https://ui.freecrm.com/");
	}
	
	@Test(priority=3)
	public void ValidateForgotPasswordLinkTest() {
		ldPage.ClickOnLoginBtn1();
		boolean pwdLink=lgPage.ValidateForgotPasswordLink();
		Assert.assertTrue(pwdLink);
	}
	
	@Test(priority=4)
	public void  LoginTest() {
	ldPage.ClickOnLoginBtn1();
	hmPage=lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
