package register;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
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
import pages.NewsLetterPage;
import pages.PrivacyPolicyPage1;
import pages.RegisterPage;
import pages.ReturnsOptionPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.SiteMapOptionPage;
import pages.SpecialsOptionPage;
import pages.TermsandConditionsOptions;
import pages.loginPage;
//pimport pages.PrivacyPolicyPage1;
import pages.RightColumnOptions;
import utility.CommonUtilities;



public class RegisterTestCases extends Base {
	WebDriver driver;
	
	@AfterMethod
	public void teardown()
	{
		CloseBrowser(driver);
	}
	@BeforeMethod
	public void Setup()
	{  
		  driver=OpenBrowserAndAppURl();
          headerOptions=new HeaderOptions(driver);
          headerOptions.clickonAccountDropMenu();
          registerPage=headerOptions.clickOnRegister();
	}
    @Test(priority=1)
	public  void RegisterWithMandatoryfields() {
          
      
    	registerPage.FirstNameField(prop.getProperty("firstName"));
    	registerPage.LastNameField(prop.getProperty("lastName"));
        registerPage.EmailField(CommonUtilities.generateBrandNewEmail());
        registerPage.Telephone(prop.getProperty("telephoneNumber"));
        registerPage.passwordfield(prop.getProperty("validPassword"));
        registerPage.ConfirmPasswordField(prop.getProperty("validPassword"));
        registerPage.SubScribeNewsletter();
        registerPage.PrivacyPolicy();
        accountSuccessPage=registerPage.ContinueButton();
  		
  		//String ExpectedHeading="Your Account Has Been Created!";
        Assert.assertTrue(accountSuccessPage.Logout());
	    Assert.assertTrue(accountSuccessPage.SuccessOption());
  		
  		
  		
  		String ExpextedTextOne="Congratulations! Your new account has been successfully created!";
  		String ExpectedTexttwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";
  		String ExpextedTextthree="If you have ANY questions about the operation of this online shop, please e-mail the store owner";

  		String ExpextedTextfour="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
  		String ExpextedTextfive=" contact us";
  		
  		Assert.assertTrue(accountSuccessPage.getcontent().contains(ExpextedTextOne));
  		Assert.assertTrue(accountSuccessPage.getcontent().contains(ExpectedTexttwo));
  		Assert.assertTrue(accountSuccessPage.getcontent().contains(ExpextedTextthree));
  		Assert.assertTrue(accountSuccessPage.getcontent().contains(ExpextedTextfour));
  		Assert.assertTrue(accountSuccessPage.getcontent().contains(ExpextedTextfive));
  		
  		accountpage=accountSuccessPage.ClickOnContinueButton();
  		accountpage.didwenavigateonmyaccountpage();
  		

    }
    @Test(priority=2)
	public void verifyRegisterAccountWithAllFields() {
		
    	registerPage.FirstNameField(prop.getProperty("firstName"));
    	registerPage.LastNameField(prop.getProperty("lastName"));
    	registerPage.EmailField(CommonUtilities.generateBrandNewEmail());
    	registerPage.Telephone(prop.getProperty("telephoneNumber"));
    	registerPage.passwordfield(prop.getProperty("validPassword"));
    	registerPage.ConfirmPasswordField(prop.getProperty("validPassword"));
    	registerPage.SubScribeNewsletter();
    	registerPage.PrivacyPolicy();
        accountSuccessPage=registerPage.ContinueButton();
        
		Assert.assertTrue(accountSuccessPage.Logout());
	    Assert.assertTrue(accountSuccessPage.SuccessOption());
	    
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";
		
		Assert.assertTrue(accountSuccessPage.getcontent().contains(expectedProperDetailsOne));
		Assert.assertTrue(accountSuccessPage.getcontent().contains(expectedProperDetailsTwo));
		Assert.assertTrue(accountSuccessPage.getcontent().contains(expectedProperDetailsThree));
		Assert.assertTrue(accountSuccessPage.getcontent().contains(expectedProperDetailsFour));
		Assert.assertTrue(accountSuccessPage.getcontent().contains(expectedProperDetailsFive));
		Assert.assertTrue(accountSuccessPage.getcontent().contains(expectedProperDetailsSix));
		
		accountpage=accountSuccessPage.ClickOnContinueButton();		
		
		accountpage.didwenavigateonmyaccountpage();
	
	}
   
