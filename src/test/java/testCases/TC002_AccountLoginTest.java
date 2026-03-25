package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.AccoutLoginPage;
import utilities.Environment_Variable;

public class TC002_AccountLoginTest extends BaseClass {
 
	@Test(groups = {"Sanity", "Master"})
	public void login_verify() {
		logger. info("** starting test***");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clkMyAccount();
		hp.clkLogin();
		
		
		AccoutLoginPage lp = new AccoutLoginPage(driver);
		logger. info("** providing email id***");
		lp.putEmail(Environment_Variable.getUsername());
		logger. info("providing password");
		lp.putPwd(Environment_Variable.getPassword());
		lp.clickLogin();
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean result =ap.isMyAccountDisplayed();
		Assert.assertEquals(result, true, "test failed"); //if both are not equal then the message will be displayed
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger. info("test completed");
		
	}
	
	
}
