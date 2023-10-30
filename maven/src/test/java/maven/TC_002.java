package maven;

import static org.testng.Assert.assertTrue;

import org.eclipse.sisu.Description;
import org.testng.annotations.Test;

import com.Pomfile.Loginpom;

public class TC_002 extends BaseClass{


	@Test
	
	public void VerifyinvalidLogin(){
		
		logincredencial(prop.getProperty("INUN"),prop.getProperty("INPW"));
		
	 	String Actualresult = Gettext(Loginpom.loginerrormessage);

	 if(!Actualresult.contains("Username and password do not match")) {
		 
		 assertTrue(false);
	 }
	 
	 
	}
}
