package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
@Listeners(vTiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void createContactWithOrgTest() throws IOException
	 {

		/* Create organization */

		// create object of all utilities
		
//Read all the required data
		

		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();

		

		
		/*
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 */
		

		// Step 2: Login to App
		
		// Step 3: Navigate to Organizations LInk
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		
		// Step 4: click on Create Organization Look Up Image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();

		// Step 5: Create Organization with Mnadatory fields
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME);
	
		// Step 7: Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeaderText();
		//Assert.fail();
		//Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		
		/* create contact using the same organization */
		

		// step8:navigate to  contact link
		hp.clickOnContactsLink();

		// step9:click on create contact lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		//step 10:create contact
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		

		
		// Step 16: Validate
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ContactHeader = cip.getContactText();
		System.out.println(ContactHeader);
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		

		// step 17:logout
		

	}
}
