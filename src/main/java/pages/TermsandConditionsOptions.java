package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class TermsandConditionsOptions extends Root{
	WebDriver driver;
	public TermsandConditionsOptions(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
