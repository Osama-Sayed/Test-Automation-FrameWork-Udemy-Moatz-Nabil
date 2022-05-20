package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPage extends PageBase{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "strong.current-item")
    public WebElement productNamebreadCrumb;

    @FindBy(css="button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;

    @FindBy(id = "price-value-4")
    public WebElement productPriceLbl;

    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;

    @FindBy(id="add-to-wishlist-button-4")
    WebElement addToWishListBtn;

    @FindBy(linkText = "wishlist")
    WebElement addToWishListNotificationLink;

    @FindBy(css="button.button-2.add-to-compare-list-button")
    WebElement addToCompareBtn;

    @FindBy(linkText = "product comparison")
    WebElement productCompareLink;

    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartLink;
    @FindBy(id ="add-to-cart-button-4")
    WebElement addToCartBtn;

    public void openSendEmail(){
        clickButton(emailFriendBtn);
    }

    public void openAddReviewPage(){
        clickButton(addReviewLink);
    }

    public void addProductToWishList(){
        clickButton(addToWishListBtn);
        clickButton(addToWishListNotificationLink);
    }

    public void addProductToCompare(){
        clickButton(addToCompareBtn);
        clickButton(productCompareLink);
    }

    public void addToCart(){
        clickButton(addToCartBtn);
        clickButton(shoppingCartLink);
    }
}
