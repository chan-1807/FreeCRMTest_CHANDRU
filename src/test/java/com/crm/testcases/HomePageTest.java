package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class HomePageTest extends TestBase {
	

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		 initialisation();
		 testUtil=new TestUtil();
		 loginpage=new LoginPage();
		 homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void HomePageTitleTest() {
	String flag=homepage.verifyHomePageTitle();
	Assert.assertEquals(flag, "CRMPRO","HOMEPAGE TITLE MIS_MATCH");
	}
	
	@Test
	public void ContactsLinkTest() {
		testUtil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
		
	   Assert.assertTrue(contactspage.verifyContactsLabled());
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
}
