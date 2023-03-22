package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
/*--------------TESTCASE07-------------------------
Verify that you will be able to save previously placed order as a pdf file
 *
 *   Note: This TestCase7 version is due to the below amended steps.
 *
Test Steps:
1. Go to https://sevenam.vn/
2. Click on Đăng nhập link
3. Login in application using previously created credential
4. Click on id đơn hàng  để xem chi tiết
5. Verify the previously created order is displayed and status is Pending
6. Click on 'Print Order' link
7. *** note: the link was not found.
 Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
*/

@Test
public class Testcase07 {
    public static void testcase07(){


        //1. Init web-driver session
        WebDriver driver = new FirefoxDriver();
        try {
//            Step 1. Go to https://sevenam.vn/
//            set địa chỉ trang web cần mở
            driver.get("https://sevenam.vn/");

//            2. Click on Đăng nhập link
//            xác nhận vị trí link đăng nhập cần nhấn trên trang web
            WebElement clickLogin = driver.findElement(By.cssSelector("a[class='icon_user'] span"));
//            nhấn vào vị trí link đăng nhập đã được chỉ định
            clickLogin.click();
            Thread.sleep(1000); // đợi 1 giây để thao tác

//            3. Login in application using previously created credential
//            xác nhận ví trí nhập địa chỉ Email trên trang web
            WebElement emailAddress = driver.findElement(By.cssSelector("#CustomerEmail"));
//            xác nhận ví trí nhập mật khẩu trên trang web
            WebElement pass = driver.findElement(By.cssSelector("#CustomerPassword"));
//            nhập dữ liệu vào ô email
            emailAddress.sendKeys("duy1234@gmail.com");
//            nhập dữ liệu vào ô mật khẩu
            pass.sendKeys("Duy123");
//            xác nhận ví trí nút nhấn đăng nhập trên trang web
            WebElement btnLogin = driver.findElement(By.cssSelector("input[value='Đăng nhập']"));
//            nhấn vào nút đăng nhập
            btnLogin.click();
            Thread.sleep(2000); // đợi 2 giây để nhập dữ liệu và nhấn đăng nhập

//            4. Click on id đơn hàng  để xem chi tiết
//            xác nhận ví trí view order trên trang web
            WebElement viewOder = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]"));
//            nhấn vào vị trí view order đã tìm được
            viewOder.click();
            Thread.sleep(1000); // chờ 1 giây để chuyển qua trang web xem đơn hàng

//            5. Verify the previously created order is displayed and status is Pending
//            xác nhận ví trí tình trạng thanh toán trên trang web
            WebElement checkStatus = driver.findElement(By.cssSelector("body > div:nth-child(13) > main:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > p:nth-child(2)"));
//            tạo biến kiểu string để nhân giá trị
            String status = checkStatus.getText();
//            verify giá trị tình trạng thanh toán với kết quả mong muốn rồi in ra kiểu boolean
            System.out.println(status.equals("Tình trang thanh toán: pending"));
//            chụp ảnh màn hình toàn bộ lịch sử đặt hàng
//            tạo 1 file chứa ảnh chụp
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            tạo biến chứa đường dẫn đến mục lưu file ảnh đã chụp
            String pathname = ".\\image\\testcase07.png";
//            lưu file ảnh đã chụp vào 1 vị trí đường dẫn mới tạo
            FileUtils.copyFile(src, new File(pathname));
            Thread.sleep(1000);// chờ 1 giây để thao tác

//            6. Print Order
            WebElement clickRight = driver.findElement(By.cssSelector("div[class='grid__item two-thirds medium-down--one-whole'] h2[class='h4']"));
            Actions act = new Actions(driver);
            act.contextClick(clickRight).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

            Thread.sleep(1000);// chờ 1 giây để thao tác
            Thread.sleep(1000);// chờ 1 giây để thao tác

//            7. *** note: the link was not found.
//            Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Quit browser session
        driver.quit();
    }
}
