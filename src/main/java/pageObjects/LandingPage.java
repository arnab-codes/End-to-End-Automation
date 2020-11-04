package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By login =By.cssSelector("a[href='https://www.printshoppy.com/login']");
	//By title = By.cssSelector("img[title='Printshoppy']");
	By title = By.xpath("//*[@id='logo']/a/img");
	
	public LandingPage(WebDriver driver) {
		 this.driver = driver;
	}

	public LogInPage getLogin()
	{
	    driver.findElement(login).click();
	    LogInPage lo = new LogInPage(driver);
		return lo;
		
	}

	public WebElement getTitle() 
	{
		return driver.findElement(title);
	}
}
