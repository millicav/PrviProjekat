package webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");

        return driver;
    }


}
