package ownFramework.Trial;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class propertyfiledatainput {
	WebDriver driver;
 
	
  @BeforeTest
  public void beforeTest() throws IOException {
	  System.out.println("load propertyfile");
	  Properties prop=new Properties();
	  FileInputStream fis=new FileInputStream("data\\commondata.property");
	  prop.load(fis);
	  System.out.println(prop.getProperty("email"));
	  System.out.println(prop.getProperty("password"));
  }
  @BeforeClass
  public void BeforeClass() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  //options.addArguments("--remote-allow-origins=*");
	  //options.addArguments("--disable notifications");
	  DesiredCapabilities cp = new DesiredCapabilities();
	  cp.setCapability(ChromeOptions.CAPABILITY, options);
	  options.merge(cp);
	  driver = new ChromeDriver(options);
	  driver.get("https:www.citi.com");
 	 System.out.println("launch browser");
 }
  
  @Test
  public void f() {
	  System.out.println(driver.getTitle());
	  
	  
  }

@AfterClass
public void AfterClass() {
	driver.quit();
	  System.out.println("close browser");
} 
  @AfterTest
  public void afterTest() {
	  
	  System.out.println("close propertyfile");
  }

}
