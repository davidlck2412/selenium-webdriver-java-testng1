package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_30_Wait_09_Fluent {
    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement;

    private long fullTimeoutInSecond = 30;
    private long pollingTimeoutInMilisecond = 300;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();

        fluentDriver = new FluentWait<WebDriver>(driver);
    }

    @Test
    public void TC_01_(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //driver.findElement(By.cssSelector("div#start>button")).click();

        waitAndFindElement(By.cssSelector("div#start>button")).click();

        // Condition
        String hellotext = waitAndFindElement(By.xpath("//div[@id='finish']//h4")).getText();

        Assert.assertEquals(hellotext, "Hello World!");
    }
    @Test
    public void TC_02_(){
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDowntime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        fluentElement =  new FluentWait<WebElement>(countDowntime);

        fluentElement.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchSessionException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                String  text =  webElement.getText();
                System.out.println(text);
                return text.endsWith("00");
            }
        });
    }

    public WebElement waitAndFindElement(By locator) {

        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);

        fluentDriver.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        return fluentDriver.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(locator);
            }
        });
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
