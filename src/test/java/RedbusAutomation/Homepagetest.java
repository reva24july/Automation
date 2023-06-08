package RedbusAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.redbus.base.BaseUI;
import com.redbus.pages.Homepage;
import com.redbus.pages.searchbus;
import com.redbus.utils.Utilities;



public class Homepagetest 

{
	Homepage h=new Homepage();
	searchbus s=new searchbus();
	
 @BeforeClass
    public void setUp() {
    	BaseUI ob=new BaseUI();
		ob.invokebrowser();
		ob.openBrowser("websiteurl");
	
	}
 @Test(priority=0)
 public void checkcurrentpagetitle() {
	   Assert.assertEquals(h.getTittle(),
				"Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India"); 
 }

   @Test(priority=1)
    public void homepageDepatureCheck() throws IOException {
		String[] exceldata=Utilities.excelsheetsData("Sheet1");
		h.depaturecityinHomepage(exceldata[1]);
   }
    @Test(priority=2)
   public void homepageArrivalChek() throws IOException {
		String[] exceldata=Utilities.excelsheetsData("Sheet1");
		String b=exceldata[2];
		h.arrivalcityinhomepage(b);
		
   }
   @Parameters("Date")
   @Test(priority=3)
   public void homepageCalendercheck(String Date) {
	      h.dateselectioninhomepage("Dec 2023", Date);

   }
   @Test(priority=4)
   public void searchbox() {
	   h.searchbarclick();
   }
   @Test(priority=5)
   public void searchpagetriptime() {
	   s.triptimeSelection();
	   
   }
   @Test(priority=6)
   public void checkingseatselection() {
	String text=   s.checkTriptimeSelected();
	Assert.assertEquals(text,"6 am to 12 pm" );
	   
   }
   @Test(priority=7)
   public void searchseatType() {
	   s.seatselection();
   }
   @Test(priority=8)
   public void seatselectiondisplayed() {
	 String text1=  s.tripseatselected();
	 Assert.assertEquals(text1, "SEATER");
	   
   }
   @Test(priority=9)
   public void screenshot() throws IOException {
	   s.screenshot();
   }
   }



