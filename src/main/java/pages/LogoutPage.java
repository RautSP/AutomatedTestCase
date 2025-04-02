package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class LogoutPage extends Root {
	WebDriver driver;
	public LogoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public loginPage getloginpage()
	{
		return new loginPage(driver);
	}

}
