package com.sharekhan.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sharekhan.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//pagefactory or Object repositary
	
	@FindBy(xpath="//div[@class='logo']/child::a/child::img[@title='Sharekhan']")
	WebElement Logo;
	
	@FindBy(xpath="(//a[@href='https://newtrade.sharekhan.com'])[1]")
	WebElement loginBtn;
	
	@FindBy(name="emailLoginId")
	WebElement EmailId;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement MailsubmitBtn;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit' and @class='blk-lg-button col-sm-12 ng-binding']")
	WebElement LoginBtn;
	

	
	//initailizing the page objects to driver
		public LoginPage() throws IOException {
			PageFactory.initElements(driver, this);
			
			
		}
		
	
		//actions
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
			
		}
		public boolean validateLogo()
		{
			return Logo.isDisplayed();
		}
		
		public Portfolio login(String un, String pwd)
		{
			loginBtn.click();
			EmailId.sendKeys(un);
			MailsubmitBtn.click();
			Password.sendKeys(pwd);
			LoginBtn.click();
			return new Portfolio();
			
			
			
		}
		
		

}
