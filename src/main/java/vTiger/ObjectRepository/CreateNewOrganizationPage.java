package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	// declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	// initialisation
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// utilisation
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	// Business Library
	/**
	 * This method will create a new organisation with mandatory feilds and save it
	 * 
	 * @param ORGNAME
	 */
	public void createNewOrg(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}

	/**
	 * This method will create a organisation with industry feilds and save
	 * 
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrg(String ORGNAME, String INDUSTRY)

	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn, INDUSTRY);
		SaveBtn.click();
	}

}
