package orders;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Order_01_Search {
    @BeforeTest(alwaysRun = true)
    public void init(){
        System.out.println("Pre-Condition for bellow testcases");
    }

    @Test(groups = "order")
    public void testSearchWithDate(){
    }

    @Test(groups = "order")
    public void testSearchWithBilling(){
    }

    @Test(groups = "order")
    public void testSearchWithProduct(){
    }

    @AfterTest(alwaysRun = true)
    public void after(){
        System.out.println("Post-Condition for above testcase");
    }

}
