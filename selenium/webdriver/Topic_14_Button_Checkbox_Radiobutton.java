package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.Locale;

public class Topic_14_Button_Checkbox_Radiobutton {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Egov_Button(){
        driver.get("");

        WebElement registerButton = driver.findElement(By.xpath(""));

        // Verify button bị disable khi chưa click vào checkbox
        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.xpath("")).click();
        sleepInSeconds(2);

        // Verify button này đã được enable khi chưa sau click vào checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // Lấy ra mã màu của Button
        String registerBackgroundRGB = registerButton.getCssValue("");
        System.out.println("registerBackgroundRGB" + registerBackgroundRGB);

        // Convert từ kiểu String (mã RGB) qua kiểu Color
        Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);

        // Convert qua Hexa
        String registerBackgroundHexa = registerBackgroundColor.asHex();
        System.out.println("registerBackgroundHexa" + registerBackgroundHexa);

        Assert.assertEquals(registerBackgroundHexa.toLowerCase(), "");
    }
    @Test
    public void TC_02_Fahasha(){
        driver.get("https://www.fahasa.com/customer/account/create");

        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(2);

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='fhs-btn-login']"));

        // Verify login button is Disable
        Assert.assertFalse(loginButton.isEnabled());

        // Verify login button = backgroundColor
        System.out.println(loginButton.getCssValue("background-color"));

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000") ;

        driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("0986960346");
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Camkhang91@");
        sleepInSeconds(2);

        // Verify login button is Enable
        Assert.assertTrue(loginButton.isEnabled());
        System.out.println(loginButton.getCssValue("background-color"));
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127") ;

    }

    @Test
    public void TC_03_(){

    }

    @Test
    public void TC_04_(){

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
