package test.java.lesson1Tests;

import main.java.lesson1.Task2;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Task2Test {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Hello from Task2Test");
    }

    @Test(dataProvider = "names")
    public void correctName (String s, String expectedName){
        assertEquals(s,expectedName,"Error!");


    }
    @DataProvider (name = "names")
    public Object[][]getData(){
        return new Object[][]{{"Vita","Vita"},{"Irina","Irina"},{"Kate","Kati"},
    };

    }
}
