package ownFramework.Trial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdownselection {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/select-menu"); 
	  String act=driver.getTitle();
	  String ect="DEMOQA";
	  Assert.assertEquals(act, ect);
	  System.out.println(driver.getTitle());
	  WebElement drop = driver.findElement(By.id("oldSelectMenu"));
	  Select select=new Select(drop);
	  select.selectByIndex(4);
	  Thread.sleep(10000);
	  System.out.println(drop.getText());
	  
	  
	  
	  driver.quit();
  }
}
