package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.wait.WaitUtil;

public class BasePage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInLink;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutLink;

    protected WaitUtil waitUtil = new WaitUtil();
    protected WebDriver driver;

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
        signInLink.click();
        return new LoginPage(driver);
    }

    /**
     * Click log in button
     * @return User's HomePage
     */
    public HomePage clickSignInButton() {
        signInButton.click();
        return new HomePage(driver);
    }

    /**
     * Click sign out link
     * @return HomePage
     */
    public HomePage clickSignOutLink() {
        signOutLink.click();
        return new HomePage(driver);
    }

    /**
     * Get method for Sign Out Link
     * @return WebElement
     */
    public WebElement getSignOutLink() {
        return signOutLink;
    }
}
