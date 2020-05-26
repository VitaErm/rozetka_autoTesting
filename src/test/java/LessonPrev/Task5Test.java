package test.java.LessonPrev;

import main.java.lesson1.Task5;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task5Test {
    @Parameters({"name"})
    @Test
    public static void correctReverse(@Optional("QWERTY") String name) {
        String actual = Task5.reverse(name);
        assertEquals(actual, "spoooO", "Error!");
    }

    @Test
    public static void correctReverse2(@Optional("QWERTY") String name) {
        String actual = Task5.reverse(name);
        assertEquals(actual, Task5.reverse("QWERTY"), "Error!");
    }
}
