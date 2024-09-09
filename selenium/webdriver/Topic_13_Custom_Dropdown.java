package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_13_Custom_Dropdown {
    WebDriver driver;

    // Tường minh: trạng thái cụ thể cho element
    // Visible/ Invisible/ Presence/ Number/ Clickable/...
    WebDriverWait explicitWait;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // 1- Click vào thẻ để nó xở hết các item bên trong Dropdown ra
        driver.findElement(By.xpath("//span[@id='number-button']")).click();
        // 2.1 - Nó sẽ xổ ra chứa hết tất cả các item
        // 2.2 - Nó sex xổ ra nhưng chỉ chứa 1 phhần và đang load thêm
        // Chờ cho nó xổ ra hết cả các item trong dropdown

        // Có case item k có visible hết tất cả (Angular/ React/...)
        // Xuất hiện đầy đủ trong HTML
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='number-menu']//div")));

        List<WebElement> allItems = driver.findElements(By.xpath("//ul[@id='number-menu']//div"));
        // allItems đang lưu trữ 19 item bên trong
        // 19 WebElement

        // For Each
        for (WebElement item : allItems ){
            String textItem = item.getText();
            System.out.println("Text item = " + textItem);

            // String
            if (textItem.equals("15")){
                item.click();
                break;// Thoát vòng lặp (for/ while/ do-while/ switch-case)
            }
        }
    }

    @Test
    public void TC_02_() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        driver.findElement(By.xpath("//span[@id='speed-button']")).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='speed-menu']//div")));
        List<WebElement> allSpeed = driver.findElements(By.xpath("//ul[@id='number-menu']//div"));

        for (WebElement speed : allSpeed){
            String textSpeed = speed.getText();
            System.out.println("Text speed = " + textSpeed);

            // String
            if (textSpeed.equals("Fast")){
                speed.click();
                break;// Thoát vòng lặp (for/ while/ do-while/ switch-case)
            }
        }
    }

    @Test
    public void TC_03_() {

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