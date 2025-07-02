package demo;



	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import utils.ExcelUtils;


	public class AON {
		
		static String URL = "https://digitalapps.kandkusa-stage.com/#/display/665888bbcb50f096dd3e0d02";
		static WebDriver driver;
		@Test
		public void test2() throws InterruptedException {
			String path="excel\\data.xlsx";
			ExcelUtils EL=new ExcelUtils(path, "Sheet1");
			String projectPath = System.getProperty("user.dir");
			System.out.println(projectPath);
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement QORB =driver.findElement((By.id("btnquoteorbuy")));
			wait.until(ExpectedConditions.visibilityOf(QORB));
			wait.until(ExpectedConditions.elementToBeClickable(QORB));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", QORB);
			WebElement Fqa =driver.findElement((By.xpath("//label[@for='isLeagueRegisteredWithPW-Yes']")));
			Fqa.click();
			WebElement Sqa =driver.findElement((By.id("desiredEffDate")));
			Sqa.sendKeys("08012025");
			WebElement se =driver.findElement((By.id("leagueState")));
			Select sl=new Select(se);
			sl.selectByVisibleText("Alaska");
			WebElement Tqa =driver.findElement((By.xpath("//span[text()='League']")));
			Tqa.click();
			WebElement Frqa =driver.findElement((By.xpath("//label[@for='profitOrganization-Yes']")));
			Frqa.click();
			WebElement ctn =driver.findElement((By.id("btnContinueEligibility")));
			ctn.click();
			
			//String s=EL.getCellDataString(1, 2);
			//System.out.println(s);
			//System.out.println(driver.findElement(By.xpath("//a[text()='create a music game where I can generate my own tune']")).getText()+"not printing");
			
			//driver.quit();
			
			        

			
			
		}
	}


