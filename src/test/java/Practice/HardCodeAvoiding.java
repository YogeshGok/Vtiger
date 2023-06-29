package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardCodeAvoiding {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	//random class
	Random ran=new Random();
	int r = ran.nextInt(1000);
	//read data from property
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p=new Properties();
	p.load(fisp);
	String BROWSER = p.getProperty("browser");
	System.out.println(BROWSER);//Chrome
	String URL = p.getProperty("url");
	String USERNAME = p.getProperty("username");
	String PASSWORD = p.getProperty("password");
	//excel fetching
	//Create object of FIS
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//create method from workbook factpry
		Workbook wb = WorkbookFactory.create(fise);
		//getsheet
		Sheet sh = wb.getSheet("Organization");
		//navigate to row
		String ORGNAME = sh.getRow(1).getCell(2).getStringCellValue();
		
		//naviagte to insdstry name
		String INDUSTRYTYPE = sh.getRow(4).getCell(3).getStringCellValue();
		//lauch the browser
		
/*		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);             */
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser Name");
		}
		driver.get(URL); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		//Login  to app
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//clcik on org
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//clcik on + sign
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//fill org name
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+r);
		
		//click on chemocals industry
		WebElement indpdn = driver.findElement(By.xpath("//select[@name='industry']"));
		//create object of select class
		Select s=new Select(indpdn);
		s.selectByValue(INDUSTRYTYPE);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate
		Thread.sleep(4000);
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME)) {
			System.out.println("Ts is pass");
		}
		else{
			System.out.println("Fail");
		}
		
		
		//Logout from appp(use Actions class)
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//create object of Actions class
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		
		//naviagate to sign out
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
	
}
}
