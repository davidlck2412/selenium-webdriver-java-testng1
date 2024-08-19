package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");

    String osName = System.getProperty("oss.name");

    @BeforeClass
    public void Run_On_Chrome() {
        driver = new ChromeDriver();
        driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen%2Fdemo");
    }


    // TestNG: Order testcase theo Alphabbet(0-9, A-Z)
    // Firname textbox - HTML Code
    //HTML Element: <tagname attribute_name_1='attibute_value' attribute_name_2='attribbute_value' ...>

    @Test
    public void TC_01_ID(){
        // Timf element cos id laf firstName
        driver.findElement(By.id("FirstName")).sendKeys("Keane");
    }
    @Test
    public void TC_02_Class(){
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthday"));
    }

    @Test
    public void TC_04_Tagname(){
        driver.findElement(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText(){
        // Độ chính xác cao = tuyêt đối = Toàn bộ
        driver.findElement(By.linkText("Shiping & returns"));
    }

    @Test
    public void TC_06_Partial_LinK(){
        // Độ chính xác không cao = tương đối = 1 Phần(đầu/ giữa/ cuối)
        driver.findElement(By.partialLinkText("for  vendor"));
        driver.findElement(By.partialLinkText("vendor account"));
        driver.findElement(By.partialLinkText("Apply for  vendor"));
    }

    @Test
    public void TC_07_Css(){
        // Css vs id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("FirstName"));

        // Css vs Class
        driver.findElement(By.cssSelector("div[class='FirstName']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // Css vs Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // Css vs Tagname
        driver.findElement(By.cssSelector("input"));

        // Css vs Link
        driver.findElement(By.cssSelector("a[href='customer/addresses']"));

        // Css vs partial link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        driver.findElement(By.cssSelector("a[href^='addresses']"));
        driver.findElement(By.cssSelector("a[href$='addresses']"));
    }

    public void TC_08_XPath(){
        // XPath vs id
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // XPath vs Class
        driver.findElement(By.xpath("//div[@class='FirstName']"));

        // XPath vs Name
        driver.findElement(By.xpath("input[name='FirstName']"));

        // XPath vs Tagname
        driver.findElement(By.xpath("//input"));

        // XPath vs Link
        driver.findElement(By.xpath("//a[@href='customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='addresses']"));

        // XPath vs partial link
        driver.findElement(By.xpath("//a[contains(href*='addresses'])"));
        driver.findElement(By.xpath("//a[contains(text()='addresses')]"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
