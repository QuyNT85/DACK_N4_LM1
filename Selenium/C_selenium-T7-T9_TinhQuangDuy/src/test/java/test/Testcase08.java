package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
/*--------------TESTCASE08-------------------------/
        *  Verify you are able to change or reorder previously added product
        *  Test Data = QTY = 5
        Test Steps:
        1. Go to https://sevenam.vn/
        2. Click on Đăng nhập link
        3. Login in application using previously created credential
        4. Click on 'giỏ hàng' link , change QTY & Update
        5. Verify Grand Total is changed
        6. Complete Billing & Shipping Information
        7. Verify order is generated and note the order number

        Expected outcomes:
        1) Grand Total is Changed
        2) Order number is generated
*/

@Test
public class Testcase08 {
    public static void testcase08(){


        //1. Init web-driver session
        WebDriver driver = new FirefoxDriver();
        try {
//            Step 1. Go to https://sevenam.vn/
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

//            4. Click on 'giỏ hàng' link , change QTY & Update
//            chụp màn hình xác nhận lịch sử order trước khi cập nhật số lượng
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathname = ".\\image\\testcase08.png";
            FileUtils.copyFile(src, new File(pathname));
            Thread.sleep(1000);
//           xác nhận vị tris link giỏ hàng
            WebElement clickGiohang = driver.findElement(By.cssSelector(".open-qv-cart"));
//            nhấn vào link giỏ hàng
            clickGiohang.click();
//            xác nhận vị trí nhấn xem giỏ hàng
            WebElement viewCart = driver.findElement(By.cssSelector("div[class='header-cart header-icon desktop-cart-wrapper'] a[class='view-cart']"));
//            click vào xem giỏ hàng
            viewCart.click();
//            chụp màn hình xác nhận giá trước khi cập nhật số lượng
            File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathname1 = ".\\image\\testcase08-1.png";
            FileUtils.copyFile(src1, new File(pathname1));
            Thread.sleep(1000);
//            xác nhận vị trí và lấy giá trị của tổng tiền
            WebElement priceTT = driver.findElement(By.cssSelector("td[data-label='Tổng giá'] span[class='h3']"));
//            gán giá trị tổng tiền vào 1 biến để so sánh sau khi thay đổi số lượng
            String txPrice = priceTT.getText().toString().trim();
            System.out.println(txPrice);
//            xác nhận vị trí thay đổi số lượng sản phẩm
            WebElement qty = driver.findElement(By.cssSelector("#updates_"));
//            xóa số lượng cũ ở ô dữ liệu
            qty.clear();
//            nhập số lượng cần thay đổi vào (0 < qty <=5)
            qty.sendKeys("2");
//            nhấn thao tác chuột để cập nhật
            WebElement click = driver.findElement(By.cssSelector("td[data-label='Tổng giá'] span[class='h3']"));
            click.click();
            Thread.sleep(2000);

//            5. Verify Grand Total is changed
            WebElement checkPriceTT = driver.findElement(By.cssSelector(".h3.cart__subtotal"));
//            lấy giá trị tổng tiền khi thay đổi số lượng
            String txTT = checkPriceTT.getText().toString().trim();
            System.out.println(txTT);
//            so sánh giá tiền sau khi thay đổi với giá ban đầu nếu có thay đổi là true
            System.out.println(!txTT.equals(txPrice));
//            chụp màn hình xác nhận thay đổi tổng tiền
            File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathname2 = ".\\image\\testcase08-2.png";
            FileUtils.copyFile(src2, new File(pathname2));
//            Xác nhận vị trí nút thanh toán
            WebElement btnThanhToan = driver.findElement(By.cssSelector("button[name='checkout']"));
//            nhấn vào nut thanh toán
            btnThanhToan.click();
            Thread.sleep(1000);

//            6. Complete Billing & Shipping Information
//            xác nhận vị trí địa chỉ đã lưu trữ
            WebElement Address = driver.findElement(By.cssSelector("#stored_addresses"));
//            nhấn vào mục địa chỉ lưu trữ
            Address.click();
//            chọn vị trí thứ 2 để tự động điền vào các ô dữ liệu
            Select gdAddress = new Select(Address);
            gdAddress.selectByIndex(1);
            Thread.sleep(1000);
//            xác nhận vị trí nút thanh toán
            WebElement btnThanhtoan = driver.findElement(By.cssSelector("#form_next_step"));
//            nhấn vào nút thanh toán
            btnThanhtoan.click();
            Thread.sleep(1000);// chờ 1 giây để thao tác

//            chọn Phương thức vận chuyển
//            Xác nhận vị trí vận chuyển Miền bắc
            WebElement vcBac = driver.findElement(By.cssSelector("label[for='shipping_rate_id_1620770'] span[class='radio-label-primary']"));
//            nhấn vào Miền bắc
            vcBac.click();
            Thread.sleep(1000);
//            chọn Phương thức Thanh Toán
//            Xác nhận vị trí lựa chọn thanh toán là COD
            WebElement ttCOD = driver.findElement(By.cssSelector("#shipping_rate_id_1620770"));
//            nhấn vào Thanh toán COD
            ttCOD.click();
//            xác nhận vị trí nút đặt hàng
            WebElement clickOrder = driver.findElement(By.cssSelector("#checkout_complete"));
//            nhấn vào đặt hàng
            clickOrder.click();
            Thread.sleep(1000);// chờ 1 giây để thao tác
            Thread.sleep(5000);// chờ 5 giây để chuyển màn hình

//            sau khi đặt hàng sẽ hiển thị khoảng 3 giây để xem thông tin đơn hàng rồi trở về màn hình Trang chủ
//            7. Verify order is generated and note the order number

//            xác nhận vị trí link tài khoản cần nhấn trên trang web
            WebElement clickAccount = driver.findElement(By.cssSelector("body > header:nth-child(11) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)"));
//            nhấn vào vị trí link đăng nhập đã được chỉ định
            clickAccount.click();
            Thread.sleep(1000); // đợi 1 giây để thao tác

//            xác định vị trí nhấn xem đơn hàng vừa đặt
            WebElement clickOrderId = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]"));
//            nhấn vào orderID để xem chi tiết
            clickOrderId.click();
            Thread.sleep(1000);// chờ 1 giây để thao tác
////            chụp màn hình để xem chi tiết đơn hàng
            File src3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathname3 = ".\\image\\testcase08-3.png";
            FileUtils.copyFile(src3, new File(pathname3));
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Quit browser session
        driver.quit();
    }
}
