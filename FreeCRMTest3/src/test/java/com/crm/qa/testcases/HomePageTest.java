package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginPage;
	TestUtil testutil;
	ContactsPage contactspage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		try {
			homepage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "HomePage title not matched");
	}

	@Test(priority = 2)
	public void verifyusernameTest() {
		testutil.switchtoframe();
		Assert.assertTrue(homepage.verifyCorrectUsername());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testutil.switchtoframe();
		contactspage = homepage.clickoncontactsLink();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
