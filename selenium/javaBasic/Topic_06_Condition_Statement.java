package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.management.RuntimeMBeanException;
import java.util.List;

public class Topic_06_Condition_Statement {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    public void TC_01_If(){

    }

    public void  TC_02_If_Else(){
    }
    @Parameters("browser")
    @Test
    public void TC_03_If_Else_If_Else(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", projectPath + "/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/browserDriers/chromedriver");
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", projectPath + "/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/browserDriers/geckodriver");
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", projectPath + "/Users/macbook/Documents/Automation Test New/03- Java Hybrid Framework/selenium-webdriver-java-testng1/browserDriers/edgedriver");
            driver = new EdgeDriver();
        } else{ //Safari/ Opera /Coccoc...
            throw new RuntimeException("Please input corect the browser name!");
        }
        System.out.println(browserName);
        System.out.println(driver.toString());

        driver.quit();
    }

    @Test
    public void TC_04_If_Else_If_Else(){
        // Page Object
        // Dynamic Page
        String pageName = "Login";
        if (pageName.equals("Login")){
            // LoginPage loginPage = new LoginPage();
            // return loginPage;
        }else if(pageName.equals("Register")){
            // RegisterPage registerPager = new RegisterPage();
            // return registerPage;
        } else if (pageName.equals("New Customer")){
            // CustomerPage customerPage = new CustomerPage();
            // return customerPage;
        } else {
            // HomePage homePage = new HomePage;
            // return homePage;
        }
    }

    // if - else
/*    int age = 17;
    String access = (age < 18) ? "You can not access" : "Welcome to our system!";
    if (age < 18) {
        access = "You can not access";
    } else {
        access = "Welcome to our system!";
    }
    System.out.println(access);*/
}
