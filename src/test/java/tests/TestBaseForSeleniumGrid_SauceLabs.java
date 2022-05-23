package tests;

import com.saucelabs.saucerest.SauceREST;
import data.LoadProperties;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import com.saucelabs.saucerest.DataCenter;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseForSeleniumGrid_SauceLabs {

    //Sauce Lab Configuration
    public static final String userName = LoadProperties.sauceLabsData.getProperty("username");
    public static final String accessKey = LoadProperties.sauceLabsData.getProperty("accessKey");
    public static final String sauceLabsURL =LoadProperties.sauceLabsData.getProperty("seleniumURL");
    private String sessionID;
    private SauceREST sauceClient;
public static String BaseURL = "https://demo.nopcommerce.com/";
protected ThreadLocal<RemoteWebDriver>  driver= null;

@BeforeClass
@Parameters(value ={"browser"})
public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
driver = new ThreadLocal<>();
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("platform","Windows 10");

    caps.setCapability("browserName", browser);
    MutableCapabilities sauceOptions= new MutableCapabilities();
    sauceOptions.setCapability("username",userName);
    sauceOptions.setCapability("accesskey",accessKey);
    caps.setCapability("sauce:options",sauceOptions);

//Selenium Grid Local
//driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"),caps));
    //Run on Sauce Labs
    driver.set(new RemoteWebDriver(new URL(sauceLabsURL),caps));
    sessionID = ((RemoteWebDriver) getDriver()).getSessionId().toString();
    sauceClient = new SauceREST(userName, accessKey,DataCenter.US);
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
