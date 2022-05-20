package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultsPage;

public class SearchProductTest extends TestBase{
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    SearchResultsPage searchResultsObject;
    @Test
    public void userCanSearchForProducts(){
        searchObject = new SearchPage(driver);
        searchObject.productSearch(productName);
        detailsObject = new ProductDetailsPage(driver);
        searchResultsObject = new SearchResultsPage(driver);
        searchResultsObject.openProductDetailsPage();
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
        Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
    }

}
