package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Topic_21_UploadFile {
    WebDriver driver;
    String projectPath = System.getProperty("os.name");
    String hcmName = "HoChiMinh.jpg";
    String dnName = "DaNang.jpg";
    String hpName = "HaiPhong.jpg";
    String ndName = "NamDinh.jpg";
    String qnName = "Quangninh.jpg";

    String hcmFilePAth = projectPath + "/uploadFiles/" + hcmName;
    String dnFilePAth = projectPath + "/uploadFiles/" + dnName;
    String hpFilePAth = projectPath + "/uploadFiles/" + hpName;
    String ndFilePAth = projectPath + "/uploadFiles/" + ndName;
    String qnFilePAth = projectPath + "/uploadFiles/" + qnName;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single_File(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadBy = By.xpath("//input[@name='files[]']");

        driver.findElement(uploadBy).sendKeys("/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/uploadFiles/DaNang.jpg");
        sleepInSeconds(3);

        driver.findElement(uploadBy).sendKeys("/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/uploadFiles/HaiPhong.jpg");
        sleepInSeconds(3);

        driver.findElement(uploadBy).sendKeys("/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/uploadFiles/HoChiMinh.jpg");
        sleepInSeconds(3);

        List<WebElement> startButton = driver.findElements(By.xpath("//span[text()='Start']"));
        for (WebElement button : startButton) {
            button.click();
            sleepInSeconds(3);
        }
    }
    @Test
    public void TC_02_(){

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
