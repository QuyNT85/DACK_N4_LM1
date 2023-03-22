package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
/*--------------TESTCASE09-------------------------
  Verify Discount Coupon works correctly

Test Case Description:
1. Go to https://sevenam.vn/
2. tìm kiếm sản phẩm quần
2. chọn sản phẩm đầu tiên and add sản phẩm to cart
3. Enter Coupon Code
4. Verify the discount generated
*/

@Test
public class Testcase09 {
    public static void testcase09(){


        //1. Init web-driver session
        WebDriver driver = new FirefoxDriver();
        try {
//            Step 1. Go to https://sevenam.vn/
            driver.get("https://sevenam.vn/");

//            2. tìm kiếm sản phẩm quần
//            xác định vị trí khung tìm kiếm
            WebElement txSearch = driver.findElement(By.cssSelector("body > header:nth-child(11) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"));
//            nhập quần vào ô tìm kiếm
            txSearch.sendKeys("quần");
            WebElement clickSearch = driver.findElement(By.cssSelector("div[class='search-form-wrapper'] img[alt='icon cart']"));
//            nhấn vào tìm kiếm
            clickSearch.click();
            Thread.sleep(1000); // chờ 1 giây để thao tác

//            xác định vị trí thêm sản phẩm vào giỏ hàng
            WebElement addCart = driver.findElement(By.cssSelector("body > div:nth-child(13) > main:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > button:nth-child(3) > span:nth-child(1) > img:nth-child(1)"));
//            nhấn để thêm sản phẩm vào giỏ hàng
            addCart.click();
            Thread.sleep(1000);// chờ 1 giây để thao tác
//            nhấn vào tiến hành thanh toán để nhập mã giảm giá
//            xác định vị trí nhấn thanh toán
            WebElement btnThanhtoan = driver.findElement(By.cssSelector(".btnProceedCheckout"));
//            nhấn vào nút thanh toán
            btnThanhtoan.click();
            Thread.sleep(1000);// chờ 1 giây để thao tác

//            3. Enter Coupon Code
//            xác định vị trí nhập code
            WebElement inputCoupon = driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
//            nhập mã code vào
            inputCoupon.sendKeys("MAGIAMGIA");
//            xác định v trí nhấn nút sử dụng
            WebElement apply = driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > form:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)"));
//            nhấn vào nút sử dụng
            apply.click();
            Thread.sleep(2000);// chờ 1 giây để update

//            4. Verify the discount generated
//            xác định vị trí hiển thị mức giá giảm
//            WebElement discount = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(2) span:nth-child(1)"));
//            tạo biến chứa giá trị giảm khi đã giảm
//            String discountPrice = discount.getText();
//            so sánh giá trị giảm giá với mục tiêu đề ra
//            System.out.println(discountPrice.equals("-$25.00"));
//            chụp màn hình để xác nhận mã giảm giá thành công
            File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathname1 = ".\\image\\testcase09.png";
            FileUtils.copyFile(src1, new File(pathname1));
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Quit browser session
        driver.quit();
    }
}
