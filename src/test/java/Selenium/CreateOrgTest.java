package Selenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest {
public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	//Random class
	Random ran =new Random();
	int r = ran.nextInt(1000);
	//Enter Login credentials
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	//click on org module
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	//click on Org Lokk up image
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//give org name
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Accenture"+r);
	//clcik on save btn
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Validate
	Thread.sleep(4000);
	String orgText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(orgText.contains("Accenture")) {
		System.out.println("TC is pass");
	}
	else {
		System.out.println("TC is fail...");
	}
	//Logut from app
	WebElement adImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(adImg).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
}
}
