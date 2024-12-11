package Testng;

import org.testng.annotations.*;

public class Topic_02_Annotations {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Ground");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("After Groups");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }
    @Test
    public void test03(){
        System.out.println("Test 03");
    }

}
