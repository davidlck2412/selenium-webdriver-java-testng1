package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_11_HomeWork {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='pass']")).clear();
        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), "This is a required field.");
    }

    @Test
    public void TC_02_LoginInvalidEmail(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("1234123@123.123");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }
    @Test
    public void TC_03_LoginPassword(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("camkhang.bk.hust@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }
    @Test
    public void TC_04_LoginIncorrectEmailPass(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("camkhang.bk.hust@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
        driver.findElement(By.xpath("//button[@title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']")).getText(), "Invalid login or password.");
    }
    @Test
    public void TC_05_Register(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
