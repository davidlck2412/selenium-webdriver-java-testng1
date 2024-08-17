package webdriver;

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
        //driver.findElement(By.);

    }
    @Test
    public void TC_02_Class(){

    }

    @Test
    public void TC_03_Name(){

    }

    @Test
    public void TC_04_Tagname(){

    }

    @Test
    public void TC_05_LinkText(){

    }

    @Test
    public void TC_06_Partial_LinK(){

    }

    @Test
    public void TC_07_XPath(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
