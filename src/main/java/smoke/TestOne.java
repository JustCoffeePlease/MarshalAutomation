package smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*Задача: организовать выполнение тестов таким образом,
    чтобы второй тест запускался только
    при условии выполнения первого теста*/

public class TestOne {

    @Test
    public void testOne() {
        System.out.println("Test one");
    }

    @Test (
            dependsOnMethods = {"testOne"},
            alwaysRun = true)
    public void testTwo() {
        System.out.println("Test one");
    }
}
/*Аннотация alwaysRun означает,
 что если первый тест упал, второй все равно выполняется*/
