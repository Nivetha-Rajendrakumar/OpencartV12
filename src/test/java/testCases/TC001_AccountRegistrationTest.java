package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccoutRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups = {"Regression", "Master"})
	public void verify_account_registration() {
		
		logger.info("*** test started***");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clkMyAccount();
		logger.info("clicking My Account");
		hp.clkRegister();
		logger.info("clicking Register");
		
		AccoutRegistrationPage rp = new AccoutRegistrationPage(driver);
		
		logger.info("providing customer details");
		rp.setFirstName(ramdomString().toUpperCase());
		rp.setLastName(ramdomString().toUpperCase());
		rp.setEmail(ramdomString()+"@gmail.com");
		rp.setTelephone(randomNumber());
		String passwd = randomAlphaNumeric();
		rp.setPassword(passwd);
		rp.setConfirmPassword(passwd);
		rp.setPolicy();
		logger.info("submitting response");
		rp.clickContinue();
		String confirmationMessage=rp.getConfirmationMessage();
		
		logger.info("validating confirmation message");
		if(confirmationMessage.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("test completed");
	}
	

 
}
