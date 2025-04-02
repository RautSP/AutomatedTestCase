package register;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.HeaderOptions;
import pages.LogoutPage;
import utility.CommonUtilities;

public class LoginTestCases extends Base {
	WebDriver driver;
	@AfterMethod
	public void teardown()
	{
		CloseBrowser(driver);
	}
	@BeforeMethod
	public void Setup()
	{  
		  driver = OpenBrowserAndAppURl();
		  headerOptions = new HeaderOptions(driver);
		  headerOptions.clickonAccountDropMenu();
		  loginpage = headerOptions.selectLoginOption();
	}
	
	@Test(priority=1)
	public void VerifyLoggingIntoApllicationUsingValidCredientials()
	{
	Assert.assertTrue(loginpage.Didwenavigateonloginpage());
	loginpage.EnterEmailData(prop.getProperty("existingEmail"));
	loginpage.EnterPasswordData(prop.getProperty("validPassword"));
	accountpage = loginpage.clickonLoginButton();
	Assert.assertTrue(accountpage.didwenavigateonmyaccountpage());
	}
	
	@Test(priority=2)
	public void VerifyLoggingIntoApllicationUsingInValidCredientials()
	{
		loginpage.EnterEmailData(CommonUtilities.generateBrandNewEmail());
		loginpage.EnterPasswordData(prop.getProperty("mismatchingPassword"));
		loginpage.clickonLoginButton();
		String ExpectedResult="Warning: No match for E-Mail Address and/or Password.";
       Assert.assertEquals(loginpage.PageLevelWarningmsg(), ExpectedResult);	
	}
	@Test(priority=3)
	public void VerifyLoggingIntoApplicationUsingInValidEmailAndvalidPassword()
	{
		loginpage.EnterEmailData(CommonUtilities.generateBrandNewEmail());
		loginpage.EnterPasswordData(prop.getProperty("validPassword"));
		loginpage.clickonLoginButton();
		String ExpectedResult="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginpage.PageLevelWarningmsg(), ExpectedResult);	
        }
    
