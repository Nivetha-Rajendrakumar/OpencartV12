package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ViewcartPage extends BasePage {
	public ViewcartPage(WebDriver driver) {
		super(driver);		
	}
	@FindBy(xpath="//a[@class='btn btn-primary' and normalize-space()='Checkout']")
	WebElement lnkCheckout;
	
	public void clkCheckout() {
		lnkCheckout.click();
	}

}
