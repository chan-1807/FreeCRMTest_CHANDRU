package com.crm.testcases;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialisation();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactpage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactpage = homepage.clickOnContactsLink();

	}

	
	  @Test(priority = 1,enabled = true) public void contactsLabelTest() {
		 log.info("CONTACTS LABEL TEXT____________----");
	  Assert.assertTrue(contactpage.verifyContactsLabled()); }
	  
	  @Test(priority = 2,enabled = true) public void selectContactTest() {
	  contactpage.selectContactsbyName("chan s"); }
	 

	
	  @DataProvider 
	  public static Iterator<Object[]> getTestData() {
	  ArrayList<Object[]> data = TestUtil.getDataFromExcel(); return
	  data.iterator(); }
	 
	  @DataProvider
	  public Object[][] getData() throws InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		Object[][] data=TestUtil.getTestData("CRM Contacts");
		return data;
	}
	  
	
	  @Test(priority = 3,enabled = false,dataProvider = "getTestData") public void
	  createContactTest(String title,String fn,String ln,String company) {
	  homepage.clickOnNewContact(); 
	  contactpage.createContact("Mr.", "Chandra", "Mohan", "C"); contactpage.createContact(title, fn, ln, company); }
	 

	@AfterMethod
	public void teardwn() {
		driver.close();
	}

}