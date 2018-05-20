package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.baseclass.TestBase;

public class Loginpage extends TestBase {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/register/' and text()='Sign Up']")
	WebElement signUpButton;
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive') and @alt='free crm logo']")
	WebElement logo;
	
	public Loginpage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean ValidateLogo() {
		
		return logo.isDisplayed();
	}
	
	public Homepage Login(String un,String pwd) throws Exception{
		
		Thread.sleep(5000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new Homepage();
	}
}
