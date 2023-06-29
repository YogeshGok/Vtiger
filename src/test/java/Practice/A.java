package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	//enter UN
	WebElement USERNAME = driver.findElement(By.xpath("//input[@name='user_name']"));
	//refresh the page
	driver.navigate().refresh();
	USERNAME.sendKeys("admin");
}
}
