package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By Email = By.id("Email");
    private By Password = By.id("Password");
    private By LoginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void EnterEmail(String email) {
        driver.findElement(Email).clear();
        driver.findElement(Email).sendKeys(email);
    }
    public void EnterPassword(String password) {
        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }
}
