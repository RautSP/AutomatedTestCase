package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;
import utility.ElementUtilities;

public class HeaderOptions extends Root{
	WebDriver driver;
	ElementUtilities ElementUtilities;
	
	public HeaderOptions(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		ElementUtilities = new ElementUtilities(driver);
		PageFactory.initElements(driver, this);
				
	}
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement AccountDropMenu;
	
	
	@FindBy(linkText="Register")
	private WebElement Register;
	
	@FindBy(linkText="Login")
	private WebElement selectloginoption;
	
	@FindBy(xpath="//i[@class='fa fa-phone']")
	private WebElement PhoneIcon;
	
	@FindBy(xpath="//i[@class='fa fa-heart']")
	private WebElement hearticon;
	
	@FindBy(xpath="//span[text()='Shopping Cart']")
	private WebElement ShoppingCartOption;
	
	@FindBy(xpath="//span[text()='Checkout']")
	private WebElement Cheackout;
	
	@FindBy(xpath="Qafox")
	private WebElement Logo;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	@FindBy(linkText="Logout")
	private WebElement ClickOnLogoutOption;
	
	@FindBy(name="search")
	private WebElement SearchBoxField;
	
	public void EnterTextIntoSearchBoxField(String ProductName)
	{
		elementUtilities.enterTextIntoElement(SearchBoxField, ProductName);
	}
	public String getSearchBoxPlaceholder()
	{
		
		return elementUtilities.getElementDomAttribute(SearchBoxField, "placeholder");
	}
	
	public LogoutPage ClickOnLogoutOption()
	{
		elementUtilities.clickOnElement(ClickOnLogoutOption);
		return new LogoutPage(driver);
	}
	
	public SearchPage ClickOnSearchButton()
	{
		elementUtilities.clickOnElement(searchButton);
		return new SearchPage(driver);
	}
	
	public HomePage selectLogoOption()
	{
		elementUtilities.clickOnElement(Logo);
		return new HomePage(driver);
	}
	
	public ShoppingCartPage SelectCheackOutOption()
	{
		elementUtilities.clickOnElement(Cheackout);
		return new ShoppingCartPage(driver);
	}
	
	public ShoppingCartPage SelectShoppingCartOption()
	{
		elementUtilities.clickOnElement(ShoppingCartOption);
		return new ShoppingCartPage(driver);
	}
	public loginPage HearticonOption()
	{
		elementUtilities.clickOnElement(hearticon);
		return new loginPage(driver);
	}
	
	public ContactUsPage selectphoneicon()
	{
		elementUtilities.clickOnElement(PhoneIcon);
		return new ContactUsPage(driver);
		}
	public loginPage selectLoginOption()
	{
		elementUtilities.clickOnElement(selectloginoption);
		return new loginPage(driver);
	}
	
	public RegisterPage clickOnRegister()
	{
		elementUtilities.clickOnElement(Register);
		return new RegisterPage(driver);
	}
	public void  clickonAccountDropMenu()
	{
		elementUtilities.clickOnElement(AccountDropMenu);
	}

}
