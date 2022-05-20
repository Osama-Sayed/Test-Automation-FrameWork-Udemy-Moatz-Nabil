package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

    HomePage home;
    ContactUsPage contactUsObject;

    String email="test@test.com";
    String fullName="Test User";
    String enquiry="Hello Admin, this is for test";

    @Test
    public void userCanUseContactUs(){
        home = new HomePage(driver);
        contactUsObject = new ContactUsPage(driver);

        home.openContactUsPage();
        contactUsObject.contactUs(fullName,email,enquiry);
        Assert.assertTrue(contactUsObject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));

    }
}
