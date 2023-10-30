package com.Pomfile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Home {
	static WebDriver driver;
	@FindBy(xpath="//div[@class='pricebar']//following-sibling::button")
		public static List<WebElement> Alladdtocart;

	@FindBy(xpath="//div/a/span[@class='shopping_cart_badge']")
	public static WebElement Addedcartcount;

	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	public static WebElement Shoppingcart;

	@FindBy(xpath="//div[@class='header_label']/div[.='Swag Labs']")
	public static WebElement SwagHeader;

	@FindBy(xpath="//div[@class='inventory_item_label']/a")
	public static List<WebElement> itemsname;
	
	@FindBy(xpath="//a/img")
	public static List<WebElement> Homeitemimage;
	
	@FindBy(xpath="//div[@class='inventory_details_img_container']/img")
	public static WebElement itemimageondetailpage;

	@FindBy(xpath="//div[@class='inventory_item_label']/a//following::div[@class='inventory_item_price']")
	public static List<WebElement> itemsprice;

	public void Addtocart() {

		Addedcartcount.click();;
		Shoppingcart.click();
	}


}
