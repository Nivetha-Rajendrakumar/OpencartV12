package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
		// TODO Auto-generated constructor stub
		@FindBy (xpath = "//h2[normalize-space()='My Account']") WebElement msgHeading;
		@FindBy (xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnkLogout; // added for logout
		public boolean isMyAccountDisplayed() {
			try {
				return msgHeading.isDisplayed();
			}
			catch(Exception e) {
				return false;
			}
		}
		public void clickLogout() {
			lnkLogout.click();
		}
			
	}

