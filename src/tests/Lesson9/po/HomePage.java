package tests.Lesson9.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    By search = By.cssSelector("[name='search']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }
    public HomePage open() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }
    public List<WebElement> searchList(String searchStr) {
        this.searchStr = searchStr;
        By searchResultItem = By.cssSelector("span.goods-tile__title");

        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultItem));
        return this.driver.findElements(searchResultItem);
    }

    public List<WebElement> searchBorder(String searchStr) {
        this.searchStr = searchStr;
        By searchResultItem = By.cssSelector(".m-cat-subl-i .m-cat-subl-i-link");

        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultItem));
        return this.driver.findElements(searchResultItem);
    }


}
