package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Action_Part1 {
    WebDriver driver;

    Actions action;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        action = new Actions(driver);
    }

    @Test
    public void TC_01_Hover(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageTextBox = driver.findElement(By.xpath("//input[@id='age']"));

        action.moveToElement(ageTextBox).perform();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");

    }

    @Test
    public void TC_02_Hover_Fahasha(){
        driver.get("https://www.fahasa.com/");

        action.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
        sleepInSeconds(2);
        action.moveToElement(driver.findElement(By.xpath("//span[@class='menu-title' and text()='FOREIGN BOOKS']"))).perform();
        sleepInSeconds(2);

        // Web element click();
        //driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']")).click();
        // Action click();
        action.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//div[@class='widget-inner']//ul[@class='nav-links']//li//a[text()='Contemporary Fiction']"))).perform();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='category3954']")).getText(), "CONTEMPORARY FICTION");
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
