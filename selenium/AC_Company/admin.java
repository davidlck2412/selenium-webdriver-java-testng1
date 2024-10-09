package AC_Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class admin {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Signin_Verify(){
        driver.get("https://cardoctor-htpt-admin-v2-dev.aggregatoricapaci.com/vi/auth/login");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.text-lg")).getText(), "Welcome, please sign in to your dashboard ");

        driver.findElement(By.xpath("")).sendKeys("");
        driver.findElement(By.xpath("")).sendKeys("");


    }
    @Test
    public void TC_02_(){

    }

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
