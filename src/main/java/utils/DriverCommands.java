package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.wait.WaitUtil;

public class DriverCommands {

    WaitUtil waitUtil = new WaitUtil();
    Logger log = new Logger();
    Sleeper sleeper = new Sleeper();

    public DriverCommands() {

    }

    public void clickElement(WebDriver driver, WebElement element) {
        log.debug("clickElement()");
        waitUtil.waitForElementToBeVisible(driver, element);
        element.click();
        sleeper.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    private void type(WebElement element, String text) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        //element.clear();
        element.sendKeys(text);
    }

    public void waitAndType(WebDriver driver, WebElement element, String text) {
        log.debug("waitAndType()");
        waitUtil.waitForElementToBeVisible(driver, element);
        type(element, text);
        sleeper.sleepForMilliseconds(TimeoutLevel.MS_SHORTEST.value());
    }
}
