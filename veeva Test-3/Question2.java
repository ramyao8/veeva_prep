package SeleniumTest1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Question2 {
	@Test
	@Parameters("browser")
	public void demo(String br)
	{
		WebDriver driver;
		switch(br)
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default: System.out.println("invalid browser name");return;
		}
		driver.get("https://www.amazon.in");
	}
}
