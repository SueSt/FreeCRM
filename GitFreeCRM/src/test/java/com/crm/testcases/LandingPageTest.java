package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;

public class LandingPageTest extends TestBase {
	LandingPage	ldPage;
	LoginPage lgPage;
	
	//1- Create Constructor
		public LandingPageTest() {
			super();
		}
	
		@BeforeMethod
		public void SetUp() {
			Initialization();
			//Create an Object of the LoginPage Class
			ldPage= new LandingPage();
		}
		
		@Test(priority=1)
		public void ValidateLandingPageTitleTest() {
			String title=ldPage.ValidateLandingPageTitle();
			Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		}
		
		@Test(priority=2)
		public void ValidateLandingPageUrlTest() {
			String cururl=ldPage.ValidateLandingPageUrl();
			Assert.assertEquals(cururl, "https://freecrm.com/");
		}
		
		@Test(priority=3)
		public void ValidateLogoTest() {
			boolean logo =ldPage.ValidateLogo();
			Assert.assertTrue(logo);
		}
		
		@Test(priority=4)
		public void ValidateNavBarTest() {
			boolean NavBar =ldPage.ValidateNavBar();
			Assert.assertTrue(NavBar);
		}
		
		@Test(priority=5)
		public void  ClickOnLoginBtn1Test() {
		lgPage=ldPage.ClickOnLoginBtn1();
		}
		
		@AfterMethod
		public void TearDown() {
			driver.quit();
		}
		
		
		
		
		
	
}
