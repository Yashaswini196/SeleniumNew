package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    @BeforeSuite
    public void setupReport(){
        extent = ExtentReportManager.getExtentReportInstance();
    }
    @AfterSuite
    public void teardownReport(){
        extent.flush();
    }

    @BeforeMethod
    public void setUp(){
        Log.info("Starting WebDriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Log.info("Navigating to the URL");
        driver.get("https://admin-demo.nopcommerce.com/login");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ExtentReportManager.CaptureScreenshot(driver,"LoginFailure");
            System.out.println("Path of the Screenshot "+screenshotPath);
            test.fail("Test Fail check Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
        if (driver != null) {
            Log.info("Closing WebDriver");
            driver.quit();
        }
    }
}
