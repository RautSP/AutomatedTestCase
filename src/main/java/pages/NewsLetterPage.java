package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class NewsLetterPage extends Root {
	WebDriver driver;
	public NewsLetterPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Newsletter']")
	private WebElement newsletterPageBreadcrumb;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	private WebElement NoNewsletterOption;
	
	public boolean isNoNewsletterOptionIsInSelectedState() {
		return NoNewsletterOption.isSelected();
	
	}

	
	public boolean isYesNewsletterOptionIsInSelectedState() {
		return elementUtilities.isElementSelected(yesNewsletterOption);
	}
	
	public boolean didWeNavigateToNewsletterPage() {
		return elementUtilities.isElementDisplayed(NoNewsletterOption);
	}

}


