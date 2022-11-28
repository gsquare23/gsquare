package com.dotKonnekt.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.pages.RecipePage;
import com.dotKonnekt.utility.Log;import net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType;

public class RecipePageTest extends BaseClass {

	RecipePage recipePage;
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().close();
	}

	@Test(enabled = true, priority = 0)
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		recipePage = new RecipePage();
		String actual_title = recipePage.getTitle();
		System.out.println("Title is" + actual_title);
		Assert.assertEquals(actual_title, "RecipePage");
		Log.endTestCase("verifyTitle");
	}

	@Test(enabled = true, priority = 1)
	public void verifyPageHeader() throws InterruptedException {
		Log.startTestCase("verifyPageHeader");

		// Thread.sleep(5000);
		Log.info("-------SEARCHBOX FUNCTIONALITY START ------");

		WebElement searchBox = getDriver().findElement(By.xpath("//input[@id='free-solo-2-demo']"));
		if (searchBox.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + searchBox.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + searchBox.isDisplayed());
		}

		// that the “Search” Box is enabled
		if (searchBox.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + searchBox.isEnabled()); // Thread.sleep(5000);
																							// searchBox.sendKeys("Selenium");
			Thread.sleep(5000);
		} else {
			System.out.println("Search Box is not enabled. Return: " + searchBox.isEnabled());
			Assert.assertTrue(searchBox.isEnabled());
		}
		Log.info("-------SEARCHBOX FUNCTIONALITY END ------");

		Log.info("-------CARTButton FUNCTIONALITY START ------");

		WebElement cart = getDriver().findElement(By.xpath("(//img[@alt ='logo'])[3]"));
		if (cart.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + cart.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + cart.isDisplayed());
		}

		// verify that the “Search” Box is enabled
		if (cart.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + cart.isEnabled());
			// Thread.sleep(5000);
			// logo.sendKeys("Selenium");
			// Thread.sleep(5000);
		} else {
			System.out.println("Search Box is not enabled. Return: " + cart.isEnabled());
			Assert.assertTrue(cart.isEnabled());
		}
		Log.info("-------CARTButton FUNCTIONALITY END ------");

		Log.info("-------userButton FUNCTIONALITY START ------");

		WebElement userButton = getDriver().findElement(By.xpath("(//img[@alt='logo'])[4]"));
		if (userButton.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + userButton.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + userButton.isDisplayed());
		}

		// verify that the “Search” Box is enabled
		if (userButton.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + userButton.isEnabled());
			// Thread.sleep(5000);
			// logo.sendKeys("Selenium");
			// Thread.sleep(5000);
		} else {
			System.out.println("Search Box is not enabled. Return: " + userButton.isEnabled());
			Assert.assertTrue(userButton.isEnabled());
		}
		Log.info("-------userButton FUNCTIONALITY END ------");

		Log.info("-------Logo FUNCTIONALITY START ------");

		WebElement Logo = getDriver().findElement(By.xpath("(//img[@alt='logo'])[1]"));
		if (Logo.isDisplayed()) {
			System.out.println("Search Box is visible. Return: " + Logo.isDisplayed());
		} else {
			System.out.println("Search Box is not visible. Return: " + Logo.isDisplayed());
		}

		// verify that the “Search” Box is enabled
		if (Logo.isEnabled()) {
			System.out.println("Search Box is enabled. Return: " + Logo.isEnabled());
			// Thread.sleep(5000);
			// logo.sendKeys("Selenium");
			// Thread.sleep(5000);
		} else {
			System.out.println("Search Box is not enabled. Return: " + Logo.isEnabled());
			Assert.assertTrue(Logo.isEnabled());
		}
		Log.info("-------Logo FUNCTIONALITY END ------");

		Log.endTestCase("verifyPageHeader");
	}

	@Test(enabled = false, priority = 2)
	public void verifyMenusLists() {
		Log.startTestCase("verifyMenusLists");
		int count = 0;
		List<WebElement> menuList = getDriver().findElements(By.xpath("//div[@class='css-vm1qo5']/div/button"));
		System.out.println(menuList.size());

		for (WebElement webElement : menuList) {
			System.out.println(webElement.getText());
			count++;
		}
		if (count == menuList.size()) {
			System.out.println("menuLists elements are equal");
		} else {
			System.out.println("menuLists elements are not equal");
			Assert.assertTrue(false);
		}
		Log.endTestCase("verifyMenusLists");
	}

	@Test(enabled = true, priority = 4)
	public void verifyBlog() throws InterruptedException {
		Log.startTestCase("verifyBlog");
		Log.info("----Verifyine the blog title----");
		String expectedTitle = "Sugarcane juice black wheat muffins/cake";
		String blogTitle = getDriver()
				.findElement(By.xpath("//div[@class = \"MuiTypography-root MuiTypography-body1 css-1q9lqtf\"]"))
				.getText();
		Assert.assertEquals(blogTitle, expectedTitle);
		Log.info("----Verifyine the blog title description----");
		String expectedblogTitleDescription = "Sugar juice is a quick energy booster. Try this healthy version of baking, which is also easy on the gut. Sugar juice is a quick energy booster. Try this healthy version of baking, which is also easy on the gut.Sugar juice is a quick energy booster. Try this healthy version of baking, which is also easy on the gut.";
		String blogTitleDescription = getDriver().findElement(By.xpath("//p[@id = 'details']/p")).getText();
		Assert.assertEquals(blogTitleDescription, expectedblogTitleDescription);
		Log.info("----Verifying the Ingredients List ----");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(5000);
		String text = getDriver().findElement(By.xpath("(//p[@varient = 'h5'])[1]")).getText();
		if (!text.equals("Ingredients")) {
			System.out.println("Ingredients are not present");
			Assert.assertTrue(false);
		}

		Log.info("---Ingredients List verification----");
		int count = 0;
		List<WebElement> ingredientsList = getDriver().findElements(By.xpath("//p[@id= 'ingredientText']/ul/li"));
		System.out.println(ingredientsList.size());

		for (WebElement webElement : ingredientsList) {
			System.out.println(webElement.getText());
			count++;
		}
		if (count == ingredientsList.size()) {
			System.out.println("menuLists elements are equal");
		} else {
			System.out.println("menuLists elements are not equal");
			Assert.assertTrue(false);
		}
		Log.info("----Image is displayed or not ----");
		Assert.assertTrue(getDriver().findElement(By.xpath("//img[@alt='The house from the offer.']")).isEnabled());

		Log.endTestCase("verifyBlog");
	}

	@Test(enabled = true, priority = 3)
	public void verifyDirections() {
		Log.startTestCase("verifyDirections");
		Log.info("----Verifyine the directions ---");

		String text1 = getDriver().findElement(By.xpath("(//p[@varient='h5'])[2]")).getText();
		Assert.assertEquals(text1, "Directions");
		
		Log.info("Checking the content for Directions");
		
		List<WebElement> directionsSteps = getDriver().findElements(By.xpath("(//p[@id='directionText'])/ol/li"));
		
		System.out.println(directionsSteps.size());
		int count = 0;
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)", "");
		for (WebElement webElement : directionsSteps) {
			System.out.println(webElement.getText());
			count++;
		}
		if (count == directionsSteps.size()) {
			System.out.println("Directions Steps are equal");
			//Assert.assertTrue(false);
		} else {
			System.out.println("Directions Steps are not equal");
			Assert.assertTrue(false);
		}
		
		System.out.println(getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-1ps229']/p[1]")).getText());
		//getDriver().findElements(By.xpath("//span[@class=\"MuiChip-label MuiChip-labelMedium css-9iedg7\"]"))
		List<WebElement> tagList = getDriver().findElements(By.xpath("//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7']"));
		System.out.println(tagList.size());
		int countt = 0;
		//JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		//js1.executeScript("window.scrollBy(0,1000)", "");
		for (WebElement webElement : tagList) {
			System.out.println(webElement.getText());
			countt++;
		}
		if (countt == tagList.size()) {
			System.out.println("Tags List are equal");
			//Assert.assertTrue(false);
		} else {
			System.out.println("Tags list Steps are not equal");
			Assert.assertTrue(false);
		}
		
		
		Log.info("Nutrition per Saving lists");
		String nutrionName = getDriver().findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1aoo3g']")).getText();
		Assert.assertEquals(nutrionName, "Nutritions Per Serving");
		WebElement seeButton =getDriver().findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1fatci1']"));
		if(seeButton.isDisplayed()) {
			seeButton.click();
		}
		List<WebElement> nutritionList = getDriver().findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-22dtt9']"));
		System.out.println(nutritionList.size());
		int count1 = 0;
		//JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		//js1.executeScript("window.scrollBy(0,1000)", "");
		for (WebElement webElement : nutritionList) {
			System.out.println(webElement.getText());
			count1++;
		}
		if (count1 == nutritionList.size()) {
			System.out.println("nutritionList List are equal");
			//Assert.assertTrue(false);
		} else {
			System.out.println("nutritionList list Steps are not equal");
			Assert.assertTrue(false);
		}
		
		Log.endTestCase("verifyDirections");
	}

}
