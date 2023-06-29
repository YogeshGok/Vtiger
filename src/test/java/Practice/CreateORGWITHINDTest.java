package Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelUtility;

import genericUtilities.PropertyFileUtility;
import genericUtilities.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateORGWITHINDTest {
public static void main(String[] args) throws Throwable {
	//create all utilies objects
	
	ExcelUtility eutil=new ExcelUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	WebdriverUtility wutil=new WebdriverUtility();
	Random r=new Random();
	int ran = r.nextInt(1000);
	
	WebDriver driver=null;
	//read all data
    String BROWSER = putil.readDataFromPropertyFile("browser");
    String URL = putil.readDataFromPropertyFile("url");
    String USERNAME = putil.readDataFromPropertyFile("username");
    String PASSWORD = putil.readDataFromPropertyFile("password");
    
   String ORGNAME = eutil.readDataFromExcel("Organization",4,2)+ran; 
   String INDUSTRY = eutil.readDataFromExcel("Organization",4,3);
   
   //Luach the browser
   if(BROWSER.equalsIgnoreCase("chrome")) {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
   }
   else if(BROWSER.equalsIgnoreCase("firefox")) {
	   WebDriverManager.firefoxdriver().setup();
	   driver=new FirefoxDriver();
   }
   else {
	   System.out.println("EDIOT ENTER PROPER BROWSER NAME");
   }
   //maximize the browser
   wutil.maxizeWindow(driver);
   wutil.waitForPageLoad(driver);
   driver.get(URL);
   //Login to APP 
 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
   driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
   driver.findElement(By.xpath("//input[@id='submitButton']")).click();
  //click on Organization module 
   driver.findElement(By.xpath("//a[text()='Organizations']")).click();
  //click on org lookupp image
   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
   //enter org name
   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
   //select chemicals from idustry dropdown
   WebElement DROPDWN = driver.findElement(By.xpath("//select[@name='industry']"));
   wutil.handleDropDown(INDUSTRY, DROPDWN);
   //save
   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
   //validate
   String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(orgHeader.contains(ORGNAME)) {
    	System.out.println("Tc is pass");
    }
    else {
    System.out.println("TC fail");
    }
    //Logout from App
   WebElement adImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
   wutil.mouseOverAction(driver, adImg);
   //sign out from app
   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
   System.out.println("Logout successfull");
   
}
}
