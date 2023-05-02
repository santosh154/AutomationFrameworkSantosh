package vTiger.GenericUtilities;

/**
 * This class consist of all basic configuration annotations
 * @author PT
 *
 */

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();

	public WebDriver driver = null;
public static WebDriver sDriver;
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		System.out.println("----Database connection successful----");
	}
	//@Parameters("BROWSER")
    // @BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws IOException {
		
		String BROWSER = pUtil.ReadDataFromPropertyFile("browser");
		String URL = pUtil.ReadDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+"browser launched successsfully");// driver is initialised to chrome
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+"browser launched successsfully");// driver is initialised to chrome
		} else {
			System.out.println("invalid browser name in property file");
		}
		sDriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME=pUtil.ReadDataFromPropertyFile("username");
		String PASSWORD=pUtil.ReadDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("---Login is successful------");
	}
	
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logOutOfApp(driver);
		System.out.println("---LogOut is successful------");
	}
	
      // @AfterTest
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acConfig() {
        driver.quit();
        System.out.println("----Browser closed successfully----");
	}

	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asConfig() {
		System.out.println("----Database closed successfully----");
	}

}
