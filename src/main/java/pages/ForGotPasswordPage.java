package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class ForGotPasswordPage extends Root {
	WebDriver driver;
	public ForGotPasswordPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Forgotten Password']")
	private WebElement forgottenPasswordBreadcrumb;
	
	public boolean didWeNavigateToForgottenPasswordPage() {
		return elementUtilities.isElementDisplayed(forgottenPasswordBreadcrumb);
	}


}
