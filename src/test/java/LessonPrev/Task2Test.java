package test.java.LessonPrev;

import main.java.lesson1.Task2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Task2Test {
    Task2 target;

    @Test
    public void correctCountOfNamesRows() {
        String multipliedName = target.nameMultiplier5by10("Vita");
        String[] mNameRows = multipliedName.split("\r\n");
        assertEquals(mNameRows.length, 5);

    }

    @Test
    public void correctCountOfNamesColumns() {
        String multipliedName = target.nameMultiplier5by10("Vita");
        String[] mNameRows = multipliedName.split("\r\n");
        for (String i : mNameRows) {
            String[] mNamesColumn = i.split(" ");
            assertEquals(mNamesColumn.length, 10);


        }
    }

    @Test
    public void shouldReturnNamesInUpperCase() {
        String multipliedName = target.nameMultiplier5by10("Vita");
        String[] mNameRows = multipliedName.split("\r\n");
        for (String i : mNameRows) {
            String[] mNamesColumns = i.split(" ");
            for (String j : mNamesColumns) {
                String actualFirstChar = String.valueOf(j.charAt(0));
                String expectedFirstChar = actualFirstChar.toUpperCase();
                assertEquals(actualFirstChar, expectedFirstChar);
            }
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        target=new Task2();
    }
}
