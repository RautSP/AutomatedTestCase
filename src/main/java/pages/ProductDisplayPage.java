package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class ProductDisplayPage extends Root {

	public WebDriver driver;

	public ProductDisplayPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="button-cart")
	private WebElement AddTocartOption;
	
	public boolean Didwenavigatetoproductdisplaypage()
	{
		return elementUtilities.isElementDisplayed(AddTocartOption);
	}

}
