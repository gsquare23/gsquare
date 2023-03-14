package com.dotKonnekt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.BlogPage;
import com.dotKonnekt.pages.CategoryPage;
import com.dotKonnekt.pages.CommonPagedetails;
import com.dotKonnekt.pages.HomePage;
import com.dotKonnekt.pages.LoginPage;
import com.dotKonnekt.pages.RecipePageFinal;
import com.dotKonnekt.utility.Log;

public class HomePageTest extends BaseClass{
	
	RecipePageFinal recipePage;
	BlogPage blogPage;
	CategoryPage categoryPage;	
	LoginPage loginPage;
	HomePage homePage;
	CommonPagedetails commonPagedetails;
	
	
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn") 
	public void TitleVerification(String page, String title, String browser, String url) {
		Log.startTestCase("TitleVerification");
		commonPagedetails = new CommonPagedetails();
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		String actualTitle = commonPagedetails.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "dot beauty", "Title Not Verified");
		Log.endTestCase("TitleVerification");
	}
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class,enabled = true, groups = "NotLoggedIn")
	
	public void HomePage_PageHeaderVerification(String page, String title, String browser, String url) {
		Log.startTestCase("HomePage_PageHeaderVerification");
		commonPagedetails = new CommonPagedetails();
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
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
		Log.endTestCase("HomePage_PageHeaderVerification");
	}
	
	
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_SearchFucntionalityVerification(String page, String title, String browser, String url) throws InterruptedException {
		
		Log.startTestCase("-----------HomePage_SearchFucntionalityVerification    Starts---------");
		
		commonPagedetails = new CommonPagedetails();
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		//homePage.NewsletterPopup();
		commonPagedetails.validateSeachFunctionality("Black","Keyboard",title);
		
		Log.info("SearchFucntionality Works perfectly");
		Log.endTestCase("-----------HomePage_SearchFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_CartFucntionalityVerification(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------HomePage_CartFucntionalityVerification    Starts---------");
		commonPagedetails = new CommonPagedetails();
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		commonPagedetails.validateCartIconFunctionality();
		Log.info("CartFucntionality Works perfectly");
		Log.endTestCase("-----------HomePage_CartFucntionalityVerification    Ends---------");
	}
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_UserFunctionalityVerification(String page, String title, String browser, String url) throws InterruptedException {

		Log.startTestCase("-----------HomePage_UserFunctionalityVerification    Starts---------");
		recipePage = new RecipePageFinal();
		commonPagedetails = new CommonPagedetails();
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		commonPagedetails.UserButtonFunctionality(title);
		Log.endTestCase("-----------HomePage_UserFunctionalityVerification    Ends---------");
	}

	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_NewArrival(String page, String title, String browser, String url) {
		Log.startTestCase("-----------HomePage_NewArrival    Starts---------");
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		homePage.newArrival();
		Log.endTestCase("-----------HomePage_NewArrival    Ends---------");
	}
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_shoutOutFromCustomers(String page, String title, String browser, String url) {
		Log.startTestCase("-----------HomePage_shoutOutFromCustomers    Starts---------");
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		homePage.shoutOut();
		Log.endTestCase("-----------HomePage_shoutOutFromCustomers    Ends---------");
	}
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_askOurExpertSection(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------HomePage_askOurExpert    Starts---------");
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		homePage.askOurExpert();
		Log.endTestCase("-----------HomePage_askOurExpert    Ends---------");
	}
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_SendAMessageFunctionality(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------HomePage_SendAMessageFunctionality    Starts---------");
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		Thread.sleep(3000);
		homePage.sendAMessage();
		Log.endTestCase("-----------HomePage_SendAMessageFunctionality    Ends---------");
	}
	
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_aboutUsSection(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------HomePage_aboutUsSection    Starts---------");
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		homePage.aboutUs();
		Log.endTestCase("-----------HomePage_aboutUsSection    Ends---------");
	}
	
	@Test(dataProvider = "HomePage", dataProviderClass = DataProviders.class, enabled = true, groups = "NotLoggedIn")
	public void HomePage_aboveAboutUsSection(String page, String title, String browser, String url) throws InterruptedException {
		Log.startTestCase("-----------HomePage_aboveAboutUsSection    Starts---------");
		homePage = new HomePage();
		launchApp_EB(browser, url);
		homePage.NewsletterPopup();
		homePage.aboveAboutSection();
		Log.endTestCase("-----------HomePage_aboveAboutUsSection    Ends---------");
	}
	 
	@AfterMethod(groups = {"LoggedIn","NotLoggedIn"})
	public void tearDown() {
		getDriver().close();
	}
}
