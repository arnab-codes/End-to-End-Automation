package cucumberOptions;

import cucumber.api.junit.Cucumber;					//* import manually if error shown!
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Features",
		glue= "stepDefinitions"
		)

public class testRunner extends AbstractTestNGCucumberTests {

}
