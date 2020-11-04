package Arnab;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Base;



public class Homepage extends Base {
	public WebDriver driver;
	private static Logger log =  LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void start() throws IOException
	{
		driver= StartDriver();
		//driver.get(prop.getProperty("url"));
		log.info("Driver Started");
	}
	


	@Test(dataProvider= "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		
		//driver= StartDriver();
		
	
		driver.get(prop.getProperty("url"));
		log.info("URL is successfully opened");
		
		LandingPage l = new LandingPage(driver);
		LogInPage li = l.getLogin();
		li.getEmail().sendKeys(username);
		li.getPassword().sendKeys(password);
		li.clickLogin().click();
		log.info(text);
		li.LogOut().click();
		log.info("user is log   out");
		/*ForgotPassword fp = lo.forgotPassword();
		fp.getEmail().sendKeys("8902131833");
		fp.getContinue().click();*/
	}


	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		data[0][0] = "8334847415";
		data[0][1] = "1timeinvestment";
		data[0][2] = "non-restricted";
		
		
		data[1][0] = "18001002053";
		data[1][1] = "null";
		data[1][2] = "restricted";
		return data;
		
	}
	
	
	@AfterTest
	public void closeShop()
	{
		driver.quit();
		driver = null;
	}
		
	}