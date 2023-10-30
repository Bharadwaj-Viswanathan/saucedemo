package maven;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	@DataProvider(name = "credentials")
	public Object[][] Datadriven() {
		return new Object[][]
				{
			{"standard_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
				};
		
	}
			
	}



