package com.redbus.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.redbus.base.BaseUI;

public class searchbus extends BaseUI {
	By triptime_xpath=getLocator("triptime_xpath");
	By checktime_xpath=getLocator("checktime_xpath");
	
	By seat_xpath=getLocator("seat_xpath");
	By checkseat_xpath=getLocator("checkseat_xpath");
	
	
	//****selecting time***//
	    public void triptimeSelection() {
		clickOn(triptime_xpath);
      	}
	//******checking the time is displayed******//
		public String checkTriptimeSelected() {
			String text=getText(checktime_xpath);
			return text;
			
		}
		
		public void seatselection() {
			clickOn(seat_xpath);
		}
		public String tripseatselected() {
			String text1=getText(checkseat_xpath);
			return text1;
			
		}
		public void screenshot() throws IOException {
			takeScreenShot("C:\\Users\\kumsiv\\eclipse-workspace\\RedbusAutomation\\Screenshot\\businfo1.jpeg");
		}
	}


