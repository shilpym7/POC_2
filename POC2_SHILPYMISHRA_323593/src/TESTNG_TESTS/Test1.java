package TESTNG_TESTS;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BASE_CLASSES.HomePage;
@Listeners(BASE_CLASSES.LogUpdate.class)
public class Test1 {

	  WebDriver dr;
	  HomePage hm;
	  Logger log;
	  @BeforeClass
		public void launchbrowser() {
			System.setProperty("webdriver.chrome.driver","chromedriver_v75.exe");
			dr = new ChromeDriver();
	    	dr.get("http://demowebshop.tricentis.com/");	
	   }
	  public void logUpd(String er,String ar,String status)
	  {
		  log=Logger.getLogger("devpinoyLogger");
			log.info("Expected Value:"+er);
			log.info("Actual Value:"+ar);
			log.info("Test Result:"+status);
	  }
	  @Test(priority=2)
	  public void test1()
	  {
		  String status="Failed";
		  hm=new HomePage(dr);
		  String er="Demo Web Shop";
		  String ar=hm.verifyTitle();
		  Assert.assertEquals(ar,er);
		  status="Passed";
		  logUpd(er,ar,status);
	  }
	  @Test(priority=3)
	  public void test2()
	  {
		  String status="Failed";
		  String ar="Register";
		  String er=hm.RegLink();
		  Assert.assertEquals(ar,er);
		  status="Passed";
		  logUpd(er,ar,status);
	  }
	  @Test(priority=4)
	  public void test3()
	  {
		  String status="Failed";
		  String ar="Log in";
		  String er=hm.LoginLink();
		  Assert.assertEquals(ar,er);
		  status="Passed";
		  logUpd(er,ar,status);
	  }
	  @AfterClass
	  public void closeBrowser()
	  {
	  	dr.close();
	  }
	
}
