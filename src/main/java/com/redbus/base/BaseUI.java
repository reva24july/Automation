package com.redbus.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.redbus.utils.Utilities;


public class BaseUI {
	public static Properties  prop;
	public static String browser;
	public static WebDriver driver;
	
public BaseUI(WebDriver driver) {
	BaseUI.driver=driver;
}
public BaseUI() {
	// TODO Auto-generated constructor stub
}
//*****to invoke browser based on the browsername******//
public WebDriver invokebrowser() {
	 prop = Utilities.initProperties();
	browser = prop.getProperty("browserName");
	
	if (browser.equalsIgnoreCase("firefox")) {
		driver = Driversetup.getFirefoxDriver();
	} else if (browser.equalsIgnoreCase("edge")) {
		driver = Driversetup.getedgeDriver();
	} else if (browser.equalsIgnoreCase("chrome")){
		driver = Driversetup.getchromedriver();
	}
	return driver;
}
	// ***  to open url**   //
	public  void openBrowser(String websiteUrlKey) {
		 prop = Utilities.initProperties();
   driver.get(prop.getProperty(websiteUrlKey));
}

	//** Click on element **//
	public void clickOn(By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       
	driver.findElement(locator).click();
	}
	
	//** Send text to an element **//

	public  void sendText(By locator, String text) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
		//driver.findElement(locator).sendKeys(Keys.ENTER);

}
//************to click an element from dropdown********//
		public  void dropdownclick(By locator) {
	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //driver.findElement(locator).sendKeys(Keys.DOWN);
    	driver.findElement(locator).click();
			}
		
	//**getting text of an element**//
	public static String getText(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		String text = null;
			text = driver.findElement(locator).getText();
		return text;
	}
	// Get By locator using locator key ****//
	public  By getLocator(String elementlocator) {
		 prop = Utilities.initProperties();
	if (elementlocator.endsWith("_id")) {
			return By.id(prop.getProperty(elementlocator));
		}
		if (elementlocator.endsWith("_name")) {
			return (By.name(prop.getProperty(elementlocator)));
		}
		if (elementlocator.endsWith("_xpath")) {
			return (By.xpath(prop.getProperty(elementlocator)));
		}
		if (elementlocator.endsWith("_css")) {
			return (By.cssSelector(prop.getProperty(elementlocator)));
		}
	
		if (elementlocator.endsWith("_tagName")) {
			return (By.tagName(prop.getProperty(elementlocator)));
		}
		
		return null;

	}
	//*****getting list of elements****//
	public static List<WebElement> getListOfElements(By locator) {
		List<WebElement> list = null;
				list = driver.findElements(locator);
		return list;
	}
	public void takeScreenShot(String filepath) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filepath));

}}
