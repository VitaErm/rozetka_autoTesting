package test.java.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    public Logger logger = LogManager.getLogger(HomePage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    private String labelName;

    @FindBy(css = "[name='search']")
    private WebElement search;
    @FindBy(css = "span.goods-tile__title")
    private List<WebElement> searchResultItem;
    @FindBy(css = ".m-cat-subl-i .m-cat-subl-i-link")
    private List<WebElement> searchResultItemLink;
    @FindBy(css = "a.goods-tile__heading")
    private List<WebElement> itemsOfLabel;

    public HomePage(WebDriver driver) {
        logger.debug("Home page initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        logger.info("Open");
        driver.get("https://rozetka.com.ua/");
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public List<WebElement> searchList(String searchStr) {
        logger.info("Search on HomePage by " + searchStr + "in searchList");
        logger.error("Search on HomePage by " + searchStr + "in searchList");
        this.searchStr = searchStr;
        wait.until(ExpectedConditions.elementToBeClickable(search));
        search.sendKeys(this.searchStr);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResultItem));
        return this.searchResultItem;
    }

    public List<WebElement> searchBorder(String searchStr) {
        logger.info("Search on HomePage by" + searchStr + "in searchBorder");
        logger.warn("Search on HomePage by" + searchStr + "in searchBorder");
        this.searchStr = searchStr;
        wait.until(ExpectedConditions.elementToBeClickable(search));
        search.sendKeys(this.searchStr);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.titleContains(searchStr));
        return this.searchResultItemLink;
    }

    public List<WebElement> notebooksLabelCorrect(String labelName) throws InterruptedException {
        this.labelName = labelName;
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
        logger.info("In method notebooksLabelCorrect");
        WebElement categoryFilterLabel = driver.findElement(By.id(labelName));
        WebElement clickableCategoryFilter = categoryFilterLabel.findElement(By.xpath(".."));
        wait.until(ExpectedConditions.elementToBeClickable(clickableCategoryFilter));
        clickableCategoryFilter.click();
        logger.error("In method notebooksLabelCorrect after filter");
        //Thread.sleep(2000);
        logger.warn(driver.getTitle());
        wait.until(ExpectedConditions.titleContains(labelName));
        return this.itemsOfLabel;


    }


}


