package ownFramework.Trial;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class crossbrowsertest {
 WebDriver driver;
 ChromeOptions chrome=new ChromeOptions();
 EdgeOptions edge= new EdgeOptions();
 
 @Parameters("browser")
  @BeforeTest
  public void intialize(String browser) {
	  if(browser.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver(chrome);
		 //S WebDriver driver =new ChromeDriver();
		 System.out.println("chrome launched");
	  }
	  else if(browser.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver(edge);
		  System.out.println("edge launched");
	  }
	  
  }
  
  @Test
  public void first() {
	// Implicitly wait for 10 seconds
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("http://www.citi.com"); 
	 String act=driver.getTitle();
	 String ect="citi";
	 Assert.assertEquals(act.contains("citi"), ect.contains("citi"));
	 System.out.println(driver.getTitle());
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
