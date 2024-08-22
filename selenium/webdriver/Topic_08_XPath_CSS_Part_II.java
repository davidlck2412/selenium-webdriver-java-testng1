package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_XPath_CSS_Part_II {
    WebDriver driver;

    @BeforeClass
    public void Run_On_Chrome() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://develop.seitrace.com/");
        driver.manage().window().maximize();
        Thread.sleep (5000);
    }

    @Test
    public void TC_01_() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='css-11nrrcx']//a[contains(@href,'about')]")).click();
        Thread.sleep (2000);
        //driver.findElement(By.xpath("//a[@id='menu-list-:r20v:-menuitem-:r211:']")).click();
        //Thread.sleep (2000);

        String succsessMessagText = driver.findElement(By.xpath("//p[@class='chakra-text css-1nrcrxf']")).getText();
        Assert.assertEquals(succsessMessagText, "Seitrace is a Block Explorer and Analytics Platform for Sei Network");

        //div[@class=‘….’]//a[contains(text(),’….’)]
        //div[@class=‘….’]//a[contains(@title,’….’)]
        //div[@class=‘….’]//a[contains(@href,’….’)]

        //span[start-with(text(), ‘….’)]
    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
