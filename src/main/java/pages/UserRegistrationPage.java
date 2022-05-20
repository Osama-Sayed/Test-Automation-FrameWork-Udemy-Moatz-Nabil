package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage extends PageBase{

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderRdoBtn;

    @FindBy(id = "FirstName")
    WebElement fnTxtBox;

    @FindBy(id = "LastName")
    WebElement lnTxtBox;

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    @FindBy(css = "a.ico-logout")
    public WebElement logoutLink;
    public void userRegistration(String firstName, String lastName,String email, String password){
        clickButton(genderRdoBtn);
        setTextElementText(fnTxtBox,firstName);
        setTextElementText(lnTxtBox,lastName);
        setTextElementText(emailTxtBox,email);
        setTextElementText(passwordTxtBox,password);
        setTextElementText(confirmPasswordTxtBox,password);
        clickButton(registerBtn);
    }

    public void userLogout(){
     /*   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-logout")));*/
        clickButton(logoutLink);
    }

    public void openMyAccountPage(){
        clickButton(myAccountLink);
    }
}
