package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int curentCount = 1;
    private final int MAX = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(curentCount < MAX) {
            curentCount++;
            return true;
        }
        return false;
    }
}


