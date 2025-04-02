package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class ProoductComparePage extends Root{
WebDriver driver;
	public ProoductComparePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//ul[@class='breadcrumb']//a[text()='Product Comparison']")
	WebElement productComparisonBreadcrumb;
	
	public boolean didWeNavigateToProductComparisonPage() {
		return elementUtilities.isElementDisplayed(productComparisonBreadcrumb);
	}
}
