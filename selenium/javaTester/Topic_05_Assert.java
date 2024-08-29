package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;

    @Test
    public void verifyTestNG(){
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&next=https%3A%2F%2Fwww.facebook.com%2Flogin%2F%3Fnext%3Dhttps%253A%252F%252Fwww.facebook.com%252Flogin%252Fidentify%252F%253Fctx%253Drecover%2526ars%253Dfacebook_login%2526next%253Dhttps%25253A%25252F%25252Fwww.facebook.com%25252F%2526from_login_screen%253D0&from_login_screen=0");
        // Trong java có nhiều thư viện để verify dữ liêệu
        // Testing Framework (Unit/ Intergration/ UI Automation Test)
        // JUnit 4/ TestNG/ JUnit 5/ Hamcrest/ AssertJ/...

        // Kiểu dữ liệu vào là boolean (true/ false)
        // Khi mong muốn điều kiện trả về là đúng thì dùng assertTrue để verify
        Assert.assertTrue(driver.getPageSource().contains("Please enter your email address or mobile number to search for your account."));

        // Mong muốn điều kiện trả về là sai thì dùng assertFalse
        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));

        // Các hàm trả về kiểu dữ liệu là boolean
        // Quy tắc : bắt đầu vs tiền tố là isXXX
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        // Mong đợi 1 điều kiện nó giống thực tế (Tuyệt đối)
        // ACT = EXP
        Assert.assertEquals(driver.getCurrentUrl(), "https://facebook.com");
        Assert.assertEquals(driver.getTitle(), "");



        //Unit Test
        Object name = null;
        Assert.assertNull(name);

        name = "Testing";
        Assert.assertNotNull(name);



    }
}
