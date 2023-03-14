package com.dotKonnekt.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.CheckoutPage;
import com.dotKonnekt.pages.CategoryPage;
import com.dotKonnekt.pages.CommonPagedetails;
import com.dotKonnekt.pages.HomePage;
import com.dotKonnekt.pages.CheckoutPage;
import com.dotKonnekt.pages.LoginPage;
import com.dotKonnekt.pages.ProductPage;
import com.dotKonnekt.pages.RecipePageFinal;
import com.dotKonnekt.utility.Log;

public class CheckoutPageTest extends BaseClass {
	
	RecipePageFinal recipePage;
	HomePage homePage;
	CategoryPage categoryPage;	
	LoginPage loginPage;
	CheckoutPage checkoutPage;
	CommonPagedetails commonPagedetails;
	ProductPage productPage;
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn") 
	public void TitleVerification(String page, String title, String browser, String url) {
		Log.startTestCase("TitleVerification");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		String actualTitle = commonPagedetails.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Checkout", "Title Not Verified");
		Log.endTestCase("TitleVerification");
	}
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	
	public void CheckoutPage_PageHeaderVerification(String page, String title, String browser, String url) {
		Log.startTestCase("CheckoutPage_PageHeaderVerification");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		Log.info("-----------Logo Verification Starts----------");
		boolean logoResult = commonPagedetails.valaidateLogo();
		Assert.assertTrue(logoResult);
		Log.info("-----------Logo Verification End successfully----------");
		Log.info("-----------SearchBox Verification Starts----------");
		boolean searchResult = commonPagedetails.validateSearchBox();
		Assert.assertTrue(searchResult);
		Log.info("-----------SearchBox Verification End Successfully----------");
		Log.info("-----------Cartbutton Verification Starts----------");
		boolean cartResult = commonPagedetails.validateSearchBox();
		Assert.assertTrue(cartResult);
		Log.info("-----------Cartbutton Verification End Successfully----------");
		Log.info("-----------Userbutton Verification Starts----------");
		boolean userResult = commonPagedetails.validateSearchBox();
		Assert.assertTrue(userResult);
		Log.info("-----------Userbutton Verification End Successfully----------");
		Log.endTestCase("CheckoutPage_PageHeaderVerification");
	}
	
	
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void CheckoutPage_SearchFucntionalityVerification(String page, String title, String browser, String url) throws InterruptedException {
		
		Log.startTestCase("-----------CheckoutPage_SearchFucntionalityVerification    Starts---------");
		
		checkoutPage = new CheckoutPage();
		launchApp_V1(browser, url);
		//checkoutPage.validateSeachFunctionalityForShopTab("mask","Keyboard","Search Page");
		commonPagedetails.validateSeachFunctionality("Blacsdfghk","Keyboard",title);
		
		Log.info("SearchFucntionality Works perfectly");
		Log.endTestCase("-----------CheckoutPage_SearchFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void CheckoutPage_CartFucntionalityVerification(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------CheckoutPage_CartFucntionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.validateCartIconFunctionality();
		Log.info("CartFucntionality Works perfectly");
		Log.endTestCase("-----------CheckoutPage_CartFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void CheckoutPage_UserFunctionalityVerification(String page, String title, String browser, String url) throws InterruptedException {

		Log.startTestCase("-----------CheckoutPage_UserFunctionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.UserButtonFunctionality(title);
		Log.endTestCase("-----------CheckoutPage_UserFunctionalityVerification    Ends---------");
	}

	
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void CheckoutPage_LogoFunctionalityVerification(String page, String title, String browser, String url) throws InterruptedException {

		Log.startTestCase("-----------CheckoutPage_LogoFunctionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		launchApp_V1(browser, url);
		commonPagedetails.logoFunctionality(title);
		Log.info("LogoFunctionalityVerification Works perfectly");
		Log.endTestCase("-----------CheckoutPage_LogoFunctionalityVerification    Ends---------");
	}
	
	
//Organic Aloe Vera Gel from freshly
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void CheckoutPage_GuestUseraddItemTotheCartforShopTab(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------CheckoutPage_GuestUseraddItemTotheCart    Starts---------");
		checkoutPage = new CheckoutPage();
		productPage = new ProductPage();
		homePage = new HomePage();
		launchApp_EB(browser, prop.getProperty("HomePageurl"));
		homePage.NewsletterPopup();
		checkoutPage.validateSeachFunctionalityForShopTab("black","Keyboard","Search Page");
		checkoutPage.ShopProducts();
		checkoutPage.selectAProduct();
		checkoutPage.availabiltyStock();
		Log.endTestCase("-----------CheckoutPage_GuestUseraddItemTotheCart    Ends---------");
	}
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void CheckoutPage_GuestUseraddItemTotheCartForArticleTab(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------CheckoutPage_GuestUseraddItemTotheCart    Starts---------");
		checkoutPage = new CheckoutPage();
		homePage = new HomePage();
		launchApp_EB(browser, prop.getProperty("HomePageurl"));
		homePage.NewsletterPopup();
		checkoutPage.SearchFunctionalityForArticleTab("aloe","Keyboard","Search Page");
		//checkoutPage.ShopProducts();
		Log.endTestCase("-----------CheckoutPage_GuestUseraddItemTotheCart    Ends---------");
	}
	
	
	@Test(dataProvider = "CheckoutPage", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn") 
	public void CheckoutPage_PageElements(String page, String title, String browser, String
	  url) throws InterruptedException {
		Log.startTestCase("-----------CheckoutPage_GuestUseraddItemTotheCart    Starts---------"); 
		checkoutPage = new CheckoutPage(); 
		launchApp_EB(browser, url);
	  //checkoutPage.SearchFunctionalityForArticleTab("aloe","Keyboard","Search Page");
		//checkoutPage.CheckoutPageStatus(); 
		checkoutPage.contactInfo();
		Log.endTestCase("-----------CheckoutPage_GuestUseraddItemTotheCart    Ends---------"); 
		}
	 
	
	@AfterMethod(groups = {"LoggedIn","NotLoggedIn"})
	public void tearDown() {
		getDriver().close();
	}

}
