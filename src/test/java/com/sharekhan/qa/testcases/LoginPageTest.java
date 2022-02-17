package com.sharekhan.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sharekhan.qa.base.TestBase;
import com.sharekhan.qa.pages.LoginPage;
import com.sharekhan.qa.pages.Portfolio;

public class LoginPageTest extends TestBase  {
	Portfolio portfolio;
	LoginPage loginpage;
	public LoginPageTest() throws IOException {
		super();
	}

	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		  loginpage = new LoginPage();
		}
	
	@Test(priority=3)
	public void VerifyTitleTest() 
	{
		String title= loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Sharekhan, Stock Market, Online Share Trading, Online Broking, Market Today, Live Quotes, Sensex, Nifty.");
		
	}
	
	@Test(priority=2)
	public void validatelogoTest()
	{
		Boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		loginpage.login(prop.getProperty("username"), "password");
	}
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
