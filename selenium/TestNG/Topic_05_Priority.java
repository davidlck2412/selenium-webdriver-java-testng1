package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_05_Priority {
    @BeforeTest(alwaysRun = true)
    public void init(){
        System.out.println("Pre-Condition for bellow testcases");
    }

    @Test
    public void Priority_01_SearchWithDate(){
    }

    @Test
    public void Priority_02_SearchWithBilling(){
    }

    @Test
    public void Priority_03_SearchWithProduct(){
    }

    @AfterTest
    public void after(){
        System.out.println("Post-Condition for above testcase");
    }

}
