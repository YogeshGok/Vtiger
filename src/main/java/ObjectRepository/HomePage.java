package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//Decladration
	@FindBy(xpath="")private WebElement orgLink;
	@FindBy(xpath="")private WebElement contactLink;
	@FindBy(xpath="")private WebElement opportunityLink;
	@FindBy(xpath="")private WebElement adminImg;
	@FindBy(xpath="")private WebElement signoutLink;
//Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//UTilization
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getOpportunityLink() {
		return opportunityLink;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
}
