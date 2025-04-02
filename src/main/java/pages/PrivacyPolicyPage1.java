package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class PrivacyPolicyPage1 extends Root{
	WebDriver driver;
	
	public PrivacyPolicyPage1(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
