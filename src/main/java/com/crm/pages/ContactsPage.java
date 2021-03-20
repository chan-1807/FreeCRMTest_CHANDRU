package com.crm.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.crm.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
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

	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabled() {
		return contactslabel.isDisplayed();
	}
	
	public void selectContactsbyName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input[@type='checkbox']"));
	}
	
	
	public void createContact(String tit,String fn,String ln ,String comp ) {
	//	System.out.println("ENTERED CreateContact functiosn");
		Select sel=new Select(title);
		sel.selectByVisibleText(tit);
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		companyname.sendKeys(comp);
		saveBtn.click();
	}

	
}
