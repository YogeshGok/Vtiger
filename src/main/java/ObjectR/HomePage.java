package ObjectR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//Declaration
	@FindBy(xpath="//a[text()='Organizations']")private WebElement orglink;
	@FindBy(xpath="//a[text()='Contacts']")private WebElement contactLink;
	@FindBy(xpath="//a[text()='Opportunities']")private WebElement opportunityLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")private WebElement adminImg;
	@FindBy(xpath="//a[text()='Sign Out']")private WebElement signOutLink;
//Initialization(costructor)
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization(getters)
	public WebElement getOrglink() {
		return orglink;
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
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
}
