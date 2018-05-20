package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.baseclass.TestBase;
import com.qa.pages.Homepage;
import com.qa.pages.Loginpage;

public class LoginPageTest extends TestBase {

	Loginpage lp;
	Homepage hp;

	public LoginPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		lp = new Loginpage();
	}
	
	@Test(priority=1)
	
	public void loginPageTitleTest() {
		
		String title=lp.ValidatePageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void LogoImageTest() {
		
		boolean flag=lp.ValidateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() throws Exception {
		
		hp=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
