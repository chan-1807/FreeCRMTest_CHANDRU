package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class NewContactsPage extends TestBase {
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public NewContactsPage() {
	PageFactory.initElements(driver, this);
	}
	
	public void createContact(String tit,String fn,String ln ,String comp ) {

		Select sel=new Select(title);
		sel.selectByVisibleText(tit);
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		companyname.sendKeys(comp);
		saveBtn.click();
	}
	
	
}
