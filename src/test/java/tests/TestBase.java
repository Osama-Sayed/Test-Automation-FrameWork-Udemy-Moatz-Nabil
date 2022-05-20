package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class TestBase {
public static WebDriver driver;

@BeforeSuite
@Parameters({"browser"})
public  void startDriver(@Optional("chrome") String browserName){

    if(browserName.equalsIgnoreCase("chrome")){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    else if (browserName.equalsIgnoreCase("firefox")){
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    else if(browserName.equalsIgnoreCase("ie")){
       System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    driver.navigate().to("https://demo.nopcommerce.com/");
}

@AfterSuite
public void stopDriver(){
    driver.quit();
}

//Taking screenshot when test case fail & add it to screenshot folder
@AfterMethod()
    public void screenshotInFailure(ITestResult result){
    if(result.getStatus() == ITestResult.FAILURE){
        System.out.println("Failed!!");
        System.out.println("Taking Screenshot.....");
        Helper.captureScreenshot(driver,result.getName());
    }
}

}
