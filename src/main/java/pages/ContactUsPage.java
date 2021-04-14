package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {

    @FindBy(id = "id_contact")
    private WebElement subjectHeadingDropDown;

    @FindBy(id = "message")
    private WebElement messageBox;

    @FindBy(id = "submitMessage")
    private WebElement submitMessageButton;

    @FindBy(xpath = "//p[@class = 'alert alert-success']")
    private WebElement successMessage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select Subject Heading
     * @return ContactUsPage
     */
    public ContactUsPage selectSubjectHeading(String subjectHeading) {
        driverCommands.selectDropDownByValue(subjectHeadingDropDown, subjectHeading);
        return this;
    }

    /**
     * Write a Message
     * @return ContactUsPage
     */
    public ContactUsPage writeAMessage(String mess) {
        log.debug("writeAMessage()");
        driverCommands.waitAndType(driver, messageBox, mess);
        return this;
    }

    public ContactUsPage submitForm() {
        log.debug("submitForm()");
        driverCommands.clickElement(driver, submitMessageButton);
        return this;
    }

    public String getSuccessMessageText() {
        log.debug("getSuccessMessageText");
        return driverCommands.getText(driver, successMessage);
    }
}
