package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class NewContactPage extends TestBase {

	@FindBy(xpath = "//div[text()='Create New Contact']")
	WebElement NewContactLabel;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//div[@name='company']//input[@aria-autocomplete='list']")
	WebElement company;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement SaveBtn;

	// Initializing The page Objects(elements)
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyNewContactLabel() {
		return NewContactLabel.isDisplayed();
	}

	public void ValidateCreateNewContact(String fName, String lName, String comp) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		SaveBtn.click();
		//Select select = new Select(driver.findElement(By.xpath("//div[@name='category']//i[@class='dropdown icon']")));
		//select.selectByVisibleText(cat);

		
	}

}
