package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;

public class Topic_15_Action_Part3 {
    WebDriver driver;
    Actions action;
    JavascriptExecutor jsExecutor;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void Run_On_FireFox() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void TC_01_Drag_Drop_HTML4(){
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourceCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement tagertCircle = driver.findElement(By.xpath("//div[@id='droptarget']"));

        action.dragAndDrop(sourceCircle, tagertCircle).perform();
        sleepInSeconds(2);
        // Verify Text
        Assert.assertEquals(tagertCircle.getText(), "You did great!");
        //  Verify Color
        Assert.assertEquals(Color.fromString(tagertCircle.getCssValue("background-color")).asHex().toUpperCase(), "#03A9F4");

    }
    @Test
    public void TC_02_Drag_Drop_HTML5_JQuery() throws InterruptedIOException, IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        // Site không support JQuery
        //String jqueryLibraries= getContentFile(projectPath + "/dragDrop/jQueryLib.js");
        String jqueryDragDropContnt = getContentFile(projectPath + "/dragDrop/dragAndDrop.js");

        // Drag A to B
        jsExecutor.executeScript(jqueryDragDropContnt);
        sleepInSeconds(2);
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "A");

        // Drag B to A
        jsExecutor.executeScript(jqueryDragDropContnt);
        sleepInSeconds(2);
        // Verify
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "B");
    }

    @Test
    public void TC_03_Drag_Drop_HTML5_Robot() {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
    }

    @Test
    public void TC_04_Scrol_To_Element() {
        driver.get("http://live.techpanda.org/index.php/about-magento-demo-store/");
        sleepInSeconds(5);

        action.scrollToElement(driver.findElement(By.xpath("//input[@type='email']"))).perform();
        sleepInSeconds(2);
    }

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        org.openqa.selenium.Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        org.openqa.selenium.Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
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
