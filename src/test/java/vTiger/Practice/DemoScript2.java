package vTiger.Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DemoScript2 {

	public static void main(String[] args) throws IOException {
		// Step 1: launch the browser
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("http://localhost:8888");
				
				TakesScreenshot screen=(TakesScreenshot)driver;
			File src=	screen.getScreenshotAs(OutputType.FILE);
			File dest=new File("Failed.png");
			FileUtils.copyFile(src, dest);
				

				// Step 2: Login to App
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				// Step 3: Navigate to Organizations LInk
				driver.findElement(By.linkText("Organizations")).click();

				// Step 4: click on Create Organization Look Up Image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				// Step 5: Create Organization with Mnadatory fields
				driver.findElement(By.name("accountname")).sendKeys("Dominos");
				//Step 6:Select Chemicals in industry dropdown
				 WebElement sel=	driver.findElement(By.name("industry"));
					Select s=new Select(sel);
					
					s.selectByValue("Chemicals");
					// Step 7: Save
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					//step8:verify
					


	}

}
