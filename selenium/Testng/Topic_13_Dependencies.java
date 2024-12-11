package Testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class Topic_13_Dependencies {


    @BeforeClass
    public void beforeMethod()  {
    }

    @Test()
    public void TC_01_CreateNewUser(){

    }

    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_02_ViewAndSearchUser(){

    }

    @Test(dependsOnMethods = "TC_01_CreateNewUser")
    public void TC_03_UpdateExistingUser(){
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "TC_03_UpdateExistingUser")
    public void TC_04_MoveExistingUserToOtherRole(){

    }

    @Test(dependsOnMethods = "TC_04_MoveExistingUserToOtherRole")
    public void TC_05_DeleteExistingUser(){

    }


    @AfterClass
    public void afterClass(){
    }

}
