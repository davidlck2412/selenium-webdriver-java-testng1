package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_02_Data_Type {
    // Primitive type/ value type: Nguyên thuỷ
    byte bNumber = 6; // 8 bits

    short sNummber = 15000; // 16 bits

    int iNumber = 65000;

    long lNumber = 65000;

    float fNumber = 15.98f;

    double dNumber = 15.98d;

    char cChar = '1'; // 16 bits (2 byte)

    boolean bStatus = false; // 1 bits = 32 số

    // Reference type: Tham chiếu
    // String
    String address = "Ho Chi Minh";
    // Array
    String[] studentAddress = {address, "Ha Noi", "Da Nang"};
    Integer[] studentNumber = {15, 20, 50};
    // Class
    Topic_02_Data_Type topic;
    // Interface
    WebDriver driver;
    // Object
    Object aObject;

    // Collection
    // List/ Set/ Queue/ Map
    List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
    Set<String> allWindows = driver.getWindowHandles();
    List<String> productName = new ArrayList<>();

    public void clickToElement(){
        address.trim();
        studentAddress.clone();
        driver.getCurrentUrl();
        aObject.toString();
        homePageLinks.size();
        allWindows.clear();

        Topic_02_Data_Type topic = new Topic_02_Data_Type();
        topic.address = "Ha Noi";
    }

    public static void main(String[] args){
        // Local variable

    }
}
