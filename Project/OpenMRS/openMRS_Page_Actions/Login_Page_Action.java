package openMRS_Page_Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common_Functions.WebButton;
import common_Functions.WebElementCommon;
import common_Functions.WebTextBox;
import openMRS_Page_Locators.Login_Page_Locator;

public class Login_Page_Action {
	WebDriver driver = null;
	Login_Page_Locator loginPL = null;
	public Login_Page_Action(WebDriver driver){
		this.driver = driver;
		loginPL = new Login_Page_Locator(driver);
	}
	
	public void enterUserName(String user){
		WebElement userEle = loginPL.getUserID();
		if(WebElementCommon.webElementPresent(userEle)){
			WebTextBox.sendInput(userEle, user);
		}
	}
	
	public void enterPassword(String pass){
		WebElement passEle = loginPL.getPassword();
		if(WebElementCommon.webElementPresent(passEle)){
			WebTextBox.sendInput(passEle, pass);
		}
	}
	
	// Pharmacy button click action added
		public void clickPharmacy() {
			WebElement pharEle = loginPL.getPharmacy();
			if (WebElementCommon.webElementPresent(pharEle)) {
				if (WebElementCommon.webElementClickble(pharEle)) {
					WebButton.clickBtn(pharEle);
				}
			}
		}
	
	public void clickLogin(){
		WebElement btnEle = loginPL.getLoginBtn();
		if(WebElementCommon.webElementPresent(btnEle)){
			if(WebElementCommon.webElementClickble(btnEle)){
				WebButton.clickBtn(btnEle);
			}
		}
	}
	
	//New method for unsuccessful login when location is not selected
		public boolean LocationNotSelectedMsg(String ValMsgLocation) {
			WebElement lblEle = loginPL.getLocationNotSelectedMsg();
			if (WebElementCommon.webElementPresent(lblEle)) {
				if (lblEle.getText().equals(ValMsgLocation)) {
					return true;
				}
			}
			return false;
		}
	
	public Home_Page_Action succesfulLogin(String user, String pass){
		Home_Page_Action homePA = null;
		try {
			enterUserName(user);
			enterPassword(pass);
			clickPharmacy(); //Called the method to click pharmacy
			clickLogin();
			homePA = new Home_Page_Action(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return homePA;
	}
	
	// Unsuccessful login when location is not selected
		public boolean unSuccessfulLoginLocationNotSelected(String user, String pass,
				String ValMsgLocation) {
			boolean value = false;
			try {
				enterUserName(user);
				enterPassword(pass);
				clickLogin();
				value = LocationNotSelectedMsg(ValMsgLocation);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return value;
		}
}
