package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;
import root.Root;

public class CheackOutPage extends Root {
	WebDriver driver;
	public CheackOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
}
