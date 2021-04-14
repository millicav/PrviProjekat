package utils;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class TestInitialize {

    public WebDriver driver;
    public String sEmail = UserProperties.getEmail();
    public String sPassword = UserProperties.getPassword();


    public void loginToApp(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignInLink();

        loginPage.typeEmail(sEmail)
                .typePassword(sPassword);

        MyAccountPage userHomePage = loginPage.clickSignInButton();
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
    }

}
