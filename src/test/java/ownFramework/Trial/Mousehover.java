package ownFramework.Trial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mousehover {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.browserstack.com/guide/mouse-hover-in-selenium"); 
	  //String act=driver.getTitle();
	  //String ect="DEMOQA";
	 // Assert.assertEquals(act, ect);
	  System.out.println(driver.getTitle());
	 
	 WebElement ele = driver.findElement(By.id("developers-dd-toggle"));
	//Creating object of an Actions class
	Actions action = new Actions(driver);
	//Performing the mouse hover action on the target element.
	//action.moveToElement(ele).perform();
	 WebElement ele1 = driver.findElement(By.id("products-dd-toggle"));
	 WebElement ele2 = driver.findElement(By.xpath("//span[text()='Web Testing']"));
	 WebElement ele3 = driver.findElement(By.xpath("//span[text()='Automate']"));
	 action.moveToElement(ele1).moveToElement(ele2).moveToElement(ele3).perform();
	 ele3.click();
	 action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	 System.out.println(driver.getTitle());
	 driver.navigate().back();
	 Thread.sleep(10000);
	 System.out.println(driver.getTitle());
	 Thread.sleep(10000);
	
	driver.quit();
  }
}
