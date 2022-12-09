package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Base {
	  protected static WebDriver driver;
	  
	  
	  public void launchbrowser () throws IOException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahesh\\Desktop\\new\\seleniumFile\\ChromeDriver.exe");
		
        driver=new ChromeDriver();
		
		driver.get(neoStoxPOMclasses.NeoUtility.readDataFromPropertyFile("devurl"));
		
		
	}

}
