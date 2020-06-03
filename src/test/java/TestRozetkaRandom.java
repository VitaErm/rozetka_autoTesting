package test.java;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.po.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestRozetkaRandom extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);

    }

    @Epic("Search")
    @Feature("search filter for random label")
    @Test
    public void testRandomLabel() throws InterruptedException {
        String randomLabel = homePage.getRandomLabelName();
        List<WebElement> notebooks = homePage.notebooksLabelCorrect(randomLabel);
        for (WebElement element : notebooks) {
            assertTrue(element.getText().contains(randomLabel), "Expected label's name of all notebooks was" + randomLabel + " ,but wasn'n");
        }
    }
}
