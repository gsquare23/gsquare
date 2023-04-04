package com.dotKonnekt.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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

public class RecipePageFinal extends BaseClass {
	
	String searchBox = "//input[@placeholder='Search']";
	String clickButton=  "//div[@class='MuiInputAdornment-root MuiInputAdornment-positionStart MuiInputAdornment-outlined MuiInputAdornment-sizeMedium css-1a6giau']//*[name()='svg']";
	String bd_Home = "(//li[@class='MuiBreadcrumbs-li'])/a";
	String bd_Blog = "(//li[@class='MuiBreadcrumbs-li'])/p";
	String Author = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-1r6qczh']";
	String P_Date = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 css-3odfiv']";
	String loginbutton = "//button[normalize-space()='LOG IN']";
	String loginPageTxt = "//input[@name='email']";
	String likeIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[1]";
	String bookMarkIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[2]";
	String shareIcon = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-fwkm60'])[3]";
	String likeCount = "//p[@class = 'MuiTypography-root MuiTypography-body1 css-5cgcae'][1]";
	String bookCount = "//p[@class = 'MuiTypography-root MuiTypography-body1 css-5cgcae'][2]";
	String socialMediaIcons = "(//*[name()='circle'])";
	String categoryElements = "//div[@class='css-1u1j1m2']/div/button";
	String blog_title = "//div[@class='MuiTypography-root MuiTypography-body1 css-w8lzqg']";
	String quickview = "//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	String discountedPrice = "//p[@class='MuiTypography-root MuiTypography-body1 css-1tva794']";
	String actualPrice = "//div[@class='MuiTypography-root MuiTypography-body1 css-lgaoco']";
	String productsName = "//div[@class='MuiBox-root css-kgu7cg']";
	String images  = "(//div[contains(@class, 'css-169jllx')])/span/img";
	String carticon = "//button[contains(@class,'css-nle8bv')]";
	String wishlist = "(//button[contains(@class,'css-v7k3k0')]//*[name()='svg'])";
	String commentTxt = "//h5[@class='MuiTypography-root MuiTypography-h5 css-3tvp08']";
	String commentBox ="//input[@placeholder='Type a comment...']";
	String postbutton = "//span[@class='MuiTypography-root MuiTypography-span css-1fz7ep2']";
	String commentCount ="//span[@class='MuiTypography-root MuiTypography-span css-1ov61vh']";
	String see_more = "//span[normalize-space()='See more']";
	String commentPosted = "//div[@class = 'MuiBox-root css-12tyeii']";
	String replyCount = "//span [@class= 'MuiTypography-root MuiTypography-span css-4ccwly']";
	String crossbutton1 = "//*[local-name()='svg' and @data-testid='ClearIcon']";
	String recipeImage =  "//img[@class='MuiBox-root css-11cts2d']";
	String taggscount= "//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7']";
	String nutritions = "//p[@class='MuiTypography-root MuiTypography-body1 css-22dtt9']";
	
	String reportAbuse = "//div[@class='css-viqta1']/button";
	String recipeVideo = "//h5[@class='MuiTypography-root MuiTypography-h5 css-12esd7r']";
	String frame = "//iframe[@id='widget2']";
	
	@FindBy (xpath = "//span[@class='MuiTypography-root MuiTypography-span css-1fz7ep2']")
	WebElement postBtn;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[normalize-space()='LOG IN']")
	WebElement loginBtn;
	@FindBy(xpath = "//div[normalize-space()='Cooking Time :']")
	WebElement cookingTime;
	
	SoftAssert softAssert = new SoftAssert();
	
