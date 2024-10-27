package cavies;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_01_Login {
    WebDriver driver;
    String email = "khanglc@cavies.xyz", passWord  = "Camkhang91@", apiKeys = "0b4a3819-a3e9-4948-bd17-96411418f2e7";

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new ChromeDriver();
        driver.get("https://seitrace.com/?chain=pacific-1");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login(){
        driver.findElement(By.xpath("//div[@class='css-9sd79d']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleepInSeconds(10);
    }
    @Test
    public void TC_02_API_Auth(){
        driver.get("https://seitrace.com/?chain=pacific-1");
        sleepInSeconds(4);

        driver.findElement(By.xpath("//button[@id='menu-button-:rp:']")).click();
        sleepInSeconds(1);

        driver.findElement(By.xpath("//span[text()='Insights Docs']")).click();
        sleepInSeconds(5);

        Assert.assertEquals(driver.findElement(By.xpath("//option[text()='https://seitrace.com/insights/']")).getText(), "https://seitrace.com/insights/");

        WebElement element = driver.findElement(By.cssSelector("button.authorize"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("button.authorize")).click();
        sleepInSeconds(1);
        driver.findElement(By.xpath("//input[@id='api_key_value']")).sendKeys("apiKeys");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[text()='Close']")).click();
    }

    @Test
    public void TC_03_API_Run(){
        // Address
        driver.findElement(By.xpath("//div[@id='operations-Addresses-AddressController-getCosmosAddress']//button[@class='opblock-summary-control']")).click();
        sleepInSeconds(1);
        driver.findElement(By.xpath("//button[text()='Try it out ']")).click();
        sleepInSeconds(1);
        driver.findElement(By.xpath("//div[@class='renderedMarkdown']/following-sibling::input[@type='text']")).clear();
        driver.findElement(By.xpath("//div[@class='renderedMarkdown']/following-sibling::input[@type='text']")).sendKeys("sei1tcqak8hf8lj5xp3hf2zru0kmt8lhes0rxxh6tr");
        driver.findElement(By.xpath("//div[@class='execute-wrapper']//button[text()='Execute']")).click();
        sleepInSeconds(2);




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
