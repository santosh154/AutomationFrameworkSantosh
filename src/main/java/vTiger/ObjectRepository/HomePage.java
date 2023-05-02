package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
    //Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//initialisation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//utilisation
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Library
	/**
	 * This method will click on Organization link
	 * 
	 */
	public void clickOnOrgLink()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This method will click on Contacts link
	 * 
	 */
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}
	/**
	 * This method will perform signout operation
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
	
}
