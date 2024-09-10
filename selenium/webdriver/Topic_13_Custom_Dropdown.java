package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void TC_01_JQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropdown("//span[@id='speed-button']", "//ul[@id='speed-menu']//div", "Faster");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']//span[@class='ui-selectmenu-text']")).getText(), "Faster");
        sleepInSeconds(2);
        //driver.navigate().refresh();
        selectItemInDropdown("//span[@id='files-button']", "//ul[@id='files-menu']//div", "ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='files-button']//span[@class='ui-selectmenu-text']")).getText(), "ui.jQuery.js");
        sleepInSeconds(2);

        selectItemInDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "18");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(), "18");
        sleepInSeconds(2);

        selectItemInDropdown("//span[@id='salutation-button']", "//ul[@id='salutation-menu']//div", "Mr.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='salutation-button']//span[@class='ui-selectmenu-text']")).getText(), "Mr.");
        sleepInSeconds(2);
    }

    @Test
    public void TC_02_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropdown("//i[@class='dropdown icon']", "//div[@class='visible menu transition']//span", "Christian");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Christian");
        sleepInSeconds(2);

        selectItemInDropdown("//i[@class='dropdown icon']", "//div[@class='visible menu transition']//span", "Stevie Feliciano");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Stevie Feliciano");
        sleepInSeconds(2);

        selectItemInDropdown("//i[@class='dropdown icon']", "//div[@class='visible menu transition']//span", "Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Justen Kitsune");
        sleepInSeconds(2);
    }

    @Test
    public void TC_03_VueJS() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "First Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "First Option");
        sleepInSeconds(2);

        selectItemInDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Second Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Second Option");
        sleepInSeconds(2);

        selectItemInDropdown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Third Option");
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Third Option");
        sleepInSeconds(2);
    }

    @Test
    public void TC_04_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemInEditDropdown("//input[@class='search']","//div[@class='visible menu transition']//span", "Belgium");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Belgium");
        sleepInSeconds(2);

        selectItemInEditDropdown("//input[@class='search']","//div[@class='visible menu transition']//span", "Australia");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Australia");
        sleepInSeconds(2);

        selectItemInEditDropdown("//input[@class='search']","//div[@class='visible menu transition']//span", "American Samoa");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "American Samoa");
        sleepInSeconds(2);
    }

    @Test
    public void TC_05_DateMonthYear() {
        driver.get("https://demo.nopcommerce.com/register");
        selectItemInDropdown("//select[@name='DateOfBirthDay']","//select[@name='DateOfBirthDay']//option","24");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']//option[@value='24']")).isSelected());
        sleepInSeconds(2);

        selectItemInDropdown("//select[@name='DateOfBirthMonth']","//select[@name='DateOfBirthMonth']//option","December");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']//option[@value='12']")).isSelected());
        sleepInSeconds(2);

        selectItemInDropdown("//select[@name='DateOfBirthYear']","//select[@name='DateOfBirthYear']//option","1991");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']//option[@value='1991']")).isSelected());
        sleepInSeconds(2);
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

    // Những dữ liệu dùng để truyền vào thì xem là tham số
    // khi các dự án khác nhau thì cần sửa lại theo đúng hành vi của app đó
    // Cypress/ Webdriver.IO/
    public void selectItemInDropdown(String parentXpath, String childItemXpath, String itemTextExpected) {
        driver.findElement(By.xpath(parentXpath)).click();
        sleepInSeconds(1);
        // Tìm Element
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(childItemXpath)));
        for (WebElement item : allItems ){
            //System.out.println("Text item = " + textItem);
            if (item.getText().equals(itemTextExpected)){
                item.click();
                break;// Thoát vòng lặp (for/ while/ do-while/ switch-case)
            }
        }
    }

    public void selectItemInEditDropdown(String parentXpath, String childItemXpath, String itemTextExpected) {
        driver.findElement(By.xpath(parentXpath)).clear();
        driver.findElement(By.xpath(parentXpath)).sendKeys(itemTextExpected);
        sleepInSeconds(1);
        // Tìm Element
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(childItemXpath)));
        for (WebElement item : allItems ){
            //System.out.println("Text item = " + textItem);
            if (item.getText().equals(itemTextExpected)){
                item.click();
                break;// Thoát vòng lặp (for/ while/ do-while/ switch-case)
            }
        }
    }
}