import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.DriverCommands;
import webDriver.WebDriverFactory;

public class PrviTest {

    @Test
    public void Proba() {
        String expectedHeader = "Automation Practice Website";

        //System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver();

        driver.get("http://automationpractice.com/index.php");
        String actualHeader = driver.findElement(By.xpath("//h1")).getText();

        //assert actualHeader.equals(expectedHeader) : "Expected header is [" + expectedHeader + "], but actual is [" + actualHeader + "].";
        //driver.quit();

        WebElement hover = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        DriverCommands driverCommands = new DriverCommands();
        driverCommands.mouseOver(driver, hover);
        System.out.println("---");
        String elemText = driverCommands.getText(driver, hover);
        System.out.println(elemText);
        driver.quit();
    }
}
