package cavies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_01_Login {
    WebDriver driver;
    String email = "khanglc@cavies.xyz", passWord  = "Camkhang91@";

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login(){
        driver.get("https://develop.seitrace.com/");
        driver.findElement(By.xpath("//div[@class='css-9sd79d']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleepInSeconds(10);
    }
    @Test
    public void TC_02_verifyAccount(){
        driver.findElement(By.xpath("//div[@class='css-1bl7k3q']//div[@class='css-bnpv8w']")).click();
        driver.findElement(By.xpath("//div[@class='css-6hgcyh']//p")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='field-:rha:']")).getAttribute("value"), email);
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
