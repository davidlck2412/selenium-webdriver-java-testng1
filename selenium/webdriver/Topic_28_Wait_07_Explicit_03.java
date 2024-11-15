package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_28_Wait_07_Explicit_03 {
    WebDriver driver;
    WebDriverWait explicitWait;

    String hcmName = "HoChiMinh.jpg";
    String dnName = "DaNang.jpg";
    String hpName = "HaiPhong.jpg";

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_AjaxLoading(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        By selectedDateBy = By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']");

        Assert.assertEquals(driver.findElement(selectedDateBy).getText(), "No Selected Dates to display.");

        driver.findElement(By.xpath("//a[text()='12']")).click();

        // Wait cho Loading Icon biến mất trong x dây
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));

        Assert.assertEquals(driver.findElement(selectedDateBy).getText(), "Tuesday, November 12, 2024");
    }
    @Test
    public void TC_02_Upload_File(){
        driver.get("https://gofile.io/welcome");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Wait + Verify Spinner icon bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-border"))));

        // Wait + Click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.bi-cloud-upload"))).click();

        // Wait + Verify Spinner icon bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/uploadFiles/DaNang.jpg");
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/uploadFiles/HaiPhong.jpg");
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/uploadFiles/HoChiMinh.jpg");

        // Wait + Verify Spinner icon bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.spinner-border")))));

        // Wait Progress Bar bien mat
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.progress")))));

        // Wait + Click
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.mainUploadSuccessLink a.ajaxLink"))).click();

        // Verify button Play cos tai tung hinh dc upload
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + dnName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + hpName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[text()='" + hcmName + "']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']"))).isDisplayed());
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
