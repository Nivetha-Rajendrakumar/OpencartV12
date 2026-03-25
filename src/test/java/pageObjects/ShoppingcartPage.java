package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingcartPage extends BasePage{

	public ShoppingcartPage(WebDriver driver) {
		super(driver);
		}
	@FindBy(xpath="//div[@class='pull-right']/a")
	WebElement lnkCheckout;
	
	public void clkCheckout() {
		lnkCheckout.click();
	}

}