	public RecipePageFinal() {
		PageFactory.initElements(getDriver(), this);
		softAssert.assertAll();
	}
	
	
	

	
	public void recipeImage() {
		WebElement recipeimage = getDriver().findElement(By.xpath(recipeImage));
		//Boolean p = (Boolean) ((JavascriptExecutor)getDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", recipeImage); 
		//boolean p = Action.isDisplayed(getDriver(), recipeimage);
		//Assert.assertTrue(p);
		//List<WebElement> image = getDriver().findElements(By.xpath(images));
			Action.scrollByVisibilityOfElement(getDriver(), recipeimage);
			boolean result = recipeimage.getAttribute("src").contains("amazonaws.com");
			if(result) {	
			Log.info("Successfully verified the recipe image on Recipe Page");}
			else {
				softAssert.assertTrue(result, "Recipe Image is not present");
				Log.info("Recipe Image is not present on the recipe Page");
			}
		
	}
	
	
	public void breadCrumbFunctionality(String title) {
		int count =0;
		List<WebElement>  breadcrumb = getDriver().findElements(By.xpath(bd_Home));
		List<String> listElements = new ArrayList<String>();
		for (WebElement webElement : breadcrumb) {
			listElements.add(webElement.getText().replace(" ", "|"));
			count++;
		}
		String delim = "|";
		String actualBreadcrumb = String.join(delim, listElements);
		 System.out.println(actualBreadcrumb);
			getDriver().findElement(By.xpath(bd_Home)).click();
			Action.explicitWaitbyTitle(getDriver(), "dot beauty", Duration.ofSeconds(10));
			String HomeTitle = getDriver().getTitle();
			Assert.assertEquals(HomeTitle, "dot beauty"); 
			getDriver().navigate().back();
			Action.explicitWaitbyTitle(getDriver(), title, Duration.ofSeconds(5));
		
	}
	
	public void authoreDetailsVerification(String AuthorName, String  PublishDate) {
		
		WebElement author = getDriver().findElement(By.xpath(Author));
		//Action.explicitWait(getDriver(), author, Duration.ofSeconds(10));
		String actualAuthorName = getDriver().findElement(By.xpath(Author)).getText();
		if(!actualAuthorName.isBlank()) {
		System.out.println(actualAuthorName);
		softAssert.assertEquals(actualAuthorName, AuthorName);
		}
		else if(actualAuthorName.isBlank()) {
			System.out.println("Auhtor name is not Present");
			Log.warn("Author name is not present");
			softAssert.assertTrue(false,"Auhtor name is not Present");
		}
		String actualPublishDate = getDriver().findElement(By.xpath(P_Date)).getText();
		if(!actualPublishDate.isBlank()) {
		String actdate = "/" + actualPublishDate + "/";
		System.out.println("/"+actualPublishDate+"/");
		Assert.assertEquals(actdate, PublishDate);}
		else if(actualPublishDate.isBlank()) {
			System.out.println("Date is not Present");
			Log.warn("Date is not present");
			softAssert.assertTrue(false, "Publish Date is not present");	
		}
		softAssert.assertAll();
	}
	
	
	public void LikeIconfunctionality(String status) throws InterruptedException {
		String countTxt =	getDriver().findElement(By.xpath(likeCount)).getText();
		getDriver().findElement(By.xpath(likeIcon)).click();
		if(status.equalsIgnoreCase("Loggedout")) {
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
		WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
		Action.click(getDriver(), CrossButton);
		Thread.sleep(1000);
		}
		else {
		//getDriver().get("https://develop.d1fzm6olmw007.amplifyapp.com/recipe/sugarcane-juice-black-wheat-muffins-cake");
		
		getDriver().findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
		getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		Thread.sleep(10000);
		getDriver().findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
		Thread.sleep(2000)	;
		getDriver().navigate().refresh();
		int count=Integer.parseInt(countTxt); 
		getDriver().findElement(By.xpath(likeIcon)).click();
		Thread.sleep(2000)	;
		String countTxt2 =	getDriver().findElement(By.xpath(likeCount)).getText();
		int newCount = Integer.parseInt(countTxt2);
		Assert.assertEquals(count+1, newCount);
		System.out.println("dfghjklcghgjhjk");
		//WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
		//Action.moveto
		
		getDriver().findElement(By.xpath(likeIcon)).click();
		
		Thread.sleep(5000);
		//System.out.println("dfghjklcghgjhjk");
		}
		
	}
	
