package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_AlwayRun {

    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Run Before Class");

        Assert.assertTrue(false);
        // Nó bị Fail ở BeforeClass thì các testcase/ after sẽ bị skip
    }
    @Test
    public void TC_01_(){
        System.out.println("Run testcase 01");
    }

    @Test
    public void TC_02_(){
        System.out.println("Run testcase 02");
    }

    @AfterTest
    public void afterClass(){
        driver.quit();
    }
}
