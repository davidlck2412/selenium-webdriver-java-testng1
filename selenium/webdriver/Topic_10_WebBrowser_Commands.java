package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_WebBrowser_Commands {
    // Các câu lệnh để thao tác vs Browser
    // driver.
    WebDriver driver;

    // Các câu lệnh thao tác vs Element
    // element.
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        //driver = new ChromeDriver();
        //driver = new SafariDriver();
        //driver = new EdgeDriver();
        driver = new FirefoxDriver();

        // Version 3
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Version 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();
    }
// Test push
    @Test
    public void TC_01_(){
        // Mở ra trang Url bất kỳ
        driver.get("http://develop.seitrace.com");

        // Nếu như có 1 tab thì giống "quit"
        // Nhiều hơn 1 thì đóng cái nó đang active
        driver.close();
        // Đóng Browser không care bao nhiêu tab
        driver.quit();

        // 2 hàm này sẽ bị ảnh hưởng timeout của implicitWait

        // Nó sẽ đi tìm với loại By nào và trả về element nếu như được tìm thấy
        // K tìm thấy thì Fail tại step này - Throw exception: NóuchElementException
        // Trả về 1 Element - nếu như tìm thấy nhiều hơn 1 thì cũng chỉ lấy 1 (thao tác vs cái đầu tiên)
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));

        // Nó sẽ đi tìm vs loại By nào trả về 1 danh sách element nếu như được tìm thấy (List WebElement)
        // Ko được tìm thấy - k bị fail - trả về 1 list rỗng (0 Element)
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        checkboxes.get(1).click();
        driver.findElement(By.cssSelector("button#login")).click();
    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
