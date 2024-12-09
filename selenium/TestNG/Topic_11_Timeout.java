package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_Timeout {

    WebDriver driver;

        @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(timeOut = 5000)
    public void TC_05_Success(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        // 3- Sẽ dùng tính năng Registẻ trước- email không có định (random)
        // Chạy luôn đúng cho tất cả case
        // Đăng ký  acc trước

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String firstName = "David", lastName = "Luong", emailAddress = getEmailAddress(), passWord = "Camkhang91@";
        String fullName = firstName + " " + lastName;


        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[@title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(), "Hello, " + fullName + "!");

        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // Log out
        driver.findElement(By.cssSelector("a.skip-account")).click();

        driver.findElement(By.xpath("//a[@title='Log Out']")).click();


        // Login
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(passWord);

        driver.findElement(By.xpath("//button[@title='Login']")).click();

        // Verify info
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(), "Hello, " + fullName + "!");

        contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        // Verify Acc
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), emailAddress);

        System.out.println("Email Address/ Password = " + emailAddress + " - " + passWord);

        // Log out
        driver.findElement(By.cssSelector("a.skip-account")).click();

        driver.findElement(By.xpath("//a[@title='Log Out']")).click();

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

    public String getEmailAddress(){
        Random rand  = new Random();
        return "camkhang.bk.hust" + rand.nextInt(99999) + "@gmail.com";
    }
}
