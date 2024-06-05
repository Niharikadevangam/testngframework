package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.baseclass.Base;
import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.pages.registerpage;
import com.tutorialsninja.qa.utilities.Utilities;

public class RegisterTest extends Base {
	public RegisterTest() throws IOException {
		super();
	}

	WebDriver driver;
	homepage hp;
	registerpage rp;

	@BeforeMethod
	public void setup() {

		driver = initializebrowserandopenapplication(prop.getProperty("browser"));
		hp = new homepage(driver);
		hp.clickonmyaccount();
		rp = hp.clickonregister();
		// driver.findElement(By.linkText("Register")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void verifyregisteringaccountwithmandatoryfields() {
		rp.firstnamefield(prop1.getProperty("firstname"));
		rp.lastnamefield(prop1.getProperty("lastname"));
		rp.emailfield(Utilities.generatetimestamp());
		rp.telephonefield(prop1.getProperty("telephonenumber"));
		rp.passwordfield(prop.getProperty("password"));
		rp.confirmpasswordfield(prop.getProperty("password"));
		rp.checkboxfield();
		rp.continuebutton();
		Assert.assertTrue(rp.accountcreatedheading().contains(prop1.getProperty("accountcreatedheading")));

		// driver.findElement(By.id("input-firstname")).sendKeys(prop1.getProperty("firstname"));
		// driver.findElement(By.id("input-lastname")).sendKeys(prop1.getProperty("lastname"));
		// driver.findElement(By.id("input-email")).sendKeys(Utilities.generatetimestamp());
		// driver.findElement(By.id("input-telephone")).sendKeys(prop1.getProperty("telephonenumber"));
		// driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("password"));
		// driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("password"));
		// driver.findElement(By.xpath("/false/input[@type='checkbox']")).click();
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();
		// String actualstring =
		// driver.findElement(By.xpath("//div[@id='content']/child::h1")).getText();
		// Assert.assertEquals(actualstring,prop1.getProperty("accountcreatedheading"));
	}
}
