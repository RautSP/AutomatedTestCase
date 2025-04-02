package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class GiftCertificatesOptionPage extends Root {
	WebDriver driver;
	public GiftCertificatesOptionPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
