package root;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.FooterOptions;
import pages.HeaderOptions;
import pages.HomePage;
import pages.loginPage;
import utility.ElementUtilities;
import pages.RightColumnOptions;
public class Root {
WebDriver driver;
public ElementUtilities elementUtilities;
	
	public Root(WebDriver driver) {
		this.driver = driver;
		elementUtilities=new ElementUtilities(driver);
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//i[@class='fa fa-home']")
	private WebElement HomeBreadCrumb;
	
	@FindBy(xpath="//a[text()='Account']")
	private WebElement AccountbreadCrumb;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
     private WebElement PrivacyPlicyWarning;
	
	 public String PageLevelWarningmsg()
	    {
	    	return elementUtilities.getElementText(PrivacyPlicyWarning);
	    }
	
	public loginPage selectAccountBreadCrumb()
	{
		elementUtilities.clickOnElement(AccountbreadCrumb);
		return new loginPage(driver); 
		
	}
	
	public HomePage SelectHomeBreadCrumb()
	{
		elementUtilities.clickOnElement(HomeBreadCrumb);
		return new HomePage(driver);
		
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement pageHeading;
	
	public HeaderOptions getHeaderOptions() {
		
		return new HeaderOptions(driver);
	}
    public FooterOptions getFooterOptions() {
		
		return new FooterOptions(driver);
	}
	
	public RightColumnOptions getRightColumnOptions() {
		return new RightColumnOptions(driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
