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

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement yourLogoImage;

    @FindBy(xpath = "//a[@title='Contact Us']")
    private WebElement contactUsLink;

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

    /**
     * Click on Your Logo Image
     * @return HomePage
     */
    public HomePage clickYourLogo() {
        log.debug("clickYourLogo()");
        driverCommands.clickElement(driver, yourLogoImage);
        return new HomePage(driver);
    }

    /**
     * Click ContactUs button
     * @return ContactUsPage
     */
    public ContactUsPage clickContactUs() {
        log.debug("clickContactUs()");
        driverCommands.clickElement(driver, contactUsLink);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        return contactUsPage;
    }
}
