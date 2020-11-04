package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	
	By emailphone =By.cssSelector("[name='email']");
	By clickContinue =By.cssSelector("[type='submit']");
	
	
	public ForgotPassword(WebDriver driver) {
		 this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(emailphone);
	}

	public WebElement getContinue()
	{
		return driver.findElement(clickContinue);
	}
}
