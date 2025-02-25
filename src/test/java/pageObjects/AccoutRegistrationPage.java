package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccoutRegistrationPage extends BasePage {

	public AccoutRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(id="input-firstname")
WebElement txtFirstName;

@FindBy(id="input-lastname")
WebElement txtLastName;

@FindBy(id="input-email")
WebElement txtEmail;

@FindBy(id="input-telephone")
WebElement txtTel;

@FindBy(id="input-password")
WebElement txtPwd;

@FindBy(id="input-confirm")
WebElement txtConfirmPwd;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement txtMessage;

public void setFirstName(String fname) {
	txtFirstName.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastName.sendKeys(lname);
}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setTelephone(String tel) {
	txtTel.sendKeys(tel);
}

public void setPassword(String pwd) {
	txtPwd.sendKeys(pwd);
}

public void setConfirmPassword(String pwd) {
	txtConfirmPwd.sendKeys(pwd);
}

public void setPolicy() {
	chkPolicy.click();
}

public void clickContinue() {
	btnContinue.click();
	//btnContinue.submit(); //if above doest works
}

public String getConfirmationMessage() {
	try {
		return (txtMessage.getText());//returns confirmation message text
	}
	catch(Exception e)
	{
		return(e.getMessage());
		//returns error message
	}
}
}
