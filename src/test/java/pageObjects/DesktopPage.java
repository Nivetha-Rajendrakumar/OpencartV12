package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesktopPage extends BasePage {
	public DesktopPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath="//img[@title='HP LP3065']")
	WebElement addtocartButton;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement gotoCart;
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewcart;
	
	public void clickAddtocart() {
		addtocartButton.click();
	}
	public void clkgotoCart() {
		gotoCart.click();
	}
	public void clkViewcart() {
		lnkViewcart.click();
	}

}
