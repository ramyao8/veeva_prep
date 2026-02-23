package SeleniumTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://github.com/login");
		driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys("ramyasada9999@gamil.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Ramya@ias2255");
		driver.findElement(By.xpath("//input[@name='commit']")).click();

	}

}
