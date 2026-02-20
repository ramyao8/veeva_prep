package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	@Parameters({"os","browser"})
	@BeforeClass(groups={"sanity","datadriven"})
	public void setUp(String os,String browser) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());
		
		//LOADING PROPERTIES
		FileReader f=new FileReader("./src//test//resources//config.Properties");
		p=new Properties();
		p.load(f);
		switch(browser)
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default: System.out.println("invalid driver");return;
		}
		driver.get(p.getProperty("appURL2"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/*@AfterClass
	public void tearDown()
	{
		driver.close();
	}*/
	public String randomString()
	{
		String gen_string=RandomStringUtils.randomAlphabetic(5);
		return gen_string;
	}
	public String randomAlphaNum()
	{
		String gen_string1=RandomStringUtils.randomAlphabetic(3);
		String gen_num=RandomStringUtils.randomNumeric(3);
		return (gen_string1+"@"+gen_num);
	}
	public String randomNum()
	{
		String gen_num=RandomStringUtils.randomNumeric(10);
		return gen_num;
	}
}
