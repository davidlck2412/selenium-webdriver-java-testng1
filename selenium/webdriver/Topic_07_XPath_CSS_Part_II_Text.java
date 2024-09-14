package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_XPath_CSS_Part_II_Text {
    WebDriver driver;

    @BeforeClass
    public void Run_On_Chrome() {
        driver = new ChromeDriver();
        driver.get("https://automationfc.github.io/basic-form/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_(){
        //  1 - Truyền cái Text vào để trong locator để check hiển thị (displayed)
        // Nên sử dụng vì nó tuyệt đối
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();

        // Hạn chế vì nó tương đối
        driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).isDisplayed();
        driver.findElement(By.xpath("//p[contains(text(),\"Mail Personal or Business Check, Cashier's Check or money order to\")]")).isDisplayed();


        // 2- Get cái text ra rồi verify sau
        String text = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
        //Mail Personal or Business Check, Cashier's Check or money order to
        Assert.assertTrue(text.contains("Mail Personal or Business Check"));
        Assert.assertTrue(text.contains("Cashier's Check or money order to"));
        Assert.assertTrue(text.contains("Mail Personal or Business Check, Cashier's Check or money order to"));

        String nestedText = driver.findElement(By.xpath("//h5[@id='nested']")).getText();
        System.out.println(nestedText);
        Assert.assertEquals(nestedText,"Hello World! (Ignore Me) @04:45 PM");


        String concatText = driver.findElement(By.xpath("//span[@class='concat']")).getText();
        System.out.println(concatText);
        Assert.assertEquals(concatText,"Hello \"John\", What's happened?");
    }
    @Test
    public void TC_02_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
