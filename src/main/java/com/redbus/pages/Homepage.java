package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.redbus.base.BaseUI;

public class Homepage extends BaseUI{

 By from_xpath=getLocator("from_xpath");
	By fromDropdown_xpath=getLocator("fromDropdown_xpath");
	 By to_xpath=getLocator("to_xpath");
	 By todropdown_xpath=getLocator("todropdown_xpath");
	 By calender_xpath=getLocator("calender_xpath");
	 By month_xpath= getLocator("month_xpath");
	 By arrow_xpath=getLocator("arrow_xpath");
	 By date_xpath=getLocator("date_xpath");
	 By search_xpath=getLocator("search_xpath");
	  
	 public String getTittle() {
		 String title=driver.getTitle();
		return title;
		 
	 }
      // *** Search for depature city location** //
	 
		public void depaturecityinHomepage(String text) {
			
			clickOn(from_xpath);
			sendText(from_xpath, text);
			dropdownclick(fromDropdown_xpath);
			}
		
		//***for arrival city location***//
		public void arrivalcityinhomepage(String text) {
			clickOn(to_xpath);
           sendText(to_xpath, text);
           clickOn(todropdown_xpath);
		}
		
		//***to select date and month**//
		public void dateselectioninhomepage(String month,String date) {
			clickOn(calender_xpath);
			while(true) {
				String datepick=getText(month_xpath);
				
				if(datepick.equalsIgnoreCase(month)) {
					break;
				}
				else {
						clickOn(arrow_xpath);
                  }
			}
			List<WebElement> links1=getListOfElements(date_xpath);	
			
			for(int i=0;i<links1.size();i++) { 
				String day=links1.get(i).getText();
				if(day.equals(date)) {
				links1.get(i).click();
		 }}
		}
		//*******to click the search button*******//
			public void searchbarclick() {
		clickOn(search_xpath);

}
			}
