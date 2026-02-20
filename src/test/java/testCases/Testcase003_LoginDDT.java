package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccount;
import testBase.BaseClass;
import utilities.DataProvider_login;

public class Testcase003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider_login.class,groups={"datadriven"})
	public void verify_login(String mail,String pass,String exp) throws InterruptedException
	{
		System.out.println("TEST IS RUNNING");
		HomePage hp=new HomePage(driver);
		hp.navigateToMyAccount();
		hp.login();
		LoginPage lp=new LoginPage(driver);
		lp.email(mail);
		lp.password(pass);
		lp.logButton();
		Thread.sleep(2000);
		MyAccount my_acc=new MyAccount(driver);
		boolean ver=my_acc.isMyAccExist();
		System.out.println("Login result: " + ver);
		if(exp.equalsIgnoreCase("valid"))
		{
			if(ver==true)
			{
				my_acc.logout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(exp.equalsIgnoreCase("invalid"))
		{
				if(ver==true)
				{
					my_acc.logout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
		}
	}
	
}
