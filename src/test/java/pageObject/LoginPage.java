package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']") WebElement email_txt;
	@FindBy(xpath="//input[@id='input-password']") WebElement pass_txt;
	@FindBy(xpath="//input[@value='Login']")	WebElement log_butt;
	
	public void email(String m)
	{
		email_txt.sendKeys(m);
	}
	public void password(String p)
	{
		pass_txt.sendKeys(p);
	}
	public void logButton()
	{
		log_butt.click();
	}
}
