package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/*
Test Steps:
1. Go to https://sevenam.vn//
2. Click on -> San pham moi nhat
3. Trong list sản phẩm chọn sp Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ... , click on Search for sp,update size và add giỏ hàng
4. Thay đổi số lượng 0 và cập nhật giỏ hàng. Xem giỏ hàng
5. Đọc thông báo của giỏ hàng
6. Click tiếp tục mua hàng và thêm sản phẩm vào giỏ hàng
7. Xác nhận sp đã thêm vào giỏ hàng với số lượng là n.

 */
@Test
public class Test3 {
    public static void Tested3(){
        // Step 1. Go to https://sevenam.vn
       WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://sevenam.vn");

            //Step 2. Click on -> San pham moi nhat
            WebElement spnew=driver.findElement(By.xpath("//ul[@class='inline-list']/li[1]/a"));
            spnew.click();

            //3. Trong list sản phẩm chọn sp Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ... ,
            // click on Search for sp,update size là XL và add giỏ hàng



            //   Lấy thành phần muốn di chuột
            WebElement imageElement = driver.findElement(By.xpath("//img[@id='1045546038']"));

            //  Gán thành phần vào point
            // Get the location of the image element
            Point imageElementLocation = imageElement.getLocation();


            // Di chuyển chuyển vào vị trí point phía trên
            new Actions(driver).moveByOffset(imageElementLocation.getX(), imageElementLocation.getY()).perform();

            Thread.sleep(3000);

//            Click vào icon search
           driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
            Thread.sleep(3000);

//            Chuyển đổi từ màn hình main sang pop up
            String parentWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

//            Chọn size L và nhấn thêm giỏ hàng
            driver.findElement(By.xpath("//label[@for='qv-swatch-0-l']")).click();
            driver.findElement(By.xpath("//button[@id='AddToCardQuickView']")).click();


//            Chuyển đổi sang popup cart
            String parentWindow2 = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindow2)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            Thread.sleep(3000);

//            Chỉnh sửa số lượng về 0
          WebElement input =   driver.findElement(By.xpath("//body[1]/div[6]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]"));
                input.clear();
                input.sendKeys("0");
//                CLick vào nut cập nhật giỏ hàng
            driver.findElement(By.xpath("//button[@onclick='UpdateCartFromCart();']")).click();
            Thread.sleep(3000);
//            Chuyển đổi sang popup cart

 //           driver.findElement(By.xpath("//span[@id='modalAddComplete-close']")).click();
            WebElement EmptyCart = driver.findElement(By.xpath("//div[@id='modalAddComplete']//div//div//div//h2"));
//          System.out.println(EmptyCart);
            if(EmptyCart.isDisplayed()){
                System.out.println("ton tai");
                System.out.println(EmptyCart.getText());
            }else {
                System.out.println("ko ton tai");
            }

            //6. Click tiếp tục mua hàng và thêm sản phẩm vào giỏ hàng
            driver.findElement(By.xpath("//form[@action='/cart']//div//div//p//a")).click();
            driver.findElement(By.xpath("//body//div[@id='PageContainer']//div//div//div//div//div//div//div[2]//div[1]//div[1]//div[2]//h3[1]//a[1]")).click();
            driver.findElement(By.xpath("//button[@id='AddToCart']")).click();
            Thread.sleep(3000);
            //7. Xác nhận sp đã thêm vào giỏ hàng với số lượng là n.

//            Lấy số lượng về sp
            WebElement QTY =   driver.findElement(By.xpath("//INPUT[@id='Quantity']"));
            String inputValue = QTY.getAttribute("value");

        // Chuyển đổi giá trị thành kiểu số
            int inputNumber = Integer.parseInt(inputValue);

                System.out.println("san pham duoc them vao gio hang voi so luong la: "+inputNumber);


//     Chuyển về main  chính
            driver.switchTo().window(parentWindow);

        }catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }
       driver.quit();
    }
}
