package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//font[@color='red'][text()='Sign Up']")
	WebElement signup;

	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement CRMLogo;
//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return CRMLogo.isDisplayed();
	}
	
	public HomePage Login(String uid, String pwd) throws InterruptedException {
		username.sendKeys(uid);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();
		return new HomePage();
	}
}
