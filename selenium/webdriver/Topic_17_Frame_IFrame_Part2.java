package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_17_Frame_IFrame_Part2 {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Shadow_Dom(){
        driver.get("https://automationfc.github.io/shadow-dom/");
        sleepInSeconds(5);

        // Đi theo đúng cấu trúc của HTML / DOM
        // Biến driver đang đại diện cho cái Real DOM (DOM bên ngoài)
        WebElement shadowHostElement = driver.findElement(By.xpath("//div[@id='shadow_host']"));

        // shadowRootcontext = đại diện cho cái Shadow DOM 1 bên trong
        SearchContext shadowRootcontext = shadowHostElement.getShadowRoot();

        String someText = shadowRootcontext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);

        Assert.assertEquals(someText, "some text");

        WebElement checkBox = shadowRootcontext.findElement(By.cssSelector("input[type='checkbox']"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());

        List<WebElement> allInput = shadowRootcontext.findElements(By.cssSelector("input"));
        System.out.println(allInput.size());

        // nestedShadowHostElement đại diện cho cái nested shadow DOM 2 (Nằm trong cái sahdow DOM 1)
        WebElement nestedShadowHostElement = shadowRootcontext.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedshadowRootcontext = nestedShadowHostElement.getShadowRoot();

        String nestedText = nestedshadowRootcontext.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        Assert.assertEquals(nestedText, "nested text");
    }
    @Test
    public void TC_02_Shadow_Shopee(){
        driver.get("https://shopee.vn");
        sleepInSeconds(3);

        WebElement shadowHostElement = driver.findElement(By.cssSelector("shopee-banner-stateful"));
        SearchContext shadowRootContext = shadowHostElement.getShadowRoot();
        // 2 trường hợp có thể xẩy ra là có hiển thị và k hiển thị popup
        // Verify Popup hien thi
        if (shadowRootContext.findElements(By.cssSelector("div.home-popup__content")).size()>0
                && shadowRootContext.findElements(By.cssSelector("div.home-popup__content")).get(0).isDisplayed()){
            // click để close popup
            shadowRootContext.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
            sleepInSeconds(3);
        }
        // Ko hiển thị/ đã bị đóng rồi thì qua step Search dữ lệu
        driver.findElement(By.cssSelector("input.shopee-searchbar-input__input")).sendKeys("Iphone 16 pro max");
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("button.shopee-search__search-button")).click();
        sleepInSeconds(3);
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
