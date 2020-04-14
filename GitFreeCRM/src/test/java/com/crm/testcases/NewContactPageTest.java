package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;
import com.crm.pages.NewContactPage;
import com.crm.util.TestUtil;

public class NewContactPageTest extends TestBase {

	LoginPage lgPage;
	HomePage hmPage;
	LandingPage ldPage;
	ContactsPage contaPage;
	NewContactPage NewcontaPage;
	String sheetName="Contacts";
	

	// 1- Create Constructor
	public NewContactPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		Initialization();
		// Create an Object of the LoginPage Class
		lgPage = new LoginPage();
		ldPage = new LandingPage();
		hmPage = new HomePage();
		contaPage = new ContactsPage();
		NewcontaPage = new NewContactPage();
	}

	@Test(priority = 1)
	public void VerifyNewContactLabelTest() {
		ldPage.ClickOnLoginBtn1();
		lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		contaPage = hmPage.ClickOnContactsLink();
		NewcontaPage = hmPage.ClickOnNewContacts();
		Assert.assertTrue(NewcontaPage.VerifyNewContactLabel());
	}
	
	
	@DataProvider(name="getCRMTestData")
	public Object[][] getCRMTestData() {
	Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=2, dataProvider="getCRMTestData")
	public void ValidateCreateNewContactTest(String firstName, String LastName, String company) throws InterruptedException {
		ldPage.ClickOnLoginBtn1();
		Thread.sleep(5000);
		lgPage.Login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(5000);
		contaPage = hmPage.ClickOnContactsLink();
		Thread.sleep(5000);
		NewcontaPage = hmPage.ClickOnNewContacts();
		Thread.sleep(5000);
		NewcontaPage.ValidateCreateNewContact(firstName, LastName, company);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
