package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_Popup_02 {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        //driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Random_In_Dom(){
        driver.get("https://dehieu.vn/");

        By newsletterPopup = By.xpath("//div[@class='modal-content css-modal-bt']");

        // Nếu hiển thị thì nhảy vào close nó đi
        // Luôn luôn chạy được vì element luôn có trong HTML/DOM
        if(driver.findElements(newsletterPopup).size() > 0 &&  driver.findElements(newsletterPopup).get(0).isDisplayed()){ // >0 nghĩa là đã được render ra nhưng àm chưa biết hiển thị hay k
            System.out.println("Popup hiển thị");
            int hieghtBrowser = driver.manage().window().getSize().getHeight();
            System.out.println("Browser hieght" + hieghtBrowser);
            if (hieghtBrowser < 1920) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='close']")));
            } else {
                driver.findElement(By.xpath("//button[@class='close']")).click();
            }
            sleepInSeconds(5);
        } else {
            System.out.println("Popup k hiển thị");
        }

        driver.findElement(By.xpath("//input[@name='key']")).sendKeys("lập dự toán");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ellipsis-2']")).getText(), "Khóa học Lập dự toán M&E");
    }
    @Test
    public void TC_02_Random_IN_Dom(){
        driver.get("https://www.kmplayer.com/home");

        By newpopupMKT = By.xpath("//div[@class='pop-container']");
        if(driver.findElements(newpopupMKT).size() > 0 &&  driver.findElements(newpopupMKT).get(0).isDisplayed()){ // >0 nghĩa là đã được render ra nhưng àm chưa biết hiển thị hay k
            System.out.println("Popup hiển thị");
            driver.findElement(By.xpath("//div[@class='close']")).click();
            sleepInSeconds(5);

        } else {
            System.out.println("Popup k hiển thị");
        }
    }

    // Khi chuển màn hình mà hiển thị popup
    public WebElement findElement(By locator){
        if (driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@class='close']")).click();
            sleepInSeconds(3);
        }
        return driver.findElement(locator);
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
