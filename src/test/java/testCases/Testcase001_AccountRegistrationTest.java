package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class Testcase001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"sanity","master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("*****starting Testcase001_AccountRegistrationTest******");
		HomePage hp=new HomePage(driver);
		hp.navigateToMyAccount();
		hp.register();
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		logger.info("*****ENTERING DETAILS TO THE FORM*****");
		arp.firstName(randomString().toUpperCase());
		arp.lastName(randomString().toUpperCase());
		arp.email(randomString()+"@gmail.com");
		arp.phoneNum(randomNum());
		String pass=randomAlphaNum();
		Thread.sleep(5000);
		arp.password(pass);
		arp.confirmPassword(pass);
		Thread.sleep(5000);
		arp.agreePolicy();
		arp.continueButton();
		logger.info("*****VALIDATING EXPECTED MESSAGE******");
		Assert.assertEquals(arp.confirmMsg(),"Your Account Has Been Created!");
		logger.error("*****error occured******");
		logger.info("*****ending Testcase001_AccountRegistrationTest******");
	}
	
}
