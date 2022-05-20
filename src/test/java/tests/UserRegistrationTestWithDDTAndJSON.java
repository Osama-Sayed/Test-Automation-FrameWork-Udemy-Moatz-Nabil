package tests;

import data.JSONDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJSON extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;


    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessful() throws Exception{
        JSONDataReader jsonDataReader = new JSONDataReader();
        jsonDataReader.JsonReader();
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(jsonDataReader.firstName,jsonDataReader.lastName,jsonDataReader.email,jsonDataReader.password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
        registerObject.userLogout();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(jsonDataReader.email,jsonDataReader.password);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }

}

