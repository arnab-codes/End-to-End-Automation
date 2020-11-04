package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import pageObjects.PortalHomepage;
import resources.Base;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver= StartDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" website$")
	public void navigate_to_website(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	     driver.get(arg1);
	}

	@Given("^Click on login in homepage to land on secure signin page$")
	public void click_on_login_in_homepage_to_land_on_secure_signin_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		l.getLogin();
	}
	 @When("^user logs in with username (.+) and password (.+)$")
	    public void user_logs_in_with_username_and_password(String username, String password) throws Throwable {
		 LogInPage li = new LogInPage(driver);
			li.getEmail().sendKeys(username);
			li.getPassword().sendKeys(password);
			li.clickLogin().click();
	    }


	@Then("^Verify the user is successfully logged in$")
	public void verify_the_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    PortalHomepage p = new PortalHomepage(driver);
	   Assert.assertTrue(p.getMyOrders().isDisplayed());
	}

	 @And("^Close all the browsers$")
	    public void close_all_the_browsers() throws Throwable {
	        driver.quit();
	    }


}
