package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Default_Dropdow {
    WebDriver driver;
    String firstName = "David", lastName = "Luong", emailAddress = getEmailAddress();
    String passWord = "Camkhang91@", companyName = "LCK SJC";
    String day = "19", month = "February", year = "1991";

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fcustomer%2Finfo");
        sleepInSeconds(2);
    }

    @Test
    public void TC_01_Register(){
        //driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);

        // Day Dropdow
        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        // Chọn ngày
        dayDropdown.selectByVisibleText(day);
        // Verify dropdow này là Single (k phải là Multiple)
        Assert.assertFalse(dayDropdown.isMultiple());
        // Verify số lượng item trong Dropdow này là 32 item
        Assert.assertEquals(dayDropdown.getOptions().size(), 32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("February");
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1991");

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(passWord);

        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        sleepInSeconds(100);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
    }
    @Test
    public void TC_02_Login(){
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passWord);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(3);

        // Verify
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        sleepInSeconds(2);

        // emailAddress
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Company']")).getAttribute("value"), companyName);
    }

    @Test
    public void TC_03_CustomDropDown(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).click();
        driver.findElement(By.xpath("//div[@id='ui-id-3']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).getText(), "Medium");
        sleepInSeconds(2);

        driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).click();
        driver.findElement(By.xpath("//div[@id='ui-id-1']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).getText(), "Slower");
        sleepInSeconds(2);

        driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).click();
        driver.findElement(By.xpath("//div[@id='ui-id-5']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).getText(), "Faster");
        sleepInSeconds(2);
    }


    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailAddress(){
        Random rand  = new Random();
        return "camkhang.bk.hust" + rand.nextInt(99999) + "@gmail.com";
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
