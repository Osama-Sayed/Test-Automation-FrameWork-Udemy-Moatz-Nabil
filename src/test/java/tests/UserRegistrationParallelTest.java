package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationParallelTest extends TestBaseForSeleniumGrid{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessful(){

        homeObject = new HomePage(getDriver());
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(getDriver());
        registerObject.userRegistration("Osama","Sayed","testemail19888999@gmail.com","12345678");
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods = "userCanRegisterSuccessful")
    public void registerObjectCanLogout(){
        registerObject.userLogout();
    }
    @Test (dependsOnMethods = "registerObjectCanLogout")
    public void registerUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(getDriver());
        loginObject.userLogin("testemail19888999@gmail.com","12345678");
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }
}

