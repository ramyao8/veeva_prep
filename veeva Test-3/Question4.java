package SeleniumTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
public class Question4 {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle().equals("Google"));
		String ele=(driver.getCurrentUrl());
		URL u=new URL(ele);	
		System.out.println(u);
		if(u.equals("https://www.google.co.in"))
			System.out.println("redirected to .in");
		else
			System.out.println("not redired to .in");
		
	}

}
