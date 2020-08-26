package test.java;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.po.ContactPage;

import java.util.List;

public class TestPORozetkaCP extends TestBaseSetup {
    ContactPage contactPage;

    @BeforeMethod
    public void initialize() {
        contactPage = new ContactPage(driver);
    }

    @Test
    public void getCorrectContacts() {
        contactPage.open();
        List<String> numbers = contactPage.contactNumbers();
        Assert.assertTrue(numbers.size()>0, "Expected count of numbers on Contact Page was more than 0, but had 0");

        for (String a : numbers) {
            Assert.assertTrue(a.matches("\\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}"), "Expected numbers pattern like (ddd) ddd-dd-dd, but had another pattern");
        }
    }
}
