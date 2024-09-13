package webdriver;

import graphql.language.SelectionSet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_15_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Default_Telerick_Checkbox(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        sleepInSeconds(8);

        By duaZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/child::input");
        By rearSideChecbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/child::input");

        // Click vào checkbox
        // Case 1: Nếu app mở ra checkbox đã được mở rồi
        checkToElement(rearSideChecbox);
        // Case 2: Nếu app mở ra checkbox chưa được chọn
        checkToElement(duaZoneCheckbox);
        // Verify checkbox đã được chọn thành công
        Assert.assertTrue(driver.findElement(rearSideChecbox).isSelected());
        Assert.assertTrue(driver.findElement(duaZoneCheckbox).isSelected());
        // Bỏ chọn 2 checkbox
        uncheckToElement(rearSideChecbox);
        uncheckToElement(duaZoneCheckbox);
        // Verify bỏ chọn
        Assert.assertFalse(driver.findElement(rearSideChecbox).isSelected());
        Assert.assertFalse(driver.findElement(duaZoneCheckbox).isSelected());
    }
    @Test
    public void TC_02_Default_Telerick_RadioButton(){
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index#");
        sleepInSeconds(5);

        By towPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/child::input");
        By towDieselRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/child::input");

        // Click chọn 1 trong 2
        checkToElement(towPetrolRadio);
        // Verify
        Assert.assertTrue(driver.findElement(towPetrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(towDieselRadio).isSelected());

        checkToElement(towDieselRadio);
        // Verify
        Assert.assertFalse(driver.findElement(towPetrolRadio).isSelected());
        Assert.assertTrue(driver.findElement(towDieselRadio).isSelected());
    }


    public void checkToElement(By byXpath){
        // Nếu như Element chưa được chọn thhì mới click
        if (!driver.findElement(byXpath).isSelected()){// True -> mmới vào thân hàm if
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    @Test
    public void TC_03_Select_All_Checkbox(){
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckboxs = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type='checkbox']"));
        // 29 checkbox

        // Chọn tất cả các checkbox tỏng màn hình
        for (WebElement checkbox: allCheckboxs){
            if (!checkbox.isSelected()){
                checkbox.click();
               // sleepInSeconds(1);
            }
        }

        // Verify toàn bộ
        for (WebElement checkbox: allCheckboxs){
            Assert.assertTrue(checkbox.isSelected());
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        allCheckboxs = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type='checkbox']"));

        // Chọn 1 checkbox/ Radio nào đó trong tất cả các checkbox/ Radio
        for (WebElement checkbox: allCheckboxs){
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()) {
                checkbox.click();
                sleepInSeconds(1);
            }
        }

        // Verify toàn bộ
        for (WebElement checkbox: allCheckboxs){
            if (checkbox.getAttribute("value").equals("Heart Attack")) {
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }
    }


     @Test
     public void TC_04_Custom_Checkbox() {
        driver.get("https://login.ubuntu.com/");

        // Case 1
         // 1 element mà cần define tới 2 Locator thì sau này => Maintain mất nhiều thời gian hơn
        //driver.findElement(By.xpath("//label[@class='new-user']")).click();
        //Assert.assertTrue(driver.findElement(By.xpath("//input[@id='id_new_user']")).isSelected());

       // driver.findElement(By.xpath("//label[@for='id_accept_tos']")).click();
         //Assert.assertTrue(driver.findElement(By.xpath("//input[@id='id_accept_tos']")).isSelected());

         // Case 2
         // Dùng thẻ input để click => JavasriptExecutor (JS)
         // Dùng thẻ input để verify => isSelected: only applies to input elements
         // Chỉ cần 1 locator
         By registerRadio = By.xpath("//input[@id='id_new_user']");

         ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(registerRadio));
         Assert.assertTrue(driver.findElement(registerRadio).isSelected());

         // interface Webdriver
         // interface JavascriptExecutor
         // Ép kiểu interface qua kiểu interface khác

     }


    @Test
    public void TC_05_Google_Docs() {
        driver.get("https://docs.google.com/forms/u/1/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");

        By canThoradio = By.xpath("//div[@aria-label='Cần Thơ']");
        By quangNamCheckboxes = By.xpath("//div[@aria-label='Quảng Nam']");
        By quangBinhCheckboxes = By.xpath("//div[@aria-label='Quảng Bình']");

        // Verify radio chưa click
        // Cách 1
        Assert.assertEquals(driver.findElement(canThoradio).getAttribute("aria-checked"), "false");
        // Cách 2 - Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());

        driver.findElement(canThoradio).click();
        sleepInSeconds(2);

        // Verify radio đã được click
        // Cách 1
        Assert.assertEquals(driver.findElement(canThoradio).getAttribute("aria-checked"), "true");
        // Cách 2 - Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='true']")).isDisplayed());

        // CheckBoxes
        driver.findElement(quangNamCheckboxes).click();
        driver.findElement(quangBinhCheckboxes).click();
        sleepInSeconds(2);
        // Verify
        Assert.assertEquals(driver.findElement(quangNamCheckboxes).getAttribute("aria-checked"), "true");
        Assert.assertEquals(driver.findElement(quangBinhCheckboxes).getAttribute("aria-checked"), "true");


    }

    public void uncheckToElement(By byXpath){
        // Nếu như Element đã được chọn thì click lần nữa cho bỏ chọn
        if (driver.findElement(byXpath).isSelected()){// True -> mmới vào thân hàm if
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
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
