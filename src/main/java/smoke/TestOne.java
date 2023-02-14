package smoke;

import org.testng.annotations.Test;

public class TestOne {

    @Test (groups = {"smokeTest", "regress"})
    public void testOne() {
        System.out.println("Test one");
    }

    @Test (groups = {"regress"})
    public void testOneOne() {
        System.out.println("Test one one");
    }

    @Test (groups = {"regress"})
    public void testOneOneOne() {
        System.out.println("Test one one one");
    }


}
