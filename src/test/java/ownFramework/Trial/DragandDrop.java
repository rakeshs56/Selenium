package ownFramework.Trial;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {
	WebDriver driver;
	
  @Test
  public void f()  {
	  WebDriverManager.edgedriver().setup();
	  driver =new EdgeDriver();
	  driver.manage().window().maximize();
	  /* driver.get("https://demoqa.com/droppable/"); 
	  
	  WebElement drag = driver.findElement(By.id("draggable"));
	  WebElement drop = driver.findElement(By.id("droppable"));
	  Actions action = new Actions(driver);
	  action.dragAndDrop(drag, drop).perform(); */
	  
	  driver.get("https://easyupload.io/");
	  long time = 2000;
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	  WebElement upload = driver.findElement(By.id("dropzone"));
	  WebElement download = driver.findElement(By.xpath("//span[text()='Download All']"));
	  File file = new File("C:\\Users\\SKP\\Documents\\workspace\\NewProject\\data.xlsx");
	  String absolutePath = file.getAbsolutePath();
      // Upload the file
	  upload.sendKeys(absolutePath);
	  
	  download.click();
	 
		driver.quit();
	  
  }
}
