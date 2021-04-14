import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestInitialize;
import webDriver.WebDriverFactory;

public class BuyingProductTest extends TestInitialize {

    @Test
    public void testBuyingProduct() {
        WebDriver driver = WebDriverFactory.getDriver();

        try {
            loginToApp(driver);

            HomePage homePage = new HomePage(driver);
            homePage.clickYourLogo()
                    .mouseOverFirstBlouse()
                    .clickAddToCart();

        } finally {
            //driver.quit();
        }
    }
}
