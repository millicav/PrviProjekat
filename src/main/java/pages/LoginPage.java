package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String passwd) {
        passwordInput.sendKeys(passwd);
        return this;
    }
}

/* zadatak: koristiti nove metode umesto ovoga.
umesto clicka svuda ubaciti driversCommands,
umesto metoda iz testa, ubaciti ove nove...
mozemo napraviti jos neke metode u DriverCommands
npr: isElementPresent, scrollToElement, clickElement.JS,
getText, mouseOver.JS... koriste JavaScriptExecutora */