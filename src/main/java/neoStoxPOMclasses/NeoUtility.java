package neoStoxPOMclasses;

import java.awt.RenderingHints.Key;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

//import org.apache.xmlbeans.impl.repackage.Repackage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class NeoUtility {
	
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//creat object of properties class
	Properties props=new Properties();
	
	FileInputStream myfile= new FileInputStream("C:\\Users\\Mahesh\\eclipse-workspace\\9_july_c_batch_selenium\\neoStoxKey.properties");
	
	props.load(myfile);
	
	String value = props.getProperty(key);
	
	Reporter.log("reading "+key+" from property file", false);
	return value;
	}
	
	
	public static void screenshot(WebDriver driver,String name) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Mahesh\\Desktop\\sel document\\screenshiot\\image2"+name+".jpg");
		FileHandler.copy(src, dest);
		Reporter.log("scrolling to element....", true);
	}
	
	public static void wetting(WebDriver driver, int time) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		
		Reporter.log("wetting for"+time+"ms", true);
	}
	
	public static void scrooling(WebDriver driver,WebElement element) {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 
	 js.executeScript("argument[0]ScrollIntoView", element);
	 
	 Reporter.log("scrolling to element", true);
	}
	
	
}
