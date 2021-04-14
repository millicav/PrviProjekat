import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import webDriver.WebDriverFactory;

public class ContactUsSendMessage {

    @Test
    public void testContactUsSendMessage() {

        String email = "milicica@gmail.com";
        String psswd = "mica123";
        String subjectHeading = "1";
        String message = "This is message";
        String expectedConfirmationMessage = "Your message has been successfully sent to our team.";

        WebDriver driver = WebDriverFactory.getDriver();

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.clickSignInLink();

            loginPage.typeEmail(email)
                    .typePassword(psswd);

            MyAccountPage userHomePage = loginPage.clickSignInButton();

            ContactUsPage contactUsPage = userHomePage.clickContactUs();

            contactUsPage.selectSubjectHeading(subjectHeading)
                    .writeAMessage(message)
                    .submitForm();

            String actualConfirmationMessage = contactUsPage.getSuccessMessageText();
            assert actualConfirmationMessage.equals(expectedConfirmationMessage):"Expected is [" + expectedConfirmationMessage + "], but actual is [" + actualConfirmationMessage + "].";
        } finally {
            //driver.quit();
        }
    }
}
