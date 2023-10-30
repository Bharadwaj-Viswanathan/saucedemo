package maven;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.Pomfile.Checkoutpom;
import com.Pomfile.Home;

public class TC_006 extends BaseClass {

	@Test(dataProvider = "credentials",dataProviderClass = Dataprovider.class)
	public void validate_error_Message_incheckoutinfopage(String username,String password){//
		logincredencial(username,password);
		
		Tosleep();
		
		ListofWebelement(Home.Alladdtocart,"Click");

		Home.Shoppingcart.click();
		
		Tosleep();
		
		Checkoutpom.clickcheckout.click();
		
		Tosleep();
		
		Checkoutpom.Checkoutcontiue.click();
		
		assertTrue(CheckIsDisplay(Checkoutpom.Checkoutinfoerror),"The Login is"+username+" "+password);
		

	}
}
