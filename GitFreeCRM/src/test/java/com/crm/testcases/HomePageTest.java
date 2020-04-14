package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;
import com.crm.pages.NewContactPage;
import com.crm.pages.TasksPage;

public class HomePageTest extends TestBase{
	LoginPage lgPage;
	HomePage hmPage;
	LandingPage	ldPage;
	ContactsPage contaPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	NewContactPage NewcontaPage;
	
	
	
	//1- Create Constructor
		public HomePageTest() {
			super();
		}

		@BeforeMethod
		public void SetUp() {
			Initialization();
			//Create an Object of the LoginPage Class
			lgPage= new LoginPage();
			ldPage= new LandingPage();
			hmPage=new HomePage();
			NewcontaPage= new NewContactPage();
		}
		
		@Test(priority=1)
		public void ValidateHomePageTitleTest() {
			ldPage.ClickOnLoginBtn1();
			lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
			String title=hmPage.ValidateHomePageTitle();
			Assert.assertEquals(title, "Cogmento CRM");
		}
		
		@Test(priority=2)
		public void ValidateHomePageUrlTest() {
			ldPage.ClickOnLoginBtn1();
			lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
			String currurl=hmPage.ValidateHomePageUrl();
			Assert.assertEquals(currurl, "https://ui.freecrm.com/");
		}
		
		@Test(priority=3)
		public void ClickOnContactsLinkTest() {
			ldPage.ClickOnLoginBtn1();
			lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
			contaPage=hmPage.ClickOnContactsLink();
		}
		
		@Test(priority=4)
		public void ClickOnDealsLinkTest() {
			ldPage.ClickOnLoginBtn1();
			lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
			dealsPage=hmPage.ClickOnDealsLink();
		}
		
		@Test(priority=5)
		public void ClickOnTasksLinkTest() {
			ldPage.ClickOnLoginBtn1();
			lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
			tasksPage=hmPage.ClickOnTasksLink();
		}
		
		@Test(priority=6)
		public void ClickONNewContactsTest() {
			ldPage.ClickOnLoginBtn1();
			lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
			contaPage=hmPage.ClickOnContactsLink();
			NewcontaPage=hmPage.ClickOnNewContacts();
		}
		
		
		@AfterMethod
		public void TearDown() {
			driver.quit();
		}
	
	
	
}
