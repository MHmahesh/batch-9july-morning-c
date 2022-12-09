package neoStoxPOMclasses;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxHomePage {
	@FindBy(xpath = "//span[@id='lbl_username']")private  WebElement Username;
	@FindBy(xpath = "//span[@id='lbl_curbalancetop']")private WebElement ACbalance;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOut;
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okpopup;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closepopup;
	
	
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void popupHandling(WebDriver driver) {
		
		okpopup.click();
		NeoUtility.wetting(driver, 1000);
		closepopup.click();
		NeoUtility.wetting(driver, 1000);
		Reporter.log("handling popup......", true);
	}
	public String userid1(WebDriver driver) {
		String actualusername = Username.getText();
		Reporter.log("getting actual username", true);
		return actualusername;
	}
	
	public String avlFund() {
		String funds = ACbalance.getText();
		Reporter.log("getting available is"+funds+" funds", true);
		return funds;
		
	}
	public void logoutapplication() {
		Username.click();
		logOut.click();
		Reporter.log("logout apllication.....", true);
	}
	
	
	
}
