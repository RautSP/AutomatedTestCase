package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class RegisterPage extends Root {
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-firstname")
	private WebElement FirstName;
	
    @FindBy(id="input-lastname")
    private WebElement LastName;
    
    @FindBy(id="input-email")
    private WebElement Email;  
    
    @FindBy(id="input-telephone")
    private WebElement Telephone;
    
    @FindBy(id="input-password") 
    private WebElement password;
    
    @FindBy(id="input-confirm")
    private WebElement ConfirmPassword;
    
    @FindBy(xpath="//input[@name='newsletter'][@value='1']")
    private WebElement YesNewsletter;
    
    @FindBy(xpath="//input[@name='agree'][@value='1']")
    private WebElement PrivacyPolicy;
    
    @FindBy(xpath="//input[@value='Continue']")
    private WebElement ContinueButton;
    
    @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
    private WebElement FirstNameWarning;
    
    @FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
    private WebElement LastNameWarning;
    
    @FindBy(xpath="//input[@id='input-email']/following-sibling::div")
    private WebElement EmailFieldWarning;
    
    @FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
    private WebElement TelephoneWarning;
    
    @FindBy(xpath="//input[@id='input-password']/following-sibling::div")
    private WebElement PasswordWarning;
    
    @FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div")
	private WebElement passwordConfirmationWarning;
    
   
    
    @FindBy(xpath="//input[@name='newsletter'][@value='0']")
    private WebElement NoNewsLetter;
    
    @FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Register']")
    private WebElement registerbreadcrumb;
    
    @FindBy(linkText="login page")
    private WebElement selectloginoption;
    
    public loginPage selectloginoption()
    {
    	elementUtilities.clickOnElement(selectloginoption);
    	return new loginPage(driver);
    }
    
    
    public String getPasswordFieldDomAttribute(String attributeName) {
    	return elementUtilities.getElementDomAttribute( password, attributeName);
		
	}
	
	public String getPasswordConfirmFieldDomAttribute(String attributeName) {
    	return elementUtilities.getElementDomAttribute( ConfirmPassword, attributeName);

	}
    public WebElement getfirstnamefieldElement()
    {
    	return FirstName;
    }
    
    public WebElement getlastnamefieldElement() 
    {
    	return LastName;
    }
    
    public WebElement getemailfieldElement()
    {
    	return Email;
    	
    }
    
    public WebElement gettelephonefieldelement()
    {
    	return Telephone;
    }
    public WebElement getpasswordfieldelement()
    {
    	return password;
    }
    
    public WebElement getconfirmpasswordfieldelement()
    {
    	return ConfirmPassword;
    }
    public WebElement getcontinuebuttonfieldelement()
    {
    	return ContinueButton;
    }
    public boolean didwenavigateonregisterpage()
    {
    	return elementUtilities.isElementDisplayed(registerbreadcrumb);
    }
    public RegisterPage selectOnRegisterBreadCrumb()
    {
    	elementUtilities.clickOnElement(registerbreadcrumb);
    	return new RegisterPage(driver);
    	
    }
    
    public void nonewsletterbox()
    {
    	elementUtilities.clickOnElement(NoNewsLetter);
    }
    
   
    
    public String PasswordWarningmsg()
    {
    	return elementUtilities.getElementText(PasswordWarning);
    }
    public String Passwordconfirmationwarning()
    {
    	return elementUtilities.getElementText(passwordConfirmationWarning);
    }
    
    public String Telephonewarningmsg()
    {
    	return elementUtilities.getElementText(TelephoneWarning);
    }
    
    public String EmailFieldWarningmsg()
    {
    	return elementUtilities.getElementText( EmailFieldWarning);
    }
    public String LastNameWarningmsg()
    {
    	return  elementUtilities.getElementText(LastNameWarning);
    }
    
    public String FirstNameWarningmsg()
    {
    	return elementUtilities.getElementText(FirstNameWarning);
    }
    public AccountSuccessPage ContinueButton()
    {
    	elementUtilities.clickOnElement(ContinueButton);
    	return new AccountSuccessPage(driver);
    }
    
    public void PrivacyPolicy()
    {
    	elementUtilities.clickOnElement(PrivacyPolicy);
    }
    
    
    
    public void SubScribeNewsletter()
    {
    	elementUtilities.clickOnElement(YesNewsletter);
    }
    public void ConfirmPasswordField(String confirmt)
    {
		elementUtilities.enterTextIntoElement(ConfirmPassword, confirmt);

    }
    
    public void passwordfield(String passwordt)
    {
		elementUtilities.enterTextIntoElement(password, passwordt);

    }
    public void Telephone(String number)
    {
		elementUtilities.enterTextIntoElement(Telephone, number);

    }
    
    public void EmailField(String Emailt)
    {
		elementUtilities.enterTextIntoElement(Email, Emailt);
    }
    
    public void LastNameField(String LastNamet)
    {
		elementUtilities.enterTextIntoElement(LastName, LastNamet);

    }
	
	public void FirstNameField(String FirstNamet)
	{
		elementUtilities.enterTextIntoElement(FirstName, FirstNamet);
	}
	public String getemailvalidationmsg()
	{
		return elementUtilities.getElementDomProperty(Email, getemailvalidationmsg());
	}
	public void clearemailfield()
	{
		elementUtilities.clearTextFromElement(Email);
	}

	 public String getfirstnamefieldPlaceholder() 
	 {
		return elementUtilities.getElementDomAttribute(FirstName, "placeholder");
	 }
	 public String getlastnamefieldPlaceholder() 
	 {
		return  elementUtilities.getElementDomAttribute(LastName, "placeholder");
	 }
	 public String getemailfieldPlaceholder() 
	 {
		return elementUtilities.getElementDomAttribute(Email, "placeholder");
	 }
	 public String gettelephonefieldPlaceholder() 
	 {
		 return elementUtilities.getElementDomProperty(Telephone, "placeholder");
	 }
	 public String getpasswordfieldPlaceholder() 
	 {
		 return elementUtilities.getElementDomProperty(password, "placeholder");
	 }
	 public String getconfirmpasswordfieldPlaceholder() 
	 {
		 return elementUtilities.getElementDomProperty(ConfirmPassword, "placeholder");
	 }

}
