package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
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
        driver = new FirefoxDriver(); //**

        // Version 3
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Version 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**
        driver.manage().window().maximize();
    }
// Test push
    @Test
    public void TC_01_() throws MalformedURLException {
        // Mở ra trang Url bất kỳ
        driver.get("http://develop.seitrace.com");  //**

        // Nếu như có 1 tab thì giống "quit"
        // Nhiều hơn 1 thì đóng cái nó đang active
        driver.close(); //*
        // Đóng Browser không care bao nhiêu tab
        driver.quit(); //**

        // 2 hàm này sẽ bị ảnh hưởng timeout của implicitWait

        // Nó sẽ đi tìm với loại By nào và trả về element nếu như được tìm thấy
        // K tìm thấy thì Fail tại step này - Throw exception: NóuchElementException
        // Trả về 1 Element - nếu như tìm thấy nhiều hơn 1 thì cũng chỉ lấy 1 (thao tác vs cái đầu tiên)
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));  //**

        // Nó sẽ đi tìm vs loại By nào trả về 1 danh sách element nếu như được tìm thấy (List WebElement)
        // Ko được tìm thấy - k bị fail - trả về 1 list rỗng (0 Element)
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Tại sao lại cần phải lấy dữ liệu ra để làm gì?
        // Dùng để lấy ra cái Url của màn hình hiện tại
        driver.getCurrentUrl(); //*

        // LẤy ra page source TML/ CSS/ JS của trang hiện tại
        // Verify 1 cách tương đối
        driver.getPageSource();
        Assert.assertTrue(driver.getCurrentUrl().contains("Hello EVerry One"));

        // Lấy ra cái title của trang hiện tại
        driver.getTitle();

        // Lấy ra cái id của tab hiêện tại
        driver.getWindowHandle();
        driver.getWindowHandles();

        // Cookies - dùng trong bài Framework
        driver.manage().getCookies();

        // Get ra những log ở Dev Tool
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho việc tìm Element (findElement/ findElemets)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //**

        // Chờ cho 1 page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set trước khi dùng vs thư viện JavascriptExcutor
        // Inject 1 đoạn code JS vào trong Browser/ Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));


        // Chạy full màn hình (như F11)
        driver.manage().window().fullscreen();
        driver.manage().window().maximize(); //**
        driver.manage().window().minimize();

        // Test Responsive
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setSize(new Dimension(2560, 1440));

        driver.manage().window().getSize();

        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();

        // Điều hướng trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        // Thao tác vs history của web page (back/forward)
        driver.navigate().to("https://facebook.com");
        driver.navigate().to(new URL("https://facebook.com/"));

        // Alert/ Window(tab)/ Frame (iFrame)  //*
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("");

        // Lấy ra cái id của tab hiêện tại
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window("homePageWindowID");

        // Switch/ handle frame(iFrame)  //*
        // Index/ ID(name)/ Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("3243242");
        driver.switchTo().frame(driver.findElement(By.id("")));

        // Switch về HTML chứa frame trước đó
        driver.switchTo().defaultContent();

        // Từ Frame trong đi ra ngoài chứa nó
        driver.switchTo().parentFrame();


    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
