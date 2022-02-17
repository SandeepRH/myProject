package com.sharekhan.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sharekhan.qa.util.Testutil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
public static Properties prop;

public TestBase() throws IOException
{
	try {
	prop= new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\investmentbanking\\src\\main\\java\\com\\sharekhan\\qa\\config\\config.properties");
			prop.load(ip);
	}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}

}

public void initialization() {
	String browsername= prop.getProperty("browser");
	if(browsername.equals("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	

	

	  driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		



}
}




