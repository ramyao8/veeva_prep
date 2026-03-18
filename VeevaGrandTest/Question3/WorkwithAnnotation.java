package Question3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WorkwithAnnotation {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
        System.out.println("Browser opened and website loaded");
    }
    @Test
    public void loginTest() {
        driver.findElement(By.name("email")).sendKeys("cherry01@gmail.com");
        driver.findElement(By.name("password")).sendKeys("cherry123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        System.out.println("Login test executed");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
