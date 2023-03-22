/*
Chức năng lựa chọn sản phẩm theo giá.Cập nhật số lượng sản phẩm. Chọn kiểu size
Thêm sản phẩm vào giỏ hàng. Chụp lại giỏ hàng .
 */

package test;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
Test Steps:
1. Vào đường link: https://sevenam.vn/
2. Click áo có tên Áo khoác tay cộc lưới trắng cài hoa thời trang nữ Seven AM H103081
   Chọn áo có giá từ 700,000 - 1,000,000đ
   Cập nhật lại size và số lượng
   Thêm áo và giỏ hàng
3. Chụp hình để xác nhận đã thêm sản phẩm vào giỏ hàng
*/
@Test
public class Test04 {
    public static void Test04(){
        WebDriver  driver = new FirefoxDriver();
        //Step 1. Vào đường link https://sevenam.vn/
        driver.get("https://sevenam.vn/");
        try {
            /*2. Thêm áo có tên Áo khoác tay cộc lưới trắng cài hoa thời trang nữ Seven AM H103081
                 Chọn áo có giá từ 700,000 - 1,000,000đ
                 Cập nhật lại size và số lượng
             */
            driver.findElement(By.xpath("//ul[@class='inline-list']/li[3]")).click();
            //Chọn giá Từ 700,000₫ - 1,000,000₫
            driver.findElement(By.xpath("//div[@class='panel sidebar-sort']/ul/li[5]")).click();
            //Chọn hinh anh
            driver.findElement(By.xpath("//img[@id='1045183219']")).click();
            //Chọn size áo
            driver.findElement(By.xpath("//label[@for='swatch-0-l']")).click();
            Thread.sleep(2000);
            //Thêm số lượng
            driver.findElement(By.cssSelector("i[class='fa fa-caret-up']")).click();
            Thread.sleep(2000);
            //Thêm vào giỏ hàng
            driver.findElement(By.cssSelector("#AddToCart")).click();
            Thread.sleep(2000);
            //3 Chụp hình để xác nhận đã thêm sản phẩm vào giỏ hàng
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File image = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(image, new File(".\\image\\Selenium_Test04.png"));
            Thread.sleep(2000);
        }catch (Exception ignored){}
        //driver.close();
        driver.quit();
    }
}
