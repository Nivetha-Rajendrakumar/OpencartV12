package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HpPage extends BasePage {
	public HpPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//button[normalize-space()='Add to Cart']")
	WebElement lnkAddtocart;
	
	@FindBy(xpath="//button[starts-with(@class,'btn btn-inverse')]")
	WebElement lnkItem;
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewcart;
	public void clkAddtocart(){
		
		lnkAddtocart.click();
	}
public void clkItem(){
		
	lnkItem.click();
	}
public void clkViewcart(){
	
	lnkViewcart.click();
	}
}
