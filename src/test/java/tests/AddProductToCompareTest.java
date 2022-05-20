package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase{
    String firstProductName="Apple MacBook Pro 13-inch";
    String secondProductName="Asus N551JK-XO076H Laptop";
    /*
    1-Search for product number 1
    2-Search for product number 2
    3-Add to compare
    4-Clear list
     */

    ProductDetailsPage detailsObject;
    HomePage homeObject;
    ComparePage compareObject;
    SearchPage searchObject;


    @Test(priority = 1)
    public void userCanCompareProducts() throws InterruptedException{
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        compareObject = new ComparePage(driver);


        searchObject.productSearchUsingAutoSuggest("Mac");
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
        detailsObject.addProductToCompare();

        searchObject.productSearchUsingAutoSuggest("Asus");
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
        detailsObject.addProductToCompare();

        Assert.assertTrue(compareObject.firstProduct.isDisplayed());
        Assert.assertTrue(compareObject.secondProduct.isDisplayed());
        compareObject.compareProducts();
    }

    @Test(dependsOnMethods = "userCanCompareProducts")
    public void userCanClearCompareList(){
        compareObject.clearCompareList();
        Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
    }
}
