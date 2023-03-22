/* Đăng nhập bằng tài khoản đã tạo trước đó, chọn Áo lửng cổ ve, tay cộc can cúp sườn H331089C
sau đó tiến hành đặt hàng
Test Steps:
1. Go to https://sevenam.vn/
2.  Click vào đăng nhập
3 Đăng nhập bằng thông tin đã tạo trước đó
4. Click áo
5. Chọn Áo lửng cổ ve, tay cộc can cúp sườn H331089C
6 Chọn size áo
7 Chọn mua ngay
8 Nhập thông tin thanh toán. Em đã tạo thông tin từ trước nên ở đây em sẽ lấy lại thông tin đó
9 Click chọn phương thức thanh toán
10 Chọn Thanh toán. Bước này em xin skip vì nó sẽ tốn tiền
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


public class Test06 {
    @Test
    public static void Test06() {
        WebDriver  driver = driverFactory.getChromeDriver();
        //Debug only
        try {
            // Vào đường link https://sevenam.vn/
            driver.get("https://sevenam.vn/");

            //Step 2.  Click vào đăng nhập
            driver.findElement(By.cssSelector("a[class='icon_user'] span")).click();
            //3 Đăng nhập bằng thông tin đã tạo trước đó
            WebElement email = driver.findElement(By.cssSelector("#CustomerEmail"));
            email.clear();
            email.sendKeys("honganh@gmail.com");
            driver.findElement(By.cssSelector("#CustomerPassword")).sendKeys("honganh123");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[value='Đăng nhập']")).click();
            Thread.sleep(2000);
            //4. Click chọn áo
            driver.findElement(By.xpath("//ul[@class='inline-list']/li[3]")).click();
            Thread.sleep(2000);
            //5 Chọn Áo lửng cổ ve, tay cộc can cúp sườn H331089C
            driver.findElement(By.xpath("//img[@id='1045075146']")).click();
            Thread.sleep(2000);
            //6 Chọn size áo
            driver.findElement(By.cssSelector("label[for='swatch-0-l']")).click();
            Thread.sleep(2000);
            //7 Chọn mua ngay
            driver.findElement(By.cssSelector("#buy-now")).click();
            //8 Nhập thông tin thanh toán. Em đã tạo thông tin từ trước nên ở đây em sẽ lấy lại thông tin đó
            //Có thể web sẽ bỏ qua bước này bởi vì nó đã lấy được thông tin ở trước đó.
            WebElement address = driver.findElement(By.cssSelector("#stored_addresses"));
            address.click();
            Select addressSelect = new Select(address);
            addressSelect.selectByIndex(3);
            Thread.sleep(4000);

            //9 Click chọn phương thức thanh toán
            driver.findElement(By.cssSelector("#form_next_step .btn")).click();
            //10 Chọn Thanh toán. Bước này em xin skip vì nó sẽ tốn tiền



        } catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
