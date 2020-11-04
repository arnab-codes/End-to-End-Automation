package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// the main motive of this class is that if there are many test cases such as 1500 or 1000 then all the test cases will run
// in which browser that will be decided here.

 
public class Base {
	 public WebDriver driver;
	 public Properties prop;

	public WebDriver StartDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fins = new FileInputStream("C:\\Users\\arnab\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fins);
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\arnab\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if(BrowserName.equals("firefox")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\arnab\\geckodriver.exe");
		     driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("IE")){
			// same as above give IE driver
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
		FileUtils.copyFile(src,new File(destinationFile));
		return destinationFile;
	}

}
