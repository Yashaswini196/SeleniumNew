package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://admin-demo.nopcommerce.com/login");
        System.out.println("Title of the Page is= "+driver.getTitle());
        WebElement Email = driver.findElement(By.id("Email"));
            Email.clear();
            Email.sendKeys("admin@yourstore.com");
        WebElement password = driver.findElement(By.id("Password"));
             password.clear();
             password.sendKeys("admin");
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button"));
             Login.click();
             System.out.println("Button is click ="+Login.getText());
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleContains("Dashboard"));
        Thread.sleep(3000);
        driver.quit();

    }
}
