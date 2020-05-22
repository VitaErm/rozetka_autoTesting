package tests.Lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Lesson9.po.HomePage;

import static org.testng.Assert.assertTrue;
import java.util.List;


public class Test_Po_Rozetka extends TestBaseSetup {
    HomePage homePage;
    String good;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);

    }

    @Test
    public void testCorrectSearchList() {
        good = "iPhone";
        homePage.open();
        List<WebElement> goods = homePage.searchList(good);
        for (WebElement element : goods) {
            assertTrue(element.getText().contains(good),"Expected all goods "+ good+",but had not");


        }
    }

    @Test
    public void testCorrectSearchBorder() {
        good = "Samsung";
        homePage.open();
        List<WebElement> groupOfElements = homePage.searchBorder(good);
        System.out.println(groupOfElements.size());
        for (WebElement element : groupOfElements) {
            assertTrue(element.getAttribute("href").contains(good.toLowerCase()),"Expected all goods "+good+", but had not");
        }


    }
}