	public void BookMarkIconfunctionality(String status) throws InterruptedException {
		String countTxt =	getDriver().findElement(By.xpath(bookCount)).getText();
		getDriver().findElement(By.xpath(bookMarkIcon)).click();
		System.out.println(countTxt);
		if(status.equalsIgnoreCase("Loggedout")) {
		WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
		Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
		Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
		WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
		Action.click(getDriver(), CrossButton);
		Thread.sleep(5000);
		}
		else {
			getDriver().findElement(By.name("email")).sendKeys(prop.getProperty("Username"));
			getDriver().findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
			Thread.sleep(10000);
			getDriver().findElement(By.xpath("//button[normalize-space()='LOG IN']")).click();
			Thread.sleep(2000)	;
			getDriver().navigate().refresh();
			int count=Integer.parseInt(countTxt); 
			System.out.println(count); 
			Thread.sleep(2000)	; 
			getDriver().findElement(By.xpath(bookMarkIcon)).click();
			Thread.sleep(2000)	; 
		String countTxt2 =	getDriver().findElement(By.xpath(bookCount)).getText();
		System.out.println(countTxt2);
		int newCount = Integer.parseInt(countTxt2);
		Assert.assertEquals(count+1, newCount);
		getDriver().findElement(By.xpath(bookMarkIcon)).click();
		}
	}
	
	public void ShareIconfunctionality() throws InterruptedException {
		getDriver().findElement(By.xpath(shareIcon)).click();
		//Thread.sleep(2000);
		List<WebElement> socialMediaList =	getDriver().findElements(By.xpath(socialMediaIcons));
		System.out.println(socialMediaList.size());
		
	}
	
