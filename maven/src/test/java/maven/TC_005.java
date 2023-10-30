package maven;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pomfile.Checkoutpom;
import com.Pomfile.Home;

public class TC_005 extends BaseClass{


	@Test(dataProvider = "credentials",dataProviderClass = Dataprovider.class)
	public void Complete_Checkout_flow(String username,String password)  {//Complete Checkout

		logincredencial(username,password);
		
		Tosleep();
		
		ListofWebelement(Home.Alladdtocart,"Click");

		Home.Shoppingcart.click();
		
		Checkoutpom.clickcheckout.click();
		
		Checkoutpom.Tosendcheckoutinfo(prop.getProperty("First_name"),
				prop.getProperty("Last_name"),prop.getProperty("Code"));
		

		System.out.println(Checkoutpom.Totalamount.getText());
		
		Checkoutpom.Finishbutton.click();
		
		TakeScreenshot();

		Checkoutpom.Aftercheckout();

	}


}
