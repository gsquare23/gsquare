package com.dotKonnekt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class RecipePage extends BaseClass {

	RecipePage recipePage;
	
	@FindBy(xpath = "//input[@id='free-solo-2-demo']")
	WebElement searchBox;
	
	@FindBy(xpath = "(//img[@alt ='logo'])[3]")
	WebElement cartButton;
	
	@FindBy(xpath = "(//img[@alt='logo'])[1]")
	WebElement imgButton;
	
	@FindBy(xpath = "(//p[@id='directionText'])/ol/li")
	List<WebElement> directionsSteps;
	
	
	public RecipePage() {
		PageFactory.initElements( getDriver(), this);
	}
	
	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}
	
	public void validateDirections() {
		Log.info("----Verifyine the directions ---");

		String text1 = getDriver().findElement(By.xpath("(//p[@varient='h5'])[2]")).getText();
		Assert.assertEquals(text1, "Directions");
		
		Log.info("Checking the content for Directions");
		
		//List<WebElement> directionsSteps = getDriver().findElements(By.xpath("(//p[@id='directionText'])/ol/li"));
		
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
		
		System.out.println(getDriver().findElement(By.xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-qfzj9b']")).getText());
		
		  WebElement seeMoreButton =getDriver().findElement(By.
		  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-juaq']"));
		  if(seeMoreButton.isDisplayed()) { seeMoreButton.click(); }
		 
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
	}
	public void validateBlog(){
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	}
}
