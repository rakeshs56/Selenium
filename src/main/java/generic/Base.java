package generic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.generic.Filelibe;
import com.generic.Log;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    public static WebDriver driver;
    public static ExtentReports extent;
    protected ExtentTest test;
    public static Base base;

    @BeforeSuite
    public void setup() throws Throwable {
        Log.info("Starting test suite setup");
        extent = extentReportGenerator();
        Log.info("Extent report generator setup completed");
    }

    @Parameters("browsername")
    @BeforeMethod
    public void launchBrowser(java.lang.reflect.Method m, ITestContext context, @Optional("chrome") String browserName) throws Exception {
        Log.startTestCase("launchBrowser");
        Log.info("Launching browser: " + browserName);
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "internet explorer":
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        Capabilities capability = ((RemoteWebDriver) driver).getCapabilities();
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Selenium Version", System.getProperty("selenium.version"));
        extent.setSystemInfo("Java version", System.getProperty("java.version"));

        Log.info(browserName + " initialized");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Browser window maximized and implicit wait set");

        Filelibe fl = new Filelibe();
        String url = fl.getproperty("url");
        driver.get(url);
        Log.info("Navigated to URL: " + url);

        String browserInfo = capability.getBrowserName() + " " + capability.getBrowserVersion();
        test = extent.createTest(m.getName());
        test.assignDevice(browserInfo);
        Log.setTest(test);
        Log.endTestCase("launchBrowser");
    }

    @AfterMethod
    public void closeBrowser(java.lang.reflect.Method m, ITestResult result) throws Throwable {
        Log.startTestCase("closeBrowser");
        Log.info("Closing browser for test: " + m.getName());
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPathFail = captureScreenshot(result.getMethod().getMethodName() + ".jpg");
            test.addScreenCaptureFromPath(screenshotPathFail);
            test.fail(result.getThrowable());
            Log.error("Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(m.getName() + "  " + "this test is passed");
            String screenshotPathPass = captureScreenshot(result.getMethod().getMethodName() + ".jpg");
            test.addScreenCaptureFromPath(screenshotPathPass);
            Log.info("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(m.getName() + "  " + "this test is skipped");
            String screenshotPathSkipped = captureScreenshot(result.getMethod().getMethodName() + ".jpg");
            test.addScreenCaptureFromPath(screenshotPathSkipped);
            Log.warn("Test skipped");
        }
        test.assignCategory(m.getAnnotation(Test.class).groups());
        driver.quit();
        Log.info("Browser closed for test: " + m.getName());
        Log.endTestCase("closeBrowser");
    }

    @AfterSuite
    public void tearDown() {
        Log.startTestCase("tearDown");
        extent.flush();
        Log.info("Extent reports flushed");

        base.closeServer();
        Log.info("Server closed");

        // Open the Extent report automatically
        try {
            openExtentReport();
        } catch (IOException e) {
            Log.error("Error opening the Extent report: " + e.getMessage());
        }
        Log.endTestCase("tearDown");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    // Methods of base class
    private static ExtentReports extentReportGenerator() throws Throwable {
        String separator = File.separator;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
        String path = System.getProperty("user.dir") + separator + "HTMLReports" + separator + "ExtentReport"
                + separator + "report-" + timeStamp + ".html";
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.loadJSONConfig(new File("./src/main/resources/extentreportsconfig.json"));
        reporter.viewConfigurer().viewOrder().as(new ViewName[] {
                ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.EXCEPTION, ViewName.LOG, ViewName.AUTHOR,
                ViewName.DEVICE }).apply();

        extent.attachReporter(reporter);
        return extent;
    }

    public void login() throws Exception {
        Log.startTestCase("login");
        Filelibe fl = new Filelibe();
        String email = fl.getproperty("email");
        String password = fl.getproperty("password");

        com.pom.login log = new com.pom.login(driver);
        log.getemail().sendKeys(email);
        Log.info("Entered email");
        log.getpassword().sendKeys(password);
        Log.info("Entered password");
        log.getloginbtn().click();
        Log.info("Clicked login button");
        Log.endTestCase("login");
    }

    public void logout() {
        Log.startTestCase("logout");
        com.pom.login log = new com.pom.login(driver);
        log.getlogoutmenu().click();
        Log.info("Clicked logout menu");
        log.getlogout().click();
        Log.info("Clicked logout button");
        Log.endTestCase("logout");
    }

    public void closeServer() {
        Log.startTestCase("closeServer");
        try {
            String processName = "chrome.exe";
            Process process = Runtime.getRuntime().exec("taskkill /F /IM " + processName);
            process.waitFor();
            Log.info("Server closed successfully");
        } catch (Exception e) {
            Log.error("Error closing server: " + e.getMessage());
        }
        Log.endTestCase("closeServer");
    }

    public String getMethodName() {
        // Use reflection to get the current method name
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String methodName = stackTraceElements[2].getMethodName();
        return methodName;
    }

    public static String captureScreenshot(String filename) throws Throwable {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
        String screenshotPath = "./Screenshot/" + "/" + timeStamp + "_screenshot.png";

        File destFile = new File(screenshotPath);
        FileUtils.copyFile(src, destFile);
        Log.info("Screenshot captured: " + screenshotPath);
        return destFile.getAbsolutePath();
    }

    public static String base64() throws Throwable {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64 = ts.getScreenshotAs(OutputType.BASE64);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
        String screenshotPath = "./Screenshot/" + "/" + timeStamp + "_screenshot.png";
        Log.info("Base64 screenshot captured");
        return base64;
    }

    private void openExtentReport() throws IOException {
        String separator = File.separator;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
        String path = System.getProperty("user.dir") + separator + "HTMLReports" + separator + "ExtentReport" + separator + "report-" + timeStamp + ".html";

        File reportFile = new File(path);

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(reportFile.toURI());
            Log.info("Extent report opened automatically");
        } else {
            Log.warn("Opening the report is not supported on this platform.");
        }
    }
}
