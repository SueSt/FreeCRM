package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;

// checking for gitHub

public class ContactsPageTest extends TestBase{
	LoginPage lgPage;
	HomePage hmPage;
	LandingPage	ldPage;
	ContactsPage contaPage;
	
	
//1- Create Constructor
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		Initialization();
		//Create an Object of the LoginPage Class
		lgPage= new LoginPage();
		ldPage= new LandingPage();
		hmPage=new HomePage();
		contaPage= new ContactsPage();
	}
	
	@Test(priority=1)
	public void VerifyContactLabelTest(){
		ldPage.ClickOnLoginBtn1();
		hmPage=lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		contaPage=hmPage.ClickOnContactsLink();
		Assert.assertTrue(contaPage.VerifyContactLabel(), "contacts label is missing from page");	
	}
	
	@Test(priority=2)
	public void SelectSingleContactsByNameTest() throws InterruptedException{
		ldPage.ClickOnLoginBtn1();
		hmPage=lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		contaPage=hmPage.ClickOnContactsLink();
		Thread.sleep(5000);
		contaPage.SelectContactsByName(prop.getProperty("Contact1"));
	}
	
	@Test(priority=3)
	public void SelectMultipleContactsByNameTest() throws InterruptedException{
		ldPage.ClickOnLoginBtn1();
		hmPage=lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		contaPage=hmPage.ClickOnContactsLink();
		Thread.sleep(5000);
		contaPage.SelectContactsByName(prop.getProperty("Contact1"));
		Thread.sleep(5000);
		contaPage.SelectContactsByName(prop.getProperty("Contact2"));
	}
	
	
	@AfterMethod
	public void TearDown() {
	driver.quit();
	}
	
	
	
	
}
