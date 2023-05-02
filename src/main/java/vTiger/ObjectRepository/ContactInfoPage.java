package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	// declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement ContactInfoTxt;

		// initialisation
		public ContactInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
			
		}
		//utilization
		
		public WebElement getContactInfoTxt() {
			return ContactInfoTxt;
		}
		
		//Busniess library
		/**
		 * This method will get the contact header
		 * @return
		 */
		public String getContactText()
		{
			return ContactInfoTxt.getText();
		}
}
