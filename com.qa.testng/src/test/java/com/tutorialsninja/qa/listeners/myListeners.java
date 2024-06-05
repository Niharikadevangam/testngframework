package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilities.Extentreport;

public class myListeners implements ITestListener{
	ExtentReports report;
	ExtentTest extenttest;
	String testname;
	@Override
	public void onStart(ITestContext context) {
		try {
			 report = Extentreport.generateextentreport();
			} catch (IOException e) {
    			e.printStackTrace();
			}
		
	}
	@Override
	public void onTestStart(ITestResult result) {
	 testname=result.getName();
		
	 extenttest = report.createTest(testname);
		
		extenttest.log(Status.INFO, testname+"started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	 		extenttest.log(Status.PASS,testname+"executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir")+"\\test-output\\EXTENTREPORTS\\screenshot.png");
        try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        extenttest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\test-output\\EXTENTREPORTS\\screenshot.png");
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.FAIL, testname+"got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.SKIP, testname+"got skipped");
		
	}


	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		File pathofreport=new File(System.getProperty("user.dir")+"\\test-output\\EXTENTREPORTS\\tutorialsninjareport.html");
		try {
			Desktop.getDesktop().browse(pathofreport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
