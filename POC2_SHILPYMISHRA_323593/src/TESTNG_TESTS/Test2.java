package TESTNG_TESTS;

import org.testng.annotations.Test;

import BASE_CLASSES.HomePage;
import BASE_CLASSES.Login;
import BASE_CLASSES.MyAccount;
import UTILITIES.readwrite;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
@Listeners(BASE_CLASSES.LogUpdate.class)
public class Test2 {

    WebDriver dr;
	Login login;
	MyAccount ma;
  Logger log;
  WebDriverWait wt;
 String str[][];
 @BeforeClass
 public void readExcel()
 {
	 readwrite rw=new readwrite();
	  str=rw.readFromExcelsheet();
 }
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
	 
	public void waitexp(String path)
	{
		wt=new WebDriverWait(dr,10);
	    wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	}
 

  @Test(priority=5)
  public void test4()
  {
	  String status="Failed";
	  login=new Login(dr);
	  String er="Demo Web Shop. Login";
	  String ar=login.verifyTitle();
	  Assert.assertEquals(ar,er);
	  status="Passed";
	  logUpd(er,ar,status);
  }
  @Test(dataProvider = "data",priority=6)
  public void test5(String email,String pwd,String expres)
  {
	  String status="Failed";
	  login.userlogin(email, pwd);
	  ma=new MyAccount(dr);
	  waitexp("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
	  String er= expres;
	  String ar=ma.verifyEmail();
	  ma.logout();
	  Assert.assertEquals(ar,er);
	  status="Passed";
	  logUpd(er,ar,status);
  }

@AfterClass
public void closeBrowser()
{
	dr.close();
}
  @DataProvider
  public String[][] data() {
    return str;
  }

}
