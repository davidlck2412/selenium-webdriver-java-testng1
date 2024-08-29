package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Scope {
    // CÁc biến được khai báo ở bên ngoài hàm -> phạm vi là Class
    // Biến Global (toàn cục)
    // có thể dùng cho tất cả các hàm trong 1 class
    WebDriver driver;

    String homePageUrl; // Khai báo

    String fullName = "Automation FC"; // Khai báo  + Khởi tạo(Initial)


    @BeforeClass
    public void Run_On_Firefox() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_(){
        // Các biến được khai báo ở trong 1 cái hàm/ Block code -> phạm vi cục bộ (local)
        // Chỉ dùng cái hàm nó được khai bo/ block code được sinh ra
        // Biến Local chưa khởi tạo à gọi thì nó sẽ báo lỗi ngay (compole code)
        String homePageUrl = "https://facebook.com";

        // Trong 1 hàm nếu như có 2 biến cùng tên (Global/ Local) thì nó sẽ ưu tiên lấy biến Local dùng
        // 1 biến Local nếu được gọi mà chưa khởi tạo thì sẽ bị lỗi.
        driver.get(homePageUrl);

        // Nếu trong 1 hàm có 2 biền cùng tên (Global/Local) mà miình muốn ấy biến Global ra để dùng
        // Từ khoá "this"
        // Biến Global chưa khởi tạo mà gọi ra dùng thì k báo lỗi ở level (compile code)
        // Level Runtime sẽ lỗi
        driver.get(this.homePageUrl);

    }
    @Test
    public void TC_02_(){

    }
    public void TC_03_(){

    }
    public void TC_04_(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
