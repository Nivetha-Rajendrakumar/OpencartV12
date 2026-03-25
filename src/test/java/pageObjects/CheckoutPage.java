package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//label[normalize-space()='E-Mail']/following-sibling :: input")
	WebElement inputLogin;
	@FindBy(xpath="//label[normalize-space()='Password']/following-sibling :: input")
	WebElement inputPassword;
	@FindBy(xpath="//input[@id='button-login']")
	WebElement btnlogin;
	@FindBy(xpath="//input[@value='existing' and @name='payment_address']")
	WebElement radioExistingadd;
	@FindBy(xpath="//input[@value='new']")
	WebElement radioNewadd;
	@FindBy(css="#input-payment-firstname")
	WebElement inputFirstName;
	@FindBy(css="#input-payment-lastname")
	WebElement inputLastName;
	@FindBy(css="#input-payment-address-1")
	WebElement inputAddress;
	@FindBy(css="#input-payment-city")
	WebElement inputCity;
	@FindBy(css="##input-payment-postcode")
	WebElement inputPostcode;
	@FindBy(css="#input-payment-country")
	WebElement drpCountry;
	@FindBy(css="#input-payment-zone")
	WebElement drpRegion;
	@FindBy(css="input#button-payment-address")
	WebElement btnContinue;
	@FindBy(xpath="//input[@value='existing' and @name='shipping_address']")
	WebElement shipExistingadd;
	@FindBy(css="input#button-shipping-address")
	WebElement btnshipaddContinue;
	@FindBy(css="input#button-shipping-method")
	WebElement btnShipContinue;
	@FindBy(xpath="//input[@name='agree']")
	WebElement cbTerms;
	@FindBy(css="input#button-payment-method")
	WebElement btnPaymentContinue;
	@FindBy(css="input#button-confirm")
	WebElement btnConfim;
	
	public void setLogininput(String Username,String Password) {
		inputLogin.sendKeys(Username);
		inputPassword.sendKeys(Password);
	}
	public void clkLoginbtn() {
		btnlogin.click();
	}
	public void clkradioExitingadd() {
		radioExistingadd.click();
		
	}
	public void clkshipExitingadd() {
		shipExistingadd.click();
		
	}
	public void clkShipaddcontinue() {
		btnshipaddContinue.click();
	}
	
	public void clkradioNewadd() {
		radioNewadd.click();
	}
	public void setFirstname(String firstName) {
		inputFirstName.sendKeys(firstName);
	}
	public void setLastname(String LastName) {
		inputLastName.sendKeys(LastName);
	}
	public void setAddress(String address) {
		inputAddress.sendKeys(address);
	}
	
	public void setCity(String city) {
		inputCity.sendKeys(city);
	}
	public void setPostcode(String postcode) {
		inputCity.sendKeys(postcode);
	}
	
	public void selectCountry(String country) {
		Select s=new Select(drpCountry);
		s.selectByVisibleText(country);
	}
	
	public void selectRegion(String region) {
		Select s=new Select(drpRegion);
		s.selectByVisibleText(region);
	}
	public void clkcontinue() {
		btnContinue.click();
	}
	public void clkShipcontinue() {
			btnShipContinue.click();
		}
	public void clkTerms() {
			cbTerms.click();
		}
	public void clkPaymentcontinue() {
		btnPaymentContinue.click();
	}
	public void clkConfirm() {
		btnConfim.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}