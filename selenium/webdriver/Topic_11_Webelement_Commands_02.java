package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_11_Webelement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Displayed(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Nếu như mong đợi 1 element hiển thị thì verifyTrue
        // Nếu như mong đợi 1 element ko hiển thị thì verifyFalse
        //isDisplayed() = true | false
        if (driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("Automation Testing");
            System.out.println("Email Textbox is Displayed");
        } else {
            System.out.println("Email Textbox is not Displayed");
        }

        if (driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id='under_18']")).click();
            System.out.println("Under 18 radio is Displayed");
        } else {
            System.out.println("Under 18 radio is not Displayed");
        }

        if (driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed()){
            driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
            System.out.println("Education TextArea is Displayed");
        } else {
            System.out.println("Education TextArea is Displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            System.out.println("Name User5 text is Displayed");
        } else {
            System.out.println("Name User5 text is not Displayed");
        }
    }

    @Test
    public void TC_02_Enable(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.xpath("//input[@id='mail']")).isEnabled()){
            System.out.println("Email Textbox is Enabled");
        } else {
            System.out.println("Email Textbox is Disable");
        }

        if (driver.findElement(By.xpath("//input[@id='check-disbaled']")).isEnabled()){
            System.out.println("Checkbox is Enabled");
        } else {
            System.out.println("Checkbox is Disable");
        }

        if (driver.findElement(By.xpath("//input[@id='disable_password']")).isEnabled()){
            System.out.println("Password Textbox is Enabled");
        } else {
            System.out.println("Password Textbox is Disable");
        }
    }

    @Test
    public void TC_03_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//input[@id='under_18']")).click();
        driver.findElement(By.xpath("//input[@id='java']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='java']")).isSelected());

        driver.findElement(By.xpath("//input[@id='java']")).click();
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='java']")).isSelected());
    }

    @Test
    public void TC_04_MailChimp(){
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("camkhang.bk.hust@gmail.com");

        // Case 1: Chỉ số (Number)
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("12345");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        // Case 2: viết thường (Lower case)
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("khang");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        // Case 3: Chỉ viết Hoa
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("KHANG");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        // Case 4: ký tự đặc biệt
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("@#$%");

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

        // Case 5: Max Lenght
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("12345678");
        sleepInSeconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());

        // Case 6: Nhập đúng
        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("Minhthien@17");
        sleepInSeconds(2);

        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
