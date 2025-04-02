package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import pages.AboutUsPage;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.AffiliateOptionPage;
import pages.BrandsOptionPage;
import pages.CheackOutPage;
import pages.ContactUsPage;
import pages.DeliveryInformationPage;
import pages.FooterOptions;
import pages.ForGotPasswordPage;
import pages.GiftCertificatesOptionPage;
import pages.HeaderOptions;
import pages.HomePage;
import pages.LogoutPage;
import pages.NewsLetterPage;
import pages.PrivacyPolicyPage1;
import pages.ProductDisplayPage;
import pages.ProoductComparePage;
import pages.RegisterPage;
import pages.ReturnsOptionPage;
import pages.RightColumnOptions;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.SiteMapOptionPage;
import pages.SpecialsOptionPage;
import pages.TermsandConditionsOptions;
import pages.loginPage;
import utility.CommonUtilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public String browserName; 

	public HeaderOptions headerOptions;
	public RegisterPage registerPage;
	public AccountSuccessPage accountSuccessPage;
	public NewsLetterPage newsletterPage;
	public AccountPage accountpage;
	public loginPage loginpage;
	public RightColumnOptions rightcolumnoptions;
	public ContactUsPage contactuspage;
	public ShoppingCartPage ShoppingcartPage;
	public CheackOutPage cheackoutpage;
	public HomePage homepage;
	public SearchPage searchpage;
	public ForGotPasswordPage forgotpasswordpage;
	public FooterOptions footeroptions ;
	public AboutUsPage AboutUsPage ;
	public DeliveryInformationPage DeliveryInformationPage;
	public PrivacyPolicyPage1 PrivacyPolicyPage;
	public TermsandConditionsOptions TermsandConditionsOptions ;
	public ReturnsOptionPage ReturnsOptionPage;
	public SiteMapOptionPage SiteMapOptionPage;
	public BrandsOptionPage BrandsOptionPage;
	public GiftCertificatesOptionPage GiftCertificatesOptionPage;
	public AffiliateOptionPage AffiliateOptionPage ;
	public SpecialsOptionPage SpecialsOptionPage;
	public Actions actions;
	public LogoutPage LogoutPage;
	public ProductDisplayPage productdisplaypage;
	public ProoductComparePage productcomparepage;
	
	public void CloseBrowser(WebDriver driver)
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	public WebDriver  OpenBrowserAndAppURl()
	{
		prop=CommonUtilities.loadPropertiesFile();
		browserName = prop.getProperty("browserName");

			if (browserName.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equals("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equals("internetexplorer")) {
				driver = new InternetExplorerDriver();
			} else if (browserName.equals("safari")) {
				driver = new SafariDriver();
			}
			  //driver= new ChromeDriver();
	          driver.manage().window().maximize();
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	         
	          driver.get(prop.getProperty("appURL"));
	          return driver;
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void navigateBackInBrowser(WebDriver driver) {
		driver.navigate().back();
	}
	public void refreshpage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public Actions GetAction(WebDriver driver)
	{
		actions=new Actions(driver);
		return actions;
	}
	public Actions clickkeyboardkeymultipletime(Actions actions,Keys Keyname,int nooftimes)
	{
		
		for(int i=0;i<=nooftimes;i++)
		{
			actions.sendKeys(Keyname).perform();	
			
		}
		   return actions;
	}
	public Actions typeTextUsingActions(Actions actions,String text) 
	{
		actions.sendKeys(text).perform();
		return actions;
	}
	

}
