package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class registeredUserCheckoutProductTest extends TestBase{

    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartObject;
    CheckOutPage checkOutObject;

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
        shoppingCartObject.openCheckOutPage();
    }

    @Test(dependsOnMethods = "userCanRemoveProductFromCart")
    public void userCanOpenCheckOutPageFromCart() throws InterruptedException {
        checkOutObject = new CheckOutPage(driver);

        checkOutObject.clickOnCheckOutAsGuest();

        checkOutObject.registeredUserCheckoutProduct("Osama","Sayed","osama@gmail.com", "Alabama","United States","Egypty","11511","01022222222","Egypt");

    }

}
