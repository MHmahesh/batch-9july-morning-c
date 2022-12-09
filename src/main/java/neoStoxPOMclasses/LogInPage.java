package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

//import neoStoxUtility.NeoUtility;

public class LogInPage {
	
	@FindBy(name = "ctl00$MainContent$signinsignup$txt_mobilenumber")private WebElement username;
	@FindBy(xpath = "(//a[text()='Sign Up'])[2]")private WebElement signup;
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginpage(WebDriver driver,String un) {
		username.sendKeys(un);
		NeoUtility.wetting(driver, 1000);
		Reporter.log("sending user name", true);
	}
	public void signinclick(WebDriver driver) {
		
		signup.click();
		NeoUtility.wetting(driver, 1000);
		Reporter.log("sign in click....", true);
	}
	
	
	

}
