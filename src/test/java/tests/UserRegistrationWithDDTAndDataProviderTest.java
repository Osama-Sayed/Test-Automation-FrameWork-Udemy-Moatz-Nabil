package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProviderTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    String firstname = LoadProperties.userData.getProperty("firstname");
    String lastname = LoadProperties.userData.getProperty("lastname");
    String emailval = LoadProperties.userData.getProperty("email");
    String passwordval = LoadProperties.userData.getProperty("password");


    @DataProvider(name ="testData")
    public static Object[][] userData(){

        return new Object[][]{{"Osama", "Sayed","osama@gmail.com","123456"},
                {"test","Auto","test@gmail.com","123456"}};
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "testData")
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

