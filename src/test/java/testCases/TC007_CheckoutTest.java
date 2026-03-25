package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;
import utilities.Environment_Variable;
import pageObjects.CheckoutPage;
import pageObjects.DesktopPage;
import pageObjects.HomePage;
import pageObjects.HpPage;
import pageObjects.ShoppingcartPage;
import pageObjects.SuccesscheckoutPage;

public class TC007_CheckoutTest extends BaseClass {
	

	

		@Test(groups= {"sanity","master"})
		
		public void verify_Checkout(){
			logger.info("starting test");
			
			try {
				
				HomePage hp=new HomePage(driver);
				hp.clkDesktop();
				hp.clkShowdesktopt();
				DesktopPage dp=new DesktopPage(driver);
				dp.clickAddtocart();
				HpPage hpp=new HpPage(driver);
				hpp.clkAddtocart();
				hpp.clkItem();
				hpp.clkViewcart();
				ShoppingcartPage sp=new ShoppingcartPage(driver);
				sp.clkCheckout();
				CheckoutPage cp=new CheckoutPage(driver);
				cp.setLogininput(Environment_Variable.getUsername(), Environment_Variable.getPassword());
				cp.clkLoginbtn();
				/*cp.clkradioNewadd();
				cp.setFirstname(randomString().toUpperCase());
				cp.setLastname(randomString().toUpperCase());
				cp.setAddress(randomString().toUpperCase());
				cp.setCity("Chennai");
				cp.setPostcode("2134234");
				cp.selectCountry("India");
				cp.selectRegion("Tamil Nadu");
				cp.clkcontinue();
				cp.clkcontinue();*/
				//cp.clkradioExitingadd();
				cp.clkcontinue();
				//cp.clkshipExitingadd();
				cp.clkShipaddcontinue();
				cp.clkShipcontinue();
				cp.clkTerms();
				cp.clkPaymentcontinue();
				cp.clkConfirm(); 
				SuccesscheckoutPage scp=new SuccesscheckoutPage(driver);
				String successmsg=scp.getSuccessmsg();
				if(successmsg.equals("Your order has been placed!")) {
					Assert.assertTrue(true);
				}
				else {
					logger.error("Test Failed as success message does not match");
					Assert.assertTrue(false);
				}
				
				
			}
			catch(Exception e){
				Assert.fail();
				
		}
	}
}
