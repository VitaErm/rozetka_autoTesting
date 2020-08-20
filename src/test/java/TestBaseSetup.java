package test.java;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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



    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // FirefoxOptions optionsF= new FirefoxOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        context.setAttribute("driver" , driver);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        attachString();
        attachScreen();
        driver.quit();
    }

    @Attachment
    private String attachString() {
        return "Hello, some attach";
    }

    @Attachment(value = "screenshot" , type = "image/png")
    private byte[] attachScreen() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}


