package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();   		//for Prop files 
	}

	
	@BeforeMethod
	public void setup() {
		initialisation();									// Method from TestBase.class
		loginpage= new LoginPage();		   // For PageFactory Setting
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title=loginpage.verifyHomePageTitle();
		Assert.assertEquals(title, "Free CRM  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest() {
	boolean flag=	loginpage.verifyLoginPageLogo();
	Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
	homePage= 	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
