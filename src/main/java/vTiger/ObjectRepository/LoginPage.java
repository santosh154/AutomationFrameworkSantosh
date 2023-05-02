package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//DECLARATION
	@FindBy(name="user_name")
	private WebElement USRNAME;
	
	@FindBy(name="user_password")
	private WebElement USRPASS;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	// initialisation
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}

//UTILISATION
	public WebElement getUSRNAME() {
		return USRNAME;
	}

	public WebElement getUSRPASS() {
		return USRPASS;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	//BUSINESS LIBRARY
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		USRNAME.sendKeys(USERNAME);
		USRPASS.sendKeys(PASSWORD);
		LoginBtn.click();
	}
	
	
	
}
