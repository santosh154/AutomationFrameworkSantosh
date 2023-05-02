package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass{
	 
	@Test(dataProvider="getData")
	public void createMultipleOrgWithIndustry(String ORG,String INDUSTRY) throws IOException, InterruptedException
	{
		// Create Object of all Utilities
					
					

					String ORGNAME = ORG+jUtil.getRandomNumber();

					

					// Step 2: Login to App
					
					
					// Step 3: Navigate to Organizations LInk
					HomePage hp=new HomePage(driver);
					hp.clickOnOrgLink();
					

					// Step 4: click on Create Organization Look Up Image
					
					
					OrganizationsPage op=new OrganizationsPage(driver);
					op.clickOnCreateOrgLookUpImage();

					// Step 5: Create Organization with Mnadatory fields
					
					CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
					cnop.createNewOrg(ORGNAME, INDUSTRY);
					

					

					// Step 7: Validate
					OrganizationInfoPage oip=new OrganizationInfoPage(driver);
					Thread.sleep(2000);
					String OrgHeader = oip.getOrgHeaderText();
					Assert.assertTrue(OrgHeader.contains(ORGNAME));
					
					// Step 8: Logout
					
	}
     @DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		 return eUtil.readMultipleDataFromExcel("DataProviderOrg");
		
	}
}
