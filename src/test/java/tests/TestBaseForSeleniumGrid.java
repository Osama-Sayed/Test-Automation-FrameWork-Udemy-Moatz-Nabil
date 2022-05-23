package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseForSeleniumGrid {

public static String BaseURL = "https://demo.nopcommerce.com/";
protected ThreadLocal<RemoteWebDriver>  driver= null;

@BeforeClass
@Parameters(value ={"browser"})
public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
driver = new ThreadLocal<>();
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("browserName", browser);
driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"),caps));
getDriver().navigate().to(BaseURL);
}

public WebDriver getDriver(){
    return driver.get();
}

@AfterClass
public void stopDriver(){
    getDriver().quit();
    driver.remove();
}

    //Taking screenshot when test case fail & add it to screenshot folder
    @AfterMethod()
    public void screenshotInFailure(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed!!");
            System.out.println("Taking Screenshot.....");
            Helper.captureScreenshot(getDriver(),result.getName());
        }
    }





}
