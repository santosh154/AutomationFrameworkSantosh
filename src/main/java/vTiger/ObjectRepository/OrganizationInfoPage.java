package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeader;
	
	// initialisation
		public OrganizationInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}
       //utilisation

		public WebElement getOrgHeader() {
			return OrgHeader;
		}
		
		//Business library
		/**
		 * This method will get the org header text and return it to caller
		 * @return
		 */
		public String getOrgHeaderText()
		{
			return OrgHeader.getText();
		}

}
