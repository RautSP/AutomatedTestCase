package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class AccountSuccessPage extends Root {
	WebDriver driver;
	public AccountSuccessPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement subscribeUnsubscribeToNewsletterOption;
	
	@FindBy(linkText="Logout")
	private WebElement LogOutOption;
	
	@FindBy(id="content")
	private WebElement accountSuccesspagecontent;
	
	@FindBy(xpath="//div[@id='content']//a[text()='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
	private WebElement SuccessBreadcrumb;
	
	@FindBy(xpath="//div[@id='common-success']//h1")
	private WebElement CommonSuccessHeading;
	
	public String CommonSuccessHeadingoption()
	{
		return elementUtilities.getElementText(CommonSuccessHeading);
	}
	public boolean SuccessOption()
	{
		return elementUtilities.isElementDisplayed(SuccessBreadcrumb);
	}
	
	public AccountPage ClickOnContinueButton()
	{
		elementUtilities.clickOnElement(ContinueButton);
		  return new AccountPage(driver);
		
	}
	
	public String getcontent()
	{
		return elementUtilities.getElementText(accountSuccesspagecontent);
		
	}
	public boolean  Logout()
	{
		return elementUtilities.isElementDisplayed(LogOutOption);	
		
	}
		
	

	
	public boolean didWeNavigateToMyAccountPage() {
		
		return elementUtilities.isElementDisplayed(editYourAccountInformationOption);
	}

}


