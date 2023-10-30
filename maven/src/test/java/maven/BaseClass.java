package maven;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Pomfile.Checkoutpom;
import com.Pomfile.Home;
import com.Pomfile.Loginpom;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	public static WebDriver driver;


	public static Properties prop;
	static FileReader fis;

	@Parameters("Browser")
	@BeforeMethod
	public static void BeforeTC(String Browser) throws IOException {
		File file= new File("./Configuration/Config.Properties");
		fis = new FileReader(file);
		prop = new Properties();
		prop.load(fis);

	//	String Browser = "opera";

		if(Browser==null)
			System.out.println("No browser Avaliable");
		else if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver=new FirefoxDriver(); 
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(); 

		}
		else if(Browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			System.setProperty("webdriver.opera.driver", "C:\\Users\\bharadwaj.viswanatha\\eclipse-workspace1\\maven\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver(); 

		}	


		driver.get(prop.getProperty("URL"));

		driver.manage().window().maximize();
		PageFactory.initElements(driver,Loginpom.class);
		PageFactory.initElements(driver,Home.class);
		PageFactory.initElements(driver,Checkoutpom.class);
	}



	@AfterMethod
	public void AfterMethod() {
		Toquit();

	}

	//-----------------------Framework method's---------------------------------//

/**
 * Login using Username and password
 * @param username Enter the username
 * @param password Enter the password
 */
	public static void logincredencial(String username, String password) {
		Loginpom.Loggedin(username,password);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
/**
 * Thread.sleep for 3 sec
 */
	public static void Tosleep()  {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
/**
 * To quit
 */
	public static void Toquit() {
		driver.quit();
	}


	public static void logout() {
		Loginpom.Menubutton.click();

		Loginpom.Logout.click();

	}

	public boolean CheckIsDisplay(WebElement element) {
		boolean Swagname = element.isDisplayed();
		return Swagname;
	}

	public String Getcurrenturl() {
		String actualurl = driver.getCurrentUrl();
		return actualurl;
	}

	public String Gettext(WebElement element) {
		return element.getText();
	}

	public void ListofWebelement(List<WebElement> element,String Action) {
		if(Action.equalsIgnoreCase("Click")) {
			int count = element.size();

			for (int i=0;i<count;i++) {
				element.get(i).click();

			}

		}
		else if(Action.equalsIgnoreCase("text")) {
			int count = element.size();

			for (int i=0;i<count;i++) {
				element.get(i).getText();

			}
		}

	}
	/*
	 * Get the itemname and price
	 *
	 */
	public void printitemandprice(List<WebElement> itemsname,List<WebElement> itemsprice) {

		String Allitemsname=null;
		String Allitemsprice= null;
		int count = itemsname.size();
		int pricecount=itemsprice.size();
		for(int i=0;i<count;i++) {
			for(int j=0;j<pricecount;j++) {

				Allitemsname= itemsname.get(i).getText();
				Allitemsprice= itemsprice.get(j).getText();

			}
			System.out.println(Allitemsname+" "+Allitemsprice);
		}
	}


	public String Getattribute(WebElement element,String Attribute_name) {

		String Attributevalue = element.getAttribute(Attribute_name);
		return Attributevalue;

	}

	public String  Getattribute(List<WebElement> element,String Attribute_name) {

		String Attributevalue= null;
		for(int i=0;i<element.size();i++) {
			Attributevalue = element.get(i).getAttribute(Attribute_name);

		}
		return Attributevalue;
	}


	public void TakeScreenshot()  {

		TakesScreenshot scrShot =((TakesScreenshot)driver);

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File("./Testdata/"+getClass()+".png");

		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

