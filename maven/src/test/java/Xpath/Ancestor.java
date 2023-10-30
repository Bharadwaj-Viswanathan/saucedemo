package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ancestor {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
			WebDriver driver =new EdgeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='nav-link']//ancestor::a[.='Software']")).click();
		Thread.sleep(3000);
		driver.quit();
		main();

	}

	public static void main() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h4[contains(.,'Pista')]//following-sibling::div/a[.='+']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h4[contains(.,'Pista')]//following-sibling::div/button[.='ADD TO CART']")).click();
		Thread.sleep(3000);		
		
	
		driver.quit();
	}

}
