package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_29_Wait_08_Mix_inplicit_Explicit {
    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Only_Implicit_Foud(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");

        // Khi vào tìm element thì nó tìm thấy ngay
        // Ko cần chờ hết timeout
        driver.findElement(By.cssSelector("input#email"));
    }
    @Test
    public void TC_02_Only_Implicit_Not_Found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");

        // Khi vào tìm element sẽ k tìm thấy
        // Polling mỗi nửa s tìm lại  lần
        // Hết timeout sẽ đánh fail testcase và Throw exception
        driver.findElement(By.cssSelector("input#automation"));
    }
    @Test
    public void TC_03_Only_Implicit_Found() {
        driver.get("https://www.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
    }

    @Test
    public void TC_04_Only_Implicit_Not_Found_Param_By() {
        driver.get("https://www.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Khi vào tìm element sẽ k tìm thấy
        // Polling mỗi nửa s tìm lại  lần
        // Hết timeout sẽ đánh fail testcase và Throw exception
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
    }

    @Test
    public void TC_05_Only_Implicit_Not_Found_Param_WebElement() {
        driver.get("https://www.facebook.com/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Khi vào tìm element sẽ k tìm thấy
        // Polling mỗi nửa s tìm lại  lần
        // Hết timeout sẽ đánh fail testcase và Throw exception
        System.out.println("Start time: " + getDateTime());
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#automation"))));
        } catch (Exception e) {
            System.out.println("End time: " + getDateTime());
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TC_06_Mix_Implicit_Explicit(){
        driver.get("https://www.facebook.com/");

        // < = > chung  công thức
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Start time: " + getDateTime());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
        } catch (Exception e) {
            System.out.println("End time: " + getDateTime());
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public String getDateTime() {
        Date date = new Date();
        return date.toString();
    }

}
