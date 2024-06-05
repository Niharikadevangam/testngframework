package com.tutorialninja.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utilities.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties prop1;

	public Base() throws IOException {
		prop = new Properties();
		File f = new File(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\com\\tutorialsninja\\qa\\config\\config.properties");

		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		prop1 = new Properties();
		File f1 = new File(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\com\\tutorialsninja\\qa\\config\\testdata.properties");
        FileInputStream fis1=new FileInputStream(f1);
        prop1.load(fis1);
	}

	public WebDriver initializebrowserandopenapplication(String browsername) {
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
