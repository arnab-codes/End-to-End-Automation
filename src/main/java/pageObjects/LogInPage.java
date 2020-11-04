package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	public WebDriver driver;
	
	By emailphone =By.cssSelector("[name='email']");
	By password =By.cssSelector("[name='password']");
	By LogIn =By.cssSelector("[id='button-login']");
	By LogOut= By.xpath("(//a[text()='Logout'])[1]");
	//By forgotPassword = By.linkText("Forgotten Password");
	
	public LogInPage(WebDriver driver) {
		 this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(emailphone);
	}

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(LogIn);
	}
	
	public WebElement LogOut()
	{
		return driver.findElement(LogOut);
	}
	
	
		
		
	

	/*public ForgotPassword forgotPassword() {
		// TODO Auto-generated method stub
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}*/
}
