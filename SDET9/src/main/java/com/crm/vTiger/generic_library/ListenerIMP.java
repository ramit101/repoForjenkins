package com.crm.vTiger.generic_library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListenerIMP implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	WebDriver driver;
	public void onFinish(ITestContext arg0) {
		reports.flush();

	}

	public void onStart(ITestContext arg0) {
		ExtentHtmlReporter filep = new ExtentHtmlReporter(new File("./Reports/extentreport.html"));
		reports = new ExtentReports();
		reports.attachReporter(filep);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {


	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL,result.getThrowable());
		try {
			String path = WebDriverUtils.screenshot(driver);
			test.addScreenCaptureFromPath(path);
		} 
		catch (Throwable e) {

			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

		
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP,result.getThrowable());
		try {
			String path = WebDriverUtils.screenshot(driver);
			test.addScreenCaptureFromPath(path);
		} 
		catch (Throwable e) {

			e.printStackTrace();
		}

	}

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult arg0) {

		test.log(Status.PASS, "this test case got passed");
	}

}
