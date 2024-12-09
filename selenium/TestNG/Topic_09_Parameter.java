package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.management.RuntimeMBeanException;
import java.time.Duration;

public class Topic_09_Parameter {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");


    @Parameters({"browser", "version"})
    @BeforeClass
    public void beforeClass(String browserName, String browerVersion) {
        driver = getBrowserDriver(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Parameters("enviroment")
    @Test()
    public void TC_01_Login(@Optional("live") String enviromentName)  {
        //Chức năng login
        driver.get(getEnviromentUrl(enviromentName) + "/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));
    }

    private WebDriver getBrowserDriver(String browserName) {
        WebDriver driver;

        if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        } else if (browserName.equals("opera")) {
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Browser name is not valid.");
        }
        return driver;
    }

    private String getEnviromentUrl(String envirommentName) {
        String urlValue;

        if (envirommentName.equals("dev")) {
            urlValue = "http://dev.techpanda.org";
        } else if (envirommentName.equals("testing")) {
            urlValue = "http://testing.techpanda.org";
        } else if (envirommentName.equals("staging")) {
            urlValue = "http://staging.techpanda.org";
        } else if (envirommentName.equals("live")) {
            urlValue = "http://live.techpanda.org";
        } else {
            throw new RuntimeException("Browser name is not valid.");
        }
        return urlValue;
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
