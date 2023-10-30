package maven;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pomfile.Home;




public class TC_001 extends BaseClass{

	//verify the url and verify after logged in Swag header is display or not
	@Test(dataProvider = "credentials",dataProviderClass = Dataprovider.class)
	public void Verify_Url_and_login(String username,String Password){
		
		SoftAssert softAssert= new SoftAssert();
		
		softAssert.assertEquals(Getcurrenturl(),prop.getProperty("URL"));
	
		logincredencial(username,Password);

		softAssert.assertTrue(CheckIsDisplay(Home.SwagHeader));
		
		logout();
		
		softAssert.assertAll();
	}







}
