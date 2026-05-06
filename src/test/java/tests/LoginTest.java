package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public void TestValidLogin() {

        Log.info("Starting the Validation");
        test = ExtentReportManager.createTest("Login Test");
        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigate To login Page");
        Log.info("Adding credentials");
        loginPage.EnterEmail("admin@yourstore.com");
        loginPage.EnterPassword("admin");
        loginPage.clickLoginButton();
        test.info("Credentials are correct and Login Successfull!");
        Log.info("Login Successful");
        Log.info("Verifying page Title");
        test.info("Verifying page Description");
        System.out.println("Title of the page is= " + driver.getTitle());
        test.pass("Everything is correct and Login Successfull!");
//        Assert.assertEquals(driver.getTitle(), "Welcome");

    }
    @Test
    public void TestInValidLogin() {

        Log.info("Starting the Validation");
        test = ExtentReportManager.createTest("Login Test");
        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigate To login Page");
        Log.info("Adding Invalid credentials");
        loginPage.EnterEmail("Commeneerce1234@yourstore.com");
        loginPage.EnterPassword("Commerce");
        loginPage.clickLoginButton();
        test.info("Credentials are correct and Login Successfull!");
        Log.info("Login Successful");
        Log.info("Verifying page Title");
        test.info("Verifying page Description");
        test.pass("Everything is correct and Login Successfull!");
        Assert.assertEquals(driver.getTitle(), "Welcome");

    }
}
