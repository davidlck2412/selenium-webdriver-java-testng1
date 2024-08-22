package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void Run_On_Chrome() {
        driver = new ChromeDriver();
        driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen%2Fdemo");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_(){

    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
