package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//a[@title='Contact Us']")
    private WebElement contactUsLink;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage clickContactUs() {
        log.debug("clickContactUs()");
        driverCommands.clickElement(driver, contactUsLink);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        return contactUsPage;
    }
}
