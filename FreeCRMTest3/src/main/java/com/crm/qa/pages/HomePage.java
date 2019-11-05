package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//td[contains(text(),'Kushan Choudhury')]")
	@CacheLookup
	WebElement usernameLabel;

	@FindBy(xpath = "//a[contains(@title,'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(@title,'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(@title,'Tasks')]")
	WebElement TasksLink;

	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContactsLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}

	public boolean verifyCorrectUsername() {

		return usernameLabel.isDisplayed();
	}

	public ContactsPage clickoncontactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickonTasksLink() {
		TasksLink.click();
		return new TasksPage();
	}

	public void clickonNewContactLink() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		Thread.sleep(3000);
		newContactsLink.click();
	}
}
