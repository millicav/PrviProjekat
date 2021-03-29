package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public boolean isElementPresent(WebDriver driver, WebElement element) {
        return false;
    }

    public void scrollToElement(WebDriver driver, WebElement element) {

    }

    /** click element.js **/

    public String getText(WebDriver driver, WebElement element) {
        log.debug("getText()");
        waitUtil.waitForElementToBeVisible(driver, element);
        String text = element.getText();
        sleeper.sleepForSeconds(TimeoutLevel.SHORTER.value());
        return text;
    }

    public void mouseOver(WebDriver driver, WebElement element) {
        log.debug("mouseOver()");
        waitUtil.waitForElementToBeVisible(driver, element);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }
}
