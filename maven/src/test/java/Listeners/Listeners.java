package Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import maven.BaseClass;

public class Listeners extends BaseClass implements ITestListener {

	static Logger log =Logger.getLogger(Listeners.class);



	@Override		
	public void onTestFailure(ITestResult result) {	
		DOMConfigurator.configure("log4j.xml");
		TakesScreenshot scrShot =((TakesScreenshot)driver);

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File("./Testdata/"+result.getName()+".png");

		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		log.error(result.getName()+"This test case if failed");
	}		

	@Override		
	public void onTestSkipped(ITestResult result) {								
		Reporter.log("This test case is skipped"+result);
		log.info("This TC is skipped");

	}		


	@Override
	public void onFinish(ITestContext contextFinish) {
		log.info("Completed.....");
	}

	@Override
	public void onStart(ITestContext contextStart) {
		log.info("Started.....");
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("The TC was started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("This TC was Passed"+result);
	}

}


