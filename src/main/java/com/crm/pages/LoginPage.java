package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory - OBJ REPO
	
	@FindBy(name="username") 
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLoginPageLogo() {
	return	logo.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un,String Pss) {
		username.sendKeys(un);  
		password.sendKeys(Pss); 
		loginbtn.click();
		return new HomePage();
	}

}
