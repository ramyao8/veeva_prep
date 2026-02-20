package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccount extends BasePage{
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement my_acc;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logOutButt;
	public boolean isMyAccExist()
	{
		try {
			return (my_acc.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void logout()
	{
		logOutButt.click();
	}
}
