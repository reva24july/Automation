package com.redbus.base;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.redbus.pages.Homepage;
import com.redbus.pages.searchbus;
import com.redbus.utils.Utilities;

public class Temp {

	private static WebDriver driver;

	public static void main(String[] args) throws IOException{
		
		BaseUI ob=new BaseUI();
		ob.invokebrowser();
		ob.openBrowser("websiteurl");

		Homepage h=new Homepage();
		h.getTittle();
		System.out.println(h.getTittle());
		String[] exceldata=Utilities.excelsheetsData("Sheet1");
		String a=exceldata[1];
		String b=exceldata[2];
	h.depaturecityinHomepage(a);
	//h.gettingtextOfSearchlocation();
	//System.out.println("location:"+ h.gettingtextOfSearchlocation());
	h.arrivalcityinhomepage(b);
h.dateselectioninhomepage("Dec 2022","15");
h.searchbarclick();
h.takeScreenShot("C:\\Users\\kumsiv\\eclipse-workspace\\RedbusAutomation\\Screenshot\\sample2.jpeg");
	searchbus sb=new searchbus();
	sb.triptimeSelection();
	sb.checkTriptimeSelected();
	System.out.println("Time:"+sb.checkTriptimeSelected());
	sb.seatselection();
sb.tripseatselected();
System.out.println("seatlabel:"+sb.tripseatselected());

	//System.out.println(userDir+prop.getProperty("chromepath"));
	

		//Driversetup.getedgeDriver();
		//Driversetup.getchromedriver();
		//Driversetup.getFirefoxDriver();
	}

}
