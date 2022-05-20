package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="button.remove-btn")
    WebElement removeCheck;

    @FindBy(id="updatecart")
    WebElement updateCartBtn;

    @FindBy(id ="itemquantity11215")
    public WebElement quantityTxt;

    @FindBy(css="span.product-subtotal")
    public WebElement totalLbl;

    @FindBy(id ="checkout")
    WebElement checkOutBtn;

    @FindBy(id="termsofservice")
    WebElement agreeCheckBox;
    public void removeProductFromCart(){
        clickButton(removeCheck);
     //   clickButton(updateCartBtn);
    }

    public void updateProductQuantityInCart(String quantity) throws InterruptedException{
        clearText(quantityTxt);
        setTextElementText(quantityTxt, quantity);
        clickButton(updateCartBtn);
    }

    public void openCheckOutPage(){
        clickButton(agreeCheckBox);
        clickButton(checkOutBtn);

    }
}
