package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

    HomePage homeObject;
    ProductDetailsPage productDetailsObject;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test (priority=1)
    public void userCanChangeCurrency(){
        homeObject = new HomePage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        homeObject.changeCurrency();
    }


    @Test(dependsOnMethods = "userCanChangeCurrency")
    public void userCanSearchWithAutoSuggest()
    {
        try {
            searchObject = new SearchPage(driver);
            detailsObject = new ProductDetailsPage(driver);
            searchObject.productSearchUsingAutoSuggest("MAC");
            Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
            //System.out.println("Currency= "+ detailsObject.productPriceLbl.getText());
            Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("€"));

        }
        catch (Exception e){
            System.out.println("Error occurred " + e.getMessage());
        }
    }
}
