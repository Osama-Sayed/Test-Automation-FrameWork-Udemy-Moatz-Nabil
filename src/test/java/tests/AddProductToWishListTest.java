package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
    //fatma was here xD

    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    WishListPage wishListObject;

    @Test(priority = 1)
    public void userCanSearchWithAutoSuggest()
    {
        try {
            searchObject = new SearchPage(driver);
            detailsObject = new ProductDetailsPage(driver);
            searchObject.productSearchUsingAutoSuggest("MAC");
            Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
        }
        catch (Exception e){
            System.out.println("Error occurred " + e.getMessage());
        }
    }

    @Test (dependsOnMethods = "userCanSearchWithAutoSuggest")
    public void userCanAddProductToWishList(){
        detailsObject = new ProductDetailsPage(driver);
        detailsObject.addProductToWishList();
        wishListObject = new WishListPage(driver);
        Assert.assertTrue(wishListObject.wishListHeader.isDisplayed());
        Assert.assertTrue(wishListObject.productCell.getText().contains(productName));
    }

    @Test(dependsOnMethods = "userCanAddProductToWishList")
    public void userCanRemoveProductFromCart(){
        wishListObject = new WishListPage(driver);
        wishListObject.removeProductFromCart();

        Assert.assertTrue(wishListObject.emptyCarLbl.getText().contains("The wishlist is empty!"));
    }




}
