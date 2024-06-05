package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailfield;
     
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@value='Login']")
  private	WebElement loginbutton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailandpasswordnotmatching;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS PERFORMED ON WEBELEMENTS
	public void enteremailfield(String emailid)
	{
		emailfield.sendKeys(emailid);
	}
	public void enterpasswordfield(String password)
	{
		passwordfield.sendKeys(password);
	}

	public Accountpage clickonloginbutton()
	{
		loginbutton.click();
		return new Accountpage(driver);
	}
	public String emailandpasswordnotmatching()
	{
		String alerttext=emailandpasswordnotmatching.getText();
	    return alerttext;
	    
	}
}
