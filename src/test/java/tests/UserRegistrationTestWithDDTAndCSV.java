package tests;

import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestWithDDTAndCSV extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    CSVReader reader;

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessful() throws Exception {

        String CSV_file=System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
        reader = new CSVReader(new FileReader(CSV_file));
        String [] csvCell;
        while ((csvCell = reader.readNext()) != null) {
            String firsname = csvCell[0];
            String lastname = csvCell[1];
            String email = csvCell[2];
            String password = csvCell[3];


            homeObject = new HomePage(driver);
            homeObject.openRegistrationPage();
            registerObject = new UserRegistrationPage(driver);
            registerObject.userRegistration(firsname, lastname, email, password);
            Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
            registerObject.userLogout();
            homeObject.openLoginPage();
            loginObject = new LoginPage(driver);
            loginObject.userLogin(email, password);
            Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
        }
    }
}

