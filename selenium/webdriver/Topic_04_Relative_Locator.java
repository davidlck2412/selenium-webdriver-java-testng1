package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_04_Relative_Locator {
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");

    String osName = System.getProperty("oss.name");

    @BeforeClass
    public void Run_On_Chrome() {
        driver = new ChromeDriver();
        //driver.get("https://www.nopcommerce.com/en/login?returnUrl=%2Fen");
    }

    @Test
    public void TC_01_Relative() throws InterruptedException {
        //driver.get("https://www.nopcommerce.com/en/login?returnUrl=%2Fen");
        driver.get("https://workspace.seitrace.com/sign-in");
        //Thread.sleep(40000);

        // Login button
        By loginbuttonBy = By.cssSelector("button.login-button");
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        // Remember Me Checkbox
        By rememberMeCheckboxBy = By.id("RememberMe");

        // Forgot Password Link
        WebElement forgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        //Password textbox
        By passwordTextboxBy = By.cssSelector("input#Password");

        // GUI (location/ position)
        WebElement rememberMeTextElement = driver
                .findElement( RelativeLocator.with(By.tagName("label"))
                .above(loginbuttonBy)
                .toRightOf(rememberMeCheckboxBy)
                .toLeftOf(forgotPasswordElement)
                .below(passwordTextboxBy)
                .near(forgotPasswordElement));
        System.out.println(rememberMeTextElement.getText());

       List<WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
       System.out.println(allLinks.size());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
