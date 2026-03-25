package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SuccesscheckoutPage extends BasePage {

	public SuccesscheckoutPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
WebElement msgsuccess;

public String getSuccessmsg() {
	try {
		return(msgsuccess.getText());
	}
	catch(Exception e){
		return(e.getMessage());
	}
	
}
}
