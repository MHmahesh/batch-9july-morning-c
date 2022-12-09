package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class Password {

	@FindBy(name = "ctl00$MainContent$_wp_enteraccesspin$txt_accesspin")private WebElement password;
	@FindBy(xpath = "//a[text()='Submit']")private WebElement Submit;
	
	public Password(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPassword(WebDriver driver,String pass) {
		password.sendKeys(pass);
		NeoUtility.wetting(driver, 2000);
		Reporter.log("enter passworrd successfully....", true);
	}
	
	public void submitclick(WebDriver driver) {
		Submit.click();
		NeoUtility.wetting(driver, 1000);
		Reporter.log("click on password submit....", true);
	}
	
	
	
	
	
	
	
	
	
}
