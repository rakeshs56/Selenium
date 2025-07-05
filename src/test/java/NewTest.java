import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	
	WebDriver driver=null;
	 
  @BeforeSuite
  public void beforesuite() {
	  System.out.println("beforesuite");
	  
  }
 
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforesuite");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
  }
  
  @BeforeTest
  public void beforeTest() {
	//goto google.com
	
	System.out.println("gotoapp");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("login");
  }
  
  @Test
  public void googlesearch() {
	  System.out.println("perform task");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("logout");
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("close app");
  }
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  System.out.println("beforesuite");
	 driver.quit();
	 
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("close excel");
  }
  

}