    	@Test(priority=3)
    	public void ToVerifyProrperMsgsdisplayesWhilenodataprovide() {
    		
            registerPage.ContinueButton();

    		String ExpectedTextOne="First Name must be between 1 and 32 characters!";
    		String ExpectedTextTwo="Last Name must be between 1 and 32 characters!";
    		String ExpectedTextThree="E-Mail Address does not appear to be valid!";
    		String ExpectedTextFour="Telephone must be between 3 and 32 characters!";
    		String ExpectedTextFive="Password must be between 4 and 20 characters!";
    		String ExpectedTextSix="Warning: You must agree to the Privacy Policy!";
    		
    		Assert.assertEquals(registerPage.FirstNameWarningmsg(),ExpectedTextOne);
    		Assert.assertEquals(registerPage.LastNameWarningmsg(), ExpectedTextTwo);
    		Assert.assertEquals(registerPage.EmailFieldWarningmsg(), ExpectedTextThree);
    		Assert.assertEquals(registerPage.Telephonewarningmsg(), ExpectedTextFour);
    		Assert.assertEquals(registerPage.PasswordWarningmsg(), ExpectedTextFive);
    		Assert.assertEquals(registerPage.PageLevelWarningmsg(), ExpectedTextSix);
    		
}
    	@Test(priority=4)
    	public void VerifyingRegisterAccountBySubcribeNewsletter()
    	{
    		
    		

        	registerPage.FirstNameField(prop.getProperty("firstName"));
        	registerPage.LastNameField(prop.getProperty("lastName"));
        	registerPage.EmailField(CommonUtilities.generateBrandNewEmail());
        	registerPage.Telephone(prop.getProperty("telephoneNumber"));
        	registerPage.passwordfield(prop.getProperty("validPassword"));
        	registerPage.ConfirmPasswordField(prop.getProperty("validPassword"));
        	registerPage.SubScribeNewsletter();
        	registerPage.PrivacyPolicy();
            accountSuccessPage=registerPage.ContinueButton();
            
    		Assert.assertTrue(accountSuccessPage.Logout());
    	    Assert.assertTrue(accountSuccessPage.SuccessOption());
    	    accountpage =accountSuccessPage.ClickOnContinueButton();
    	    newsletterPage=accountpage.subunsubNewsLetterOption();
    	    Assert.assertTrue(newsletterPage.didWeNavigateToNewsletterPage());
    		Assert.assertTrue(newsletterPage.isYesNewsletterOptionIsInSelectedState());
    	}
    	@Test(priority=5)
    	public void verifyRegisteringAccountBySayingNoToNewsletter() {
    		
    		
    		registerPage.FirstNameField(prop.getProperty("firstName"));
        	registerPage.LastNameField(prop.getProperty("lastName"));
        	registerPage.EmailField(CommonUtilities.generateBrandNewEmail());
        	registerPage.Telephone(prop.getProperty("telephoneNumber"));
        	registerPage.passwordfield(prop.getProperty("validPassword"));
        	registerPage.ConfirmPasswordField(prop.getProperty("validPassword"));
        	registerPage.nonewsletterbox();
        	registerPage.PrivacyPolicy();
        	accountSuccessPage=registerPage.ContinueButton();
        	accountpage=accountSuccessPage.ClickOnContinueButton();
        	newsletterPage=accountpage.subunsubNewsLetterOption();
    		
    		Assert.assertTrue(newsletterPage.didWeNavigateToNewsletterPage());
    		Assert.assertTrue(newsletterPage.isNoNewsletterOptionIsInSelectedState());
    		
    	}
        @Test(priority=6)
    	public void NavigatetoDifferentPages()
    	{
    		
    		
    		Assert.assertTrue(registerPage.didwenavigateonregisterpage());

    		
    		
    		headerOptions.clickonAccountDropMenu();
    		loginpage = headerOptions.selectLoginOption();
    		registerPage = loginpage.clickOnContinueButton();
    		Assert.assertTrue(registerPage.didwenavigateonregisterpage());
    		headerOptions = registerPage.getHeaderOptions();
    		headerOptions.clickonAccountDropMenu();
    		loginpage = headerOptions.selectLoginOption();
    		rightcolumnoptions  = loginpage.getRightColumnOptions();
    		registerPage = rightcolumnoptions.clickOnRegisterOption();
    		Assert.assertTrue(registerPage.didwenavigateonregisterpage());


    		}
    	@Test(priority=7)
    	public void VerifyimgRegisteringAccountByEnteringDifferentPAssword()
    	{

    		registerPage.FirstNameField(prop.getProperty("firstName"));
        	registerPage.LastNameField(prop.getProperty("lastName"));
        	registerPage.EmailField(CommonUtilities.generateBrandNewEmail());
        	registerPage.Telephone(prop.getProperty("telephoneNumber"));
        	registerPage.passwordfield(prop.getProperty("validPassword"));
        	registerPage.ConfirmPasswordField(prop.getProperty("mismatchingPassword"));
        	registerPage.nonewsletterbox();
        	registerPage.PrivacyPolicy();
        	registerPage.ContinueButton();
      		String Expectedresult="Password confirmation does not match password!";
      				
            Assert.assertEquals(registerPage.Passwordconfirmationwarning(),Expectedresult);		
      	
     
    	}
    	@Test(priority=8)
    	public void VerifyRgeisteringaccountByFillinigExistingFunctionality()
    	{
    		registerPage.FirstNameField(prop.getProperty("firstName"));
        	registerPage.LastNameField(prop.getProperty("lastName"));
        	registerPage.EmailField(prop.getProperty("existingEmail"));
        	registerPage.Telephone(prop.getProperty("telephoneNumber"));
        	registerPage.passwordfield(prop.getProperty("validPassword"));
        	registerPage.ConfirmPasswordField(prop.getProperty("mismatchingPassword"));
        	registerPage.nonewsletterbox();
        	registerPage.PrivacyPolicy();
        	registerPage.ContinueButton();
    	    String ExpectedWarning="Warning: E-Mail Address is already registered!";
    		Assert.assertEquals(registerPage.PageLevelWarningmsg(), ExpectedWarning );
    		
}
    
