package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerpage {
	
		WebDriver driver;
@FindBy(id="input-firstname")
private WebElement firstname;


@FindBy(id="input-lastname")
private WebElement lastname;

@FindBy(id="input-email")
private WebElement emailfield;
@FindBy(id="input-telephone")
private WebElement telephoneno;
@FindBy(id="input-password")
private WebElement password;
@FindBy(id="input-confirm")
private WebElement confirmpassword;
@FindBy(xpath="//input[@type='checkbox']")
private WebElement checkbox;
@FindBy(xpath="//input[@value='Continue']")
private WebElement continuebutton;
@FindBy(xpath="//div[@id='content']/child::h1")
private WebElement accountcreatedheading;

public registerpage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void firstnamefield(String firstname1)
{
	firstname.sendKeys(firstname1);
}
public void lastnamefield(String lastname1)
{
	lastname.sendKeys(lastname1);
}
public void emailfield(String email)
{
	emailfield.sendKeys(email);
	
}
public void telephonefield(String telephone)
{
	telephoneno.sendKeys(telephone);	
}
public void passwordfield(String password1)
{
	password.sendKeys(password1);
}

public void confirmpasswordfield(String confirmpassword1)
{
	confirmpassword.sendKeys(confirmpassword1);
}
public void checkboxfield()
{
	checkbox.click();
}

public void continuebutton()
{
	continuebutton.click();
}
public String accountcreatedheading()
{
	String heading = accountcreatedheading.getText();
	return heading;
}




}