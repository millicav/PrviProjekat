import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import utils.TestInitialize;
import webDriver.WebDriverFactory;

public class BuyingProductTest extends TestInitialize {

    @Test
    public void testBuyingProduct() {
        WebDriver driver = WebDriverFactory.getDriver();
        String expectedHeader = "Your order on My Store is complete.";

        try {
            loginToApp(driver);

            HomePage homePage = new HomePage(driver);
            homePage.clickYourLogo()
                    .mouseOverFirstBlouse()
                    .clickAddToCartHomePage();

            CheckoutPage checkoutPage = homePage.clickOnTheProceedToCheckOut();
            checkoutPage.clickOnTheProceedToCheckOut1()
                        .clickOnTheProceedToCheckOut2()
                        .clickOnTheTermsOfService()
                        .clickOnTheProceedToCheckOut3()
                        .clickOnPayByBankWireButton()
                        .clickOnIConfirmMyOrderButton();

            String actualHeader = checkoutPage.getConfirmationHeader();
            assert actualHeader.equals(expectedHeader) : "Expected header is [" + expectedHeader + "], but actual is [" + actualHeader + "].";
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testBlousePage() {
        WebDriver driver = WebDriverFactory.getDriver();

        try {
            loginToApp(driver);

            HomePage homePage = new HomePage(driver);
            homePage.clickYourLogo()
                    .mouseOverFirstBlouse();
            ProductPage blousePage = homePage.clickOnTheFirstBlouse();

        } finally {
            //driver.quit();
        }
    }
}

//domaci
//pronaci lokatore na stranici bluze za:
//twitter, facebook, sve do dole i desno
//zavrsiti kupovinu ovog proizvoda
//sledeci cas: prelazak na tab i iframe