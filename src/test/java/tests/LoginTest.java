package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;
import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = System.getProperty("user.dir")+ "/TestData/Datatesting.xlsx";
        ExcelUtils.LoadExcel(filePath,"Sheet1");
        int rowCount = ExcelUtils.getRowCount("Sheet1");
        Object[][] data = new Object[rowCount-1][2];
        for(int i=1;i<rowCount;i++){
            data[i-1][0] = ExcelUtils.getCellData(i,0); // Email
            data[i-1][1] = ExcelUtils.getCellData(i,1); // Password
        }
        ExcelUtils.closeExcel();
        return data;
    }

    @DataProvider(name="LoginData2")
    public Object[][] getData(){
        return new Object[][]{
                {"admin@yourstore.com","admin"},
                {"user1","pass1"}
        };
    }
    @Test(dataProvider = "LoginData2")
    public void TestValidLogin(String email, String password) throws IOException {
        Log.info("Starting the Validation");
        test = ExtentReportManager.createTest("Login Test - "+email);
        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigate To login Page");
        Log.info("Adding credentials");
//        loginPage.EnterEmail("admin@yourstore.com");
//        loginPage.EnterPassword("admin");
        loginPage.EnterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        test.info("Credentials are correct and Login Successfull!");
        Log.info("Login Successful");
        Log.info("Verifying page Title");
        test.info("Verifying page Description");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Just a moment...")));
        wait.until(ExpectedConditions.titleIs("Dashboard / nopCommerce administration"));
        System.out.println("Title of the page is= " + driver.getTitle());
        test.pass("Everything is correct and Login Successfull!");
        Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");

    }
    @Test(dataProvider = "LoginData")
    public void TestInValidLogin(String email, String password) throws IOException {

        Log.info("Starting the Validation");
        test = ExtentReportManager.createTest("Login Test");
        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigate To login Page");
        Log.info("Adding Invalid credentials");
//        loginPage.EnterEmail("Commeneerce1234@yourstore.com");
//        loginPage.EnterPassword("Commerce");
        loginPage.EnterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        test.info("Credentials are correct and Login Successfull!");
        Log.info("Login Successful");
        Log.info("Verifying page Title");
        test.info("Verifying page Description");
        test.pass("Everything is correct and Login Successfull!");
        Assert.assertEquals(driver.getTitle(), "Welcome");
    }

    @Test()
    @Parameters({"email","password"})
    public void TestValidLoginTestNG(String email, String password) throws IOException {
        Log.info("Starting the Validation");
        test = ExtentReportManager.createTest("Login Test - "+email);
        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigate To login Page");
        Log.info("Adding credentials");
//        loginPage.EnterEmail("admin@yourstore.com");
//        loginPage.EnterPassword("admin");
        loginPage.EnterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        test.info("Credentials are correct and Login Successfull!");
        Log.info("Login Successful");
        Log.info("Verifying page Title");
        test.info("Verifying page Description");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Just a moment...")));
        wait.until(ExpectedConditions.titleIs("Dashboard / nopCommerce administration"));
        System.out.println("Title of the page is= " + driver.getTitle());
        test.pass("Everything is correct and Login Successfull!");
        Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");

    }
}
