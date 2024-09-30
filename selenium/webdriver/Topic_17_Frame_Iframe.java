package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Frame_Iframe {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Formsite(){
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.xpath("//div[@id='imageTemplateContainer']/img")).click();
        sleepInSeconds(5);

        // Iframe Element
        WebElement formIframe = driver.findElement(By.xpath("//div[@id='formTemplateContainer']/iframe"));
        Assert.assertTrue(formIframe.isDisplayed());

        // Switch vao frame/ Iframe trước khi mình thao táo bên trong -> quan trang B
        driver.switchTo().frame(formIframe);

        new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-2']"))).selectByVisibleText("Senior");
        sleepInSeconds(3);

        // Switch ra lại trang A
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav.header--desktop-floater a.menu-item-login")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//button[@id='login']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='message-error']")).getText(), "Username and password are both required.");
    }
    @Test
    public void TC_02_Skills_English(){
        driver.get("https://skills.kynaenglish.vn/");
        sleepInSeconds(4);

        // Switch to Iframe Fanpage
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='face-content']/iframe")));
        // Verify followers number
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText(), "198K followers");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("cs_chat_iframe");

        driver.findElement(By.cssSelector("div.button_bar")).click();
        driver.findElement(By.cssSelector("input.input_name")).sendKeys("Cam Khang");
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0986960346");

        new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
        sleepInSeconds(3);

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Tu Van Tuyen sinh");
        sleepInSeconds(3);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@id='live-search-bar']")).sendKeys("Java");
        driver.findElement(By.xpath("//button[@class='search-button']")).click();
        sleepInSeconds(2);
    }

    @Test
    public void TC_03_Frame_HDFCBank() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("Cris_Ronaldo");
        sleepInSeconds(2);
        driver.findElement(By.cssSelector("a.login-btn")).click();
        sleepInSeconds(10);

        driver.switchTo().defaultContent();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='keyboard']")).isDisplayed());

        driver.findElement(By.xpath("//input[@id='keyboard']")).sendKeys("123456789");
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
