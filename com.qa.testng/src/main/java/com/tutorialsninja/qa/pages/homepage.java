package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='My Account']")
 private WebElement myaccountdropmenu;
	
	@FindBy(linkText="Login")
	private WebElement loginclick;
	 @FindBy(linkText="Register")
	WebElement clickonregister;
	
	
	public homepage(WebDriver driver)
	{
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	
	//ACTIONS PERFORMED ON WEBELEMENTS
	public void clickonmyaccount()
	{
		myaccountdropmenu.click();
	}
	public Loginpage clickonlogin()
	{
		loginclick.click();
		return new Loginpage(driver);
	}

	public registerpage clickonregister()
	{
		clickonregister.click();
		return new registerpage(driver);
	}
}
