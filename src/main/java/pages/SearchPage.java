package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="small-searchterms")
    WebElement searchTextBox;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(id="ui-id-1")
    List<WebElement> productList;

    public void productSearch(String productName){
        setTextElementText(searchTextBox, productName);
        clickButton(searchBtn);
    }

    public void productSearchUsingAutoSuggest(String searchTxt){
        setTextElementText(searchTextBox,searchTxt);
        try{Thread.sleep(3000);}
        catch(Exception e){
            e.getMessage();
        }
        productList.get(0).click();
    }

}
