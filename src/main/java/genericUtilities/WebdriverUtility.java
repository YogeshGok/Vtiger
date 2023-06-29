package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility {
	/**
	 * This method is used to load the webpage
	 * @author Ankush
	 * @param driver
	 */
public void waitForPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
/**
 * This method is used to maximaize the window
 * @author Ankush
 * @param driver
 */
public void maxizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * This method is used to load the element on webpage
 * @author Ankush
 * @param driver
 * @param element
 */
public void waitforelementToBeVisible(WebDriver driver, WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method is used to handle dropdown using index
 * @author Ankush
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element, int index) {
	Select s=new Select(element);
	s.selectByIndex(index);
}
/**
 * @author Ankush
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element, String value) {
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * @author Ankush
 * This method is used to handle dropdown using visible text
 * @param visibleText
 * @param element
 */
public void handleDropDown( String visibleText,WebElement element) {
	Select s=new Select(element);
	s.selectByVisibleText(visibleText);
	
}
public void mouseOverAction(WebDriver driver, WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method is used to right click on webpage(anywhere)
 * @author Ankush
 * @param driver
 */
public void rightClickOnWebpage(WebDriver driver) {
	Actions act=new Actions(driver);
	act.contextClick().perform();
	
}
/**
 * This method is used to right click on element on webpage
 * @author Ankush
 * @param driver
 * @param element
 */
public void rightClickOnParticularElementOfWebpage(WebDriver driver, WebElement element) {
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
public void doubleClickOnWebpage(WebDriver driver) {
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
public void doubleClickOnParticulkarElement(WebDriver driver, WebElement element) {
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
public void dragAndDropAction(WebDriver driver, WebElement srcelement, WebElement targetelement) {
	Actions act=new Actions(driver);
	act.dragAndDrop(srcelement,targetelement).perform();
}
public void switchToFrame(WebDriver driver, int index) {
	driver.switchTo().frame(index);
}
public void switchToFrame(WebDriver driver, String nameOrId) {
	driver.switchTo().frame(nameOrId);
}
public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
public void switchToParentFrame(WebDriver driver) {
	driver.switchTo().parentFrame();
}
public void switchToDefaultFrame(WebDriver driver) {
	driver.switchTo().defaultContent();
}
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
}
public void dismissAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
public String getAlertText(WebDriver driver) {
return	driver.switchTo().alert().getText();
}
public String takesScreenShot(WebDriver driver, String screenshotName) throws Throwable {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(".\\Screenshots"+screenshotName+".png");
	 Files.copy(src, dest);
	return  dest.getAbsolutePath();//It gives the path of screenshot it is useful in extent report while sending to team leader
	
}
public void scrollAction(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("windows.scrollBy(0,500)");
}
public void switchToWindow(WebDriver driver, String patialTitle) {
	//step1:- capture all windows
	Set<String> winIDS = driver.getWindowHandles();
	//step2 :- Navigate to each window
	for(String winID:winIDS) {
		//step 3:- capture the title of window
		String actTitle = driver.switchTo().window(winID).getTitle();
		//compare patial title and actual title
		if(actTitle.contains(patialTitle)) {
			break;
		}
	}
}



}
