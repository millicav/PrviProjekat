package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//img[@title = 'Blouse'])[1]")
    private WebElement firstBlouse;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[2]")
    private WebElement quickViewButton;

    @FindBy(xpath = "//button[@name=\"Submit\"]")
    private WebElement addToCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage mouseOverFirstBlouse() {
        log.debug("mouseOverFirstBlouse()");
        driverCommands.mouseOver(driver, firstBlouse);
        return this;
    }

    public HomePage clickAddToCart() {
        log.debug("clickAddToCart()");
        driverCommands.clickElement(driver, quickViewButton);
        //driverCommands.getSleeper().sleepForSeconds(5);
        //addToCartButton.click();
        return this;
    }
}
