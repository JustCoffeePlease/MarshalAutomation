package smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOne {

    @DataProvider(name = "dataBase")
    public static Object[][] dataBase() {
        return new Object[][] {
                {"SQL", new Integer(1)},
                {"NOSQL", new Integer(2)}
        };
    }

    @Parameters({"db"})
    @Test (dataProvider = "dataBase")
    public void testOne(String element1, int element2) {
        System.out.println("Test one" + " " + element1 + " " + element2);
    }
}
