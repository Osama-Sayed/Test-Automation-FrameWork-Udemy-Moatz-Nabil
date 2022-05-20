package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.remove-btn")
    WebElement removeFromCartBtn;

    @FindBy(css="a.product-name")
    public WebElement productCell;

    @FindBy(css="h1")
    public WebElement wishListHeader;

    @FindBy(name ="addtocart")
    WebElement updateWishListBtn;

    @FindBy(css = "div.no-data")
    public WebElement emptyCarLbl;


    public void removeProductFromCart(){
        clickButton(removeFromCartBtn);
        clickButton(updateWishListBtn);

    }
}
