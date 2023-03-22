/* Tạo tài khoản trên trang web. Đăng nhập bằng tài khoản vừa tạo.Click vào
 sản phẩm bất kỳ để xem hướng dẫn mua hàng,
Test Steps:
1. Vào đường link https://sevenam.vn/
2.  Click vào đăng ký
3. Click Create an Account link
4. Click vào thanh tìm kiếm , nhập áo
5. Chọn Áo 2 dây Lụa xanh H190009C
6. Xem hướng dẫn mua hàng

*/
package test;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Random;

@Test
public class Test05 {
    public static void Test05() {
        WebDriver  driver = driverFactory.getChromeDriver();
        //Debug only
        try {

            //1 Vào đường link https://sevenam.vn/
            driver.get("https://sevenam.vn/");
            //Step 2.  Click vào đăng ký
            driver.findElement(By.xpath("//a[contains(text(),'/ Đăng ký')]")).click();
            Thread.sleep(2000);
            //3. Click Create an Account link
            //Nhập tên
            WebElement firstanme = driver.findElement(By.cssSelector("#FirstName"));
            firstanme.sendKeys("Tèo");
            //Nhập Họ
            WebElement lastname = driver.findElement(By.cssSelector("#LastName"));
            lastname.sendKeys("Tony");
            //Code tạo email tự động
            int length = 10;
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                sb.append(randomChar);
            }
            String randomString = sb.toString();
            //Nhập email
            WebElement email = driver.findElement(By.xpath("//form[@id='create_customer']//input[@id='Email']"));
            email.clear();
            email.sendKeys(randomString+"@gmail.com");
            //Nhập mật khẩu
            WebElement passworkd = driver.findElement(By.xpath("//input[@id='CreatePassword']"));
            passworkd.sendKeys("123456");
            // Click đăngký
            driver.findElement(By.cssSelector("input[value='Đăng ký']")).click();

            //4 Click vào thanh tìm kiếm, nhập từ áo
            //Click vào thafnh tìm kiếm
            WebElement search = driver.findElement(By.xpath("//div[@class='search-form-wrapper']//input[@id='searchtext']"));
            search.sendKeys("Áo");
            driver.findElement(By.cssSelector("div[class='search-form-wrapper'] img[alt='icon cart']")).click();
            //5 Chọn Áo 2 dây Lụa xanh H190009C
            driver.findElement(By.xpath("//img[@id='1045052819']")).click();
            Thread.sleep(2000);
            //Lấy tên áo
            String name = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText().toString();
            System.out.println("Kết quả: "+name);
            String gia = driver.findElement(By.xpath("//p[@class='line-price']//span[@id='ProductPrice']")).getText().toString();
            System.out.println("Kết quả: "+gia);
            Thread.sleep(2000);
            //6 Xem hướng dẫn mua hàng và hướng dẫn chọn size
            //Click Xem hướng dẫn mua hàng
            driver.findElement(By.cssSelector("#show_popup_huongdanmuahang")).click();
            Thread.sleep(2000);
            //Chụp hướng dẫn mua hàng
            TakesScreenshot screensbuy = (TakesScreenshot) driver;
            File image = screensbuy.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(image, new File(".\\image\\Selenium_Test05_huong_dan_mua_hang.png"));
            Thread.sleep(2000);

        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
