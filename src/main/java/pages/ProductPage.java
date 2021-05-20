package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'btn-twitter')]")
    private WebElement twitterButton;

    @FindBy(xpath = "//button[contains(@class, 'btn-facebook')]")
    private WebElement facebookButton;

    @FindBy(xpath = "//button[contains(@class, 'btn-google-plus')]")
    private WebElement googlePlusButton;

    @FindBy(xpath = "//button[contains(@class, 'btn-pinterest')]")
    private WebElement pinterestButton;

    @FindBy(xpath = "//a[contains(text(),'Write a review')]")
    private WebElement writeAReview;

    @FindBy(xpath = "//a[@id='send_friend_button']")
    private WebElement sendToAFriend;

    @FindBy(xpath = "//a[@href='javascript:print();']")
    private WebElement printButton;

    @FindBy(xpath = "//input[@name='qty']")
    private WebElement quantityBox;

    @FindBy(xpath = "//a[contains(@class, 'button-minus')]")
    private WebElement quantityMinus;

    @FindBy(xpath = "//a[contains(@class, 'button-plus')]")
    private WebElement quantityPlus;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement sizeDropDown;

    @FindBy(xpath = "//a[@name='White']")
    private WebElement colorWhite;

    @FindBy(xpath = "//a[@name='Black']")
    private WebElement colorBlack;

    @FindBy(xpath = "//span[contains(text(), 'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='wishlist_button']")
    private WebElement addToWishlistButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
