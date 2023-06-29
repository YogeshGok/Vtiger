package Practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_org_with_Industry {
public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	//Implicit wait 
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//Random Class
	Random r=new Random();
	int ranNum = r.nextInt(1000);
	//enter UN 
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	//enter PWD
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	//Click Login Btn
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	//We need to click on Organization module
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	//click on org lookup image(+)
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//fill org name
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("WIPRO"+ranNum);
	//now we nned to handle industy dropdown(we have to select chemicals )
	WebElement indpdn = driver.findElement(By.xpath("//select[@name='industry']"));
	//create object of select class
	Select s=new Select(indpdn);
	s.selectByValue("Chemicals");
	//save it
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//verification
	Thread.sleep(4000);
	String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(orgHeader.contains("WIPRO")) {
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
	
	
}
}
