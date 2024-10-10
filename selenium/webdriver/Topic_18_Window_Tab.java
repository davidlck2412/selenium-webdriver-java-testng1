package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Basi_Form(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSeconds(5);

        switchToWindowByTitle("Google");

        switchToWindowByTitle("Selenium WebDriver");

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSeconds(3);

        switchToWindowByTitle("Facebook - log in or sign up");
        sleepInSeconds(4);

        switchToWindowByTitle("Selenium WebDriver");

    }
    @Test
    public void TC_02_KynaEnglish(){
        driver.get("https://skills.kynaenglish.vn/");
        sleepInSeconds(10);
        String parentID = driver.getWindowHandle();

        driver.findElement(By.xpath("//div[@class='hotline']//img[@alt='facebook']")).click();
        sleepInSeconds(5);

        switchToWindowByTitle("Kyna.vn | Ho Chi Minh City | Facebook");

        driver.findElement(By.cssSelector("form#login_popup_cta_form input[name='email']")).sendKeys("0986960346");
        sleepInSeconds(3);

        switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");

        driver.findElement(By.xpath("//div[@class='hotline']//img[@alt='youtube']")).click();
        sleepInSeconds(5);

        switchToWindowByTitle("Kyna.vn - YouTube");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='contentContainer']//div[@id='page-header-container']//h1//span")).getText(), "Kyna.vn");

        closeAllWithoutParent(parentID);
        sleepInSeconds(3);
    }
    @Test
    public void TC_03_Techpanda(){
        driver.get("https://live.techpanda.org/");
        sleepInSeconds(5);

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSeconds(3);

        driver.findElement(By.xpath("//a[@title='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product IPhone has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//a[@title='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.xpath("//button[@title='Compare']")).click();

        switchToWindowByTitle("Products Comparison List - Magento Commerce");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(), "COMPARE PRODUCTS");

        switchToWindowByTitle("Mobile");

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Cam khang");
        sleepInSeconds(3);
    }
    @Test
    public void TC_04_Seleniu_Version_4(){
        driver.get("https://seitrace.com/?chain=pacific-1");
        sleepInSeconds(5);
        System.out.println("Driver SEITRACE =" + driver.toString());

        // New 1 tab mới hoặc 1 window mới
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://x.com/seitrace_");
        sleepInSeconds(2);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://24h.com.vn");
        sleepInSeconds(2);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        switchToWindowByTitle("Seitrace | The comprehensive explorer for the Sei Network");
        sleepInSeconds(5);
    }
    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToWindowByID(String expectedID){
        // Lấy ra hết tất cả các tab
        Set<String> allIDs = driver.getWindowHandles();
        // Dùng vòng lặp duyệt qua từng ID trong Set ở trên
        for (String id: allIDs){
            if(id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedTitle) {
        // Lấy hết tất cả ID của các Window/Tab
        Set<String> allIDs = driver.getWindowHandles();
        // Dòng vòng lặp duyệt qua Set ID ở trên
        for (String id: allIDs){
            // Cho Switch vào từ ID trước
            driver.switchTo().window(id);
            sleepInSeconds(3);
            // Lấy ra cái title của tab/window hiện tại
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }

    public void closeAllWithoutParent(String parentID){
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
