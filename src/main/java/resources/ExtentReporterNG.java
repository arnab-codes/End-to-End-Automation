package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
   static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		//ExtentReports , ExtentSparkReporter-this class expects html file where it has to create  
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter	reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation");
				reporter.config().setDocumentTitle("Test Results");
				
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester" , " Arrnab Saha");
				return extent;
				
	}

}
