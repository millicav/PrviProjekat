package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.wait.WaitUtil;

public class DriverCommands {

    WaitUtil waitUtil = new WaitUtil();
    Logger log = new Logger();
    Sleeper sleeper = new Sleeper();

    public DriverCommands() {

    }

    public Sleeper getSleeper() {
        return sleeper;
    }

    /**
     * Click Element
     *
     * @param element element
     */
    public void clickElement(WebDriver driver, WebElement element) {
        log.debug("clickElement()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        element.click();
        sleeper.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    /**
     * Typing
     *
     * @param element element
     */
    private void type(WebElement element, String text) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        //element.clear();
        element.sendKeys(text);
    }

    /**
     * Waiting and Typing
     *
     * @param element element
     */
    public void waitAndType(WebDriver driver, WebElement element, String text) {
        log.debug("waitAndType()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        type(element, text);
        sleeper.sleepForMilliseconds(TimeoutLevel.MS_SHORTEST.value());
    }

    /**
     * Is element present
     *
     * @param element element
     * @return boolean
     */
    public boolean isElementPresent(WebElement element) {
        log.debug("isElementPresent()");
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    /**
     * Scroll to element
     *
     * @param element element
     */
    public void scrollToElement(WebDriver driver, WebElement element) {
        log.debug("scrollToElement()");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        scrollHorizontally(driver, -100);
    }

    /**
     * Scroll to up or down in pixels (Negative number is up, positive number is
     * down)
     *
     * @param yPixels yPixels
     */
    public void scrollHorizontally(WebDriver driver, int yPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + yPixels + ")");
    }

    /**
     * Click on element with JavaScript and wait for given milliseconds
     *
     * @param element element
     */
    public void clickElementJS(WebDriver driver, WebElement element) {
        log.debug("Click on element with js");
        waitUtil.waitForElementToBeVisible(driver, element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        scrollToElement(driver, element);
        js.executeScript("arguments[0].click();", element);
        sleeper.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    /**
     * Get Text
     *
     * @param element element
     * @return String
     */
    public String getText(WebDriver driver, WebElement element) {
        log.debug("getText()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        String text = element.getText();
        sleeper.sleepForSeconds(TimeoutLevel.SHORTER.value());
        return text;
    }

    /**
     * Mouse Over element
     *
     * @param element element
     */
    public void mouseOver(WebDriver driver, WebElement element) {
        log.debug("mouseOver()");
        waitUtil.waitForElementToBeVisible(driver, element);
        scrollToElement(driver, element);
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        sleeper.sleepForSeconds(TimeoutLevel.SHORTER.value());
    }

    /**
     * Select Drop Down List By Value
     *
     * @param element element
     */
    public void selectDropDownByValue(WebElement element, String value) {
        log.debug("selectDropDownByValue()");
        Select dropDownByValue = new Select(element);
        dropDownByValue.selectByValue(value);
    }

}
