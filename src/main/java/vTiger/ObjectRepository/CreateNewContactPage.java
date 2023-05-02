package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	
	// declaration
		@FindBy(name = "lastname")
		private WebElement LastNameEdt;
		
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement SaveBtn;
		
		@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@title='Select']")
		private WebElement OrgLookUpImg;
		
		@FindBy(name = "search_text")
		private WebElement OrgSearchEdt;
		
		@FindBy(name = "search")
		private WebElement OrgSearchBtn;
		
		// initialisation
		public CreateNewContactPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//utilisation

		public WebElement getLastNameEdt() {
			return LastNameEdt;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}

		public WebElement getOrgLookUpImg() {
			return OrgLookUpImg;
		}

		public WebElement getOrgSearchEdt() {
			return OrgSearchEdt;
		}

		public WebElement getOrgSearchBtn() {
			return OrgSearchBtn;
		}
		//Business library
		/**
		 * This method will create a contact by giving mandatory information
		 * @param LASTNAME
		 */
		public void createNewContact(String LASTNAME)
		{
			LastNameEdt.sendKeys(LASTNAME);
		}
		/**
		 * This method wi;; create a new contact with organisation
		 * @param LASTNAME
		 * @param ORGNAME
		 * @param driver
		 */
		public void createNewContact(String LASTNAME,String ORGNAME, WebDriver driver)
		{
			LastNameEdt.sendKeys(LASTNAME);
			OrgLookUpImg.click();
			switchToWindow(driver, "Accounts");
			OrgSearchEdt.sendKeys(ORGNAME);
			OrgSearchBtn.click();
			driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
			switchToWindow(driver, "Contacts");
			SaveBtn.click();
		}
		

}
