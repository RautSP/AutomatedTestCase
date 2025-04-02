package utility;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtilities {
WebDriver driver;
public Actions action;
Select select;
	
	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
	}
	public void clickOnElement(WebElement element) {
		
			element.click();
		
	}
	public void CopyTextFromPasswordfieldusingkeyboard(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).
		keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
	}
	public void PasteTextIntoemailfieldusingKeyboard(WebElement element ,WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.click(element).keyDown(Keys.CONTROL).sendKeys("v").
		build().perform();
		
	}

	
	
	public String getElementText(WebElement element){
		String elementText = "";
		if(isElementDisplayed(element)) {
			elementText = element.getText();
		}
		return elementText;
		
	}
	public boolean isElementDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();
		} catch(NoSuchElementException e) {
			b = false;
		}
		return b;
	}
	
	public boolean isElementDisplayedOnPage(WebElement element) {
		boolean b = false;
		b = element.isDisplayed();
		return b;
	}
	
	public boolean isElementSelected(WebElement element)  {
		boolean b = false;
		if(isElementDisplayedOnPage(element)) {
			b = element.isSelected();
		}
		return b;
	}
	public String getElementDomAttribute(WebElement element,String attributeName) {
		return element.getDomAttribute(attributeName);
	}
	
	public String getElementDomProperty(WebElement element,String attributeName) {
		return element.getDomProperty(attributeName);
	}
	public void clearTextFromElement(WebElement element)  {
		if(isElementDisplayedOnPage(element) && element.isEnabled()) {
			element.clear();
		}
	}
	public void enterTextIntoElement(WebElement element, String text) {
		if(isElementDisplayedOnPage(element) && element.isEnabled()) {
			clearTextFromElement(element);
			element.sendKeys(text);
		}
	}
	public int getElementCount(List<WebElement>elements)
	{
		int count=0;
		for(int i=0;i<=elements.size();i++)
		{
			 count++;
		}
		return count;
	}
	
	public void SelectCategoriesDropDownFieldUsingIndex(WebElement element,String OptionIndex)
	{
		if(isElementDisplayedOnPage(element) && element.isEnabled()) 
		{
			select=new Select(element);
			int Index=Integer.parseInt(OptionIndex);
			select.selectByIndex(Index);
		}
	}
	

}