    @Test(priority=4)
    public void VerifyApplicationUsingValidEmailAndInvalidPAssword()
    {
    	loginpage.EnterEmailData(prop.getProperty("existingEmail"));
		loginpage.EnterPasswordData(prop.getProperty("mismatchingPassword"));
		loginpage.clickonLoginButton();
		String ExpectedResult="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginpage.PageLevelWarningmsg(), ExpectedResult);	

    }
    @Test(priority=5)
    public void verifyLoggingIntoApplicationWithoutProvidingAnyCredientials()
    {
    	
		loginpage.clickonLoginButton();
		String ExpectedResult="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginpage.PageLevelWarningmsg(), ExpectedResult);	
    }
    @Test(priority=6)
    public void VerifyForgottonPasswordLinkIsAvailableAndItWorks()
    {
    	Assert.assertTrue(loginpage.ForGottonPAsswordlinkispresent());
    	forgotpasswordpage=loginpage.clickOnForgotPasswordlink();
    	Assert.assertTrue(forgotpasswordpage.didWeNavigateToForgottenPasswordPage());
    }
    @Test(priority=7)
    public void VerifyLoggingIntoApplicationUsingKeyboardKeys()
    {
    	actions = clickkeyboardkeymultipletime(GetAction(driver), Keys.TAB, 22);
		actions = typeTextUsingActions(actions, prop.getProperty("existingEmail"));
		actions = clickkeyboardkeymultipletime(actions, Keys.TAB, 1);
		actions = typeTextUsingActions(actions, prop.getProperty("validPassword"));
		actions = clickkeyboardkeymultipletime(actions, Keys.TAB, 1);
		actions = clickkeyboardkeymultipletime(actions, Keys.ENTER, 1);
		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.didwenavigateonmyaccountpage());
    }
    @Test(priority=8)
    public void VerifyEMailAddressandpasswordtextfieldsintheLoginpagehavetheplaceholdertext()
    {
    	Assert.assertEquals(loginpage.getEmailPlaceholder(), "E-mail");
    	Assert.assertEquals(loginpage.getPasswordPlaceholder(), "password");
    }
    @Test(priority=9)
    public void VerifyBrowsingBackAfterlogin()
    {
    	loginpage.EnterEmailData(prop.getProperty("existingEmail"));
    	loginpage.EnterPasswordData(prop.getProperty("validPassword"));
    	accountpage = loginpage.clickonLoginButton();
    	navigateBackInBrowser(accountpage.getDriver());
    	refreshpage(accountpage.getDriver());
    	Assert.assertTrue(accountpage.didwenavigateonmyaccountpage());

    }
    @Test(priority=10)
    public void VerifyBrowsingBackAfterLogOut()
    {
        accountpage=loginpage.LoginIntoApplication(prop.getProperty("existingEmail"),prop.getProperty("validPassword"));
    	headerOptions=accountpage.getHeaderOptions();
    	LogoutPage = headerOptions.ClickOnLogoutOption();
    	navigateBackInBrowser(LogoutPage.getDriver());
    	refreshpage(LogoutPage.getDriver());
    	loginpage=LogoutPage.getloginpage();
    	Assert.assertTrue(loginpage.Didwenavigateonloginpage());
    	}
    @Test(priority=11)
    public void VerifyLoginIntoApplicationUsingInactiveCredientials()
    {
        accountpage=loginpage.LoginIntoApplication(prop.getProperty("InactiveEmail"),prop.getProperty("validPassword"));
        String ExpectedResult="Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginpage.PageLevelWarningmsg(), ExpectedResult);
    }
    @Test(priority=12)
    public void Verifynumberofunsuccessfulattempts()
    {
    	String InvalidEmail=CommonUtilities.generateBrandNewEmail();
       loginpage.LoginIntoApplication(InvalidEmail,prop.getProperty("validPassword"));
       loginpage.LoginIntoApplication(InvalidEmail,prop.getProperty("validPassword"));
       loginpage.LoginIntoApplication(InvalidEmail,prop.getProperty("validPassword"));
       loginpage.LoginIntoApplication(InvalidEmail,prop.getProperty("validPassword"));
       loginpage.LoginIntoApplication(InvalidEmail,prop.getProperty("validPassword"));

       loginpage.LoginIntoApplication(InvalidEmail,prop.getProperty("validPassword"));
       String ExpectedResult="Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
       
       Assert.assertEquals(loginpage.PageLevelWarningmsg(), ExpectedResult);
    }
    @Test(priority=13)
    public void VerifyPasswordFieldIsToggled()
    {
        Assert.assertEquals(loginpage.getPasswordFieldDomAttribute("type"), "password");

    }
    @Test(priority=14)
    public void VerifyCopyingofthetestfrompasswordfield()
    {
    	loginpage.EnterPasswordData(prop.getProperty("validPassword"));
    	loginpage.CopyTestFromPAsswordField();
    	loginpage.pasteTextintoemailfield();
    	loginpage.clickonLoginButton();
    	Assert.assertNotEquals(loginpage.getPastedThingsfromemailfield(), prop.getProperty("validPassword"));
    }
    @Test(priority=15)
    public void VerifyLoginpagenavigations()
    {
    	headerOptions=loginpage.getHeaderOptions();
    	contactuspage=headerOptions.selectphoneicon();   	
    	Assert.assertTrue(getPageTitle(headerOptions.getDriver()).equals("Contact Us"));
  	    navigateBackInBrowser(headerOptions.getDriver());
  	    
		loginpage=headerOptions.HearticonOption();
  	    Assert.assertEquals(getPageTitle(loginpage.getDriver()),"Account Login");
    	
  	  ShoppingcartPage = headerOptions.SelectShoppingCartOption();
	  Assert.assertEquals(getPageTitle(ShoppingcartPage.getDriver()),"Shopping Cart");
	  navigateBackInBrowser(ShoppingcartPage.getDriver());
	  
	  ShoppingcartPage=headerOptions.SelectCheackOutOption();
	  Assert.assertTrue(getPageTitle(ShoppingcartPage.getDriver()).equals("Shopping Cart"));
	  navigateBackInBrowser(ShoppingcartPage.getDriver());
	  
	 //headerOptions.selectLogoOption();
	 // Assert.assertEquals(getPageTitle(homepage.getDriver()), "Qafox");
	 // navigateBackInBrowser(homepage.getDriver());
	  
	  searchpage=headerOptions.ClickOnSearchButton();
	  Assert.assertEquals(getPageTitle(searchpage.getDriver()), "Search");
	  navigateBackInBrowser(searchpage.getDriver()); 
	  
	 // Assert.assertEquals(getPageTitle(homepage.getDriver()), "Your Store");
	  //navigateBackInBrowser(homepage.getDriver()); 
	  
	  loginpage= headerOptions.selectAccountBreadCrumb();
      Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
      navigateBackInBrowser(loginpage.getDriver()); 
      
      rightcolumnoptions= loginpage.getRightColumnOptions();
	     registerPage= rightcolumnoptions.clickOnRegisterOption();
	     Assert.assertEquals(getPageTitle(registerPage.getDriver()), "Register Account");
	     
	     loginpage=rightcolumnoptions.clickOnLoginOption();
	     Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	     navigateBackInBrowser(loginpage.getDriver()); 
	     
	    forgotpasswordpage = rightcolumnoptions.clickOnforgotpassword();
	    Assert.assertEquals(getPageTitle(forgotpasswordpage.getDriver()), "Forgot Your Password?");
	    navigateBackInBrowser(forgotpasswordpage.getDriver()); 
	    
	    loginpage= rightcolumnoptions.clickOnMyaccount();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	   
	    loginpage= rightcolumnoptions.clickOnAddressBook();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	    
	    loginpage=rightcolumnoptions.clickOnWishList();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	    
	    loginpage=rightcolumnoptions.clickOnOrderHistory();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	    
	    loginpage=rightcolumnoptions.clickOnDownlods();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	   
	    loginpage=rightcolumnoptions.clickOnRecurringPayments();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	   
	    loginpage=rightcolumnoptions.clickOnRewardPoints();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	    
	    loginpage=rightcolumnoptions.clickOnReturns();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	    
	    loginpage=rightcolumnoptions.clickOnTransaction();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
	    
	    loginpage=rightcolumnoptions.clickOnNewsLetter();
	    Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	    navigateBackInBrowser(loginpage.getDriver());
		 footeroptions = loginpage.getFooterOptions();
		 AboutUsPage = footeroptions.ClickOnAboutUsOption();
		 Assert.assertEquals(getPageTitle(AboutUsPage.getDriver()), "About Us");
		 navigateBackInBrowser(AboutUsPage.getDriver());
		 
		DeliveryInformationPage = footeroptions.ClickOnDeliveryInformation();
		Assert.assertEquals(getPageTitle(DeliveryInformationPage.getDriver()), "Delivery Information");
		navigateBackInBrowser(DeliveryInformationPage.getDriver());
		
		PrivacyPolicyPage = footeroptions.clickOnPrivacyPolicy();
	    Assert.assertEquals(getPageTitle(PrivacyPolicyPage.getDriver()), "Register Account");
		navigateBackInBrowser(PrivacyPolicyPage.getDriver());
		
	    TermsandConditionsOptions = footeroptions.clickOnTermsandConditionsOptions();
	    Assert.assertEquals(getPageTitle(TermsandConditionsOptions.getDriver()), "Terms & Conditions");
	  	navigateBackInBrowser(TermsandConditionsOptions.getDriver());
	  	
	  	contactuspage=footeroptions.clickOnContactUsOption();
	  	Assert.assertEquals(getPageTitle(contactuspage.getDriver()), "Contact Us");
	   	navigateBackInBrowser(contactuspage.getDriver());

	  //  ReturnsOptionPage = footeroptions.clickOnReturnsOption();
		//Assert.assertEquals(getPageTitle(ReturnsOptionPage.getDriver()), "Product Returns");
	   	//vigateBackInBrowser(ReturnsOptionPage.getDriver());
		   
	    SiteMapOptionPage = footeroptions.clickOnSiteMapOption();
	    Assert.assertEquals(getPageTitle(SiteMapOptionPage.getDriver()), "Site Map");
	   	navigateBackInBrowser(SiteMapOptionPage.getDriver());
	   	
	    BrandsOptionPage = footeroptions.clickOnBrandsOption();
	    Assert.assertEquals(getPageTitle(BrandsOptionPage.getDriver()), "Find Your Favorite Brand");
	   	navigateBackInBrowser(BrandsOptionPage.getDriver());
	   	
	   	GiftCertificatesOptionPage = footeroptions.clickOnGiftCertificatesOption();
	   	Assert.assertEquals(getPageTitle(GiftCertificatesOptionPage.getDriver()), "Purchase a Gift Certificate");
	   	navigateBackInBrowser(GiftCertificatesOptionPage.getDriver());
	   	
	   	AffiliateOptionPage = footeroptions.clickOnAffiliateOption();
	   	Assert.assertEquals(getPageTitle(AffiliateOptionPage.getDriver()), "Affiliate Program");
	   	navigateBackInBrowser(AffiliateOptionPage.getDriver());
	   	
	    SpecialsOptionPage = footeroptions.clickOnSpecialsOption();
		Assert.assertEquals(getPageTitle(SpecialsOptionPage.getDriver()), "Special Offers");
	   	navigateBackInBrowser(SpecialsOptionPage.getDriver());
	   	
	   	//loginpage=footeroptions.clickOnMyAccountOption();
	   	//Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Your Store");
	   	//navigateBackInBrowser(loginpage.getDriver());
	   	
	   //	loginpage=footeroptions.clickOnOrderHistoryOption();
		//Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Your Store");
	   //	navigateBackInBrowser(loginpage.getDriver());
	   	
	   	loginpage=footeroptions.clickOnWishListOption();
	   	Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	   	navigateBackInBrowser(loginpage.getDriver());
	   	
	   	loginpage=footeroptions.clickOnNewsletterOption();
	   	Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
	   	navigateBackInBrowser(loginpage.getDriver());

	}
    @Test(priority=16)
    public void Verifyveriouswaysofloginintoapplication() {
    	Assert.assertTrue(loginpage.Didwenavigateonloginpage());
    	rightcolumnoptions=loginpage.getRightColumnOptions();
    	rightcolumnoptions.clickOnloginoption();
    	Assert.assertTrue(loginpage.Didwenavigateonloginpage());
    	registerPage=loginpage.clickOnContinueButton();
    	loginpage=registerPage.selectloginoption();
    	Assert.assertTrue(loginpage.Didwenavigateonloginpage());
    }
    @Test(priority=17)
    public void verifybreadcrumbpageheadingpagetitleofloginfunctionality()
    {
    	Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Account Login");
		Assert.assertEquals(getPageURL(loginpage.getDriver()), prop.getProperty("loginPageURL"));
		Assert.assertTrue(loginpage.Didwenavigateonloginpage());
		Assert.assertEquals(loginpage.getfirstheading(), "New Customer");
		Assert.assertEquals(loginpage.getsecondheading(), "Returning Customer");

    }

    


    
}