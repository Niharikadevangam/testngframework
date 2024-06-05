package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {
	
	public static ExtentReports generateextentreport() throws IOException
	{
		ExtentReports extentreport=new ExtentReports();
		File f= new File(System.getProperty("user.dir")+"\\test-output\\EXTENTREPORTS\\tutorialsninjareport.html");
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(f);
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Tutorialsninja testcases report");
		sparkreporter.config().setDocumentTitle("TN AUTOMATION REPORT");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkreporter);
		Properties prop=new Properties();
		File f1= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fis= new FileInputStream(f1);
		
		prop.load(fis);
		extentreport.setSystemInfo("application URL",prop.getProperty("username"));
		
		extentreport.setSystemInfo("Browsername", prop.getProperty("browser"));
		extentreport.setSystemInfo("Operating system", System.getProperty("os.name"));
		extentreport.setSystemInfo("username", System.getProperty("user.name"));
		extentreport.setSystemInfo("java version", System.getProperty("java.version"));
		return extentreport;
		
	}

}
