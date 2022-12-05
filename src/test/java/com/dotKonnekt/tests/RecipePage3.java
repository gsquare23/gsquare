package com.dotKonnekt.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.pages.CommonUtils;
import com.dotKonnekt.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecipePage3 extends BaseClass  {

	public WebDriver driver;
	public CommonUtils commonUtils;
	RecipePage3 recipePage3;
	@Test(dataProvider = "getTitle", dataProviderClass = DataProviders.class )
	public void recipePagesetUp(String page, String title,String browser,String url ,String AuthorName,String CategoryElements,String publishDate,String blogTitle,String ingredientsElements) throws InterruptedException {
		Log.startTestCase("");
		System.out.println(browser);
		// String browsername = prop.getProperty("browser");

		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.contains("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}

		else if (browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 40);
		driver.get(url);
		driver.manage().window().maximize();
		Action.pageLoadTimeOut(driver, 40);
		
	//Title Verification	
		Log.info("Verfying the title of the Page");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		System.out.println(title);
		Assert.assertEquals(actualTitle, title, "Title Verified");
	
	// PageHeader Verification
		Log.startTestCase("verifyPageHeader");
		
		Log.info("-------SEARCHBOX FUNCTIONALITY START ------");

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='free-solo-2-demo']"));
		if (searchBox.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + searchBox.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + searchBox.isDisplayed());
			Assert.assertTrue(searchBox.isDisplayed());
		}

		// that the “Search” Box is enabled
		if (searchBox.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + searchBox.isEnabled()); // Thread.sleep(5000);
			Action.explicitWait(driver, searchBox, Duration.ofSeconds(10));																			// searchBox.sendKeys("Selenium");
		
		} else {
			System.out.println("Search Box is not enabled. Return: " + searchBox.isEnabled());
			Assert.assertTrue(searchBox.isEnabled());
		}
		Log.info("-------SEARCHBOX FUNCTIONALITY END ------");

		Log.info("-------CARTButton FUNCTIONALITY START ------");

		WebElement cart = driver.findElement(By.xpath("(//img[@alt ='logo'])[3]"));
		if (cart.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + cart.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + cart.isDisplayed());
		}

		// verify that the “Cart” Button is enabled
		if (cart.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + cart.isEnabled());
		} else {
			System.out.println("Search Box is not enabled. Return: " + cart.isEnabled());
			Assert.assertTrue(cart.isEnabled());
		}
		Log.info("-------CARTButton FUNCTIONALITY END ------");

		Log.info("-------userButton FUNCTIONALITY START ------");

		WebElement userButton = driver.findElement(By.xpath("(//img[@alt='logo'])[4]"));
		if (userButton.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + userButton.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + userButton.isDisplayed());
		}

		// verify that the “Search” Box is enabled
		if (userButton.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + userButton.isEnabled());
		} else {
			System.out.println("Search Box is not enabled. Return: " + userButton.isEnabled());
			Assert.assertTrue(userButton.isEnabled());
		}
		Log.info("-------userButton FUNCTIONALITY END ------");

		Log.info("-------Logo FUNCTIONALITY START ------");

		WebElement Logo = driver.findElement(By.xpath("(//img[@alt='logo'])[1]"));
		if (Logo.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + Logo.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + Logo.isDisplayed());
			Assert.assertTrue(false);
		}

		// verify that the “LOGO” Box is enabled
		if (Logo.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + Logo.isEnabled());

		} else {
			System.out.println("Search Box is not enabled. Return: " + Logo.isEnabled());
			Assert.assertTrue(Logo.isEnabled());
		}
		Log.info("-------Logo FUNCTIONALITY END ------");
		Log.endTestCase("verifyPageHeader");
	// Author Name Verification ----------------------------------------------
		Log.info("Author Name Verification");
		String  actualAuthorName = driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']")).getText();
		System.out.println(actualAuthorName);
		Assert.assertEquals(actualAuthorName, AuthorName);
		
		String actualPublishDate = driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']")).getText();
		String actdate = "/"+actualPublishDate+"/";
		//System.out.println("/"+actualPublishDate+"/");
		Assert.assertEquals(actdate, publishDate);
	// verify the category list
		
		Log.info("Verfying the Category List");
		int count = 0;
		List<WebElement> menuList = driver.findElements(By.xpath("//div[@class='MuiBox-root css-dgk9vs']/button"));
		System.out.println(menuList.size());
		
		List<String> listElements = new ArrayList<String>();
		for (WebElement webElement : menuList) {
			//String text = webElement.getText();
			//System.out.print(text+", ");
			listElements.add(webElement.getText().replace(" " , ","));
			count++;
		}
		//System.out.println(listElements);
		String delim = ",";
		String category = String.join(delim, listElements);
		System.out.println(category);
		//System.out.println(CategoryElements);
		Assert.assertEquals(category, CategoryElements);
		if(count!=0) {
			if (count == menuList.size()) {
				System.out.println("menuLists elements are equal");
			} else {
				System.out.println("menuLists elements are not equal");
				Assert.assertTrue(false);
			} 
		}
		else {
			System.out.println("MenusLists are not present");
		}
	

		// ----------------- Veryfying the blog Title 
		Log.info("-----Veryfying the blog title--------");
		String actualblogTitle  = driver.findElement(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-1q9lqtf']")).getText();
		System.out.println(actualblogTitle);
		Assert.assertEquals(blogTitle, actualblogTitle);
		//--------------vERYFYING THE INGREDIENTS LIST
		
		Log.info("------vERYFYING THE INGREDIENTS LIST--------");
		int count1 = 0;
		List<String> listElements1 = new ArrayList<String>();
		List<WebElement> ingredientsList = driver.findElements(By.xpath("//p[@id= 'ingredientText']/ul/li"));
		System.out.println(ingredientsList.size());

		for (WebElement webElement : ingredientsList) {
			listElements1.add(webElement.getText().replace("  " , ","));
			count1++;
		}
		String delim1 = "-";
		String ingredients = String.join(delim1, listElements1);
		System.out.println(ingredients);
		Assert.assertEquals(ingredients, ingredientsElements);
		
		
		if (count1 == ingredientsList.size()) {
			System.out.println("menuLists elements are equal");
			Assert.assertTrue(false);
		} else {
			System.out.println("menuLists elements are not equal");
			Assert.assertTrue(false);
		}
		Log.info("----Image is displayed or not ----");
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='The house from the offer.']")).isEnabled());
		
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
}
