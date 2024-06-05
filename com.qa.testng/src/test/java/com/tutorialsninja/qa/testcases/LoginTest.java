package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.baseclass.Base;
import com.tutorialsninja.qa.pages.Accountpage;
import com.tutorialsninja.qa.pages.Loginpage;
import com.tutorialsninja.qa.pages.homepage;
import com.tutorialsninja.qa.utilities.Utilities;

public class LoginTest extends Base {
	public LoginTest() throws IOException {
		super();

	}

	WebDriver driver;
	Loginpage lp;
	homepage hp;
	Accountpage account;

	@BeforeMethod
	public void setup() throws IOException {
		driver = initializebrowserandopenapplication(prop.getProperty("browser"));
		hp = new homepage(driver);
		hp.clickonmyaccount();
		lp = hp.clickonlogin();
		// REPLCED WITH PAGE OBJECT MODEL --
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Login")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name = "testdata")
	public Object[][] testdata() throws IOException {
		Object[][] data1 = Utilities.readdatafromexcel("LOGIN");
		return data1;
	}

	@Test(priority = 1, dataProvider = "testdata")
	public void DataDrivenTest(String email, String password) {

		lp.enteremailfield(email);
		lp.enterpasswordfield(password);
		lp.clickonloginbutton();
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		account = new Accountpage(driver);
		boolean status = account.getdisplaystatsofeditaccountinfo();
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void verifyloginwithvalidcredentials() throws InterruptedException {
		// driver.findElement(By.linkText("Login")).click();

		lp.enteremailfield(prop.getProperty("username"));
		lp.enterpasswordfield(prop.getProperty("password"));
		account = lp.clickonloginbutton();
		Assert.assertTrue(account.getdisplaystatsofeditaccountinfo());
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("username"));
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("password"));
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Assert.assertTrue(driver.findElement(By.linkText("Edit your account
		// information")).isDisplayed());

	}

	@Test(priority = 3)
	public void verifyloginwithinvalidcredendials() {
		// driver.findElement(By.linkText("Login")).click();

		lp.enteremailfield(Utilities.generatetimestamp());
		lp.enterpasswordfield(prop1.getProperty("invalidpassword"));
		lp.clickonloginbutton();
		Assert.assertTrue(lp.emailandpasswordnotmatching().contains(prop1.getProperty("emailpasswordnotmatching")));
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generatetimestamp());
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop1.getProperty("invalidpassword"));
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		// String actualstring =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		// Assert.assertTrue(actualstring.contains(prop1.getProperty("emailpasswordnotmatching")));

	}

	@Test(priority = 4)
	public void verifyloginwithinvalidemailandvalidpassword() {
		// driver.findElement(By.linkText("Login")).click();

		lp.enteremailfield(Utilities.generatetimestamp());
		lp.enterpasswordfield(prop.getProperty("password"));
		lp.clickonloginbutton();
		Assert.assertTrue(lp.emailandpasswordnotmatching().contains(prop1.getProperty("emailpasswordnotmatching")));
		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generatetimestamp());
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("password"));
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		// String actualstring =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		// Assert.assertTrue(actualstring.contains(prop1.getProperty("emailpasswordnotmatching")));
	}

	@Test(priority = 5)
	public void verifyloginwithvalidemailandinvalidpassword() {
		// driver.findElement(By.linkText("Login")).click();

		lp.enteremailfield(prop.getProperty("username"));
		lp.enterpasswordfield(prop1.getProperty("invalidpassword"));
		lp.clickonloginbutton();
		Assert.assertTrue(lp.emailandpasswordnotmatching().contains(prop1.getProperty("emailpasswordnotmatching")));
		// driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("username"));
		// driver.findElement(By.id("input-password")).sendKeys(prop1.getProperty("invalidpassword"));
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		// String actualstring =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		// Assert.assertTrue(actualstring.contains(prop1.getProperty("emailpasswordnotmatching")));
	}

	@Test(priority = 6)
	public void verifyloginwithoutprovidingemailandpassword() {
		// driver.findElement(By.linkText("Login")).click();

		lp.clickonloginbutton();
		Assert.assertTrue(lp.emailandpasswordnotmatching().contains(prop1.getProperty("emailpasswordnotmatching")));
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		// String actualstring =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		// Assert.assertTrue(actualstring.contains(prop1.getProperty("emailpasswordnotmatching")));
	}

}

