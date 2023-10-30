package maven;

import org.testng.annotations.Test;

import com.Pomfile.Home;

public class TC_004 extends BaseClass {
	// Get all the product items along with price

	@Test(dataProvider = "credentials",dataProviderClass = Dataprovider.class)
	
	public void Get_Products_name_and_price(String username,String password){

		
		logincredencial(username,password);

	
		printitemandprice(Home.itemsname, Home.itemsprice);
	
		logout();

	}
}