    		@Test(priority=9)
    		public void verifyRegisteringAccountUsingInvalidEmail() throws InterruptedException, IOException {
    			
    	   registerPage.FirstNameField(prop.getProperty("firstName"));
           registerPage.LastNameField(prop.getProperty("lastName"));
           registerPage.EmailField(prop.getProperty("invalidEmailOne"));
           registerPage.Telephone(prop.getProperty("telephoneNumber"));
       	   registerPage.passwordfield(prop.getProperty("validPassword"));
       	   registerPage.ConfirmPasswordField(prop.getProperty("validPassword"));
           registerPage.nonewsletterbox();
           registerPage.PrivacyPolicy();
           registerPage.ContinueButton();
    	   Thread.sleep(3000);
    	   String ExpectedWarningmsg="Please include an '@' in the email address. 'amotoori' is missing an '@'.";
    	   String ActualWarningmsg=registerPage.getemailvalidationmsg();		
    	   Assert.assertEquals(ActualWarningmsg, ExpectedWarningmsg);
    		   
    		registerPage.clearemailfield(); 
    		registerPage.EmailField(prop.getProperty("invalidEmailTwo"));
    		registerPage.ContinueButton();
    			
    		String ExpectedWarningmsg1="Please enter a part following '@'. 'amotoori@' is incomplete.";
    		String ActualWarningmsg1=registerPage.getemailvalidationmsg();		
    		Assert.assertEquals(ActualWarningmsg1, ExpectedWarningmsg1);

    		registerPage.clearemailfield(); 
    		registerPage.EmailField(prop.getProperty("invalidEmailThree"));
    		registerPage.ContinueButton();
    		String ExpectedWarningmsg3="'.' is used at a wrong position in 'gmail.'.";
    		String ActualWarningmsg3=registerPage.getemailvalidationmsg();		
    	    Assert.assertEquals(ActualWarningmsg3, ExpectedWarningmsg3);
    	        
    	       }
    		@Test(priority=10)
    		public void verifyRegisteringAccountUsingKeyboardKeys() {
    					
    					
    		actions = clickkeyboardkeymultipletime(GetAction(driver),Keys.TAB,23);
    		actions = typeTextUsingActions(actions,prop.getProperty("firstName"));
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,1);
    		actions = typeTextUsingActions(actions,prop.getProperty("lastName"));
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,1);
    		actions = typeTextUsingActions(actions,CommonUtilities.generateBrandNewEmail());
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,1);
    		actions = typeTextUsingActions(actions,prop.getProperty("telephoneNumber"));
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,1);
    		actions = typeTextUsingActions(actions,prop.getProperty("validPassword"));
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,1);
    		actions = typeTextUsingActions(actions,prop.getProperty("validPassword"));
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,1);
    		actions = clickkeyboardkeymultipletime(actions,Keys.ARROW_LEFT,1);
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,2);
    		actions = clickkeyboardkeymultipletime(actions,Keys.SPACE,1);
    		actions = clickkeyboardkeymultipletime(actions,Keys.TAB,1);
    		clickkeyboardkeymultipletime(actions,Keys.ENTER,1);
    		
    		rightcolumnoptions = registerPage.getRightColumnOptions();
    		//Assert.assertTrue(rightcolumnoptions.didWeGetLoggedIn());
             //accountSuccessPage = rightcolumnoptions.getAccountSuccessPage();
    		Assert.assertTrue(accountSuccessPage.didWeNavigateToMyAccountPage());

    				}

            @Test(priority=11)
    		public void verifyRegisterAccountPagePlaceholders() {
    		String expectedFirstNamePlaceHolder = "First Name";
    		String expectedLastNamePlaceHolder = "Last Name";
    		String expectedEmailPlaceHolder = "E-Mail";
    		String expectedTelephonePlaceHolder = "Telephone";
    		String expectedPasswordPlaceHolder = "Password";
        	String expectedPasswordConfirmPlaceHolder = "Password Confirm";
    						
    		Assert.assertEquals(registerPage.getfirstnamefieldPlaceholder(), expectedFirstNamePlaceHolder);
    		Assert.assertEquals(registerPage.getlastnamefieldPlaceholder(), expectedLastNamePlaceHolder);
    		Assert.assertEquals(registerPage.getemailfieldPlaceholder(), expectedEmailPlaceHolder);
    		Assert.assertEquals(registerPage.gettelephonefieldPlaceholder(), expectedTelephonePlaceHolder);
    		Assert.assertEquals(registerPage.getpasswordfieldPlaceholder(), expectedPasswordPlaceHolder);
    		Assert.assertEquals(registerPage.getconfirmpasswordfieldPlaceholder(), expectedPasswordConfirmPlaceHolder);
    						
                       }
                       	
        	/*@Test(priority=12 ,enabled=false)
             public void verifyMandatoryFieldsInRegisterAccountPage() {
                       		
                       		
             String expectedContent = "\"* \"";
             String expectedColor = "rgb(255, 0, 0)";
                       		
             WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
             WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
             WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
             WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
             WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
             WebElement passwordConfirmLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
             WebElement privacyPolicyLabel = driver.findElement(By.cssSelector("div[class='pull-right']"));
                       		
             JavascriptExecutor jse = (JavascriptExecutor)driver;
             String fistNameLabelContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",firstNameLabel);
             Assert.assertEquals(fistNameLabelContent,expectedContent);
             String fistNameLabelColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", firstNameLabel);
             Assert.assertEquals(fistNameLabelColor, expectedColor);
                       		
             String lastNameLabelContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",lastNameLabel);
             Assert.assertEquals(lastNameLabelContent,expectedContent);
             String lastNameLabelColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", lastNameLabel);
             Assert.assertEquals(lastNameLabelColor, expectedColor);
                       		 
             String emailLabelContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",emailLabel);
             Assert.assertEquals(emailLabelContent,expectedContent);
             String emailLabelColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", emailLabel);
             Assert.assertEquals(emailLabelColor, expectedColor);
                       		 
             String telephoneLabelContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",telephoneLabel);
             Assert.assertEquals(telephoneLabelContent,expectedContent);
             String telephoneLabelColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", telephoneLabel);
             Assert.assertEquals(telephoneLabelColor, expectedColor);
                       		
             String passwordLabelContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",passwordLabel);
             Assert.assertEquals(passwordLabelContent,expectedContent);
             String passwordLabelColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", passwordLabel);
             Assert.assertEquals(passwordLabelColor, expectedColor);
                       		 
             String passwordConfirmLabelContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",passwordConfirmLabel);
             Assert.assertEquals(passwordConfirmLabelContent,expectedContent);
             String passwordConfirmLabelColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", passwordConfirmLabel);
             Assert.assertEquals(passwordConfirmLabelColor, expectedColor);
                       		 
             String privacyPolicyLabelContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');",privacyPolicyLabel);
             Assert.assertEquals(privacyPolicyLabelContent,expectedContent);
             String privacyPolicyLabelColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", privacyPolicyLabel);
             Assert.assertEquals(privacyPolicyLabelColor, expectedColor);
                       		
                       		
        	}*/
           /* @Test(dataProvider="userdata",priority=22)
             public void VerifyRegisterAccountUsingPasswordWhichDoesNotFollowPasswordComplexityStandard(String userdata) {
                    		 
                    		
            driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("reva");
            driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("raut");

            driver.findElement(By.id("input-telephone")).sendKeys("1234567");
            driver.findElement(By.id("input-email")).sendKeys(CommonUtilities.generateBrandNewEmail());
            driver.findElement(By.id("input-password")).sendKeys("userdata");
            driver.findElement(By.id("input-confirm")).sendKeys("userdata");
            driver.findElement(By.xpath("//*[text()='Yes']"));
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
                    		
            String ExpectedWarningMassage="User Should Have To Follow Password Complexity";
                    		
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), ExpectedWarningMassage);
                    		
                 }
            @DataProvider(name="userdata")
            public Object[][] createData() {
             	return new Object[][] { 
             {"12345"}, {"Abc2123"}, {"AsweQw@@"} };
                    	}*/
            @Test(priority=13)
            public void verifyHeightWidthNumberOfCharacters() {
                    		
            String expectedHeight = "34px";
            String expectedWidth = "701.25px";
                    	
            //First Name Field check
                    		
            WebElement firstNameField = registerPage.getfirstnamefieldElement();
            String actualFirstNameFieldHeight = firstNameField.getCssValue("height");
            Assert.assertEquals(actualFirstNameFieldHeight, expectedHeight);
            String actualFirstNameWidth = firstNameField.getCssValue("width");
            Assert.assertEquals(actualFirstNameWidth, expectedWidth);
                    		
            String exptectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
            registerPage.getcontinuebuttonfieldelement();
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), exptectedFirstNameWarning);
            firstNameField = driver.findElement(By.id("input-firstname"));
           	firstNameField.sendKeys("a");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            boolean firstNameWarningStatus = false;
            try {
              firstNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed();
                }catch(NoSuchElementException e) {
            firstNameWarningStatus = false;
                    		}
            Assert.assertFalse(firstNameWarningStatus);
            firstNameField = driver.findElement(By.id("input-firstname"));
            firstNameField.clear();
            firstNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeab");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            firstNameWarningStatus = false;
            try {
            firstNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).isDisplayed();
             }catch(NoSuchElementException e) {
             firstNameWarningStatus = false;
                }
             Assert.assertFalse(firstNameWarningStatus);
             firstNameField = driver.findElement(By.id("input-firstname"));
             firstNameField.clear();
             firstNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeabc");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), exptectedFirstNameWarning);
                    		
                    		//Last Name Field check
                    		
             WebElement lastNameField = driver.findElement(By.id("input-lastname"));
             String actualLastNameFieldHeight = lastNameField.getCssValue("height");
             Assert.assertEquals(actualLastNameFieldHeight, expectedHeight);
             String actualLastNameWidth = lastNameField.getCssValue("width");
             Assert.assertEquals(actualLastNameWidth, expectedWidth);
                    		
             String exptectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), exptectedLastNameWarning);
             lastNameField = driver.findElement(By.id("input-lastname"));
             lastNameField.sendKeys("a");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             boolean lastNameWarningStatus = false;
             try {
             lastNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed();
             }catch(NoSuchElementException e) {
             lastNameWarningStatus = false;
              }
             Assert.assertFalse(lastNameWarningStatus);
             lastNameField = driver.findElement(By.id("input-lastname"));
             lastNameField.clear();
             lastNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeab");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             lastNameWarningStatus = false;
             try {
             lastNameWarningStatus = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).isDisplayed();
              }catch(NoSuchElementException e) {
             lastNameWarningStatus = false;
                    		}
             Assert.assertFalse(lastNameWarningStatus);
             lastNameField = driver.findElement(By.id("input-lastname"));
             lastNameField.clear();
             lastNameField.sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeabc");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), exptectedLastNameWarning);
                    		
                    		//Email Field check
                    		
             WebElement emailField = driver.findElement(By.id("input-email"));
             String actualEmailFieldHeight = emailField.getCssValue("height");
             Assert.assertEquals(actualEmailFieldHeight,expectedHeight);
             String actualEmailFieldWidth = emailField.getCssValue("width");
             Assert.assertEquals(actualEmailFieldWidth, expectedWidth);
             emailField.sendKeys("adfdsfasdfadfdsssssafasdfasdfasdfadsfasdf@email.com");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             boolean emailWarningStatus = false;
             try {
             emailWarningStatus = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).isDisplayed();
                }catch(NoSuchElementException e) {
            	emailWarningStatus = false;
                    		}
             Assert.assertFalse(emailWarningStatus);
                    		
                    		//Telephone Field check
                    		
             WebElement telephoneField = driver.findElement(By.id("input-telephone"));
             String actualTelephoneFieldHeight = telephoneField.getCssValue("height");
             Assert.assertEquals(actualTelephoneFieldHeight,expectedHeight);
             String actualTelephoneFieldWidth = telephoneField.getCssValue("width");
             Assert.assertEquals(actualTelephoneFieldWidth, expectedWidth);
                    		
             String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
             telephoneField = driver.findElement(By.id("input-telephone"));
             telephoneField.sendKeys("1");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
             telephoneField = driver.findElement(By.id("input-telephone"));
             telephoneField.clear();
             telephoneField.sendKeys("12");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
             telephoneField = driver.findElement(By.id("input-telephone"));
             telephoneField.clear();
             telephoneField.sendKeys("123");
             driver.findElement(By.xpath("//input[@value='Continue']")).click();
             boolean telephoneWarningStatus = false;
             try {
            	telephoneWarningStatus = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed();
                 }catch(NoSuchElementException e) {
                    			telephoneWarningStatus = false;
                    		}
           Assert.assertFalse(telephoneWarningStatus);
           telephoneField =driver.findElement(By.id("input-telephone"));
           telephoneField.clear();
           telephoneField.sendKeys("12345678901234567890123456789012");
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           telephoneWarningStatus = false;
           try {
             telephoneWarningStatus = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).isDisplayed();
               }catch(NoSuchElementException e) {
           telephoneWarningStatus = false;
                    		}
           Assert.assertFalse(telephoneWarningStatus);
           telephoneField = driver.findElement(By.id("input-telephone"));
           telephoneField.clear();
           telephoneField.sendKeys("123456789012345678901234567890123");
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarning);
                    		
                    		//Password Field check
           WebElement passwordField = driver.findElement(By.id("input-password"));
           String actualPasswordFieldHeight = passwordField.getCssValue("height");
           Assert.assertEquals(actualPasswordFieldHeight,expectedHeight);
           String actualPasswordFieldWidth = passwordField.getCssValue("width");
           Assert.assertEquals(actualPasswordFieldWidth, expectedWidth);
           String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);
                    		
           passwordField = driver.findElement(By.id("input-password"));
           passwordField.clear();
           passwordField.sendKeys("1");
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);
           passwordField = driver.findElement(By.id("input-password"));
           passwordField.clear();
           passwordField.sendKeys("12");
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);
           passwordField = driver.findElement(By.id("input-password"));
           passwordField.clear();
           passwordField.sendKeys("123");
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWarning);
           passwordField = driver.findElement(By.id("input-password"));
           passwordField.clear();
           passwordField.sendKeys("1234");
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           boolean passwordWarningStatus = false;
           try {
           passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed();
             }catch(NoSuchElementException e) {
           passwordWarningStatus = false;
                    		}
           Assert.assertFalse(passwordWarningStatus);
           passwordField = driver.findElement(By.id("input-password"));
           passwordField.clear();
           passwordField.sendKeys("12345678901234567890");
           driver.findElement(By.xpath("//input[@value='Continue']")).click();
           passwordWarningStatus = false;
           try {
              passwordWarningStatus = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).isDisplayed();
              }catch(NoSuchElementException e) {
           passwordWarningStatus = false;
                    		}
           Assert.assertFalse(passwordWarningStatus);
                    		
           passwordField = driver.findElement(By.id("input-password"));
           passwordField.clear();
                    		
                    		
                    		
                    		}
          @Test(priority=14)
          public void ToVerifyLeadingAndTrailingSpace()
                    	{
        	  registerPage.FirstNameField("  "+prop.getProperty("firstName")+"  ");
              registerPage.LastNameField("  "+prop.getProperty("lastName")+" ");
      		  String emailWithTimeStamp = CommonUtilities.generateBrandNewEmail();

              registerPage.EmailField("  "+emailWithTimeStamp+"  ");
              registerPage.Telephone("  "+prop.getProperty("telephoneNumber")+"  ");
          	  registerPage.passwordfield("  "+prop.getProperty("validPassword")+"  ");
          	  registerPage.ConfirmPasswordField("  "+prop.getProperty("validPassword")+"  ");
              registerPage.nonewsletterbox();
              registerPage.PrivacyPolicy();
              accountSuccessPage=registerPage.ContinueButton();
                        		
              String ExpectedHeading="Your Account Has Been Created!";
              Assert.assertEquals(accountSuccessPage.CommonSuccessHeadingoption(), ExpectedHeading);
                        	     
                        }
         
                    	     

          @Test(priority=15)
          public void Toverifyprivacypolicyoptionisnotseletedbydefault()
                    	{
                    		
                    	
          String	ExpectedWarningmsg="Warning:Privacy Policy checkbox option is not selected by default";
                    		
          Assert.assertFalse(driver.findElement(By.xpath("//input[@name='agree']")).isSelected(), "Privacy Policy checkbox option is not selected by default");
                    	
                    	}
           @Test(priority=16)
            public void ToVerifyregisterFunctionalityPrivacyPolicyIsNotSelected()
                    	{
                    		
                    		
        	registerPage.FirstNameField(prop.getProperty("firstName"));
           	registerPage.LastNameField(prop.getProperty("lastName"));
           	registerPage.EmailField(CommonUtilities.generateBrandNewEmail());
           	registerPage.Telephone(prop.getProperty("telephoneNumber"));
           	registerPage.passwordfield(prop.getProperty("validPassword"));
           	registerPage.ConfirmPasswordField(prop.getProperty("validPassword"));
           	registerPage.SubScribeNewsletter();
            accountSuccessPage=registerPage.ContinueButton();
               
            String ExpectedWarning="Warning: You must agree to the Privacy Policy!";
            Assert.assertEquals(registerPage.PageLevelWarningmsg(),ExpectedWarning);
                    	
                    	}
            @Test(priority=17)
            public void PasswordtextenteredintoPasswordandPasswordConfirmfieldsneedtobetoggledtohideitsvisibilty ()
                    	{
                    		
          
            Assert.assertEquals(registerPage.getPasswordFieldDomAttribute("type"), "password");
            Assert.assertEquals(registerPage.getPasswordConfirmFieldDomAttribute("type"), "password");
             }
          @Test(priority=18)
          public void VerifynavigatingtootherpagesusingtheoptionsrlinksprovidedontheRegisterAccount()
                    	{
    	  headerOptions= registerPage.getHeaderOptions();       	 
          contactuspage=headerOptions.selectphoneicon();
    	  Assert.assertTrue(getPageTitle(headerOptions.getDriver()).equals("Contact Us"));
    	  navigateBackInBrowser(headerOptions.getDriver());
        	  
		  loginpage=headerOptions.HearticonOption();
		  Assert.assertEquals(getPageTitle(loginpage.getDriver()),"Account Login");
		  navigateBackInBrowser(loginpage.getDriver());
		  
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
	
	      registerPage=registerPage.selectOnRegisterBreadCrumb();
	      Assert.assertEquals(getPageTitle(registerPage.getDriver()), "Register Account");
	      //navigateBackInBrowser(registerPage.getDriver()); 
        	  
         rightcolumnoptions= registerPage.getRightColumnOptions();
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

    ReturnsOptionPage = footeroptions.clickOnReturnsOption();
	Assert.assertEquals(getPageTitle(ReturnsOptionPage.getDriver()), "Product Returns");
   	navigateBackInBrowser(ReturnsOptionPage.getDriver());
	   
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
   	
   	loginpage=footeroptions.clickOnMyAccountOption();
   	Assert.assertEquals(getPageTitle(loginpage.getDriver()), "Your Store");
   	navigateBackInBrowser(loginpage.getDriver());
   	
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
          @Test(priority=19)
          public  void fillingpasswordandnotfillingpasswordconfirmfield() {
          registerPage.FirstNameField(prop.getProperty("firstName"));
          registerPage.LastNameField(prop.getProperty("lastName"));
          registerPage.EmailField(CommonUtilities.generateBrandNewEmail());
          registerPage.Telephone(prop.getProperty("telephoneNumber"));
          registerPage.passwordfield(prop.getProperty("validPassword"));
          registerPage.SubScribeNewsletter();
          registerPage.PrivacyPolicy();
          registerPage.ContinueButton();
         
          String Expectedwarning="Password confirmation does not match password!";
          Assert.assertEquals(registerPage.Passwordconfirmationwarning(), Expectedwarning);	  		
                  	  		
                  }
          @Test(priority=20)
          public void Verify_Breadcrumb_PageHeading_PageUrl_PageTitleOfRF() {
          Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
                    	    
                    	     
          String Expectedurl="https://tutorialsninja.com/demo/index.php?route=account/register";
          Assert.assertEquals(driver.getCurrentUrl(), Expectedurl);
                    	     
          String ExpectedTitle="Register Account";
          Assert.assertEquals(driver.getTitle(), ExpectedTitle);
                    	     
                    	    

              	}
           @Test(dataProvider="EnvironmentSupplier",priority=21)
           public void verifyUrlondifferentenvironments(String env)
              	{
          
           
            driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("reva");
            driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("raut");

            driver.findElement(By.id("input-telephone")).sendKeys("1234567");
            driver.findElement(By.id("input-email")).sendKeys(CommonUtilities.generateBrandNewEmail());
            driver.findElement(By.id("input-password")).sendKeys("SPRmay2024##");
            driver.findElement(By.id("input-confirm")).sendKeys("SPRmay2024##");
            driver.findElement(By.xpath("//*[text()='Yes']"));
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
                    	 		
           //driver.findElement(By.xpath("//a[text()='Continue']")).click();
            Assert.assertEquals(driver.getTitle(),"Your Account Has Been Created!");
                    			
                	}
            @DataProvider(name="EnvironmentSupplier")
            public Object[][] envsup()
                   {
           	Object[][] en= {{"chrome"},{"firefox"},{"edge"}};
                   return en;
                   }




                    




    	
} 	
	




