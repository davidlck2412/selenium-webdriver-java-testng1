package webdriver;

import org.openqa.selenium.Alert;
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
import java.util.regex.Pattern;

public class Topic_26_Wait_05_Explicit_01_Knowledge {
    WebDriver driver;

    WebDriverWait explicitWait; // Khai báo chưa khởi tạo

    @BeforeClass // Precondition - Khởi tạoh dữ liệu/ data test/ page class/ Variable
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();

        // Khởi tạo 1 explicit Wait có tổng thời gian là 10s - polling là 0,5s mặc định
        // 500 miliseconds = 0,5 Second
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void TC_01_Methot(){
        // Dùng để chờ cho 1 Alert present trong HTML/DOM trươớc khi thao tác lên
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        // Chờ cho cái element k còn ở trong DOM
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(""))));

        // Chờ cho element có trong DOM(không quan tâm trong UI)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        // Trả về 1 list element có trong DOM
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("")));

        // Chờ cho 1-n element được hiển thị trên UI
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("")), driver.findElement(By.xpath(""))));
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("")), driver.findElement(By.xpath("")), driver.findElement(By.xpath(""))));

        // Chờ cho 1 Element dc phép click: Link/ button/ Checkbox/ radio/...
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

        // Chờ cho page hiện tại có 1 title như mong đợi
        explicitWait.until(ExpectedConditions.titleIs("Create New Customer Account"));
        driver.getTitle();

        // Kết hợp nhiều điều kiện -  2 điều kiện đều đúng
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath(""))));

        // Kết hợp nhiều điều kiện - 1 trong 2 điều kiện đúng
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath(""))));

        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "Search entrie"));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "store here..."));
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector("input#search"), "placeholder", "Search entrie store here..."));

        // Chờ 1 element có attribute có giá trị mong đợi (tuyệt đối)
        explicitWait.until(ExpectedConditions.attributeToBe(By.className("input#search"), "placeholder", "Search entrie store here..."));

        // Chờ cho 1 element có attribute khác null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("input#search")), "placeholder"));

        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("input#search")), "namespaceURI", "http://www.w3.org/1999/html"));

        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("input#search")), "namespaceURI", "http://www.w3.org/1999/html"));

        // Chờ cho 1 element dc select thành công
        // Checkbox/ Radio/ Dropdown Item ((Default)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Chờ cho 1 element đượhc selected rồi
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));

        // Chờ cho 1 element chưa dc selected
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));

        // Chờ cho 1 frame/ oframe được avaiable và switch qua
        // Name or ID
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));
        // Index
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

        // By or Element
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(""))));

        // Chờ cho 1 element biến mất (Không hiển thị trên UI)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // Chờ cho 1 đoạn code JS cần trả về giá trị
        explicitWait.until(ExpectedConditions.jsReturnsValue("document.documentElement.innerText"));

        // Chờ cho 1 đoạn code JS được thực thi k ném ra ngoaiị lệ nào hết
        // Ko ném ra: True
        // Có ngoại lệ: False
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText"));
        Assert.assertTrue(explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.documentElement.innerText")));

        // Chờ số lượng element bằng 1 con số cố định
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 10));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""), 10));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""), 10));

        // Chờ cho cái Window/ Tab là bao nhiêu
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(3));

        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""), ""));

        Pattern pattern = Pattern.compile("This is root of mobile", Pattern.CASE_INSENSITIVE);
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector("div.category-description"), pattern));

        // Bắt buộc cái text này trong DOM/ HTML
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.category-tiitle>h1"), "This is root of mobile"));

        // URL tuyệt đối
        explicitWait.until(ExpectedConditions.urlToBe("https://seitrace.com/proposals?chain=pacific-1"));
        //URL tương đối
        explicitWait.until(ExpectedConditions.urlContains("seitrace.com/proposals?chain=pacific-1"));
        explicitWait.until(ExpectedConditions.urlMatches("[^abc]"));

        // Chờ cho 1 điều kiện element này có tro
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(""))));

    }
    @Test
    public void TC_02_(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
