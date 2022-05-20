package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase{
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test
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
}
