package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddToShoppingCartTest extends TestBase{

    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void userCanSearchForProductsWithAutoSuggest() throws InterruptedException{
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest("Mac");
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productNamebreadCrumb.getText().contains(productName));
    }

    @Test(dependsOnMethods = "userCanSearchForProductsWithAutoSuggest")
    public void userCanAddProductToShoppingCart() throws InterruptedException{
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.addToCart();
        shoppingCartObject = new ShoppingCartPage(driver);

        Assert.assertTrue(shoppingCartObject.totalLbl.isDisplayed());
    }

    @Test(dependsOnMethods = "userCanAddProductToShoppingCart")
    public void userCanRemoveProductFromCart(){
        shoppingCartObject = new ShoppingCartPage(driver);
        shoppingCartObject.removeProductFromCart();
    }
}
