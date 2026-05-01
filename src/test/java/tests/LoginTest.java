package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void TestValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterEmail("admin@yourstore.com");
        loginPage.EnterPassword("admin");
        loginPage.clickLoginButton();
        System.out.println("Title of the page is= "+  driver.getTitle());
//        Assert.assertEquals(driver.getTitle(), "Welcome");

    }


}
