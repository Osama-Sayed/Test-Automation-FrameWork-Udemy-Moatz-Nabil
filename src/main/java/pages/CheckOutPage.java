package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="button.button-1.checkout-as-guest-button")
    WebElement checkOutAsGuestBtn;
    @FindBy(id="BillingNewAddress_FirstName")
    WebElement fName;
    @FindBy(id="BillingNewAddress_LastName")
    WebElement lName;
    @FindBy(id="BillingNewAddress_Email")
    WebElement email;
    @FindBy(id="BillingNewAddress_Company")
    WebElement company;
    @FindBy(id="BillingNewAddress_City")
    WebElement cityTxtBox;
    @FindBy(id="BillingNewAddress_Address1")
    WebElement address1;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement zipCode;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id="BillingNewAddress_StateProvinceId")
    WebElement state;
    @FindBy(css = "button.button-1.new-address-next-step-button")
    WebElement continueBtn;
    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement continuePaymentBtn;

    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement continueMoneyBtn;

    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement continueInfoBtn;

    @FindBy(css= "button.button-1.confirm-order-next-step-button")
    public WebElement completeOrderBtn;

    @FindBy(tagName = "h1")
    WebElement thankYouLbl;
    public void registeredUserCheckoutProduct(String firstName, String secondName,String emailVal,String stateValue, String countryName, String address, String postCode, String phone,String city) throws InterruptedException{
        setTextElementText(fName, firstName);
        setTextElementText(lName, secondName);
        setTextElementText(email,emailVal);

        select = new Select(country);
        select.selectByVisibleText(countryName);
        select = new Select(state);
        select.selectByVisibleText(stateValue);
        setTextElementText(cityTxtBox, city);
        setTextElementText(address1, address);
        setTextElementText(zipCode, postCode);
        setTextElementText(phoneNumber, phone);
        clickButton(continueBtn);
        Thread.sleep(1000);
        clickButton(continuePaymentBtn);
        Thread.sleep(1000);
        clickButton(continueMoneyBtn);
        Thread.sleep(1000);
        clickButton(continueInfoBtn);
        Thread.sleep(1000);
        clickButton(completeOrderBtn);
    }

    public void clickOnCheckOutAsGuest(){
        clickButton(checkOutAsGuestBtn);
    }

}
