package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import maven.BaseClass;

public class Retry extends BaseClass implements IRetryAnalyzer {

	int retryCount = 0;
	static final int maxRetryCount = 2;
	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryCount) {
			retryCount++;
			TakeScreenshot();
			return true;
		}
		TakeScreenshot();
		return false;
	}

}
