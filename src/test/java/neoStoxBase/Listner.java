package neoStoxBase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxPOMclasses.NeoUtility;



public class Listner extends Base implements ITestListener {
	
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC"+result.getName()+" passed successfully", true);
	}
	
	
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("TC"+result.getName()+" failed", true);
		
			try {
				NeoUtility.screenshot(driver, result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	

	public void onTestSkipped(ITestResult result) {
		Reporter.log("TC"+result.getName()+" skiped", true);
	}
	
	

}
