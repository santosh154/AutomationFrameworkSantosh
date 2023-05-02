package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	WebElement CreateOrgLookUpImg;
	
	//initialisation
	public OrganizationsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilisation
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	//business library
	/**
	 * This method will click on create organisation look up image
	 */
	public void clickOnCreateOrgLookUpImage()
	{
		CreateOrgLookUpImg.click();
	}

}
