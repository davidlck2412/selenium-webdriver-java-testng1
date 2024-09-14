package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Register {
    WebDriver driver;

    String username, password;

    @BeforeClass
    public void Run_On_Chrome() {
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01_Register() throws InterruptedException {
        // Truy cập trang Register: https://demo.guru99.com/
        driver.get("https://demo.guru99.com/");
        driver.manage().window().maximize();
        // Nhập email
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("camhanng.bk.hust@gamil.com");
        // Click submit button
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        // Get user/Pass lưu vào cái biến
        username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
        password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
        Thread.sleep(2000);
    }
    @Test
    public void TC_02_Login() throws InterruptedException {
        // Truy cập trang login: https://demo.guru99.com/v4/
        driver.get("https://demo.guru99.com/v4/");
        driver.manage().window().maximize();
        // Nhập Username và pass ở màn hình Register
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        // Clic button Login
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Thread.sleep(2000);

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
