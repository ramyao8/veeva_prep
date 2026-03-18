package Question1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataDriven {
	public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // 1.read data from Excel
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\testData.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

      
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            //data reading
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                String email = row.getCell(0).getStringCellValue();
                String pswd = row.getCell(1).getStringCellValue();


                driver.get("https://automationexercise.com/login");

         
                driver.findElement(By.name("email")).clear();
                driver.findElement(By.name("email")).sendKeys(email);

                driver.findElement(By.name("password")).clear();
                driver.findElement(By.name("password")).sendKeys(pswd);

               
                driver.findElement(By.xpath("//button[text()='Login']")).click();
                
                Thread.sleep(5000);
                driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
 
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}
