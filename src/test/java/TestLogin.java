import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import webDriver.WebDriverFactory;

public class TestLogin {

    @Test
    public void testLoginFunctionality() {

        String email = "milicica@gmail.com";
        String psswd = "mica123";
        String expectedSignOut = "Sign out";

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");

        //WebDriver driver = new ChromeDriver();
        //driver.get("http://automationpractice.com/index.php");
        //driver.manage().window().maximize();
        WebDriver driver = WebDriverFactory.getDriver();

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.clickSignInLink();
            //Thread.sleep(3000);

            loginPage.typeEmail(email)
                    .typePassword(psswd);
            //Thread.sleep(3000);

            MyAccountPage userHomePage = loginPage.clickSignInButton();
            //Thread.sleep(3000);

            //HOMEWORK: We check if there is a Sign Out link in the Navigation bar
            //if the user is successfully signed in, that button is certainly exists
            String actualSignOut = userHomePage.getSignOutLink().getText();
            assert actualSignOut.equals(expectedSignOut) : "Expected text is [" + expectedSignOut + "], but actual is [" + actualSignOut + "].";
        } finally {
            driver.quit();
        }
    }
}

/* za domaci: zavrsiti Test, klikni SUBMIT button
ali prvo napravi testnog usera, pa njegove kredencijale
verifikovati da smo ulogovani, npr preko Navigacije */