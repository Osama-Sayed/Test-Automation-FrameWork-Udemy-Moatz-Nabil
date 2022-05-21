package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName= fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessful(){

        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods = "userCanRegisterSuccessful")
    public void registerObjectCanLogout(){
        registerObject.userLogout();
    }
    @Test (dependsOnMethods = "registerObjectCanLogout")
    public void registerUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email,password);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }
}

