package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_23_Wait_Part1_Element_Status {
    WebDriver driver;

    WebDriverWait expliciWait;

    By reconfirmEmailTextbox = By.cssSelector("input[name='reg_email_confirmation__']");

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Visible(){
        driver.findElement(By.xpath("//a[text()='Sign up for Facebook']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("khang@gmail.com");
        sleepInSeconds(3);

        expliciWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));
    }

    @Test
    public void TC_02_Invisible_In_Dom(){
        // Điều kiện 2 - Element ko xuất hiện trên UI và vẫn có trong cây HTML
        driver.findElement(By.xpath("//a[text()='Sign up for Facebook']")).clear();
        sleepInSeconds(2);

        // Tại thời điểm này/ Step này thì Confirm Email textbox đang invisible
        expliciWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));

        // Kiểm tra 1 element không hiển thị
        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_02_Invisible_Not_In_Dom(){
        // Điều kiện 3 - Element xuất hiện trên UI và cũng không có trong cây HTML
        driver.findElement(By.xpath("//a[text()='Sign up for Facebook']")).clear();
        sleepInSeconds(2);

        // Tại thời điểm này/ Step này thì Confirm Email textbox đang invisible
        expliciWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));

        // Kiểm tra 1 element không hiển thị
        Assert.assertTrue(driver.findElement(reconfirmEmailTextbox).isDisplayed());
    }

    @Test
    public void TC_03_Presence(){
        driver.findElement(By.xpath("//a[text()='Sign up for Facebook']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("khang@gmail.com");
        sleepInSeconds(3);

        // Điều kiện 1 - Element có xuất hiện trên UI và vẫn có trong cây HTML
        // Tại thời điểm này/ Step này thì Confirm Email textbox đang presence (có trong HTML)
        expliciWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));

        // Điều kiện 2 - Element ko xuất hiện trên UI và cũng không có trong cây HTML
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSeconds(2);
    }

    @Test
    public void TC_04_Staleness(){

        driver.findElement(By.xpath("//a[text()='Sign up for Facebook']")).click();
        sleepInSeconds(2);

        // Tại thời điểm này element có xuất hiện và mình sẽ findelement
        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextbox);
        // Click vào icon close để đóng popup lại
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).clear();
        sleepInSeconds(2);

        // Điều kiện 3 - Element xuất hiện trên UI và cũng không có trong cây HTML
        expliciWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));
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
