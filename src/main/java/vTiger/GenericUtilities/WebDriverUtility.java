package vTiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains all the generic methods related to webdriver actions
 * 
 * @author PT
 *
 */
public class WebDriverUtility {
	/**
	 * This method will maximize the screen
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the screen
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for 20s for page to get loaded
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method will wait for element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait for element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will handle dropdown with help of index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
		
	}
	/**
	 *  This method will handle dropdown with help of String value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByValue(text);
		
	}
	/**
	 * This method will handle dropdown with help of visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
		
	}
	/**
	 * This action will perform mousehover action on a webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click anywhere on webpage
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a webelement
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click anywhere on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	/**
	 * This method will double click on a webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement srcEle,WebElement destEle)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(srcEle, destEle).perform();
	}
	/**
	 * This method will press and release enter key
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame based on nameorId
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will handle frame based on Webelement
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch the control to immediate parent frame
	 * @param driver
	 * @param index
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch the control to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will return alert text
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will take screenshot and return path of destination
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String ScreenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File(".\\ScreenShots\\"+ScreenShotName+".png");
	    Files.copy(src, dest);
	    
	    return dest.getAbsolutePath();//used in extent reports
	}
	/**
	 * This method will perform random scroll action
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", " ");
	}
	/**
	 * This method will switch to window based on window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//1.get all window id's
		Set<String> allWinIds = driver.getWindowHandles();
		
		//2.Navigate to each window id
		for(String winId:allWinIds)
		{
			//3.Switch to each window and get the title
			String title = driver.switchTo().window(winId).getTitle();
			
			//4.compare the title with required title
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	

}
