package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverCommands;
import utils.Logger;
import utils.wait.WaitUtil;

public class BasePage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutLink;

    protected WaitUtil waitUtil = new WaitUtil();
    protected DriverCommands driverCommands = new DriverCommands();
    protected WebDriver driver;
    protected Logger log = new Logger();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtil.waitPageReady(driver); //ceka da se ucita .js do kraja
    }

    /**
     * Click sign in link
     * @return LoginPage
     */
    public LoginPage clickSignInLink() {
        //waitUtil.waitForElementToBeVisible(driver, signInLink);
        //signInLink.click();
        driverCommands.clickElement(driver, signInLink);
        return new LoginPage(driver);
    }

    /**
     * Click sign out link
     * @return HomePage
     */
    public HomePage clickSignOutLink() {
        driverCommands.clickElement(driver,signOutLink);
        //signOutLink.click();
        return new HomePage(driver);
    }

    /**
     * Get method for Sign Out Link
     * @return WebElement
     */
    public WebElement getSignOutLink() {
        waitUtil.waitForElementToBeVisible(driver, signOutLink);
        return signOutLink;
    }
}
