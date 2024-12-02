package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {

    WebDriver driver;

    @Test
    public void test01(){
        // Equals = Kiểm tra 2 dữ liệu bằng nhau
        // String/ boolean/ Int/ Float/...
        String fullName = "Automation FC";
        Assert.assertEquals(fullName, "Automation FC",  "Actual fullname is  not the same!");

        // True - False
        // Điều kiện nhận vào là boolean (isDisplayed/ isEndable/ isSelected/ isMultiple/ User-Defined...)

        // Mong đợi cái kết quả trả về  là đúng
        Assert.assertTrue(isElemmentDisplayed(By.cssSelector("")));
        Assert.assertTrue(isElemmentDisplayed(By.cssSelector("")), "Element is not displayed!");

        // Mong đợi cái kết quả trả về là False
        Assert.assertFalse(isElemmentDisplayed(By.cssSelector("")));

    }

    private boolean isElemmentDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
