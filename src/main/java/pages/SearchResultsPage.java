package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageBase{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    //@FindBy (css = "h2.product-title")
    @FindBy(xpath = "//a[text()[contains(.,'Apple MacBook Pro 13-inch')]]")
    WebElement productTitle;

    public void openProductDetailsPage(){
        clickButton(productTitle);
    }
}
