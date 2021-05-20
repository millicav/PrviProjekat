package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    private WebElement proceedToCheckoutButton1;

    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement proceedToCheckoutButton2;

    @FindBy(xpath = "//label[@for='cgv']")
    private WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement proceedToCheckoutButton3;

    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement payByBankWireButton;

    @FindBy(xpath = "//span[contains(text(), 'I confirm')]")
    private WebElement iConfirmMyOrderButton;

    @FindBy(xpath = "//p[@class='cheque-indent']")
    private WebElement confirmationHeader;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickOnTheProceedToCheckOut1() {
        log.debug("clickOnTheProceedToCheckOut1()");
        driverCommands.clickElement(driver, proceedToCheckoutButton1);
        return this;
    }

    public CheckoutPage clickOnTheProceedToCheckOut2() {
        log.debug("clickOnTheProceedToCheckOut2()");
        driverCommands.clickElement(driver, proceedToCheckoutButton2);
        return this;
    }

    public CheckoutPage clickOnTheTermsOfService() {
        log.debug("clickOnTheTermsOfService()");
        driverCommands.clickElement(driver, termsOfServiceCheckbox);
        return this;
    }

    public CheckoutPage clickOnTheProceedToCheckOut3() {
        log.debug("clickOnTheProceedToCheckOut3()");
        driverCommands.clickElement(driver, proceedToCheckoutButton3);
        return this;
    }

    public CheckoutPage clickOnPayByBankWireButton() {
        log.debug("clickOnPayByBankWireButton()");
        driverCommands.clickElement(driver, payByBankWireButton);
        return this;
    }

    public CheckoutPage clickOnIConfirmMyOrderButton() {
        log.debug("clickOnIConfirmMyOrderButton()");
        driverCommands.clickElement(driver, iConfirmMyOrderButton);
        return this;
    }

    public String getConfirmationHeader() {
        log.debug("getConfirmationHeader()");
        return confirmationHeader.getText();
    }
}
