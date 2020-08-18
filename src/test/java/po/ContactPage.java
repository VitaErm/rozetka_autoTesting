package test.java.po;


import com.google.errorprone.annotations.FormatMethod;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ContactPage {
    public Logger logger = LogManager.getLogger(ContactPage.class);
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "li.c-i-service-l-i")
    private List<WebElement> contacts;


    public ContactPage(WebDriver driver) {
        logger.debug("ContactPage innitialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Step("ContactPage open")
    public ContactPage open() {
        logger.info("ContactPage open");
        driver.get("https://rozetka.com.ua/ua/contacts/");
        logger.debug("URL:" + driver.getCurrentUrl());
        return this;
    }

    public List<String> contactNumbers() {
        wait.until(ExpectedConditions.visibilityOfAllElements(contacts));
        List<String> numbers = new ArrayList<>();
        for (WebElement element : contacts) {
            String a = element.getText();
            a = String.valueOf(a.charAt(2));
            if (a.equals("0")) numbers.add(a);
        }
        return numbers;

    }

}

