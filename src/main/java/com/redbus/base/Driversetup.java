package com.redbus.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.redbus.utils.Utilities;


public class Driversetup {
	
	private static Properties prop;
	
	public  static WebDriver getchromedriver(){
    String userDir = System.getProperty("user.dir");
    prop = Utilities.initProperties();
		System.setProperty("webdriver.chrome.driver", userDir+ prop.getProperty("chromepath"));
	
			ChromeOptions c=new ChromeOptions();
			c.addArguments("---disable-notifications---");
			
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	return driver;
}
	public static WebDriver getFirefoxDriver() {
		String userDir = System.getProperty("user.dir");
		 prop = Utilities.initProperties();
		System.setProperty("webdriver.gecko.driver", userDir
				+ prop.getProperty("firefoxpath"));
		FirefoxOptions f = new FirefoxOptions();
		f.addArguments("--disable-infobars");
		f.addArguments("--disable-notifications");
		f.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
		
      WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		return driver;
	}
public static WebDriver getedgeDriver() {
	String userDir = System.getProperty("user.dir");
	 prop = Utilities.initProperties();
	System.setProperty("webdriver.edge.driver", userDir
			+ prop.getProperty("edgepath"));
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();        

		return driver;
}
}
