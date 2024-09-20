package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_15_Action_Part2 {
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
    public void TC_01_Click_And_Hold_Block(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
        Assert.assertEquals(allNumber.size(), 20);

        action.clickAndHold(allNumber.get(0)) // Click vào số 1 và giữ chuột
                .moveToElement(allNumber.get(19)) // Di chuyển chuột tới số 4
                .release() // Nhả huột trái ra - Kết thúc sự kiện clickAndHold()
                .perform(); // Thực thi ác câu lệnh trên (nếu k có thì k thực thi)
        sleepInSeconds(2);

        List<WebElement> allNumberSelected =  driver.findElements(By.xpath("//ol[@id='selectable']//li[@class='ui-state-default ui-selectee ui-selected']"));
        Assert.assertEquals(allNumberSelected.size(), 20);
    }
    @Test
    public void TC_02_Click_And_Hold_Random(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
        Assert.assertEquals(allNumber.size(), 20);

        // Nhấm phím Ctrl xống (chưa nhả ra)
        action.keyDown(Keys.COMMAND).perform();

        action.click(allNumber.get(0))
                .click(allNumber.get(3))
                .click(allNumber.get(7))
                .click(allNumber.get(10))
                .click(allNumber.get(13))
                .click(allNumber.get(17))
                .perform();

        // Nhả phím Ctrl
        action.keyUp(Keys.COMMAND).perform();

        List<WebElement> allNumberSelected =  driver.findElements(By.xpath("//ol[@id='selectable']//li[@class='ui-state-default ui-selectee ui-selected']"));
        Assert.assertEquals(allNumberSelected.size(), 6);
    }

    @Test
    public void TC_03_Double_Click(){
        driver.get("https://automationfc.github.io/basic-form/");
        sleepInSeconds(3);

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
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
