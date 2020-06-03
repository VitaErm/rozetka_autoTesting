package test.java;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.po.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;

@Epic("Search")
@TmsLink("TMS-123")
public class TestPORozetka extends TestBaseSetup {
    HomePage homePage;
    String good;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);

    }

    @Feature("search list")
    @Story("search list of iPhone")
    @Issue("QWe-345")
    @Test
    public void testCorrectSearchList() {
        good = "iPhone";
        homePage.open();
        List<WebElement> goods = homePage.searchList(good);
        for (WebElement element : goods) {
            assertTrue(element.getText().contains(good), "Expected all goods " + good + ",but had not");


        }
    }

    @Feature("search sideBorder")
    @Test
    public void testCorrectSearchBorder() {
        good = "Samsung";
        homePage.open();
        List<WebElement> groupOfElements = homePage.searchBorder(good);
        System.out.println(groupOfElements.size());
        for (WebElement element : groupOfElements) {
            assertTrue(element.getAttribute("href").contains(good.toLowerCase()), "Expected all goods " + good + ", but had not");
        }


    }

    @Feature("search filter for MSI, Apple, Xiaomi")
    @Test(dataProvider = "labelName")
    public void testCorrectLabel(String name) throws InterruptedException {
        homePage.open();
        List<WebElement> notebooks = homePage.notebooksLabelCorrect(name);
        for (WebElement element : notebooks) {
            assertTrue(element.getText().contains(name), "Expected label's name of all notebooks was" + name + " ,but wasn'n");
        }
    }

    @DataProvider(name = "labelName")
    public Object[][] getData() {
        return new Object[][]{{"MSI"}, {"Apple"}, {"Xiaomi"},
        };
    }

}




