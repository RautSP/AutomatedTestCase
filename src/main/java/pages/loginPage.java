package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class loginPage extends Root{
	WebDriver driver;
	public loginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-primary'][text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement EmailData;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement PasswordData;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement clickOnLogin;
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Login']")
	private WebElement Login;
	
	@FindBy(linkText="Forgotten Password")
	private WebElement ForgotPasswordLink;
	
	@FindBy(xpath="(//div[@id='content']//h2)[1]")
	private WebElement getFirstheading;
	
	@FindBy(xpath="(//div[@id='content']//h2)[2]")
	private WebElement secondheading;
	
	public String  getsecondheading()
	{
		return elementUtilities.getElementText(secondheading);
	}
	
	public String  getfirstheading()
	{
		return elementUtilities.getElementText(getFirstheading);
	}
	
	public boolean ForGottonPAsswordlinkispresent()
	{
		return elementUtilities.isElementDisplayed(ForgotPasswordLink);
	}
	public ForGotPasswordPage clickOnForgotPasswordlink()
	{
		elementUtilities.clickOnElement(ForgotPasswordLink);
		return new ForGotPasswordPage(driver);
	}
	public AccountPage clickonLoginButton()
	{
		 elementUtilities.clickOnElement(clickOnLogin);
		 return new AccountPage(driver);
	}
	
	public boolean  Didwenavigateonloginpage()
	{
		return elementUtilities.isElementDisplayed(Login);
	}
	public void EnterEmailData(String emailtext)
	{
		elementUtilities.enterTextIntoElement(EmailData, emailtext);
		}
	public void EnterPasswordData(String passwordtext)
	{
		elementUtilities.enterTextIntoElement(PasswordData, passwordtext);
	}
	public String getEmailPlaceholder()
	{
		return elementUtilities.getElementDomAttribute(EmailData, "Placeholder");
	}
	public String getPasswordPlaceholder()
	{
		return elementUtilities.getElementDomAttribute(PasswordData,"Placeholder" );

	}
	public  RegisterPage clickOnContinueButton() {
		elementUtilities.clickOnElement(continueButton);
		return new RegisterPage(driver);
	}
	public AccountPage LoginIntoApplication(String email,String Password)
	{
		elementUtilities.enterTextIntoElement(EmailData, email);
		elementUtilities.enterTextIntoElement(PasswordData, Password);
		elementUtilities.clickOnElement(clickOnLogin);
		 return new AccountPage(driver);
	}
	public String getPasswordFieldDomAttribute(String attributeName) {
    	return elementUtilities.getElementDomAttribute( PasswordData, attributeName);
	
	}
    public void CopyTestFromPAsswordField()
    {
    	elementUtilities.CopyTextFromPasswordfieldusingkeyboard(driver);
    }
    public void pasteTextintoemailfield()
    {
    	elementUtilities.PasteTextIntoemailfieldusingKeyboard(EmailData, driver);
    }
    public String getPastedThingsfromemailfield()
    {
    return	elementUtilities.getElementDomAttribute(EmailData, "value");
    }
		
	
}
