package Arnab;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listners2 extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onFinish(ITestContext result) {
		
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		test =  extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}
	
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		 
		
	}

	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable()); // to get faliure logs in html reports.
		// screenshot
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName(); //how to get a method name dynamically through listners
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	private void getScreenShotPath(String testMethodName, WebDriver driver) {
//		// TODO Auto-generated method stub
//		
//	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

}
