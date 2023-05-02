package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class DemoScript {

	public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		
		/* Generate Random Number
		Random r = new Random();
		int random = r.nextInt(1000);

		// Read All the required data
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);*/
		
		String BROWSER = pUtil.ReadDataFromPropertyFile("browser");
		String URL = pUtil.ReadDataFromPropertyFile("url");
		String USERNAME = pUtil.ReadDataFromPropertyFile("username");
		String PASSWORD = pUtil.ReadDataFromPropertyFile("password");

		/*FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		String ORGNAME = WorkbookFactory.create(fise).getSheet("Organization").getRow(7).getCell(2)
				.getStringCellValue()+random;*/
		String ORGNAME = eUtil.readDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber();
		WebDriver driver = null;
       //Step 1:Launch the browser------RUNTIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();//Driver is initialized to chrome
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();//Driver is initialized to firefox
		}

		else {
			System.out.println("Invalid Browser name");
		}

		
		/*driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));*/
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);	
	// Step 3: Navigate to Organizations LInk
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4: click on Create Organization Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 5: Create Organization with Mnadatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);	
		// Step 7: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("=== PASS ===");
		} else {
			System.out.println("=== FAIL ===");
		}

		// Step 8: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		/*Actions act = new Actions(driver);*/
		wUtil.mouseHoverAction(driver, ele);
		//act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signout successfull");

	}

}
