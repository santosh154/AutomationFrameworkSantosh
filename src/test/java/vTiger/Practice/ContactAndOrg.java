package vTiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ContactAndOrg {

	public static void main(String[] args) throws Throwable {

		// Generate Random Number
		Random r = new Random();
		int random = r.nextInt(1000);
		// Step 1: launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");

		// Step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		// step3:create contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("pradhan");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// step4:create org
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
		// Step 5: Create Organization with Mnadatory fields
		driver.findElement(By.name("accountname")).sendKeys("Dominos" + random);

		// Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 7: Logout
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				System.out.println("Signout successfull");

	}

}
