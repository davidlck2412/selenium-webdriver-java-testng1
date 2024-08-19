package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    // Kiểu dữ liệu trongn Java - 2 nhóm

    // I - Kiểu dữ liệu nguyên thuỷ (Primitive Type)
    // Số nguyên: Buyte - Short - int - Long
    // Không có phần thập phân: nhân viên 1 cty/ học csih 1 lớp/ trường/...
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 12345678;
    long lNumgber = 1234567891;

    //Số thực: float - double
    // Có phần thập phân: Diểm số/ luương/...
    float fNumber = 9.99f;
    double dNumber = 9.99d;


    // Ký tự: Char
    // Đại diện cho 1 ký tự
    char c = 'm';
    char d ='i';

    // Logic: boolean
    // Kết quả bài test: Pass/Fail (ko ngoại lệ)
    boolean status = true;
    boolean status1 = false;

    //II - Kiểu dữ liệu tham chiếu (Reference Type)
    // Class
    FirefoxDriver firefoxDriver =new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));

    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // object
    Object name = "Automation FC";

    // Array (Kiểu nguyên thuỷ/ Tham chiếu)
    int[] studentAge = {15, 20, 8};
    String [] studentName = {"Automation", "Testing"};

    // Collection: Lisst/ Set/ Queue
    List<String> studentAddress = new ArrayList<>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentPhone = new Vector<>();


    // String - Chuỗi ký tự

    String fullName = "Hồ Chí Minh";


    // Khia báo  bến đẻ lư trữ 1 loại dữ liệu nào đó
    // Access Modifier: Phạm vi truy cập (public/ private/ protected/ default)
    //Kiểu dữ liệu
    // Tên biến
    // Giá trị của biến - gán vào với phép =
    // Nếu như k gán: dữ liệu mặc đinh
    public int studentNumber = 200;
}
