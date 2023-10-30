package maven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Pomfile.Home;





public class TC_003 extends BaseClass {

	// Add all the item to cart and check weather the item's count is display correct or not
	@Test(dataProvider = "credentials",dataProviderClass = Dataprovider.class)

	public void Addcartandverifythecount(String username,String password) {

		logincredencial(username,password);
		
		Tosleep();
		
		ListofWebelement(Home.Alladdtocart,"Click");
		
		Tosleep();
		
		String Addeditemscount =Gettext(Home.Addedcartcount);
		
		String Expectedcount = Integer.toString(6);

		assertEquals(Addeditemscount, Expectedcount,"The Login is:"+username+" "+password);

		Home.Shoppingcart.click();
		logout();

	}


}
