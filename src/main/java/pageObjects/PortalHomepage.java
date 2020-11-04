package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomepage {

	public WebDriver driver;
	
	By MyOrders =By.xpath("//h2[contains(text(),'My Orders')]");
	
	
	public PortalHomepage(WebDriver driver) {
		 this.driver = driver;
	}

	public WebElement getMyOrders()
	{
		return driver.findElement(MyOrders);
	}

}
