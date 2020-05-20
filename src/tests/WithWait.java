package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class WithWait {
    WebDriver driver;
    WebDriverWait wait;

    String fieldErrorBorderColorRed = "rgb(248, 65, 71)";

    By usersAccount = By.cssSelector(".header-topline__user .header-topline__user-link");
    By registration = By.cssSelector("user-identification auth .auth-modal__register-link");
    By submit = By.cssSelector("user-identification register .auth-modal__submit");

    By userName = By.cssSelector("input[formcontrolname='name']");
    By userEmail = By.cssSelector("input[formcontrolname='username']");
    By userPassword = By.cssSelector("input[formcontrolname='password']");

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--window-size=1300,1080");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFirst() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");

        WebElement searchEl = driver.findElement(usersAccount);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        searchEl.click();

        WebElement searchEl2 = driver.findElement(registration);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl2));
        searchEl2.click();

        WebElement userNameEl = driver.findElement(userName);
        WebElement userEmailEl = driver.findElement(userEmail);
        WebElement userPasswordEl = driver.findElement(userPassword);
        WebElement submitEl = driver.findElement(submit);

        for (WebElement elementToClick : new WebElement[]{userEmailEl, userNameEl, userPasswordEl, submitEl}) {
            wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
            elementToClick.click();
        }

        Thread.sleep(2000);

        for (WebElement validationElement : new WebElement[]{userEmailEl, userNameEl, userPasswordEl}) {
            String borderColor = validationElement.getCssValue("border-color");
            System.out.println(borderColor + " " + validationElement.getAttribute("formcontrolname"));
            assertEquals(borderColor, fieldErrorBorderColorRed,
                    "Expected red field of " + validationElement + ", but had " + borderColor);
        }
    }

    @Test
    public void testSecond() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");

        WebElement searchEl = driver.findElement(usersAccount);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        searchEl.click();

        WebElement searchEl2 = driver.findElement(registration);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl2));
        searchEl2.click();

        WebElement userNameEl = driver.findElement(userName);
        wait.until(ExpectedConditions.elementToBeClickable(userNameEl));
        userNameEl.sendKeys("Петров");
        userNameEl.click();
        WebElement userEmailEl = driver.findElement(userEmail);
        wait.until(ExpectedConditions.elementToBeClickable(userEmailEl));
        userEmailEl.click();
        WebElement userPasswordEl = driver.findElement(userPassword);
        wait.until(ExpectedConditions.elementToBeClickable(userPasswordEl));
        userPasswordEl.click();

        WebElement searchEl3 = driver.findElement(submit);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl3));
        searchEl3.click();

        // Red border doesn't show up immediately
        // synchronized (driver) {
        // driver.wait(2000);
        //}
        Thread.sleep(2000);
        for (WebElement validationElement : new WebElement[]{userEmailEl, userPasswordEl}) {
            String borderColor = validationElement.getCssValue("border-color");
            assertEquals(borderColor, fieldErrorBorderColorRed, "Expected red field of " + validationElement + ", but had " + borderColor);
        }

        for (WebElement validationElement : new WebElement[]{userNameEl}) {
            String borderColor = validationElement.getCssValue("border-color");
            Assert.assertNotEquals(borderColor, fieldErrorBorderColorRed, "Expected not red field of " + validationElement + ", but had " + borderColor);
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}


