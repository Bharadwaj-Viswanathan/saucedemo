package com.Pomfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpom {

	WebDriver driver;

	@FindBy(id="user-name")
	public static WebElement Username;

	@FindBy(id="password")
	public static WebElement Password;

	@FindBy(id="login-button")
	public static WebElement Loginbutton;

	@FindBy(css="button[id='react-burger-menu-btn']")
	public static WebElement Menubutton;

	@FindBy(xpath="//a[.='Logout']")
	public static WebElement Logout;
	
	@FindBy(xpath="//div[@class='error-message-container error']//h3")
	public static WebElement loginerrormessage;



	public static void Loggedin(String UN,String PW) {

		Username.sendKeys(UN);
		Password.sendKeys(PW);
		Loginbutton.click();
	}
	public static void Loggedout() {
		Menubutton.click();
		Logout.click();
	}


}
