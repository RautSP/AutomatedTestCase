package register;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;

public class Search extends Base {
WebDriver driver;

@AfterMethod
public void teardown()
{
	CloseBrowser(driver);
}
@BeforeMethod
public void Setup()
{  
	  driver = OpenBrowserAndAppURl();
	  headerOptions = new HeaderOptions(driver);
}
@Test(priority=1)
public void verifysearchingwithanexistingproductname()
{
	headerOptions.EnterTextIntoSearchBoxField(prop.getProperty("ExistingProduct"));
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	Assert.assertTrue(searchpage.Isproductdisplayedinsearchresult());
}
@Test(priority=2)
public void verifysearchingwithanonexistingproductname()
{
	headerOptions.EnterTextIntoSearchBoxField(prop.getProperty("nonExistingProduct"));
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	Assert.assertTrue(searchpage.Searchpagewarningfornonexistingproduct());	
}
@Test(priority=3)
public void VerifysearchingWithoutprovidinganyfunctionality()
{
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	Assert.assertTrue(searchpage.msgforwithoutprovidingproductname());	
}
@Test(priority=4)
public void VeriftysearchingforaproductafterlogintotheApplication()
{
	headerOptions.clickonAccountDropMenu();
	loginpage=headerOptions.selectLoginOption();
	loginpage.EnterEmailData(prop.getProperty("existingEmail"));
	loginpage.EnterPasswordData(prop.getProperty("validPassword"));
	headerOptions.EnterTextIntoSearchBoxField(prop.getProperty("ExistingProduct"));
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	Assert.assertTrue(searchpage.Isproductdisplayedinsearchresult());
}
@Test(priority=5)
public void VerifySearchigProductsResultsMultipleProduct()
{
	headerOptions.EnterTextIntoSearchBoxField(prop.getProperty("MulProduct"));
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
    Assert.assertTrue(searchpage.getProductCount()>0);
}
@Test(priority=6)
public void VerifySearchPagePlaceholder()
{
	String expectedSearchboxplaceholder="Search";
    Assert.assertEquals(headerOptions.getSearchBoxPlaceholder(), expectedSearchboxplaceholder);
}
@Test(priority=7)
public void VerifySearchingCriteriafield()
{
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	searchpage.EntertextIntoSearchCriteria(prop.getProperty("ExistingProductone"));
	searchpage.clickonsearchbutton();
	Assert.assertTrue(searchpage.getProductCount()>0);
}
@Test(priority=8)
public void VerifySearchUsingTheTextFromProductDescription() 
{
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	searchpage.EntertextIntoSearchCriteria(prop.getProperty("TextfromProductDescription"));
	searchpage.ClickOnProductDescriptionCheackBox();
	searchpage.clickonsearchbutton();
	Assert.assertTrue(searchpage.Isproductdisplayedfromsearchdescription());	
}
@Test(priority=9)
public void VerifySearchBySelectingCategoryOfProduct()
{
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	searchpage.EntertextIntoSearchCriteria(prop.getProperty("ExistingProduct"));
	searchpage.SelectOptionfromCategoriesDropDownField(prop.getProperty("CorrectcategoryIndex"));
	searchpage.clickonsearchbutton();
	Assert.assertTrue(searchpage.Isproductdisplayedinsearchresult());
	searchpage.SelectOptionfromCategoriesDropDownField(prop.getProperty("WrongcategoryIndex"));
	searchpage.clickonsearchbutton();
    Assert.assertTrue(searchpage.Searchpagewarningfornonexistingproduct());
	
}
@Test(priority=10)
public void VerifySearchBySelectingTOSearchInSubCategoryOption()
{
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	searchpage.EntertextIntoSearchCriteria(prop.getProperty("ExistingProduct"));
	searchpage.SelectOptionfromCategoriesDropDownField(prop.getProperty("ParentcategoryOptionIndex"));
	searchpage.clickonsearchbutton();
    Assert.assertTrue(searchpage.Searchpagewarningfornonexistingproduct());
    searchpage.SelectSubCategoryCheackBoxOption();
	searchpage.clickonsearchbutton();
    Assert.assertTrue(searchpage.Isproductdisplayedinsearchresult());

}
@Test(priority=11)
public void VerifyListAndGridFunctionalityWhenOnlyOneProductIsEnteredintoSearchResult()
{
	headerOptions.EnterTextIntoSearchBoxField(prop.getProperty("ExistingProductone"));
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.didwenavigatetosearchresultpage());
	searchpage.ClickOnListOption();
	Assert.assertTrue(searchpage.Isproductdisplayedinsearchresult());
	searchpage.clickOnAddToCartButton();
	Assert.assertTrue(searchpage.SuccessMsgOnSearchPageAfeterAddingProductIntoAddToCartOption());
	refreshpage(searchpage.getDriver());
	searchpage.ClickOnWishListOption();
	Assert.assertTrue(searchpage.GetPageLevelMsgOnClickingWishListOption());
    refreshpage(searchpage.getDriver());
    searchpage.ClickOnProductCompareOption();
    Assert.assertTrue(searchpage.GetPageLevelMsgOnClickingproductcompareOption());
    refreshpage(searchpage.getDriver());
    productdisplaypage=searchpage.ClickOnimacImage();
    Assert.assertTrue(productdisplaypage.Didwenavigatetoproductdisplaypage());
    navigateBackInBrowser(productdisplaypage.getDriver());
	productdisplaypage = searchpage.clickonImacLink();
	Assert.assertTrue(productdisplaypage.Didwenavigatetoproductdisplaypage());
	navigateBackInBrowser(productdisplaypage.getDriver());
	refreshpage(searchpage.getDriver());
	searchpage.ClickOnGridOption();
	//Assert.assertTrue(searchpage.getProductCount()==1);
	searchpage.clickOnAddToCartButton();
	Assert.assertTrue(searchpage.SuccessMsgOnSearchPageAfeterAddingProductIntoAddToCartOption());
	refreshpage(searchpage.getDriver());
	searchpage.ClickOnWishListOption();
	Assert.assertTrue(searchpage.GetPageLevelMsgOnClickingWishListOption());
    refreshpage(searchpage.getDriver());
    searchpage.ClickOnProductCompareOption();
    Assert.assertTrue(searchpage.GetPageLevelMsgOnClickingproductcompareOption());
    searchpage.ClickOnimacImage();
    Assert.assertTrue(productdisplaypage.Didwenavigatetoproductdisplaypage());
    navigateBackInBrowser(productdisplaypage.getDriver());
	productdisplaypage = searchpage.clickonImacLink();
	Assert.assertTrue(productdisplaypage.Didwenavigatetoproductdisplaypage());
	navigateBackInBrowser(productdisplaypage.getDriver());
	
   
}
@Test(priority=12)
public void verifyListandGridViewsWhenMultipleProductsAreDisplayed()
{
	headerOptions.EnterTextIntoSearchBoxField(prop.getProperty("MulProduct"));
	searchpage=headerOptions.ClickOnSearchButton();
	Assert.assertTrue(searchpage.getProductCount()>1);
	searchpage.ClickOnListOption();
	Assert.assertTrue(searchpage.getProductCount()>1);
	searchpage.ClickOnGridOption();
	Assert.assertTrue(searchpage.getProductCount()>1);
}
@Test(priority=13)
public void VerifyNavigationFromsearchPageToProductComparePage()
{
	headerOptions.EnterTextIntoSearchBoxField(prop.getProperty("ExistingProductone"));
	searchpage=headerOptions.ClickOnSearchButton();
	productcomparepage = searchpage.clickonProductCompareOption();
	Assert.assertTrue(productcomparepage.didWeNavigateToProductComparisonPage());
	
	
}
}
