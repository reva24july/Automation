package RedbusAutomation;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.redbus.base.BaseUI;
import com.redbus.pages.Homepage;
import com.redbus.utils.Utilities;


public class dataprovidertest {
	Homepage h=new Homepage();

	
 @Test(priority=0)
    public void setUp() {
    	BaseUI ob=new BaseUI();
		ob.invokebrowser();
		ob.openBrowser("websiteurl");
	
	}
 
   @Test(priority=1,dataProvider="searchtext")
    public void homepageDepatureCheck(String place1,String place2) throws IOException {
		//String[] exceldata=Utilities.excelsheetsData("Sheet1");
		h.depaturecityinHomepage(place1);
		h.arrivalcityinhomepage(place2);
   }
   @Test(priority=2)
   public void homepageCalendercheck() {
	      h.dateselectioninhomepage("Dec 2022", "6");

   }
   @Test(priority=3)
   public void searchbox() {
	   h.searchbarclick();
	   
   }
   @DataProvider(name="searchtext")
   public static Object[][] dataprovider() throws IOException {
		String data[][]=Utilities.multidimenarrayexcelsheetdata("Sheet2");
		//System.out.println(data[2][1]);
		 Object[][] searchwords=new Object[5][2];
		 for(int i=1;i<5;i++) {
			 for(int j=0;j<2;j++) {
			searchwords[i][j]=data[i][j];
			//System.out.println(searchwords[i][j]);
			 }}
			
			return searchwords;
	}
}
