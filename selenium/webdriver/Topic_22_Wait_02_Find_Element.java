package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_22_Wait_02_Find_Element {
    WebDriver driver;

    WebDriverWait explicitWait;

    FluentWait fluentWait;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        //Implicit Wait
        // Set implicit = Selenium verssion 4.x trở lên
        // Timeout là 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/login/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_FindElement(){
        // Case 1 - Element dược tìm thấy trong khoảng thời gian dc set
        // Sẽ không cần hcờ hết cái timeout
        // tìm thấy sẽ trả về 1 cái WebElement
        // Qua step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.xpath("//input[@id='email']"));
        System.out.println("End step: " + getDateTimeNow());

        // Case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        // Sẽ không cần hcờ hết cái timeout
        // Lấy cái element đầu tiên dù có n node
        // Qua step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("camkhang@gmail.com");
        System.out.println("Start step: " + getDateTimeNow());

        // Case 3 - Element không được tìm thấy
        //Chờ hết thời gian 10s
        // Trong thời gian 10s cứ mỗi 1/2s thì sẽ tìm lại 1 lần
        // Nếu tìm lại mà thấy thì cũng trả về element rồi qua Step tiếp theo
        // Nếu tìm lại mà k thấy thì đánh Fail testcase
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input[name='reg_email__']"));
        System.out.println("Start step: " + getDateTimeNow());
    }
    @Test
    public void TC_02_FindElements(){
        List<WebElement> elementList;
        // Case 1 - Element dược tìm thấy trong khoảng thời gian dc set
        // Sẽ không cần chờ hết cái timeout
        // Trả về 1 List Element chứa đúng 1 Element
        //System.out.println("Start step: " + getDateTimeNow());
        //elementList = driver.findElements(By.xpath("//input[@id='email']"));
        //System.out.println("List have: " + elementList.size());
        //System.out.println("End step: " + getDateTimeNow());

        // Case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        // Sẽ không cần chờ hết cái timeout
        // Trả về 1 List Element chứa đúng nhiều Element
        //System.out.println("Start step: " + getDateTimeNow());
        //elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        //System.out.println("List have: " + elementList.size());
        //System.out.println("Start step: " + getDateTimeNow());

        // Case 3 - Element không được tìm thấy
        // Chờ hết thời gian 10s
        // Trong thời gian 10s cứ mỗi 1/2s thì sẽ tìm lại 1 lần
        // Nếu tìm lại mà thấy thì cũng trả về List Rỗng (empty) và k đánh fial testcase
        // Qua Step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[name='reg_email__']"));
        System.out.println("List have: " + elementList.size());
        System.out.println("Start step: " + getDateTimeNow());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public String getDateTimeNow(){
        Date date = new Date();
        return  date.toString();
    }
}
