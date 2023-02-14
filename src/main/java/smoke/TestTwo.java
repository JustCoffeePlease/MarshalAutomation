package smoke;

import org.testng.annotations.Test;

public class TestTwo {

    @Test (groups = {"smokeTest", "regress"})
    public void testTwo() {
        System.out.println("Test two");
    }
}
