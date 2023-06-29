package ObjectR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//identify locators
	@FindBy()private WebElement untxt;
	@FindBy()private WebElement pwdtxt;
	@FindBy()private WebElement loginBtn;
//Create Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//provide getters
	public WebElement getUntxt() {
		return untxt;
	}


	public WebElement getPwdtxt() {
		return pwdtxt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	

	
//business Library
public void LoginToApp(String UESRNAME, String PASSWORD) {
	untxt.sendKeys(UESRNAME);
	pwdtxt.sendKeys(PASSWORD);
	loginBtn.click();
}
}


