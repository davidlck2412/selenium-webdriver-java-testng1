package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_09_Webelement_Commands_01 {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void TC_01_Element(){
        // Dùng để xoá dữ lieuẹ trong 1 field cho phép nhập
        // Textbox/ Textarea/ Dropdow
        // Thường được sử dụng trước hàm senkeys
        driver.findElement(By.id("")).clear(); //*

        // Dùng để nhập liệu vào các field trên
        driver.findElement(By.id("")).sendKeys(""); //**

        // Dùng để click lên Element
        driver.findElement(By.id("")).click();//**

        // Tìm từ node cha vào node con
        driver.findElement(By.id("")). findElement(By.id("")); // Không nên dùng

        // Trả về 1 elemeent khớp với điều kiện
        WebElement fullNameTextBox = driver.findElement(By.id(""));

        // Trả về nhiều Element khớp với điều kiện
        List<WebElement> textboxes = driver.findElements(By.cssSelector(""));

        // Dùng để verify 1 cái checkbox/ Radio/ Dropdown đã được chọn hay chưa
        driver.findElement(By.id("")).isSelected();
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());//*
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // Dropdown (Default/ custom)
        Select select = new Select(driver.findElement(By.id("")));

        // Dùng để verify 1 element ất kì có hiển thị hay không
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());//**
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());

        // Dùng để very 1 element có được thao tác lên hay không (không phải Read - only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled()); //*
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        // HTML Element
        // input type = "text" id="firstname" name="firstname" value=""
        // title="First Name" maxlength="255" class"input-text required-entry"
        driver.findElement(By.id("")).getAttribute("title"); //*
        driver.findElement(By.id("")).getAttribute("type");
        driver.findElement(By.id("")).getAttribute("id");

        // Tab Accesibility/ Properties trong Element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");
        driver.findElement(By.id("")).getDomProperty("outerHTML");

        // Tab Styles trong Elements
        // Font/ Size/ Color/ Background/...
        driver.findElement(By.id("")).getCssValue("background-color"); //*
        // rgb (46, 138, 184)
        driver.findElement(By.id("")).getCssValue("font-size");
        driver.findElement(By.id("")).getCssValue("text-transform");

        // Vị trí của element so vs độ phân giải màn hình
        Point nameTextLocation = driver.findElement(By.id("")).getLocation();
        nameTextLocation.getX();
        nameTextLocation.getY();

        // Chiều cao + Rộng
        Dimension addressSize = driver.findElement(By.id("")).getSize();

        // Location + size
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();

        // Location
        Point namePoint = nameTextboxRect.getPoint();
        // Size
        Dimension nameSize = nameTextboxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();


        // Shadow Element (JavascriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        // Từ id/ clas/ name/ css/ Xpath có thể truy ra ngược lại tagname HTML
        driver.findElement(By.cssSelector("#firtname")).getTagName(); // input
        driver.findElement(By.id("firtname")).getTagName(); // input
        driver.findElement(By.className("form-instructions")).getTagName(); // p

        // Element A -> đầu ra của nó là tagname của element A
        String formListTag =  driver.findElement(By.xpath("//*[@class='form-list']")).getTagName();

        // Đầu vào của Element B sẽ nhận tagname của element A là tham số
        driver.findElement(By.xpath("//*[@class='form-list']" + formListTag));

        driver.findElement(By.cssSelector("address.copyright")).getText(); //**

        // Chụp 1 cái hình bị lỗi và lưu dưới dạng nào
        // Byte
        // File (Lưu thành 1 hình có kích thước ở trong ổ cứng: .png/ .jpg/ ....)
        // Base 64 (Hình dạng Text)
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64); //*
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BYTES);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);

        // Form (element nào là thẻ form hoặc nằm trong thẻ form)
        // Hình vi giống phím enter
        // Register/ Login/ Search/...
        driver.findElement(By.id("")).submit();

    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
