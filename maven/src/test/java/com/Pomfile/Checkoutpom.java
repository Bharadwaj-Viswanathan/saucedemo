package com.Pomfile;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkoutpom {
	
	@FindBy(xpath="//button[@id='checkout']")
	public static WebElement clickcheckout;
	
	@FindBy(xpath="//input[@id='first-name']")
	public static WebElement Checkoutfirstname;
	

	@FindBy(xpath="//input[@id='last-name']")
	public static WebElement Checkoutlastname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	public static WebElement Checkoutcode;
	
	@FindBy(id="continue")
	public static WebElement Checkoutcontiue;
	
	@FindBy(id="cancel")
	public static WebElement Checkoutcancel;
	
	@FindBy(xpath="//div/h3[@data-test='error']")
	public static WebElement Checkoutinfoerror;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	public static WebElement itemtotal;
	
	@FindBy(xpath="//div[@class='summary_tax_label']")
	public static WebElement itemtax;
	
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
	public static WebElement Totalamount;
	
	@FindBy(xpath="//button[@id='finish']")
	public static WebElement Finishbutton;
	
	@FindBy(xpath ="//h2[contains(.,'Thank you')]")
	public static WebElement Thankstext;
	
	@FindBy(xpath="//button[contains(.,'Back')]")
	public static WebElement Backbutton;
	
	public static void Tosendcheckoutinfo(String Firstname,String lastname,String Code) {
		Checkoutfirstname.sendKeys(Firstname);
		Checkoutlastname.sendKeys(lastname);
		Checkoutcode.sendKeys(Code);
		Checkoutcontiue.click();
	}
	
	
	public static void Aftercheckout() {
		assertTrue(Thankstext.isDisplayed());
		Backbutton.click();
		
		
	}
	
	
	
	
	
	
}
