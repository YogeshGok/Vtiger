package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//write elements with locators
	@FindBy(xpath="//input[@name='user_name']")private WebElement untxt;
	@FindBy(xpath="//input[@name='user_password']")private WebElement pwdtxt;
	@FindBy(xpath="//input[@id='submitButton']")private WebElement loginBtn;
	
//Create Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
// provide getteres

	public WebElement getUntxt() {
		return untxt;
	}

	public WebElement getPwdtxt() {
		return pwdtxt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
}
