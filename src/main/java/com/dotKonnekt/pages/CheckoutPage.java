package com.dotKonnekt.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class CheckoutPage extends BaseClass{

	

	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	SoftAssert softAssert = new SoftAssert();
	public void addItemTotheCart() {
		
	}
	String shopProducts = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4 css-1vybv8z']/div";
	String showingresult = "(//div[@class='MuiBox-root css-0'])[2]/p";
	String noresult = "//p[@class='MuiTypography-root MuiTypography-body1 css-3iqdok']";
	String shoptab = "//div[@aria-label='basic tabs example']/button[1]";
	String articletab = "//div[@aria-label='basic tabs example']/button[2]";
	String clickButton=  "//div[@class='MuiInputAdornment-root MuiInputAdornment-positionStart MuiInputAdornment-outlined MuiInputAdornment-sizeMedium css-1a6giau']//*[name()='svg']";
	String searchBox = "//input[@placeholder='Search']";
	String recentSearch = "//p[@class='MuiTypography-root MuiTypography-body1 css-64acg5']";
	String trending = "//p[@class='MuiTypography-root MuiTypography-body1 css-8s8b0g']";
	public void validateSeachFunctionalityForShopTab(String searchData, String ClickedBy,String Title) throws InterruptedException {
		getDriver().findElement(By.xpath(searchBox)).click();
		/*
		 * WebElement Trending = getDriver().findElement(By.xpath(trending)); String
		 * trendingTxt = Trending.getText(); Assert.assertEquals(trendingTxt,
		 * "Trending");
		 */
		
		getDriver().findElement(By.xpath(searchBox)).sendKeys(searchData);
		if(ClickedBy.equalsIgnoreCase("Mouse")) {
		getDriver().findElement(By.xpath(clickButton)).click();	
		}
		else if(ClickedBy.equalsIgnoreCase("Keyboard")) {
			getDriver().findElement(By.xpath(searchBox)).sendKeys(Keys.ENTER);
		}
		Action.explicitWaitbyTitle(getDriver(), "Search Page", Duration.ofSeconds(10));
		String title1 = getDriver().getTitle();
		Assert.assertEquals(title1, "Search Page"); 
		Thread.sleep(2000);
		WebElement ShopTab = getDriver().findElement(By.xpath(shoptab));
		//WebElement ArticleTab = getDriver().findElement(By.xpath(articletab));
		Action.explicitWait(getDriver(), ShopTab, Duration.ofSeconds(5));
		//WebElement ShopTab = getDriver().findElement(By.xpath(shoptab));
		if(ShopTab.getText().equals("Shop")) {
			
			WebElement NoResult = getDriver().findElement(By.xpath(noresult));
			System.out.println(NoResult.getText());
			System.out.println("Sorry! no result found for " + '"'+searchData+'"');
			if(NoResult.getText().equals("Sorry! no result found for " + '"'+searchData+'"')) {
				Log.info("Successfully verified the presence of the sorry things");
			}
			else {
				Assert.assertTrue(false, "Sorry No Result found is not present");
				
			}
			Log.info("No products are available for this search in Shop Tab");
		}
		
		
		
		if(ShopTab.getText().contains("Shop")&& !ShopTab.getText().equals("Shop")) {
				String  shopText = ShopTab.getText();
				String n = shopText.replaceAll("[^0-9]", "");
				System.out.println(n);
				WebElement Showingresult = getDriver().findElement(By.xpath(showingresult));
				System.out.println(Showingresult.getText());
				System.out.println("Showing " +n+ " results for " +'"' +searchData+ '"');
				if(Showingresult.getText().equalsIgnoreCase("Showing " +n+ " results for " +'"' +searchData+ '"')){
				String ss = (Showingresult.getText()).replaceAll("[^0-9]", "");
				System.out.println(ss);
				if(ss.equals(n)) {
					List<WebElement> ShopProducts = getDriver().findElements(By.xpath(shopProducts));
					int count  = ShopProducts.size();
					System.out.println(count);
					if(count == Integer.parseInt(ss)) {
						Log.info("Successfully Verified the Count of the Products");
					}
					else {
						Assert.assertTrue(false, "Products count are not equals");
					}
				}
				else {
					Assert.assertTrue(false, "Numbers are not equals");
				}
			
			}
				else {
					Assert.assertTrue(false, "Showing Result is not showing the correct numbers");
				}
		}
		else {
			Assert.assertTrue(false, "Shop tab is not present on the ui");
		}
		
		
		
		/*
		 * if(ArticleTab.getText().contains("Article") &&
		 * !ArticleTab.getText().equals("Article")) { String shopText =
		 * ShopTab.getText(); String n = shopText.replaceAll("[^0-9]", "");
		 * System.out.println(n); WebElement Showingresult =
		 * getDriver().findElement(By.xpath(showingresult)); String ss =
		 * (Showingresult.getText()).replaceAll("[^0-9]", ""); System.out.println(ss);
		 * if(ss.equals(n)) { List<WebElement> ShopProducts =
		 * getDriver().findElements(By.xpath(shopProducts)); int count =
		 * ShopProducts.size(); System.out.println(count); if(count ==
		 * Integer.parseInt(ss)) {
		 * Log.info("Successfully Verified the Count of the Products"); } else {
		 * Assert.assertTrue(false, "Products count are not equals"); }
		 * 
		 * } else { Assert.assertTrue(false, "article tab is not present on the ui"); }
		 * }
		 */
	
	}
	
	
	public void SearchFunctionalityForArticleTab (String searchData, String ClickedBy,String Title) throws InterruptedException {
		getDriver().findElement(By.xpath(searchBox)).click();
		WebElement Trending = getDriver().findElement(By.xpath(trending));
		String trendingTxt = Trending.getText();
		Assert.assertEquals(trendingTxt, "Trending");
		
		getDriver().findElement(By.xpath(searchBox)).sendKeys(searchData);
		if(ClickedBy.equalsIgnoreCase("Mouse")) {
		getDriver().findElement(By.xpath(clickButton)).click();	
		}
		else if(ClickedBy.equalsIgnoreCase("Keyboard")) {
			getDriver().findElement(By.xpath(searchBox)).sendKeys(Keys.ENTER);
		}
		Log.info("Successfully performed the search action");
		Action.explicitWaitbyTitle(getDriver(), "Search Page", Duration.ofSeconds(10));
		String title1 = getDriver().getTitle();
		Assert.assertEquals(title1, "Search Page"); 
		Log.info("Successfully verified the presence of the same title");
		//Thread.sleep(2000);
		WebElement ArticleTab = getDriver().findElement(By.xpath(articletab));
		//Action.explicitWait(getDriver(), ArticleTab, Duration.ofSeconds(5));
		//Action.click(getDriver(), ArticleTab);
		Thread.sleep(2000);
		Action.click(getDriver(), ArticleTab);
		Thread.sleep(1000);
		Log.info("Successfully clicked on the Article Tab");
		if(ArticleTab.getText().equals("Article")) {
			Action.click(getDriver(), ArticleTab);
			WebElement NoResult = getDriver().findElement(By.xpath(noresult));
			if(NoResult.getText().equals("Sorry! no result found for " + '"'+searchData+'"')) {
				Log.info("Successfully verified the presence of the sorry things in article tab");
			}
			else {
				Assert.assertTrue(false, "Sorry No Result found is not present in article tab");
			}
			Log.info("No products/ Articles are available for this search in Article Tab");
		}
		
		if(ArticleTab.getText().contains("Article") && !ArticleTab.getText().equals("Article")) {
			Log.info("fghjk");
			//Action.click(getDriver(), ArticleTab);
			//Thread.sleep(1000);
			String  ArticleTabText = ArticleTab.getText();
			String n = ArticleTabText.replaceAll("[^0-9]", "");
			System.out.println(n);
			WebElement Showingresult = getDriver().findElement(By.xpath(showingresult));
			String ss = (Showingresult.getText()).replaceAll("[^0-9]", "");
			System.out.println(ss);
			if(ss.equals(n)) {
				List<WebElement> ShopProducts = getDriver().findElements(By.xpath(shopProducts));
				int count  = ShopProducts.size();
				System.out.println(count);
				if(count == Integer.parseInt(ss)) {
					Log.info("Successfully Verified the Count of the Products");
				}
				else {
					Assert.assertTrue(false, "Products count are not equals");
				}
			
		}
		else {
			Assert.assertTrue(false, "article tab is not present on the ui");
			}
		}
		
		
		
	}
	
	
	String allproduct = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4 css-1vybv8z']/div";
	String carticon = "//*[name()='svg' and @data-testid='ShoppingCartOutlinedIcon']";
	String wishlist = "//*[name()='svg' and @data-testid='FavoriteBorderOutlinedIcon']";
	String quickview = "//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	String discountedPrice = "//div[@class='MuiBox-root css-70qvj9']/p";
	String actualPrice = "//div[@class='MuiTypography-root MuiTypography-body1 css-lgaoco']";
	String productsName = "(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4 css-1vybv8z'])[1]/div/div/div/div[1]";
	String images = "(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-4 css-1vybv8z'])[1]/div/div/span/img";

	public void ShopProducts() throws InterruptedException {

		List<WebElement> products1 = getDriver().findElements(By.xpath(allproduct));
		int n = products1.size();
		System.out.println(n);
		Thread.sleep(2000);
		List<WebElement> image = getDriver().findElements(By.xpath(images));
		int x = image.size();
		int count4 = 0;
		if (x == n) {
			for(WebElement i : image) {
				Action.mouseOverElement(getDriver(), i);
				if(i.getAttribute("srcset").contains("shopify.com")) {
					count4++;
				}
			}
			if(count4 ==n ) {
			System.out.println("All " + count4 + " images are present");}
			else {
				softAssert.assertTrue(false, n-count4+ " Images are not present  ");
			}
		} else {
			System.out.println(n - x + " Images are not present ");
			softAssert.assertTrue(false, +n - x + " Images are not present ");
		}

		List<WebElement> productName1 = getDriver().findElements(By.xpath(productsName));
		int j = productName1.size();
		if (j == n) {
			System.out.println("All Products name are present");
		} else {
			System.out.println(n - j + " Products name are not present ");
			softAssert.assertTrue(false, +n - j + " Products name are not present ");
		}

		/*
		 * List<WebElement> productActPrice =
		 * getDriver().findElements(By.xpath(actualPrice)); int z =
		 * productActPrice.size(); if (z == n) {
		 * System.out.println("All Actual Prices are present"); } else {
		 * System.out.println(n - z + " Actual Prices are not present ");
		 * softAssert.assertTrue(false, n - z + " Actual Prices are not present "); }
		 */

		List<WebElement> quickviewlink = getDriver().findElements(By.xpath(quickview));
		int i = quickviewlink.size();
		if (i == n) {
			System.out.println("All Quick View links are present");
		} else {
			System.out.println(n - i + " Quick View links are not present ");
			softAssert.assertTrue(false, n - i + " Quick View links are not present ");
		}

		List<WebElement> carticon1 = getDriver().findElements(By.xpath(carticon));
		int c = carticon1.size();
		if (c == n) {
			System.out.println("All carticon are present");
		} else {
			System.out.println(n - c + " carticon are not present ");
			softAssert.assertTrue(false, +n - c + " carticon are not present ");
		}

		List<WebElement> wishlist1 = getDriver().findElements(By.xpath(wishlist));

		int d = carticon1.size();
		if (d == n) {
			System.out.println("All Wishlist icon are present");
		} else {
			System.out.println(n - d + " Wishlist icon are not present ");
			softAssert.assertTrue(false, +n - c + " Wishlist icon are not present ");
		}

		softAssert.assertAll();
	}
	
	
	public void selectAProduct() {
		Log.info("Starting the SelectAProduct");
		List<WebElement> products1 = getDriver().findElements(By.xpath(allproduct));
		int n = products1.size();
		System.out.println(n);
		
		 Random r = new Random(); 
		  int randomValue = r.nextInt(products1.size()); //Getting a random value that is between 0 and (list's size)-1
		  products1.get(randomValue).click(); //Clicking on the random item in the list.\
		 System.out.println( products1.get(randomValue).getText());
		 Action.explicitWaitbyTitle(getDriver(), "Product", Duration.ofSeconds(5));
		  Assert.assertEquals(getDriver().getTitle(), "Product");
		  Log.info("Successfully verified the title of the Product page from search Page");
	}
	
	
	String cartButton = "//div[@class='MuiBox-root css-gw6fln']/button[1]";
	String stockCount = "//div[@class='MuiBox-root css-8hvv1y']/div/input";

	public void availabiltyStock() throws InterruptedException {

		Log.info("AddToCart of Product Page verification");
		WebElement StockCount = getDriver().findElement(By.xpath(stockCount));
		Assert.assertEquals(StockCount.getAttribute("value"), "1", "Count is not set to 1");
		WebElement addToCartIcon = getDriver().findElement(By.xpath(cartButton));
		boolean result = Action.isDisplayed(getDriver(), addToCartIcon);
		String elementTxt = addToCartIcon.getText();
		if (elementTxt.equalsIgnoreCase("ADD TO CART") && result){
			Assert.assertTrue(addToCartIcon.isEnabled(), "Add To Cart button is not enabled");
			System.out.println("AddTOCart is enabled");
			Action.doubleClick_SendValue(StockCount, "4");
			//Action.type(StockCount, "4");
			Thread.sleep(3000);
			
		}
		if(elementTxt.equalsIgnoreCase("OUT OF STOCK") && result){
			Assert.assertTrue(!addToCartIcon.isEnabled(), "Out of Stock button is enabled");
			Log.info("Product is Out of Stock");
		}
			
		
		else {
			System.out.println("Cart Icon is not present");
			Assert.assertTrue(result, "Cart Icon is not present");
		}
		Log.info("Successfully ends the availabiltyStock");
	}
	
	
	String statusInfo = "(//div[@class='css-m4samb'])[2]/div/div/span/span[2]";
	public void CheckoutPageStatus() {
		Log.info("CheckoutPageElements verification starts");
		List<WebElement> StatusInfo = getDriver().findElements(By.xpath(statusInfo));
		if(StatusInfo.size()==5) {
			List<String> listElements = new ArrayList<String>();
			for(WebElement i :  StatusInfo) {
				listElements.add(i.getText());
			}
			//String deli = "\n"; 
			  //String status = String.join(deli, listElements);
			  System.out.println(listElements);
			String elements = "CART,CUSTOMER INFORMATION,SHIPPING INFORMATION,PAYMENT INFORMATION,ORDER CONFIRMATION";
			List<String> myList = new ArrayList<String>(Arrays.asList(elements.split(",")));
			System.out.println(myList);
			if(listElements.containsAll(myList) && myList.containsAll(listElements)) {
				Log.info("Successfully verified that all the status are in correct form");
			}
			else {
				Assert.assertTrue(false, "Status are not in correct form");
			}
		}
	}
	String emailBox = "(//div[@class='MuiBox-root css-npgrt2'])/fieldset/form/div[1]/div[2]/div/div/div/div/div/div[2]/div/input";
	String loginLink = "(//div[@class='MuiBox-root css-npgrt2'])/fieldset/form/div[1]/div[2]/div/div/div/div/div/div/div/p[2]";
	String already = "(//div[@class='MuiBox-root css-npgrt2'])/fieldset/form/div[1]/div[2]/div/div/div/div/div/div/div/p[1]";
	String emailText = "(//div[@class='MuiBox-root css-npgrt2'])/fieldset/form/div[1]/div[2]/div/div/div/div/div/div[1]/p";
	String contact = "(//div[@class='MuiBox-root css-npgrt2'])/fieldset/form/div[1]/div[1]/div[1]/p";
	public void contactInfo() throws InterruptedException {
		WebElement Contact = getDriver().findElement(By.xpath(contact));
		
		System.out.println(Contact.getText());
		Assert.assertTrue(Contact.isDisplayed(), "Contact Information is not present");
		Action.JSClick(getDriver(), Contact);
		Thread.sleep(1000);
		WebElement EmailText = getDriver().findElement(By.xpath(emailText));
		Assert.assertEquals(EmailText.getText(), "Email*", "Email Text is not Present");
		WebElement Already = getDriver().findElement(By.xpath(already));
		Assert.assertEquals(Already.getText(), "Already have an account ?", "Already have an account?  Text is not Present");
		WebElement LoginLink = getDriver().findElement(By.xpath(loginLink));
		Assert.assertEquals(LoginLink.getText(), " Log-in", " Log-in  Text is not Present");
		Assert.assertTrue(LoginLink.isEnabled(), "Login link is not Enabled");
		WebElement EmailBox = getDriver().findElement(By.xpath(emailBox));
		Assert.assertEquals(EmailBox.getAttribute("placeholder"), "Email", " Placeholder  Text is not Present");
		Action.type(EmailBox, "garvitofficial97@gmial.com");
		
				
		
	}
}
