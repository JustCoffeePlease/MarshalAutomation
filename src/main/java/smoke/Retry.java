package smoke;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/*Класс, который повторно реализует тест, если тот упал*/


public class Retry implements IRetryAnalyzer {

        private int actualRetry = 0; // Количество повторений
        private  static final int MAX_RETRY = 3; // Максимальное количество повторений


        public boolean retry(ITestResult result) {
            if (actualRetry < MAX_RETRY) {
                actualRetry++;
                return true;
            } else {
                return false;
            }
        };
}
