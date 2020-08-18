package test.java.po;

import io.qameta.allure.Step;
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
import test.java.utils.PropertyLoader;
import java.util.ArrayList;
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
    @FindBy(css = "div[data-filter-name='producer'] a.checkbox-filter__link input")
    private List<WebElement> labels;


    public HomePage(WebDriver driver) {
        logger.debug("Home page initialized");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    @Step("home page open")
    public HomePage open() {
        logger.info("Open");
        driver.get(PropertyLoader.loadProperty("url"));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    @Step("search on home page by {searchStr}")
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

    @Step(" search on home page by {searchStr} on sideBorder")
    public List<WebElement> searchBorder(String searchStr) {
        logger.info("Search on HomePage by" + searchStr + "in searchBorder");
        this.searchStr = searchStr;
        logger.debug(search.getAttribute("css"));
        wait.until(ExpectedConditions.elementToBeClickable(search));
        search.sendKeys(this.searchStr);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.titleContains(searchStr));
        return this.searchResultItemLink;
    }

    @Step("get  WebElements of all notebooks by one {labelName} ")
    public List<WebElement> notebooksLabelCorrect(String labelName) throws InterruptedException {
        this.labelName = labelName;
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
        logger.info("In method notebooksLabelCorrect");
        WebElement categoryFilterLabel = driver.findElement(By.id(labelName));
        WebElement clickableCategoryFilter = categoryFilterLabel.findElement(By.xpath(".."));
        wait.until(ExpectedConditions.elementToBeClickable(clickableCategoryFilter));
        clickableCategoryFilter.click();
        logger.warn("In method notebooksLabelCorrect after filter");
        logger.error(driver.getTitle());
        wait.until(ExpectedConditions.titleContains(labelName));
        return this.itemsOfLabel;


    }

    @Step(" get random label's name")
    public String getRandomLabelName() {
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching");
        logger.info("In method getRandomLabelName");
        int max = labels.size();
        int random = (int) (Math.random() * (max + 1));
        logger.info(max);
        List<String> labelNames = new ArrayList<>();
        for (WebElement el : labels) {
            String producer = el.getAttribute("id");
            labelNames.add(producer);
        }
        logger.info("In method getRandomLabelName," +
                "size of items is " + max + ", random is " + random +
                ", randomLabelName is " + labelNames.get(random));
        return labelNames.get(random);

    }

}



