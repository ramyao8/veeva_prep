package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement fname;
	@FindBy(xpath="//input[@id='input-lastname']")	WebElement lname;
	@FindBy(xpath="//input[@id='input-email']")	WebElement mail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement phone;
	@FindBy(xpath="//input[@id='input-password']") WebElement pass;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement conPass;
	@FindBy(xpath="//input[@name='agree']")	WebElement agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_butt;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msg;
	
	
	public void firstName(String firName)
	{
		fname.sendKeys(firName);
	}
	public void lastName(String LasName)
	{
		lname.sendKeys(LasName);
	}
	public void email(String emailtxt)
	{
		mail.sendKeys(emailtxt);
	}
	public void phoneNum(String num)
	{
		phone.sendKeys(num);
	}
	public void password(String passtxt)
	{
		pass.sendKeys(passtxt);
	}
	public void confirmPassword(String confpass)
	{
		conPass.sendKeys(confpass);
	}
	public void agreePolicy()
	{
		agree.click();
	}
	public void continueButton()
	{
		continue_butt.click();
	}
	public String confirmMsg()
	{
		try {
		return msg.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	
}
