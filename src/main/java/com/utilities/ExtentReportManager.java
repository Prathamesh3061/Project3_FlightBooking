package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	 private static ExtentReports extent;

	    // ThreadLocal — each parallel thread gets its own test entry in the report
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    public static ExtentReports getReportInstance() {
	        if (extent == null) {
	            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
	            String reportPath = System.getProperty("user.dir") + "/reports/FlightBookingReport_" + timestamp + ".html";

	            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
	            spark.config().setDocumentTitle("Flight Booking Automation Report");
	            spark.config().setReportName("BlazeDemo Test Results");
	            spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	            extent.setSystemInfo("Application", "BlazeDemo");
	            extent.setSystemInfo("Tester", "Prathamesh");
	        }
	        return extent;
	    }

	    public static void createTest(String testName) {
	        ExtentTest extentTest = getReportInstance().createTest(testName);
	        test.set(extentTest);
	    }

	    public static ExtentTest getTest() {
	        return test.get();
	    }

	    public static void flushReport() {
	        getReportInstance().flush();
	    }
}
