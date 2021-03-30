package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeEmail(String email) {
        //waitUtil.waitForElementToBeVisible(driver, emailInput);
        //emailInput.sendKeys(email);
        driverCommands.waitAndType(driver, emailInput, email);
        return this;
    }

    public LoginPage typePassword(String passwd) {
        //waitUtil.waitForElementToBeVisible(driver, passwordInput);
        //passwordInput.sendKeys(passwd);
        driverCommands.waitAndType(driver, passwordInput, passwd);
        return this;
    }

    /**
     * Click log in button
     * @return User's HomePage
     */
    public MyAccountPage clickSignInButton() {
        //waitUtil.waitForElementToBeVisible(driver, signInButton);
        //signInButton.click();
        driverCommands.clickElement(driver, signInButton);
        return new MyAccountPage(driver);
    }

}

/* zadatak: koristiti nove metode umesto ovoga.
umesto clicka svuda ubaciti driversCommands,
umesto metoda iz testa, ubaciti ove nove...
mozemo napraviti jos neke metode u DriverCommands
npr: isElementPresent, scrollToElement, clickElement.JS,
getText, mouseOver.JS... koriste JavaScriptExecutora */