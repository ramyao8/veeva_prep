package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccount;
import testBase.BaseClass;

public class Testcase002_loginTest extends BaseClass {
	@Test(groups={"sanity","regression","master"})
	public void verify_login()
	{
		logger.info("***starting the test case***");
		HomePage hp=new HomePage(driver);
		hp.navigateToMyAccount();
		hp.login();
		LoginPage lp=new LoginPage(driver);
		lp.email(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.logButton();
		
		MyAccount ac=new MyAccount(driver);
		boolean exists=ac.isMyAccExist();
		Assert.assertEquals(exists, true);
		ac.logout();
		
	}
}
