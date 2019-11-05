package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstname;
	@FindBy(xpath = "//input[@name='surname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement companyname;

	@FindBy(xpath = "//input[@value='Save and Create Another (same company)']")
	WebElement SaveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return ContactsLabel.isDisplayed();
	}

	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'" + name
				+ "')]//parent::td[@class='datalistrow'] //preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"))
				.click();

	}

	public void CreateNewContact(String title, String ftname, String ltname, String cmpname)
			throws InterruptedException {
		Select sel = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		sel.selectByVisibleText(title);
		Thread.sleep(3000);
		firstname.sendKeys(ftname);
		Thread.sleep(3000);
		lastname.sendKeys(ltname);
		Thread.sleep(3000);
		companyname.sendKeys(cmpname);
		Thread.sleep(3000);
		SaveBtn.click();
		Thread.sleep(3000);
	}
}
