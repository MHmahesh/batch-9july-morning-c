package neoStoxTesting;

import org.testng.annotations.Test;


import neoStoxBase.Base;
import neoStoxPOMclasses.LogInPage;
import neoStoxPOMclasses.NeoStoxHomePage;
import neoStoxPOMclasses.NeoUtility;
import neoStoxPOMclasses.Password;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(neoStoxBase.Listner.class)
public class NeoStoxUsernameValidating extends Base{
	neoStoxPOMclasses.LogInPage login;
	neoStoxPOMclasses.NeoStoxHomePage home;
	neoStoxPOMclasses.Password pass;
	
	
  @BeforeClass
  public void launchBrowser() throws IOException {
	  launchbrowser();
	  login =new LogInPage(driver);
	  home=new NeoStoxHomePage(driver);
	  pass=new Password(driver);  
  }
  @BeforeMethod
  public void signIntoBrowser() throws IOException, InterruptedException {
	  login.loginpage(driver, neoStoxPOMclasses.NeoUtility.readDataFromPropertyFile("devUserId"));
	  login.signinclick(driver);
	  Thread.sleep(2000);
	  pass.enterPassword(driver, neoStoxPOMclasses.NeoUtility.readDataFromPropertyFile("devPassword"));
	  pass.submitclick(driver);
	  home.popupHandling(driver);
	  Thread.sleep(5000);
  }

  @Test
  public void validateUserName() throws IOException {
	  Assert.assertEquals(home.userid1(driver), NeoUtility.readDataFromPropertyFile("devexpUserId"),"test is failed exp and actual user id not matching");
	  Reporter.log("user name get validated....", true);
  }
  
//  @Test
//  public void fundsAvilable() throws IOException
//  {
//	  Assert.fail();
//	  home.avlFund();
//	  NeoUtility.screenshot(driver, "mahesh");
//	 // Assert.fail();
//  }

  @org.testng.annotations.AfterMethod
  public void AfterMethod() {
	  home.logoutapplication(); 
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
