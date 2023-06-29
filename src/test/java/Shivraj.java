import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Shivraj {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	//Fetch data from property
	PropertyFileUtility putil=new PropertyFileUtility();
	String USERNAME = putil.readDataFromPropertyFile("username");
	String PASSWORD = putil.readDataFromPropertyFile("password");
	String BROWSER = putil.readDataFromPropertyFile("browser");
	String URL= putil.readDataFromPropertyFile("url");
	//Fetch Data from excel
	ExcelUtility eutil=new ExcelUtility();
	String ORGNAME = eutil.readDataFromExcel("Organization", 1, 2);
	//javautility read
	JavaUtility jutil=new JavaUtility();
	int r = jutil.getRandomNumber();
	//runtime poly
	if(BROWSER.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
}
	else {
		System.out.println("Invalid Browser Name");
	}
	//launch application
	driver.get(URL);
	//enter Login credentials
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	 driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	 driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	 
	 //click on Organization module 
	   driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	  //click on org lookupp image
	   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	   //enter org name
	   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+r);
	   
	   //save it
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   //validate
	   Thread.sleep(4000);
	   String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    if(orgHeader.contains(ORGNAME)) {
	    	System.out.println("Tc is pass");
	    }
	    else {
	    System.out.println("TC fail");
	    }
}
}
