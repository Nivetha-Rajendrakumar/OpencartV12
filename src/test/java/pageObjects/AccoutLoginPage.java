package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccoutLoginPage extends BasePage {

	public AccoutLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtloginEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtloginpwd;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	
	public void putEmail(String email) {
		txtloginEmail.sendKeys(email);
		
	}
	public void putPwd(String pwd) {
		txtloginpwd.sendKeys(pwd);
		
	}
	public void clickLogin(){
		btnLogin.click();
		
	}
}
