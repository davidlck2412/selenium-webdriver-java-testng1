package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_Popup_01 {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_Popup_In_DOM_01(){
        driver.get("https://ngoaingu24h.vn/");
        sleepInSeconds(3);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        sleepInSeconds(2);

        By loginPopup = By.xpath("//div[@class='auth-form']");
        // Kểm tra popup login đang hiển thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.xpath("//div[@class='auth-form']//input[@autocomplete='username']")).sendKeys("camkhang");
        driver.findElement(By.xpath("//div[@class='auth-form']//input[@autocomplete='new-password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//div[@class='auth-form']//button[text()='Đăng nhập']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        sleepInSeconds(4);

        driver.findElement(By.xpath("//h2[@id='mui-2']//button")).click();
        sleepInSeconds(1);
        //Assert.assertFalse(driver.findElement(loginPopup).isEnabled());
    }
    @Test
    public void TC_02_Fixed_Popup_In_Dom(){
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        By loginPopup1 = By.xpath("//div[@class='right']");

        Assert.assertTrue(driver.findElement(loginPopup1).isDisplayed());

        driver.findElement(By.xpath("//div[@class='right']//input[@id='user-login']")).sendKeys("camkhang.bk.hust@gmail.com");
        driver.findElement(By.xpath("//div[@class='right']//input[@id='user-password']")).sendKeys("123456789");
        sleepInSeconds(2);

        driver.findElement(By.xpath("//div[@class='right']//button[@id='btn-submit-login']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='right']//div[@id='password-form-login-message']")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

        //Assert.assertFalse(driver.findElement(loginPopup1).isDisplayed());
    }

    @Test
    public void TC_03_Fixed_Popup_Not_In_Dom_01(){
        driver.get("https://tiki.vn/");
        sleepInSeconds(5);

        driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
        sleepInSeconds(2);

        By popupLoginTiki = By.cssSelector("div.ReactModal__Content");
        // Verify Popup hiển thị
        Assert.assertTrue(driver.findElement(popupLoginTiki).isDisplayed());

        driver.findElement(By.xpath("//p[text()='Đăng nhập bằng email']")).click();
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Email không được để trống']")).getText(), "Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Mật khẩu không được để trống']")).getText(), "Mật khẩu không được để trống");
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(), 0);
    }

    @Test
    public void TC_04_Fixed_Popup_Not_In_Dom_02(){
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@class='_97w5']")).click();
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='_52lo']")).isDisplayed());

        driver.findElement(By.xpath("//div[@class='_9bq4']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElements(By.xpath("//div[@class='_52lo']")).size(), 0);
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
