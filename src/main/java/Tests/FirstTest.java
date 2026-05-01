package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();

        driver.get("https://selenium.dev");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());



//        Thread.sleep(10000);

        driver.quit();
    }
}
