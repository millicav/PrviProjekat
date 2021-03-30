package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage {

    @FindBy(id = "id_contact")
    private WebElement subjectHeading;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage selectSubjectHeading() {
        log.debug("selectSubjectHeading()");
        Select subjectHeadingDropdown = new Select(subjectHeading);
        subjectHeadingDropdown.selectByValue("1");
        return this;
    }
}
