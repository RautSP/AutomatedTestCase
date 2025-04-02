package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class AccountPage extends Root {
	WebDriver driver;
	public AccountPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement NewsLetterOption;
	
	public NewsLetterPage subunsubNewsLetterOption()
	{
		elementUtilities.clickOnElement(NewsLetterOption);
		return new NewsLetterPage(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement Edityouraccoutinformationoption;
	
	public boolean didwenavigateonmyaccountpage()
	{
		return elementUtilities.isElementDisplayed(Edityouraccoutinformationoption);
	}
	
	

}