	public void CategoryListVerification() {
		int count = 0;
		List<WebElement> menuList = getDriver().findElements(By.xpath(categoryElements));
		//int size = menuList.size();
		List<String> listElements = new ArrayList<String>();
		for (WebElement webElement : menuList) {
			listElements.add(webElement.getText());
			count++;
		}
		System.out.println(listElements);
		//String delim = ",";
		//String category = String.join(delim, listElements);
		 //System.out.println(category);
		String category = "SKIN,DIY RECIPES,DOLL UP";
		 List<String> myList = new ArrayList<String>(Arrays.asList(category.split(",")));
		 System.out.println(myList);
		 if(listElements.containsAll(myList) && myList.containsAll(listElements)) {
				Log.info("Successfully verified that all the category elements are in correct form");
			}
			else {
				Assert.assertTrue(false, "Category elements are not in correct form");
			}
		  if (count != 0) { if (count == menuList.size())
		  { System.out.println("Category elements are equal"); } else {
		  System.out.println("Category elements are not equal");
		  Assert.assertTrue(false); } } else {
		  System.out.println("Category are not present"); }
	
	}
	
	
	public String blogTitleVerification() {
		String actualblogTitle = getDriver().findElement(By.xpath(blog_title)).getText();
		return actualblogTitle;
		
	}
	
	 
	public void tagList(){
		 Log.info("Veryfying the Tag List");
		 
		 WebElement l = getDriver().findElement(By.tagName("body"));
		// System.out.println("Elements with P: =" + l.getText());
		 if(l.getText().contains("Tags")) {
		 
		 WebElement tagText = getDriver().findElement(By.
				  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-qfzj9b']"));
		  Action.scrollByVisibilityOfElement(getDriver(), tagText);
		   System.out.println(tagText.getText());
		List<WebElement> taggs = getDriver().findElements(By.xpath(taggscount));
		System.out.println(taggs.size());
			if(taggs.size() == 5) {
				System.out.println(getDriver().findElement(By.xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-juaq']")).getText());
				  WebElement seeMoreButton =getDriver().findElement(By.
				  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-juaq']"));
				  if(seeMoreButton.isDisplayed()) { seeMoreButton.click(); }
				  
				  getDriver().findElements(By. xpath("//span[@class=\"MuiChip-label MuiChip-labelMedium css-9iedg7\"]"));
				  Action.explicitWait(getDriver(), seeMoreButton, Duration.ofSeconds(10));
				  List<WebElement> tagList = getDriver().findElements(By.
				  xpath(taggscount)); 
				  System.out.println(tagList.size()); 
				  int countt = 0;
				  JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
				  js1.executeScript("window.scrollBy(0,1000)", "");
				  List<String> tags = new  ArrayList<String>();
				  for (WebElement webElement : tagList) {
					  tags.add(webElement.getText()); 
					  countt++;
					  } 
				  String deli = "\n"; 
				  String taggs1 = String.join(deli, tags);
				  System.out.println(taggs1);
				  
				  //  Assert.assertEquals(taggs, tagsElements);
				  
				  if (countt == tagList.size()) 
				  { System.out.println("Tags List are equal");
				  Assert.assertTrue(true); } 
				  else {
				  System.out.println("Tags list Steps are not equal");
				  Assert.assertTrue(false); }}
			else if(taggs.size()<5 && taggs.size() !=0) {
					List<WebElement> tagList = getDriver().findElements(By.
							  xpath(taggscount)); 
							  System.out.println(tagList.size()); 
							  int countt = 0;
							  JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
							  js1.executeScript("window.scrollBy(0,1000)", "");
							  List<String> tags = new  ArrayList<String>();
							  for (WebElement webElement : tagList) {
								  tags.add(webElement.getText()); 
								  countt++;
								  } 
							  String deli = "\n"; 
							  String taggs1 = String.join(deli, tags);
							  System.out.println(taggs1);
							  
							  //  Assert.assertEquals(taggs, tagsElements);
							  
							  if (countt == tagList.size()) 
							  { System.out.println("Tags List are equal");
							  Assert.assertTrue(true); } 
							  else {
							  System.out.println("Tags list Steps are not equal");
							  Assert.assertTrue(false); }
						}
			else if(taggs.size()==0) {
				System.out.println("Taggs elements are blank");
				Assert.assertTrue(false);
			}
		 }
		 
		 else {
			 System.out.println("Tags are not present on this page");
		 }
	}
	
		public void tagElements() throws InterruptedException {
			 WebElement l = getDriver().findElement(By.tagName("body"));
				// System.out.println("Elements with P: =" + l.getText());
				 if(l.getText().contains("Tags")) {
			Log.info("Veryfying the Tag Elements functionality");
			 WebElement tagText = getDriver().findElement(By.
					  xpath("//p[@class = 'MuiTypography-root MuiTypography-body1 css-qfzj9b']"));
			  Action.scrollByVisibilityOfElement(getDriver(), tagText);
			  System.out.println(tagText.getText());
				List<WebElement> taggs = getDriver().findElements(By.xpath(taggscount));
				System.out.println(taggs.size());
				
				  Random r = new Random(); 
				  int randomValue = r.nextInt(taggs.size()); //Getting a random value that is between 0 and (list's size)-1
				  taggs.get(randomValue).click(); //Clicking on the random item in the list.\
				 System.out.println( taggs.get(randomValue).getText());
				 Action.explicitWaitbyTitle(getDriver(), "Search Page", Duration.ofSeconds(5));
				  Assert.assertEquals(getDriver().getTitle(), "Search Page");}
				 else {
					 System.out.println("Tags are not present on this Recipe Page ");
				 }
				 
	}
	
	
	public void nutrilionListVerification(String message) {
		WebElement l1 = getDriver().findElement(By.tagName("body"));
		//System.out.println(l1.getText());
		if(l1.getText().contains("Nutritions Per Serving")) {
		Log.info("Nutrition per Saving lists");
		WebElement nutritions_Display = getDriver()
				.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1aoo3g']"));
		Action.scrollByVisibilityOfElement(getDriver(), nutritions_Display);
		 System.out.println(nutritions_Display.getText());
		

			Log.info("Nutrition per Saving lists");
			if (nutritions_Display.isDisplayed()) {

				Assert.assertEquals(nutritions_Display.getText(), "Nutritions Per Serving");
				if(l1.getText().contains("See more")) {
				WebElement seeButton = getDriver()
						.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1fatci1']"));
				if (seeButton.isDisplayed()) {
					seeButton.click();
				}
				List<WebElement> nutritionLists = getDriver()
						.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-35gjpx']"));
				System.out.println(nutritionLists.size());
				int count111 = 0;
				List<String> NutritionElements = new ArrayList<String>();
				for (WebElement webElement : nutritionLists) {
					NutritionElements.add(webElement.getText());
					count111++;
				}
				String delii = "\n";
				String nutritions = String.join(delii, NutritionElements);
				System.out.println(nutritions);

				if (count111 == nutritionLists.size() && count111>0) {
					System.out.println("nutritionList List are equal");
					Assert.assertTrue(true);
				} else {
					System.out.println("nutritionList list Steps are not equal");
					Assert.assertTrue(false);
					}
				}
			
			
			else  {
			Log.info("Nutrition per Saving lists");
				Assert.assertEquals(nutritions_Display.getText(), "Nutritions Per Serving");
				List<WebElement> nutritionLists = getDriver()
						.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-35gjpx']"));
				System.out.println(nutritionLists.size());
				int count111 = 0;
				List<String> NutritionElements = new ArrayList<String>();
				for (WebElement webElement : nutritionLists) {
					NutritionElements.add(webElement.getText());
					count111++;
				}
				String delii = "\n";
				String nutritions = String.join(delii, NutritionElements);
				System.out.println(nutritions);

				if (count111 == nutritionLists.size()) {
					System.out.println("nutritionList List are equal");
					Assert.assertTrue(true);
				} else {
					System.out.println("nutritionList list Steps are not equal");
					Assert.assertTrue(false);
					}
				}
			}
		}
			else {
				System.out.println("Nutritions List are not Present");
				Log.warn("Nutrition List are not Present");
				}
	}
	
	String addAllToCart = "//div[@class='css-sg7by6']/button";
	String bigWishlistIcon = "(//*[name()='svg'][@data-testid='FavoriteBorderOutlinedIcon'])[5]";
	String allProduct= "(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-tuxzvu'])/div";
	String shoptheIngridients = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1xi88hf'])";
	public void shoptheIngredients() throws InterruptedException {
		
		WebElement l1 = getDriver().findElement(By.tagName("body"));
		//System.out.println(l1.getText());
		if(l1.getText().contains("Shop the Ingredients")) {
			WebElement ShoptheIngridients = getDriver().findElement(By.xpath(shoptheIngridients));
			Action.scrollByVisibilityOfElement(getDriver(), ShoptheIngridients);
		
			List<WebElement> products1 = getDriver().findElements(By.xpath(allProduct));
			int n = products1.size();
			System.out.println(n);

			List<WebElement> image = getDriver().findElements(By.xpath(images));
			int x = image.size();
			int count4 = 0;
			if (x == n) {
				for(WebElement i : image) {
					if(i.getAttribute("srcset").contains("shopify.com")) {
						count4++;
					}
				}
				if(count4 !=0 ) {
				System.out.println("All " + count4 + " images are present");}
				else {
					softAssert.assertTrue(false, n-count4+ "Images are not present  ");
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

			List<WebElement> productActPrice = getDriver().findElements(By.xpath(actualPrice));
			int z = productActPrice.size();
			if (z == n) {
				System.out.println("All Actual Prices are present");
			} else {
				System.out.println(n - z + " Actual Prices are not present ");
				softAssert.assertTrue(false, n - z + " Actual Prices are not present ");
			}
			
			List<WebElement> productDiscountedPrice = getDriver().findElements(By.xpath(discountedPrice));
			int r = productDiscountedPrice.size();
			if (r == n) {
				System.out.println("All Discounted Prices are present");
			} else {
				System.out.println(n - r + " Discounted Prices are not present ");
				//softAssert.assertTrue(false, n - r + " Actual Prices are not present ");
			}

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

			int d = wishlist1.size();
			if (d == n) {
				System.out.println("All Wishlist icon are present");
				
			} else {
				System.out.println(n - d + " Wishlist icon are not present ");
				softAssert.assertTrue(false, +n - d + " Wishlist icon are not present ");
			}
			
			
			WebElement  BigWishlistIcon = getDriver().findElement(By.xpath(bigWishlistIcon));
			softAssert.assertTrue(BigWishlistIcon.isDisplayed(), "Big Wishlist icon in Shop the Ingridients sections is not present");
			
				
				Action.click(getDriver(), BigWishlistIcon);
				if(l1.getText().contains("Email")) {
				WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
				Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
				Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
				WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
				Action.click(getDriver(), CrossButton);
				Thread.sleep(1000);}
				else {
					System.out.println("Wishlist icon is not clickable");
					softAssert.assertTrue(false, "Wishlist icon is not clickable");
				}
				
		WebElement  AddAllToCart = getDriver().findElement(By.xpath(addAllToCart));
		softAssert.assertTrue(AddAllToCart.isDisplayed(), "AddAllToCart in Shop the Ingridients sections is not present");
				
					
		Action.click(getDriver(), AddAllToCart);
					if(l1.getText().contains("Email")) {
					WebElement login = getDriver().findElement(By.xpath(loginPageTxt));
					Action.explicitWait(getDriver(), login, Duration.ofSeconds(10));
					Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
					WebElement CrossButton = getDriver().findElement(By.xpath(crossbutton1));
					Action.click(getDriver(), CrossButton);
					Thread.sleep(1000);}
					else {
						System.out.println("AddAllToCart icon is not clickable");
						softAssert.assertTrue(false, "AddAllToCart icon is not clickable");
					}
					
			

			softAssert.assertAll();
		
		}
		else {
			Log.warn("Shop the Ingredients section is not present");
			System.out.println("Shop the Ingredients section is not present");
		}
		
		
		
	}

	

	
	public void commentsSectionVerification() {
		WebElement comment = getDriver().findElement(By.xpath(commentTxt));
		Action.scrollByVisibilityOfElement(getDriver(), comment);
		String actualTxt = getDriver().findElement(By.xpath(commentTxt)).getText();
		Assert.assertEquals(actualTxt, "COMMENTS");
		Assert.assertTrue(getDriver().findElement(By.xpath(commentBox)).isDisplayed());
		Assert.assertTrue(getDriver().findElement(By.xpath(postbutton)).isDisplayed());
		}
	
	
	
	public void addCommentVerification() {
		WebElement CommentBox =getDriver().findElement(By.xpath(commentBox));
		Assert.assertEquals(CommentBox.getAttribute("placeholder"), "Type a comment...", "Placeholder is not correct");
		Action.type(CommentBox, "This is the comment for testing");
		WebElement PostButton =getDriver().findElement(By.xpath(postbutton));
		//getDriver().findElement(By.xpath(postbutton)).click();
		Action.click(getDriver(), PostButton);
		WebElement LoginButton =getDriver().findElement(By.xpath(loginbutton));
		boolean p = Action.isDisplayed(getDriver(), LoginButton);
		Assert.assertTrue(p);
		//Assert.assertTrue(getDriver().findElement(By.xpath(loginbutton)).isDisplayed());
		WebElement CrossButton =getDriver().findElement(By.xpath(crossbutton1));
		Action.click(getDriver(), CrossButton);
		//getDriver().findElement(By.xpath(crossbutton)).click();
		String countTxt = getDriver().findElement(By.xpath(commentCount)).getText();
		int count=Integer.parseInt(countTxt); 
		System.out.println("Total Count of comments  = "+count);
		if(count>4) {
			getDriver().findElement(By.xpath(see_more)).click();
			List<WebElement> postedcomments = getDriver().findElements(By.xpath(commentPosted));
			int postedCount = postedcomments.size();
			System.out.println("Total Posted Count after click on see more = "+postedCount);
			
			List<WebElement> abuse= getDriver().findElements(By.xpath(reportAbuse));
			int abuseCount = abuse.size();
			System.out.println("Report Abuse Count = "+ abuseCount);
			
			
			
			List<WebElement> replycomments = getDriver().findElements(By.xpath(replyCount));
			int temp =0;
			for (WebElement element: replycomments) {
			String data =	element.getText();
			int data1=Integer.parseInt(data);
			temp = temp + data1;
			}
			System.out.println("Reply Comments are = "+ temp);
			int totalCount = postedCount +  temp;
			System.out.println("Total Count are verification = "+totalCount);
			Assert.assertEquals(count, totalCount, "Comments Counts are not equal");
			
			Log.info("Report abuse count verification");
			Assert.assertEquals(abuseCount, postedCount, "Counts are not equal of Report Abuse button");
			System.out.println("Successfully verified the Report Abuse buttons ");
					
		}
		else if(count<4 && count!=0){
			List<WebElement> postedcomments = getDriver().findElements(By.xpath(commentPosted));
			int postedCount = postedcomments.size();
			System.out.println("Total Posted Count = "+postedCount);
			
			List<WebElement> abuse= getDriver().findElements(By.xpath(reportAbuse));
			int abuseCount = abuse.size();
			System.out.println("Report Abuse Count = "+ abuseCount);
			
			List<WebElement> replycomments = getDriver().findElements(By.xpath(replyCount));
			int temp =0;
			for (WebElement element: replycomments) {
			String data =	element.getText();
			int data1=Integer.parseInt(data);
			temp = temp + data1;
			}
			System.out.println("Reply Counts are" + temp);
			int totalCount = postedCount +  temp;
			System.out.println("Total Count are verification = "+totalCount);
			Assert.assertEquals(count, totalCount, "Comments Counts are not equal");

			Log.info("Report abuse count verification");
			Assert.assertEquals(abuseCount, postedCount, "Counts are not equal of Report Abuse button");
			System.out.println("Successfully verified the Report Abuse buttons ");
		}
		else {
			System.out.println("Comments are not Present");
		}
	}
	
	
	public void ReportAbuseFunctionality() {
		WebElement comment = getDriver().findElement(By.xpath(commentTxt));
		Action.scrollByVisibilityOfElement(getDriver(), comment);
		
		//List<WebElement> abuse= getDriver().findElements(By.xpath(reportAbuse));
		
		
	}
	
	
	
	
	public void recipeVideoSection() throws InterruptedException {
		WebElement frames = getDriver().findElement(By.xpath(frame));
		WebElement recipeVideos = getDriver().findElement(By.xpath(recipeVideo));
		Action.scrollByVisibilityOfElement(getDriver(), recipeVideos);
		String text = recipeVideos.getText();
		Assert.assertEquals(text, "RECIPE VIDEO");
		System.out.println(Action.isDisplayed(getDriver(), frames));
		Action.click(getDriver(), frames);
		Thread.sleep(5000);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FindBy (xpath = "//input[@id='outlined-adornment-password']")
	WebElement typecomment;
	@FindBy(xpath = "(//div[@class='MuiBox-root css-6l6otf'])[1]")
	WebElement postedComment;
	@FindBy(xpath = "//img[@alt='Picture of the author']")
	WebElement editButton;
	@FindBy(xpath = "(//img[@alt='Dlt Button'])")
	WebElement deleteButton;
	
	@FindBy(xpath = "//input[@id='standard-helperText']")
	WebElement editTextbox;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1bvc4cc'])/button[2]")
	WebElement saveBtn;
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1bvc4cc'])/button[1]")
	WebElement cancelBtn;
	
	public void LoggedInAddCommentsVerification(String save) throws InterruptedException {
		WebElement comment = getDriver().findElement(By.xpath(commentTxt));
		Action.scrollByVisibilityOfElement(getDriver(), comment);
		//Thread.sleep(5000);
		String typedComment = "This is selenium test989";
		Action.type(typecomment, typedComment);
		System.out.println("successfully typed the comment in the comment box");
		Action.click(getDriver(), postBtn);
		Thread.sleep(1000);
		System.out.println("Successfully Clicked on the Post button");
		Assert.assertEquals(postedComment.getText(), typedComment);
		Thread.sleep(1000);
		System.out.println("T3");
		Assert.assertTrue(editButton.isEnabled(), "Edit button is not present");
		Action.click(getDriver(), editButton);
		System.out.println("T4");
		String editTypedComment = "This is edited selenium test9";
		
		Action.type(editTextbox, editTypedComment);
		System.out.println("T5");
		if (save.equalsIgnoreCase("save")) {
			System.out.println("T6");
			Action.click(getDriver(), saveBtn);
			System.out.println("T7");
			Thread.sleep(2000);
			Assert.assertEquals(postedComment.getText(), editTypedComment);
			Action.click(getDriver(), deleteButton);
			Thread.sleep(1000);
			String txt = getDriver().findElement(By.xpath("(//h2[normalize-space()='Delete comment'])[1]")).getText();
			if (txt.equalsIgnoreCase("Delete Comment"))
			getDriver().findElement(By.xpath("//button[normalize-space()='Yes']")).click();
			Thread.sleep(1000);
			System.out.println("Comment successfully deleted");
			
		}
		
		  else if(save.equalsIgnoreCase("cancel"))
		  { Action.click(getDriver(),cancelBtn); 
		  Assert.assertEquals(postedComment.getText(), typedComment); }
		 
	}
	
	
	String bookMarkicon = "//*[name()='svg' and @data-testid='BookmarkBorderIcon']";
	String mightLikeProductDescription = "(//div[@class='swiper-wrapper'])/div/div/div/div[2]";
	String mightLikeProductNames = "(//div[@class='swiper-wrapper'])/div/div/div/div[1]";
	String mightLikeallproduct = "(//div[@class='swiper-wrapper'])/div/div";
	String mightLikeimages = "(//div[@class='swiper-wrapper'])/div/div/span/img";
	String mightLike1 = "//div[@class='MuiBox-root css-w6xysq']/p";
	public void weFoundOtherContentYouMightLike() throws InterruptedException {

			WebElement MightLike1 = getDriver().findElement(By.xpath(mightLike1));
			Action.scrollByVisibilityOfElement(getDriver(), MightLike1);
			
			List<WebElement> MightLikeallproduct = getDriver().findElements(By.xpath(mightLikeallproduct));
			int n = MightLikeallproduct.size();
			int count5 =0;
			System.out.println(n + " Recipes should be present in Might Like section");
			List<WebElement> MightLikeimages = getDriver().findElements(By.xpath(mightLikeimages));
			int x = MightLikeimages.size();
			System.out.println(x + " Recipes images should be present in Might Like section");
			Thread.sleep(5000);
			if(x==n) {
				for (WebElement i : MightLikeimages) 
				{
				Action.mouseOverElement(getDriver(), i);
				//Thread.sleep(1000);
				if (i.getAttribute("srcset").contains("amazonaws.com")) {
					count5++;
				}
			}	
				if (count5 == n) {
					System.out.println("All " + count5 + " might images are present");
				} else {
					softAssert.assertTrue(false, n - count5 + " Might Images are not present  ");
				}
			}
				else {
				System.out.println(n-x + " Images are not present ");
				softAssert.assertTrue(false, +n-x+" Images are not present ");
				}
			
			List<WebElement> MightLikeProductName= getDriver().findElements(By.xpath(mightLikeProductNames));
			int y = MightLikeProductName.size();
			if(y==n) {System.out.println("All "+ y +" Might_Like Product Names are present");}
				else {
				System.out.println(n-y + "  Might Like Product Names are not present ");
				softAssert.assertTrue(false, +n-y+"  Might Like Product Names are not present ");
				}
			
			List<WebElement> MightLikeProductDescription= getDriver().findElements(By.xpath(mightLikeProductDescription));
			int z = MightLikeProductDescription.size();
			if(z==n) {System.out.println("All "+ z +" Might_Like Product description are present");}
				else {
				System.out.println(n-z + "  Might Like Product description are not present ");
				softAssert.assertTrue(false, +n-z+"  Might Like Product description are not present ");
				}
			
			List<WebElement> BookMarkicon =getDriver().findElements(By.xpath(bookMarkicon));
			int c = BookMarkicon.size();
			if(c==n) {System.out.println("All "+ c +"  BookMarkicon are present");}
				else {
				System.out.println(n-c + " BookMarkicon are not present ");
				softAssert.assertTrue(false, +n-c+" BookMarkicon are not present ");
				}
				
	}
}
