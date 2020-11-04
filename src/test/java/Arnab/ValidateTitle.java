package Arnab;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	
	private static Logger log =  LogManager.getLogger(Base.class.getName());

	@AfterTest
	public void closeShop() {
		driver.quit();
	}
	
	
	@Test
     public void validateTitle() throws IOException {
			
		LandingPage l = new LandingPage(driver);
	    Assert.assertEquals(l.getTitle().getText(),"Printshoppy");		
	}
	@BeforeTest
	public void BrowserLaunch() throws IOException
	{
		driver= StartDriver();
		log.info("Driver Started");
		
		driver.get(prop.getProperty("url"));
		log.info("URL is successfully opened");
	}
}
