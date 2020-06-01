package test.java;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import test.java.utils.Screenshot;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    WebDriver driver;
    //Screenshot screenshot;

/*

    public WebDriver getDriverByName(String browser) {
        WebDriver driver = null;

        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            try {
                driver = new RemoteWebDriver(new URL("ec2-3-134-107-121.us-east-2.compute.amazonaws.com:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");
            try {
                driver = new RemoteWebDriver(new URL("ec2-3-134-107-121.us-east-2.compute.amazonaws.com:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        if (browser.equals("chromelocal")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(String browser) {
        driver = getDriverByName(browser);
        driver.manage().window().maximize();
        screenshot = new Screenshot(driver);
    }
*/

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
       // FirefoxOptions optionsF= new FirefoxOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        context.setAttribute("driver", driver);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
       // screenshot.getScreenshot(result);
        driver.quit();
    }
}

