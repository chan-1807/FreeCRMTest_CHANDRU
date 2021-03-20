package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;
import com.crm.util.TestUtil;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement loginUser;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		 contactsLink.click();
		 return new ContactsPage();
	}
	
		 public void clickOnNewContact() {


			 Actions action = new Actions(driver);
				action.moveToElement(contactsLink).build().perform();
				newContactLink.click();
			 
			 
			
			 
		 }
		
	
}
