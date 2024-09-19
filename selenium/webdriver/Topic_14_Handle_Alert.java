package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Network;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v116.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Topic_14_Handle_Alert {
    WebDriver driver;

    By resultText = By.xpath("//p[@id='result']");

    WebDriverWait explicitWait;
    String userName = "admin";
    String passWord = "admin";

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Accept_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        sleepInSeconds(2);

        // Chờ cho Alert Precent
        // Nếu trong thời gian chờ mà xuất hiện thì tự switch vào
        // Nếu hết thời gian chờ chưa xuất hiện thì Fail
        Alert alert =  explicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSeconds(3);

        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        // Khi mình accept/ cancel rồi thì alert s mất luôn
        alert.accept();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");
    }

    @Test
    public void TC_02_Confirm_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        sleepInSeconds(2);

        Alert alert =  explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        // Confirm Alert
        alert.dismiss();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked: Cancel");

    }

    @Test
    public void TC_03_Promt_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        sleepInSeconds(3);

        Alert alert =  explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        // Sendkeys
        String text = "Selenium Webdriver";
        alert.sendKeys(text);
        sleepInSeconds(3);
        // Accept Alert
        alert.accept();
        sleepInSeconds(3);
        // Verify kết quả
        Assert.assertEquals(driver.findElement(resultText).getText(),"You entered: " + text);

    }


    // Thư viện Alert không sử dụng được cho Authentication Alert được
    // Chrome dev tool Protocol (CDP) - Chrome/ Edge (Chromium)
    @Test
    public void TC_04_Authentication_Alert_Pass_To_Url(){

        // Cách 1: Truyền thẳng username và pass và url
        // Trick - By Pass qua rồi
       // driver.get("http://" + userName + ":" + passWord + "@" + "the-internet.herokuapp.com/basic_auth");

        //Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

        // Cách số 2: từ Page A thao tác lên 1 element nó sẽ Page B (Cầnn thao tác vvs Authen Alert trước)
        driver.get("https://the-internet.herokuapp.com/");
        String authenLinnkUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

        driver.get(getAuthenAlertByUrl(authenLinnkUrl, userName, passWord));
        //driver.get(authenLinnkUrl);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
    }

    @Test
    public void TC_05_Authentication_Selenium_4x(){
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        // Start new session
        devTools.createSession();
        // Enable network domain of devtools
    }

    public String getAuthenAlertByUrl(String url, String userName, String passWord){
        String[] authenArray = url.split("//");
        return authenArray[0] + "//" + userName + ":" + passWord + "@" + authenArray[1];
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
