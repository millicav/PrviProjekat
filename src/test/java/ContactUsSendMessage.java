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

        WebDriver driver = WebDriverFactory.getDriver();

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.clickSignInLink();

            loginPage.typeEmail(email)
                    .typePassword(psswd);

            MyAccountPage userHomePage = loginPage.clickSignInButton();

            ContactUsPage contactUsPage = userHomePage.clickContactUs();

            contactUsPage.selectSubjectHeading();

        } finally {
            //driver.quit();
        }
    }
}
