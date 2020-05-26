package test.java.LessonPrev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        WebElement phoneNumberEl= driver.findElement(By.cssSelector("span.link-dashed"));
        String phoneNumber= phoneNumberEl.getText();
        phoneNumber=phoneNumber.replace(" ","").replace("(","").replace(")","").replace("-","");
        System.out.println(phoneNumber);
        driver.quit();

    }
}
