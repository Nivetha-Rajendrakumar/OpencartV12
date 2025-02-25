package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath = "//span[normalize-space()='My Account']")
	 WebElement lnkAccount;
@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
@FindBy(xpath="//a[normalize-space()='Login']")
WebElement lnkLogin;

public void clkMyAccount() {
	
	lnkAccount.click();
	
}
public void clkRegister() {
	
	lnkRegister.click();
	
}
public void clkLogin() {
	
	lnkLogin.click();
}
}
