package test.java.LessonPrev;

import main.java.lesson1.Task1;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class Task1Test {
    @Test(dataProvider = "results")
    public static void successFunction(int a, int b, int c, int expectedResult) {
        int actualResult = Task1.min(a, b, c);
        assertEquals(actualResult, expectedResult, "Excpected int to be" + expectedResult + ",but got" + actualResult);
    }

    @Test
    public static void sayHello() {
        System.out.println("Hello from Task1Test!");
    }

    @DataProvider(name = "results")
    public Object[][] getData() {
        return new Object[][]{
                {5, 2, 3, 2}, {4, 3, 7, 3}, {0, 4, 7, 0},


        };
    }
}
