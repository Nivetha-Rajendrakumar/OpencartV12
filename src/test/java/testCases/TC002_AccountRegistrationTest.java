package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccoutRegistrationPage;
import pageObjects.HomePage;
public class TC002_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Regression", "Master"})
	public void Registration_AllFields() {
		logger.info("test started");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("click on MyAccount");
		hp.clkMyAccount();
		logger.info("Click on Register");
		hp.clkRegister();
		AccoutRegistrationPage rp=new AccoutRegistrationPage(driver);
		logger.info("provide all the fields");
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randomNumber());
		String pwd =randomString()+randomNumber();
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		rp.clickNewsletterYes();
		rp.setPolicy();
		rp.clickContinue();
		logger.info("Get confirmation message and compare with actual message");
		String ConfirmationMesssage=rp.getConfirmationMessage();
		Assert.assertEquals(ConfirmationMesssage, "Your Account Has Been Created!");
	}
		catch(Exception e){
			Assert.fail();
		}
	}
	

}
