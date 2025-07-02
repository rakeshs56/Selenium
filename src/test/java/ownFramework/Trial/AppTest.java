package ownFramework.Trial;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium

import junit.framework.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	@Test
	public void google() {
		
		WebDriver driver = new ChromeDriver();
		//goto google.com
				driver.get("https://google.com");
				
				//enter text in search textbooks
				driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
				
				//click on search button
				//driver.findElement(By.name("btnK")).click();
				driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
				
				//close browser
				driver.close();
				
				System.out.println("Test Completed Successfully");
					
	}
}
