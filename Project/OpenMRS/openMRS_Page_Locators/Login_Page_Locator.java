package openMRS_Page_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Locator {
	WebDriver driver = null;
	public Login_Page_Locator(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement userName;
	
	public WebElement getUserID(){
		return userName;
	}
	
	@FindBy(id = "password")
	private WebElement password;
	
	public WebElement getPassword(){
		return password;
	}
	
	// Pharmacy link locator ID added
		@FindBy(id = "Pharmacy")
		private WebElement pharmacyID;

		public WebElement getPharmacy() {
			return pharmacyID;
		}
	
	@FindBy(id = "loginButton")
	private WebElement loginBtn;
	
	public WebElement getLoginBtn(){
		return loginBtn;
	}
	
	//Validation - Location not selected message - Cannot Login
		@FindBy(id = "sessionLocationError")
		private WebElement LocationNotSelectedMsg;
		
		public WebElement getLocationNotSelectedMsg()
		{
			return LocationNotSelectedMsg;
		}
}
