package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//img[@title = 'Blouse'])[1]")
    private WebElement firstBlouse;

    @FindBy(xpath = "//a[@class='quick-view'][contains(@href, 'product=2')]")
    private WebElement quickViewButton;

    @FindBy(xpath = "//button[@type='submit'][@name='Submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@data-id-product='2']")
    private WebElement addToCartFromHomePage;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage mouseOverFirstBlouse() {
        log.debug("mouseOverFirstBlouse()");
        driverCommands.mouseOver(driver, firstBlouse);
        return this;
    }

    public HomePage clickQuickViewButton() {
        log.debug("clickQuickViewButton()");
        driverCommands.clickElementJS(driver, quickViewButton);
        return this;
    }

    public HomePage clickAddToCart() {
        log.debug("clickAddToCart()");
        driverCommands.clickElement(driver, addToCartButton);
        return this;
    }

    public HomePage clickAddToCartHomePage() {
        log.debug("clickAddToCartHomePage()");
        driverCommands.clickElementJS(driver, addToCartFromHomePage);
        return this;
    }

    public ProductPage clickOnTheFirstBlouse() {
        log.debug("clickOnTheFirstBlouse()");
        driverCommands.clickElementJS(driver, firstBlouse);
        return new ProductPage(driver);
    }

    public CheckoutPage clickOnTheProceedToCheckOut() {
        log.debug("clickOnTheProceedToCheckOut()");
        driverCommands.clickElement(driver, proceedToCheckoutButton);
        return new CheckoutPage(driver);
    }
}
