package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
Test Steps:
Step 1. Go to https://sevenam.vn//
Step 2. Click on -> San pham moi nhat
Step 3. Trong list san pham ,Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ...
Step 4. Click on Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ...
Step 5. doc sp Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ... tu trang chi tiet
Step 6. So sanh gia san pham doc sp Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ... o trang chi tiet va list sp
*/
@Test
public class Test2 {
    public static void Tested2(){
        // Step 1. Go to https://sevenam.vn
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://sevenam.vn");
            Thread.sleep(2000);
            //Step 2. Click on -> San pham moi nhat
            WebElement spnew=driver.findElement(By.xpath("//ul[@class='inline-list']/li[1]/a"));
            spnew.click();
            Thread.sleep(2000);
            //Step 3. Trong list san pham ,doc sp Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ...
            String Name=driver.findElement(By.xpath("//div[@class='grid-uniform product-list md-mg-left-10']/div[1]/div/div[1]/div[2]/h3")).getText().toString();
            System.out.println(Name);
            String Price=driver.findElement(By.xpath("//div[@class='grid-uniform product-list md-mg-left-10']/div[1]/div/div[1]/div[3]/span")).getText().toString();
            System.out.println(Price);
            Thread.sleep(2000);
            //Step 4. Click on Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ...
            driver.findElement(By.xpath("//img[@id='1045546038']")).click();
            Thread.sleep(2000);
            //Step 5. doc sp Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ... tu trang chi tiet
            String Namedetail=driver.findElement(By.xpath("//div[@class='product-page-ticky']/h1")).getText().toString();
            System.out.println(Namedetail);
            String Pricedetail=driver.findElement(By.xpath("//div[@class='product-page-ticky']/p/span[@id='ProductPrice']")).getText().toString();
            System.out.println(Pricedetail);
            //Step 6. So sanh gia san pham doc sp Jumpsuit dài ngắn tay đen cổ ngang dây xích thời trang nữ Seven AM ... o trang chi tiet va list sp
            if (Price.equals(Pricedetail)){
                System.out.println("Product prices on 2 pages are the same");
            }else {
                System.out.println("Product prices on 2 pages aren't the same");
            }
        }catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
