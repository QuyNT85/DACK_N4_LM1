package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

/*
Test Steps
Step 1. Go to https://sevenam.vn//
Step 2. Lay tieu de cua trang
Step 3. Click on -> San pham moi nhat
Step 4. Sap xep theo sp ban chay
Step 5. Chup hinh tim kiem theo khoang gia trong sp ban chay
*/
@Test
public class Test1 {
    public static void Tested1(){
       // Step 1. Go to https://sevenam.vn
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://sevenam.vn");
            Thread.sleep(2000);
        //Step 2. Verify Title of the page
            String setTitle= driver.findElement(By.cssSelector("h1")).getText();
            System.out.println(setTitle);

        //Step 3. Click on ->San pham moi nhat
            WebElement spnew=driver.findElement(By.xpath("//ul[@class='inline-list']/li[1]/a"));
            spnew.click();
            Thread.sleep(2000);
        //Step 4. Sap xep theo sp ban chay
            WebElement sortby= driver.findElement(By.xpath("//select[@id='SortBy']"));
            Select select = new Select(sortby);
            select.selectByVisibleText("Sản phẩm bán chạy");
            Thread.sleep(5000);
        //Step 5. Chup hinh tim kiem theo khoang gia trong sp ban chay
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("D:\\HocTap\\Kiemthuungdung\\Kiemthutudong\\selenium-SevenAm-LM1-N4-NguyenTrongQuy\\testcase1.png"));
            Thread.sleep(5000);
        }catch (Exception ignored) {
        }
        driver.close();
        driver.quit();
    }
}
