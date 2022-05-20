package tests;

import data.ExcelReader;
import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationWithDDTAndExcleTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;


    @DataProvider(name ="ExcelData")
    public Object[][] userData() throws Exception {

        ExcelReader ex = new ExcelReader();
        return ex.getData();
    }

    @Test(priority = 1, dataProvider="ExcelData")
    public void userCanRegisterSuccessful(String fName, String lName, String email, String password){

        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
       registerObject.userRegistration(fName,lName,email,password);
      //  registerObject.userRegistration(firstname,lastname,emailval,passwordval);

        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
        registerObject.userLogout();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email,password);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }

}

