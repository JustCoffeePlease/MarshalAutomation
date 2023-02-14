package smoke;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestOne {

    @Test (retryAnalyzer = Retry.class)
    public void testOne() {
        System.out.println("Test one");
    }
}


