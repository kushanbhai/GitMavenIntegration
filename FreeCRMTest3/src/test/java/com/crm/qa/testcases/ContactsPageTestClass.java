package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContactsPageTestClass extends TestBase {
	HomePage homepage;
	LoginPage loginPage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname = "contacts";

	public ContactsPageTestClass() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {

		initialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() throws InterruptedException {
		testutil.switchtoframe();
		Thread.sleep(3000);
		homepage.clickoncontactsLink();
		Thread.sleep(3000);
		Assert.assertTrue(contactspage.verifyContactsLabel(), "Contacts Label is missing on the page");
	}

	@Test(priority = 2)
	public void SelectContactsPageLabel() throws InterruptedException {
		testutil.switchtoframe();
		Thread.sleep(3000);
		homepage.clickoncontactsLink();
		Thread.sleep(3000);
		contactspage.selectContacts("Tom Peter");
	}

	@Test(priority = 3)
	public void SelectMultipleContacts() throws InterruptedException {
		testutil.switchtoframe();
		Thread.sleep(3000);
		homepage.clickoncontactsLink();
		Thread.sleep(3000);
		contactspage.selectContacts("Tom Peter");
		Thread.sleep(3000);
		contactspage.selectContacts("Ravi Mehra");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetname);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String Company) throws InterruptedException {
		testutil.switchtoframe();
		homepage.clickonNewContactLink();
		Thread.sleep(3000);
		contactspage.CreateNewContact(title, firstname, lastname, Company);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
