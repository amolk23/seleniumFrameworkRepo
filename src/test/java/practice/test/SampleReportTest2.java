package practice.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest2 {
	ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		
	  System.out.println("Configuring extent report.....");
	  
	  ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report1.html");
	  spark.config().setDocumentTitle("DocTitle");
	  spark.config().setReportName("Low Level Report");
	  spark.config().setTheme(Theme.DARK);
	  
	  report = new ExtentReports();
	  report.attachReporter(spark);
	  report.setSystemInfo("OS", "Windows-11");
	  report.setSystemInfo("Browser", "Chrome-125");

	}
	
	@Test
	public void sampleTest() {
		//String testName = result.getMethod().getMethodName();
		//System.out.println(testName);
		//ExtentTest test = report.createTest(testName);
		ExtentTest test = report.createTest("sampleTest");
		test.log(Status.INFO, " Started");
		//System.out.println(10/0);
		//test.log(Status.SKIP, " skipped");
		//test.log(Status.PASS, " Passed");
		test.log(Status.INFO, " Ended");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
}
