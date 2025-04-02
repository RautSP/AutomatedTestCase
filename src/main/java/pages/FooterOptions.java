package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class FooterOptions extends Root {
	WebDriver driver;
	public FooterOptions(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='About Us']")
	private WebElement AboutusOption;
	
	@FindBy(linkText="Delivery Information")
	private WebElement DeliveryInformation;
	
	@FindBy(linkText="Privacy Policy")
	private WebElement PrivacyPolicy;
	
	@FindBy(linkText="Terms & Conditions")
	private WebElement TermsandConditionsOptions;
	
	@FindBy(linkText="Contact Us")
	private WebElement ContactUsOption;
	
	@FindBy(linkText="Returns")
	private WebElement ReturnsOption;
	
	@FindBy(linkText="Site Map")
	private WebElement SiteMapOption;
	
	@FindBy(linkText="Brands")
	private WebElement BrandsOption;
	
	@FindBy(linkText="Gift Certificates")
	private WebElement GiftCertificatesOption;
	
	@FindBy(linkText="Affiliate")
	private WebElement AffiliateOption;
	
	@FindBy(linkText="Specials")
	private WebElement SpecialsOption;
	
	@FindBy(linkText="My Account")
	private WebElement MyAccountOption;
	
	@FindBy(linkText="Order History")
	private WebElement OrderHistoryOption;
	
	@FindBy(linkText="Wish List")
	private WebElement WishListOption;
	
	@FindBy(linkText="Newsletter")
	private WebElement NewsletterOption;
	
	public loginPage clickOnNewsletterOption()
	{
		elementUtilities.clickOnElement(NewsletterOption);
		return new loginPage(driver);
	}
	
	public loginPage clickOnWishListOption()
	{
		elementUtilities.clickOnElement(WishListOption);
		return new loginPage(driver);
	}
	
	public loginPage clickOnOrderHistoryOption()
	{
		elementUtilities.clickOnElement(OrderHistoryOption);
		return new loginPage(driver);
	}
	
	public loginPage clickOnMyAccountOption()
	{
		elementUtilities.clickOnElement(MyAccountOption);
		return new loginPage(driver);
	}
	
	public SpecialsOptionPage clickOnSpecialsOption()
	{
		elementUtilities.clickOnElement(SpecialsOption);
		return new SpecialsOptionPage(driver);
	}
	
	public AffiliateOptionPage clickOnAffiliateOption()
	{
		elementUtilities.clickOnElement(AffiliateOption);
		return new AffiliateOptionPage(driver);
	}
	
	public GiftCertificatesOptionPage clickOnGiftCertificatesOption()
	{
		elementUtilities.clickOnElement(GiftCertificatesOption);
		return new GiftCertificatesOptionPage(driver);
	}
	
	public BrandsOptionPage clickOnBrandsOption()
	{
		elementUtilities.clickOnElement(BrandsOption);
		return new BrandsOptionPage(driver);
	}
	
	public SiteMapOptionPage clickOnSiteMapOption()
	{
		elementUtilities.clickOnElement(SiteMapOption);
		return new SiteMapOptionPage(driver);
	}
	
	
	public ReturnsOptionPage clickOnReturnsOption()
	{
		elementUtilities.clickOnElement(ReturnsOption);
		return new ReturnsOptionPage(driver);
	}
	
	public ContactUsPage clickOnContactUsOption()
	{
		elementUtilities.clickOnElement(ContactUsOption);
		return new ContactUsPage(driver);
	}
	
	public TermsandConditionsOptions clickOnTermsandConditionsOptions()
	{
		elementUtilities.clickOnElement(TermsandConditionsOptions);
		return new TermsandConditionsOptions(driver);
	}
	
	public PrivacyPolicyPage1 clickOnPrivacyPolicy()
	{
		elementUtilities.clickOnElement(PrivacyPolicy);
		return new PrivacyPolicyPage1(driver);
	}
	
	public DeliveryInformationPage ClickOnDeliveryInformation()
	{
		elementUtilities.clickOnElement(DeliveryInformation);
		return new DeliveryInformationPage(driver);
	}
	public AboutUsPage ClickOnAboutUsOption()
	{
		elementUtilities.clickOnElement(AboutusOption);
		return new AboutUsPage(driver);
	}

}
