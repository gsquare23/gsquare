package com.dotKonnekt.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;

public class BlogPage extends BaseClass{

	SoftAssert softAssert = new SoftAssert();

	public BlogPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	String Blogimage = "//div[@class='MuiBox-root css-xyyqyk']//img[@alt='logo']";
	public void imageVerification() throws InterruptedException {
		WebElement imageDes = getDriver().findElement(By.xpath(Blogimage));
		System.out.println(imageDes.isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(imageDes.getAttribute("srcset").contains("amazonaws.com"), "Image is not present");
		Action.explicitWait(getDriver(), imageDes, Duration.ofSeconds(5));
		Boolean p = (Boolean) ((JavascriptExecutor)getDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", imageDes);
		if(p) {
			System.out.println("Image is present nad verified successfully");
		}
		else {
			System.out.println("Image is not present");
			Assert.assertTrue(false, "Image is not present");
		}
		
		
	}
	
	String blog_title = "//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom css-rhwwre']";
	public String blogTitleVerification() {
		String actualblogTitle = getDriver().findElement(By.xpath(blog_title)).getText();
		return actualblogTitle;
		
	}
	String allproduct = "//div[@class='MuiBox-root css-srjk1z']/div";
	//String images = allproduct + "/img";
	String images = "//div[@class='MuiBox-root css-srjk1z']/div/img";
	String wishlist = "//*[name()='svg'][@data-testid='FavoriteBorderOutlinedIcon']";
	String ratings = "//div[@class='MuiBox-root css-yeouz0']/span";
	//String quickView = allproduct+ "/div[2]/div/div[2]";
	String quickView ="//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	//String productName= allproduct + "/div[2]/div[2]";
	String productName = "//div[@class='MuiTypography-root MuiTypography-h5 css-qla7e7']";
	String productPrice = "//p[@class='MuiTypography-root MuiTypography-body1 css-1tk0scz']";
	String addtoCartBtn = "//div[@class='css-z2nkb7']/button";
	String productDetail = "//div[@class='MuiTypography-root MuiTypography-body1 css-rkcvek']/a";
	public void productImageVerification() {
		
		List<WebElement> products1 = getDriver().findElements(By.xpath(allproduct));
		int n = products1.size();
		System.out.println(n);
		
		

		List<WebElement> image = getDriver().findElements(By.xpath(images));
		int x = image.size();
		int count4 = 0;
		System.out.println(x+ " ProductImage should be present");
		if (x == n) {
			for(WebElement i : image) {
				Action.scrollByVisibilityOfElement(getDriver(), i);
				if(i.getAttribute("src").contains("shopify.com")) {
					count4++;
				}
			}
			System.out.println(count4);
			if(count4 ==n ) {
			System.out.println("All " + count4 + " images are present");}
			else {
				softAssert.assertTrue(false, n-count4+ " Images are not present  ");
			}
		} else {
			System.out.println(n - x + " Images are not present ");
			softAssert.assertTrue(false, +n - x + " Images are not present ");
		}
		
		List<WebElement> productName1 = getDriver().findElements(By.xpath(productName));
		int j = productName1.size();
		int count1 =0;
		System.out.println(j+ " ProductName should be present");
		if (j == n) {
			for(WebElement i : productName1) {
				//Action.scrollByVisibilityOfElement(getDriver(), i);
				if(i.isDisplayed()) {
					Log.info("ProductName is successfully verified");
					count1++;
				}
			}
			if(count1 ==n ) {
			System.out.println("All Products name are present");}
			else {
				softAssert.assertTrue(false, n-count1+ " Products name are not present  ");
			}
		} else {
			System.out.println(n - j + " Products name are not present ");
			softAssert.assertTrue(false, +n - j + " Products name are not present ");
		}
		
		
		List<WebElement> productActPrice = getDriver().findElements(By.xpath(productPrice));
		int z = productActPrice.size();
		int count2 =0;
		System.out.println(z+ " Product Price should be present");
		if (z == n) {
			for(WebElement i : productActPrice) {
				//Action.scrollByVisibilityOfElement(getDriver(), i);
				if(i.isDisplayed()) {
					Log.info("Product Price is successfully verified");
					count2++;
				}
			}
			if(count2 ==n ) {
				System.out.println("All Products Price are present");}
				else {
					softAssert.assertTrue(false, n-count2+ " Products Price are not present  ");
				}	
			} 
		else {
			System.out.println(n - z + " Actual Prices are not present ");
			softAssert.assertTrue(false, n - z + " Actual Prices are not present ");
		}
		
		
		List<WebElement> quickviewlink = getDriver().findElements(By.xpath(quickView));
		int m = quickviewlink.size();
		int count3=0;
		System.out.println(m+ "quick view links should be present");
		
		if (m == n) {
			for(WebElement i : quickviewlink) {
				//Action.scrollByVisibilityOfElement(getDriver(), i);
				if(i.isDisplayed()) {
					softAssert.assertTrue(i.isEnabled(), "Quick View Link is not Enabled");
					Log.info("Quick View Link is successfully verified");
					count3++;
				}
			}
			if(count3 ==n ) {
				System.out.println("All Quick View links are present");}
				else {
					softAssert.assertTrue(false, n-count3+ " Quick View links are not present  ");
				}	
			} 
		 else {
			System.out.println(n - m + " Quick View links are not present ");
			softAssert.assertTrue(false, n - m + " Quick View links are not present ");
		}
		
		List<WebElement> carticon1 = getDriver().findElements(By.xpath(addtoCartBtn));
		int c = carticon1.size();
		int count5=0;
		System.out.println(c+ "Add To Cart button should be present");
		if (c == n) {
			for(WebElement i : carticon1) {
				//Action.scrollByVisibilityOfElement(getDriver(), i);
				if(i.isDisplayed()) {
					softAssert.assertTrue(i.isEnabled(), "Add To Cart button is not Enabled");
					Log.info("Add To Cart button is successfully verified");
					count5++;
				}
			}
			if(count5 ==n ) {
				System.out.println("All Add To Cart button are present");}
				else {
					softAssert.assertTrue(false, n-count5+ " Add To Cart button are not present  ");
				}	
			} 
			else {
			System.out.println(n - c + " carticon are not present ");
			softAssert.assertTrue(false, +n - c + " carticon are not present ");
		}
		
		List<WebElement> wishlist1 = getDriver().findElements(By.xpath(wishlist));

		int d = wishlist1.size();
		int count6=0;
		System.out.println(d+ "Add To Cart button should be present");
		if (d == n) {
			for(WebElement i : wishlist1) {
				//Action.scrollByVisibilityOfElement(getDriver(), i);
				if(i.isDisplayed()) {
					softAssert.assertTrue(i.isEnabled(), "Wishlist icon is not Enabled");
					Log.info("Wishlist icon is successfully verified");
					count6++;
				}
			}
			if(count6 ==n ) {
				System.out.println("All Wishlist icon are present");}
				else {
					softAssert.assertTrue(false, n-count6+ " Wishlist icon are not present  ");
				}	
			} 
		else {
			System.out.println(n - d + " Wishlist icon are not present ");
			softAssert.assertTrue(false, +n - d + " Wishlist icon are not present ");
		}
		
		
		List<WebElement> Ratings = getDriver().findElements(By.xpath(ratings));

		int e = Ratings.size();
		int count7=0;
		System.out.println(e+ "Ratings icon should be present");
		if (e == n) {
			for(WebElement i : Ratings) {
				//Action.scrollByVisibilityOfElement(getDriver(), i);
				if(i.isDisplayed()) {
					softAssert.assertTrue(i.isEnabled(), "Ratings icon is not Enabled");
					Log.info("Ratings icon is successfully verified");
					count7++;
				}
			}
			if(count7 ==n ) {
				System.out.println("All Ratings icon are present");}
				else {
					softAssert.assertTrue(false, n-count7+ " Ratings icon are not present  ");
				}	
			} 
		 else {
			System.out.println(n - e + " Ratings icon are not present ");
			softAssert.assertTrue(false, +n - e + " Ratings icon are not present ");
		}
		
		softAssert.assertAll();
		
	}
	
	
	 
	/*
	 * public void productWishlistVerification() {
	 * 
	 * List<WebElement> wishlist1 = getDriver().findElements(By.xpath(wishlist));
	 * 
	 * int d = wishlist1.size(); WebElement login =
	 * getDriver().findElement(By.xpath(loginPageTxt));
	 * Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
	 * Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed(
	 * )); WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
	 * Action.click(getDriver(), CrossButton)
	 * 
	 * 
	 * }
	 */
	String recipeVideo = "//div[@class='MuiBox-root css-1cbkcwo']";
	public void blogVideoSection() throws InterruptedException {
		WebElement recipeVideos = getDriver().findElement(By.xpath(recipeVideo));
		Action.scrollByVisibilityOfElement(getDriver(), recipeVideos);
		System.out.println(Action.isDisplayed(getDriver(), recipeVideos));
		Action.click(getDriver(), recipeVideos);
		Thread.sleep(5000);
	}
	
	String productName2 = "//div[@class='MuiTypography-root MuiTypography-h5 css-qla7e7'][1]";
	String loginbutton = "//button[normalize-space()='LOG IN']";
	String loginPageTxt = "//input[@placeholder='Email']";
	String crossbutton1 = "//*[local-name()='svg' and @data-testid='ClearIcon']";
	String wishlistsTxt = "(//p[@class='MuiTypography-root MuiTypography-body1 css-uog56n'])[2]";
	String productnames = "//div[@class='MuiBox-root css-d8xk2t']/p";

	// String iconn = "(//*[local-name()='svg' and
	// @data-testid='FavoriteIcon'])[1]";

	public void wishlistIconFunctionalityForLoggedIn() throws InterruptedException {
		WebElement iconFunctionality = getDriver().findElement(By.xpath(wishlist));
		Action.scrollByVisibilityOfElement(getDriver(), iconFunctionality);
		Action.click(getDriver(), iconFunctionality);

		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		System.out.println("dfghjk");
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());

		getDriver().findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
		;
		getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		Thread.sleep(20000);
		getDriver().findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
		System.out.println("successfully entered the username and clicked on the Login button");
		Thread.sleep(10000);
		JavascriptExecutor j = (JavascriptExecutor) getDriver();
		j.executeScript("window.scrollBy(0,450)");
		//Action.scrollByVisibilityOfElement(getDriver(), iconFunctionality);
		System.out.println("Scrolled to the Wishlist Icon");
		// getDriver().navigate().refresh();

		WebElement iconFunctionality1 = getDriver().findElement(By.xpath(wishlist));
		Action.explicitWait(getDriver(), iconFunctionality1, Duration.ofSeconds(5000));
		Action.click(getDriver(), iconFunctionality1);

		/*
		 * Thread.sleep(5000); System.out.println("fdghjkcgvhj");
		 * 
		 * 
		 * WebElement wish = getDriver().findElement(By.xpath(iconn));
		 * Assert.assertTrue(wish.isDisplayed());
		 * 
		 * 
		 * 
		 * Thread.sleep(5000);
		 */
		// getDriver().navigate().refresh();
		// Action.pageLoadTimeOut(getDriver(), 10);
		JavascriptExecutor j1 = (JavascriptExecutor) getDriver();
		j1.executeScript("window.scrollBy(0,0)");
		WebElement productName1 = getDriver().findElement(By.xpath(productName2));
		String text = productName1.getText();
		System.out.println(text);
		Log.info("Click on user account button");
		getDriver().findElement(By.xpath("//div[@class='MuiBox-root css-tap1yw']//img[@alt='logo']")).click();
		Action.explicitWaitbyTitle(getDriver(), "My Account", Duration.ofSeconds(10));
		// Assert.assertEquals(getDriver().getTitle(), "My Account");
		System.out.println("dfghgjkl");
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		WebElement wishlistText = getDriver().findElement(By.xpath(wishlistsTxt));
		Action.scrollByVisibilityOfElement(getDriver(), wishlistText);
		System.out.println("dfghgjkl");
		List<WebElement> Wishlists = getDriver().findElements(By.xpath(productnames));
		System.out.println(Wishlists.size());
		boolean flag = false;
		for (WebElement webElement : Wishlists) {
			String name = webElement.getText();
			System.out.println(name);
			String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				// System.out.println("test1");
				String s = String.valueOf(new char[] { ch });
				// System.out.println(s);
				if (specialCharactersString.contains(Character.toString(ch))) {
					System.out.println(s + " contains special character");

					if (name.contains(s)) {
						String splits1[] = name.split(s);
						System.out.println(splits1[0]);
						String actualName = splits1[0];
						if (text.contains(actualName)) {
							System.out.println("Product is present in Wishlist tab ");
							flag = true;
						} else {
							Assert.assertTrue(false, " Not Present in Wishlist Tab ");

						}

					}
					break;

				}
			}
			if (flag) {
				break;
			} 

		}
	}
	
	
	String icon = "(//*[local-name()='svg' and @data-testid='FavoriteBorderOutlinedIcon'])[1]";
	String cartButton = "//div[@class='MuiBox-root css-1g2muyo']/button[1]";
	String stockCount = "//div[@class='MuiBox-root css-8hvv1y']/div/input";
	String productName1 = "//div[@class='MuiTypography-root MuiTypography-body1 css-122og3s']";
	String Bigimage = "(//div[@class='magnifier_container MuiBox-root css-1pujjbg']//img)[2]";
	String smallImage = "(//div[@class='css-j6afl0']//img)[2]";
	public void productQuickView() throws InterruptedException{
		List<WebElement> products1 = getDriver().findElements(By.xpath(allproduct));
		int n = products1.size();
		System.out.println(n);
		
		
		int count=1;
		int count1 = 1;
		for(WebElement j: products1) {
			String productname = "("+ allproduct + "/div[2]/div[2])" +"["+ count + "]"; 
			WebElement ProductName1 = getDriver().findElement(By.xpath(productname));
			Action.scrollByVisibilityOfElement(getDriver(), ProductName1);
			String PName = ProductName1.getText();
			System.out.println(PName);
			Assert.assertTrue(ProductName1.isDisplayed());
			
			String productprice = "("+ allproduct + "/div[2]/div[3]/p)"+"["+ count1 + "]";
			WebElement ProductPrice = getDriver().findElement(By.xpath(productprice));
			String PPrice = ProductPrice.getText();
			System.out.println(PPrice);
			Assert.assertTrue(ProductPrice.isDisplayed(), "Price is not present on the product Tile");
			//(//div[@class='MuiBox-root css-srjk1z']/div/div[2]/div[1]/div/span)[2]
			String productRating = "("+ allproduct + "/div[2]/div[1]/div/span)"+"["+ count + "]";
			WebElement ProductRating = getDriver().findElement(By.xpath(productRating));
			String PRating = ProductRating.getAttribute("aria-label");
			System.out.println(PRating);
			
			String quickView = "("+ allproduct + "/div[2]/div/div[2])"+"["+ count + "]";
			WebElement QuickView = getDriver().findElement(By.xpath(quickView));
			if(QuickView.isDisplayed()) {
				Action.click(getDriver(), QuickView);
				String quickPName = "//div[@class='MuiTypography-root MuiTypography-body1 css-vcbw66']";
				WebElement QuickPName = getDriver().findElement(By.xpath(quickPName));
				softAssert.assertTrue(QuickPName.getText().contains(PName), "Quick view Link does not contain same name as product Tile");
				Log.info("Successfully verifying the product name with quick view Product name");
				
				String quickPPrice = "//div[@class='MuiTypography-root MuiTypography-body1 css-1b9o26n']";
				WebElement QuickPPrice = getDriver().findElement(By.xpath(quickPPrice));
				System.out.println(QuickPPrice.getText());
				softAssert.assertEquals(QuickPPrice.getText(), PPrice, "Quick view Link does not contain same Price as product Tile");
				Log.info("Successfully verifying the product Price with quick view Product Price");
				
				String quikViewPDesc = "//div[@class='MuiTypography-root MuiTypography-body1 css-9p1hyi']";
				WebElement QuikViewPDesc = getDriver().findElement(By.xpath(quikViewPDesc));
				softAssert.assertTrue(QuikViewPDesc.isDisplayed(), "Quick view Product does not contain Product description");
				Log.info("Successfully verifying the product Description on clicking the quick view ");
				
				String productDetail1 = "//div[contains(@class,'css-rkcvek')]/a";
				WebElement ProductDetail1 = getDriver().findElement(By.xpath(productDetail1));
				softAssert.assertTrue(ProductDetail1.isDisplayed() && ProductDetail1.getText().equals("View Product Details"), "Quick view Product does not contain View Product Details link");
				softAssert.assertTrue(ProductDetail1.isEnabled(), "View Product Detail is enabled ");
				Log.info("Successfully verifying the View Product Details on clicking the quick view ");
				
				String quickPRatings = "//div[@class='MuiBox-root css-18u70he']//div[@class='MuiBox-root css-yeouz0']/span";
				WebElement QuickPRatings = getDriver().findElement(By.xpath(quickPRatings));
				String PQuickPRatings = ProductRating.getAttribute("aria-label");
				softAssert.assertEquals(PQuickPRatings, PRating, "Quick view Link does not contain same ratings as product Tile");
				Log.info("Successfully verifying the product ratings on clicking the quick view ");
				
				WebElement smallProductImage = getDriver().findElement(By.xpath(smallImage));
				String value2 = smallProductImage.getAttribute("alt");
				System.out.println(value2);

				WebElement ProductImages = getDriver().findElement(By.xpath(Bigimage));
				String value1 = ProductImages.getAttribute("alt");
				System.out.println(value1);

				if (value1.equals(value2)) {
					boolean result = Action.isDisplayed(getDriver(), ProductImages);
					if (result) {
						Action.mouseOverElement(getDriver(), ProductImages);
						Thread.sleep(2000);
					} else {
						Assert.assertTrue(result, "Product is not visible or present");
					}
				} else {
					Assert.assertTrue(false, "The zommed image and side image are not same");
				}

				String ProductName = getDriver().findElement(By.xpath(productName1)).getText();
				System.out.println(ProductName);
				String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
				for (int i = 0; i < ProductName.length(); i++) {
					char ch = ProductName.charAt(i);
					String s = String.valueOf(new char[] { ch });
					// System.out.println(s);
					if (specialCharactersString.contains(Character.toString(ch))) {
						System.out.println(s + " contains special character");

						if (ProductName.contains(s)) {
							String splits1[] = ProductName.split(s);
							System.out.println(splits1[0]);
							String actualName = splits1[0];
							if (value1.contains(actualName)) {
								System.out.println("Product name verified");
							} else {
								Assert.assertTrue(false, "Product Name are not correct");
							}
						}
					}
				}
				
				
				Log.info("AddToCart of Product Page verification");
				WebElement StockCount = getDriver().findElement(By.xpath(stockCount));
				Assert.assertEquals(StockCount.getAttribute("value"), "1", "Count is not set to 1");
				WebElement addToCartIcon = getDriver().findElement(By.xpath(cartButton));
				boolean result = Action.isDisplayed(getDriver(), addToCartIcon);
				String elementTxt = addToCartIcon.getText();
				if (elementTxt.equalsIgnoreCase("ADD TO CART") && result){
					Assert.assertTrue(addToCartIcon.isEnabled(), "Out of Stock button is not enabled");
					System.out.println("AddTOCart is enabled");
					Log.info("Successfully verified AddToCart Message");
				}
				else if(elementTxt.equalsIgnoreCase("OUT OF STOCK") && result){
					Assert.assertTrue(!addToCartIcon.isEnabled(), "Out of Stock button is enabled");
					Log.info("Product is Out of Stock");
				}
					
				
				else {
					System.out.println("Cart Icon is not present");
					Assert.assertTrue(result, "Cart Icon is not present");
				}
				Log.info("Successfully ends the availabiltyStock");
				
				
				WebElement Crossbutton = getDriver().findElement(By.xpath(crossbutton1));
				Action.click(getDriver(), Crossbutton);
				
				count++;
				count1 = count1+ 2;
			}
			
		}
		softAssert.assertAll();
	}
	
	
	
	
	
}
