package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//i[@class='fa fa-user']") WebElement nav_bar;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register_button;
	
	//login page
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement login_butt;
	
	public void navigateToMyAccount()
	{
		nav_bar.click();
	}
	public void register()
	{
		register_button.click();
	}
	public void login()
	{
		login_butt.click();
		
	}
}
