package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductReviewTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ProductReviewPage productReviewObject;

    //1-User Registration
    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessful(){

        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("Osama","Sayed","testemail19999@gmail.com","12345678");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    //2- Search for product
    @Test(dependsOnMethods = "userCanRegisterSuccessful")
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


    //3-Add review
    @Test(dependsOnMethods = "userCanSearchWithAutoSuggest")
    public void registeredUserCanReviewProduct(){
        //detailsObject = new ProductDetailsPage(driver);
        detailsObject.openAddReviewPage();
        productReviewObject = new ProductReviewPage(driver);
        productReviewObject.addProductReview("new review", "the product is very good");
        Assert.assertTrue(productReviewObject.reviewNotification.getText().contains("Product review is successfully added."));
    }

    //4-Logout
    @Test(dependsOnMethods = "registeredUserCanReviewProduct")
    public void registerObjectCanLogout(){
        registerObject.userLogout();
    }


}
