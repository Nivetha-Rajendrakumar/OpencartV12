package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccoutLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
/* valid -login success - test pass - logout
 *              fail - test failed
 * invalid - login success - test fail - logout
 *           fail - fail 
 */
public class TC004_LoginDataDriven extends BaseClass
{
	
	@Test(dataProvider = "Logindata", dataProviderClass = DataProviders.class, groups = "Datadriven")// for getting dataprovider class from different class
	public void verify_loginDDT(String email, String pwd, String exres) {
		logger.info("**started**");
		try {
		HomePage hp = new HomePage(driver);
		hp.clkMyAccount();
		hp.clkLogin();
		
		
		AccoutLoginPage lp = new AccoutLoginPage(driver);
		logger. info("** providing email id***");
		lp.putEmail(email);
		logger. info("providing password");
		lp.putPwd(pwd);
		lp.clickLogin();
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean result =ap.isMyAccountDisplayed();
		if (exres.equalsIgnoreCase("valid")) 
		{
			if(result == true) 
			{
				ap.clickLogout();
				Assert.assertTrue(true);
				
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		if(exres.equalsIgnoreCase("invalid")) 
		{
				if(result == true) 
				{
					ap.clickLogout();
					Assert.assertTrue(false);
					
				}
				else
				{
					Assert.assertTrue(true);
				}
		}
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**end**");
	}
}

