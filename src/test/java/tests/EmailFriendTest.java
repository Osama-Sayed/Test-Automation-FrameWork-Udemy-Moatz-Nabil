package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    String productName="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    EmailPage emailObject;

    //1- User Registration
    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessful(){

        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("Osama","Sayed","testemail1999@gmail.com","12345678");
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

    //3-Email to friend

    @Test(dependsOnMethods = "userCanSearchWithAutoSuggest")
    public void registerUserCanSendProductToFriend(){
        detailsObject.openSendEmail();
        emailObject = new EmailPage(driver);
        emailObject.sendEmailToFriend("awaaa@gmail.com","Hello my friend, check this product");
        Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
    }
    //4-User LogOut
    @Test(dependsOnMethods = "registerUserCanSendProductToFriend")
    public void registerObjectCanLogout(){
        registerObject.userLogout();
    }
}
