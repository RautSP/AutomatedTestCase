package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.Root;

public class SearchPage extends Root{
	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Search']")
	private WebElement SearchBreadcrumb;
	
	@FindBy(linkText="iMac")
	private WebElement ExistingproductOne;
	
	@FindBy(linkText="iMac")
	private WebElement ExistingProducttwo;
	
	@FindBy(xpath="//input[@id='button-search']//following-sibling::p")
	private WebElement pagewarningfornonexistingproduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement Warningmsgforwithoutprovidingproductname;
	
	@FindBy(xpath="//div[@class='product-thumb']")
	private List<WebElement> Productsthumnail;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchCriteriaField;
	
	@FindBy(xpath="//input[@id='button-search']")
	private WebElement ClickOnSearchButton;
	
	@FindBy(id="description")
	private WebElement ProductDescriptionCheackbox;
	
	@FindBy(name="category_id")
	private WebElement CategoriesDropdownField;
	
	@FindBy(name="sub_category")
	private WebElement SubCategorycheackboxOption;
	
	@FindBy(id="list-view")
	private WebElement ListOption;
	
	@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-shopping-cart']")
	private WebElement AddToCartButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement SuccessMSgAfterAddingProductIntocart;
	
	@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-heart']")
	private WebElement ClickOnheartOption;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement pageLevelMsgforWishListOption;
	
	@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-exchange']")
	private WebElement ClickOnCompareThisProduct;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement pageLevelMsgforproductcompareOption;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	private WebElement iMacImage;
	
	@FindBy(xpath="//i[@class='fa fa-th']")
	private WebElement GridOption;
	
	@FindBy(id="compare-total")
	private WebElement ProductCompareOption;
	
	public ProoductComparePage clickonProductCompareOption()
	{
		elementUtilities.clickOnElement(ProductCompareOption);
		return new ProoductComparePage(driver);
	}

	
	public void ClickOnGridOption()
	{
		elementUtilities.clickOnElement(GridOption);
	}
	
	public ProductDisplayPage clickonImacLink()
	{
		 elementUtilities.clickOnElement(ExistingproductOne);
         return new ProductDisplayPage(driver);
	}
	
	public ProductDisplayPage ClickOnimacImage()
	{
	   elementUtilities.clickOnElement(iMacImage);
	   return new ProductDisplayPage(driver);
	}
	
	public boolean GetPageLevelMsgOnClickingproductcompareOption()
	{
		return elementUtilities.isElementDisplayed(pageLevelMsgforproductcompareOption);
	}
	
	
	public void ClickOnProductCompareOption()
	{
		elementUtilities.clickOnElement(ClickOnCompareThisProduct);
	}
	public boolean GetPageLevelMsgOnClickingWishListOption()
	{
		return elementUtilities.isElementDisplayed(pageLevelMsgforWishListOption);
	}
	
	public void ClickOnWishListOption()
	{
		elementUtilities.clickOnElement(ClickOnheartOption);
	}
	
	public boolean SuccessMsgOnSearchPageAfeterAddingProductIntoAddToCartOption()
	{
		return elementUtilities.isElementDisplayed(SuccessMSgAfterAddingProductIntocart);
	}
	
	public void clickOnAddToCartButton()
	{
		elementUtilities.clickOnElement(AddToCartButton);
	}
	
	public void ClickOnListOption()
	{
	  elementUtilities.clickOnElement(ListOption);;
	}
	
	public void SelectSubCategoryCheackBoxOption()
	{
		elementUtilities.clickOnElement(SubCategorycheackboxOption);
	}
	
	public void SelectOptionfromCategoriesDropDownField(String OptionIndex)
	{
		elementUtilities.SelectCategoriesDropDownFieldUsingIndex(CategoriesDropdownField, OptionIndex);
	}
	
	public void ClickOnProductDescriptionCheackBox()
	{
		elementUtilities.clickOnElement(ProductDescriptionCheackbox);

	}
	
	public void clickonsearchbutton()
	{
		elementUtilities.clickOnElement(ClickOnSearchButton);
	}
	
	public void EntertextIntoSearchCriteria(String text)
	{
		elementUtilities.enterTextIntoElement(SearchCriteriaField,text );
	}
	
	public int getProductCount()
	{
		return elementUtilities.getElementCount(Productsthumnail);
		
	}
	
	public boolean msgforwithoutprovidingproductname()
	{
		return elementUtilities.isElementDisplayed(Warningmsgforwithoutprovidingproductname);
	}
	
	public boolean Searchpagewarningfornonexistingproduct() 
	{
		return elementUtilities.isElementDisplayed(pagewarningfornonexistingproduct);
	}
	
	public boolean Isproductdisplayedinsearchresult()
	{
		return elementUtilities.isElementDisplayedOnPage(ExistingproductOne);
	}
	public boolean Isproductdisplayedfromsearchdescription()
	{
		return elementUtilities.isElementDisplayedOnPage(ExistingProducttwo);
	}
	
	public boolean didwenavigatetosearchresultpage()
	{
		return elementUtilities.isElementDisplayed(SearchBreadcrumb);
	}

}
