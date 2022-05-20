package tests;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registerObject;
    MyAccountPage myAccountObject;
    LoginPage loginObject;
    String oldPassword="12345678";
    String newPassword="123456";
    String firstName ="Osama";
    String lastName ="Sayed";
    String email="testemail19998888@gmail.com";


    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessful(){

        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName,lastName,email,oldPassword);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = "userCanRegisterSuccessful")
    public void registerUserCanChangePassword(){
        myAccountObject = new MyAccountPage(driver);
        registerObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePassword(oldPassword,newPassword);
        Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
    }


}
