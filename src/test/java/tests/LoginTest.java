package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

    @Test
    public void TestValidLogin(){
        Log.info("Starting the Validation");
        LoginPage loginPage = new LoginPage(driver);
        Log.info("Adding credentials");
        loginPage.EnterEmail("admin@yourstore.com");
        loginPage.EnterPassword("admin");
        loginPage.clickLoginButton();
        Log.info("Login Successful");
        Log.info("Verifying page Title");
        System.out.println("Title of the page is= "+  driver.getTitle());
//        Assert.assertEquals(driver.getTitle(), "Welcome");

    }


}
