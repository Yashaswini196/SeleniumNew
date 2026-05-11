package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

//    private By Email = By.id("Email");
//    private By Password = By.id("Password");
//    private By LoginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");

    @FindBy(id="Email")
    WebElement Email;
    @FindBy(id="Password")
    WebElement Password;
    @FindBy(xpath = "//*[@id='main']/div/section/div/div[2]/div[1]/div/form/div[3]/button")
    WebElement LoginButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void EnterEmail(String email) {
//        driver.findElement(Email).clear();
//        driver.findElement(Email).sendKeys(email);
        Email.clear();
        Email.sendKeys(email);
    }
    public void EnterPassword(String password) {
//        driver.findElement(Password).clear();
//        driver.findElement(Password).sendKeys(password);
        Password.clear();
        Password.sendKeys(password);
    }
    public void clickLoginButton() {
        LoginButton.click();
//        driver.findElement(LoginButton).click();
    }
}
