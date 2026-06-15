package com.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("===== Test Suite Started: " + context.getName() + " =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
        logger.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
        logger.info("Test PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());
        logger.error("Test FAILED: " + result.getMethod().getMethodName(), result.getThrowable());

        // Take screenshot on failure
        try {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
            logger.info("Screenshot captured: " + screenshotPath);
        } catch (Exception e) {
            logger.error("Failed to capture screenshot", e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
        logger.warn("Test SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
        logger.info("===== Test Suite Finished: " + context.getName() + " =====");
        logger.info("Report generated in /reports folder");
    }

    // Helper method - takes screenshot and saves to /screenshots folder
    private String captureScreenshot(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) BaseTest.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        String destPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        File destFile = new File(destPath);
        destFile.getParentFile().mkdirs(); // create folder if not exists

        Files.copy(source.toPath(), destFile.toPath());
        return destPath;
    }
}
