package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import root.Root;

public class RightColumnOptions extends Root{
	WebDriver driver;

	public RightColumnOptions(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

		@FindBy(xpath="//aside[@id='column-right']//a[text()='Register']")
        private WebElement registerOption;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
		private WebElement LogOutOption;
		
		@FindBy(xpath="//aside[@id='column-right']//a[text()='Login']")
		private WebElement LoginOption;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Forgotten Password']")
		private WebElement ForgotPassword;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='My Account']")
		private WebElement MyAccount;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Address Book']")
		private WebElement AddressBook;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Wish List']")
		private WebElement WishList;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Order History']")
		private WebElement OrderHistory;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Downloads']")
		private WebElement Downlods;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Recurring payments']")
		private WebElement RecurringPayments;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Reward Points']")
		private WebElement RewardPoints;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Returns']")
		private WebElement Returns;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Transactions']")
		private WebElement Transaction;
		
		@FindBy(xpath="//a[@class='list-group-item'][text()='Newsletter']")
		private WebElement NewsLetter;
		
		public loginPage clickOnloginoption()
		{
			elementUtilities.clickOnElement(LoginOption);
			return new loginPage(driver);
		}
		
		public ForGotPasswordPage clickOnforgotpassword()
		{
			elementUtilities.clickOnElement(ForgotPassword);
			return new ForGotPasswordPage(driver);
		}
		
		public loginPage clickOnMyaccount()
		{
			elementUtilities.clickOnElement(MyAccount);
			return new loginPage(driver);
		}
		public loginPage clickOnAddressBook()
		{
			elementUtilities.clickOnElement(AddressBook);
			return new loginPage(driver);
		}
		
		public loginPage clickOnWishList()
		{
			elementUtilities.clickOnElement(WishList);
			return new loginPage(driver);
		}
		public loginPage clickOnOrderHistory()
		{
			elementUtilities.clickOnElement(OrderHistory);
			return new loginPage(driver);
		}
		public loginPage clickOnDownlods()
		{
			elementUtilities.clickOnElement(Downlods);
			return new loginPage(driver);
		}
		public loginPage clickOnRecurringPayments()
		{
			elementUtilities.clickOnElement(RecurringPayments);
			return new loginPage(driver);
		}
		public loginPage clickOnRewardPoints()
		{
			elementUtilities.clickOnElement(RewardPoints);
			return new loginPage(driver);
		}
		public loginPage clickOnReturns()
		{
			elementUtilities.clickOnElement(Returns);
			return new loginPage(driver);
		}
		public loginPage clickOnTransaction()
		{
			elementUtilities.clickOnElement(Transaction);
			return new loginPage(driver);
		}
		public loginPage clickOnNewsLetter()
		{
			elementUtilities.clickOnElement(NewsLetter);
			return new loginPage(driver);
		}
		public boolean didwelogin()
		{
			return elementUtilities.isElementDisplayed(LogOutOption);
		}
		
		public AccountPage selectOrderHistory()
		{   
			elementUtilities.clickOnElement(OrderHistory);
			return new AccountPage(driver);
		}
		public void selectDownlods()
		{
			elementUtilities.clickOnElement(Downlods);


	}

	
	
	public loginPage clickOnLoginOption()
	{
		LoginOption.click();
		
		return new loginPage(driver);
	}
	    
	public RegisterPage clickOnRegisterOption() {

		registerOption.click();
		
		return new RegisterPage(driver);
	}

}
