 package com.dotKonnekt.pages;

import java.util.Iterator;
import java.util.List;

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


public class HomePage extends BaseClass{

	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	String skin = "//button[normalize-space()='Skin']";
	public void clickOnCategory() {
		getDriver().findElement(By.xpath(skin)).click();
	}
	String allProduct = "(//div[@class='swiper-wrapper'])[2]/div/div";
	String carticon = "//*[name()='svg' and @data-testid='ShoppingCartOutlinedIcon']";
	String wishlist = "//*[name()='svg' and @data-testid='FavoriteBorderOutlinedIcon']";
	String quickview = "//p[@class='MuiTypography-root MuiTypography-body1 css-xrfgiq']";
	String discountedPrice = "//div[@class='MuiBox-root css-70qvj9']/p";
	String actualPrice = "//div[@class='MuiTypography-root MuiTypography-body1 css-lgaoco']";
	String productsName = "(//div[@class='swiper-wrapper'])[2]/div/div/div/div[1]";
	String images = "(//div[@class='swiper-wrapper'])[2]/div/div/span/img";
	SoftAssert softAssert = new SoftAssert();
	String newArrivalSection = "//div[@class='MuiTypography-root MuiTypography-body1 css-1mmjkfi']";
	public void newArrival() {
		WebElement NewArrivalSection  = getDriver().findElement(By.xpath(newArrivalSection));
		Action.scrollByVisibilityOfElement(getDriver(), NewArrivalSection);
		
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
	String thumbnailImage = "//div[@class='MuiAvatar-root MuiAvatar-circular css-1c8y4ou']";
	String thumbnail = "//*[name()='svg' and @data-testid='PersonIcon']";
	String username = "//p[@class='MuiTypography-root MuiTypography-body1 css-1q300gz']";
	String quoted = "//*[name()='svg' and @data-testid='FormatQuoteIcon']";
	String testmonialsText ="//p[@class='MuiTypography-root MuiTypography-body1 css-ceeiuo']";
	String testimonials= "//div[contains(@class,'css-1lo2wsk')]/div/div";
	String shoutOutSection= "//div[contains(@class,'css-a4vkgb')]";
	String socialMediaIcon = "//div[@class='MuiBox-root css-1p3qk0r']/span/img";
	public void shoutOut() {
		WebElement ShoutOutSection  = getDriver().findElement(By.xpath(shoutOutSection));
		Action.scrollByVisibilityOfElement(getDriver(), ShoutOutSection);
		
		List<WebElement> TestiMonials = getDriver().findElements(By.xpath(testimonials));
		Assert.assertEquals(TestiMonials.size(), 3, "All 6 testimonials are not present");
		int size = TestiMonials.size();
		Log.info("Successfully Verified the Testimonials presence");
		
		List<WebElement> TestiMonialText = getDriver().findElements(By.xpath(testmonialsText));
		Assert.assertEquals(TestiMonialText.size(), size, "All 6 testimonial Text are not present");
		for (WebElement i : TestiMonialText) {
			if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "Testimonial Text is/are not present");
			}
		}
		Log.info("Successfully Verified the Testimonials Text presence");
		
		List<WebElement> Quoted = getDriver().findElements(By.xpath(quoted));
		Assert.assertEquals(Quoted.size(), size, "All 6 Quote sign are not present");
		for (WebElement i : Quoted) {
			if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "Quote sign is/are not present");
			}
		}
		Log.info("Successfully Verified the Quote sign presence");
		
		List<WebElement> Username = getDriver().findElements(By.xpath(username));
		Assert.assertEquals(Username.size(), size, "All 6 Username  are not present");
		for (WebElement i : Username) {
			if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "Username is/are not present");
			}
		}
		Log.info("Successfully Verified the Username presence");
		
		List<WebElement> ThumbnailImage = getDriver().findElements(By.xpath(thumbnailImage));
		Assert.assertEquals(ThumbnailImage.size(), 2, "User image are not present");
		for (WebElement i : ThumbnailImage) {
			if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "User image is/are not present");
			}
		}
		System.out.println(ThumbnailImage.size() + " User Images are present in testimonials Section");
		Log.info("Successfully Verified the User image presence");
		
		List<WebElement> Thumbnail = getDriver().findElements(By.xpath(thumbnail));
		Assert.assertEquals(Thumbnail.size(),(Username.size()-ThumbnailImage.size()) , "User image are present");
		for (WebElement i : Thumbnail) {
			if(i.getText().equals(null)) {
				softAssert.assertTrue(false, "User image is/are not present");
			}
		}
		System.out.println(Thumbnail.size() + " User with nonImages are present in testimonials Section");
		Log.info("Successfully Verified the User with nonImage presence");
		
		
		List<WebElement> SocialMediaIcon = getDriver().findElements(By.xpath(socialMediaIcon));
		System.out.println(SocialMediaIcon.size() + " Social Media icons are present in testimonials Section");
		for (WebElement i : SocialMediaIcon) {
			System.out.println(i.getAttribute("alt"));
		}
		Log.info("Successfully Verified the Social Media presence");
		
	}
	
	String askour = "//div[@class='MuiTypography-root MuiTypography-body1 css-bp10qf']";
	String askDesc = "//p[@class='MuiTypography-root MuiTypography-body1 css-1lnopq3']";
	String experts = "(//div[@class='swiper-wrapper'])[3]/div";
	String expertsImage = "(//div[@class='MuiBox-root css-2txfei'])/span/img";
	String newExperts = "//div[@class='MuiBox-root css-2txfei']";
	String sendAMessage = "//div[@class='message MuiBox-root css-1ggpf2f']";
	String expertName = "//div[@class='MuiBox-root css-1nj6oyt']";
	String click1 = "//div[@class='MuiBox-root css-x9cc89']//button[2]//span[1]";
	String crossbutton1 = "//*[local-name()='svg' and @data-testid='ClearIcon']";
	public void askOurExpert() throws InterruptedException {
		WebElement AskOur  =  getDriver().findElement(By.xpath(askour));
		Action.scrollByVisibilityOfElement(getDriver(), AskOur);
		softAssert.assertEquals(AskOur.getText(), "ASK OUR EXPERT");
		Log.info("Successfully Verified the Ask Our Experts Presence on UI");
		
		
		WebElement AskDesc  =  getDriver().findElement(By.xpath(askDesc));
		softAssert.assertTrue(AskDesc.isDisplayed(), "Ask Desc is not present");
		String desc= "We're all about real connection, and our store ambassadors make it happen. With endless passion and leadership, they motivate their communities to get sweaty and make a difference.";
		softAssert.assertEquals(AskDesc.getText(), desc, "Ask our Expert Description text are not same");
		Log.info("Succesfully verified the text Presence on the UI for the Ask our Expert section");
		
		List<WebElement> Experts = getDriver().findElements(By.xpath(experts));
		Assert.assertEquals(Experts.size(), 3, " Total 3 experts are not Present" );
		Log.info("Total 7 experts are present and successfully verified the presence");
		int n= Experts.size();
		
		
		List<WebElement> ExpertsImage = getDriver().findElements(By.xpath(expertsImage));
		int x = ExpertsImage.size();
		System.out.println(x);
		int count5 = 0;
		if (x == n) {
			for (WebElement i : ExpertsImage) {
				Action.mouseOverElement(getDriver(), i);
				if (i.getAttribute("srcset").contains("amazonaws.com")) {
					count5++;
				}
			}
			if (count5 == n) {
				System.out.println("All " + count5 + " images are present");
			} else {
				softAssert.assertTrue(false, n - count5 + "Images are not present  ");
			}
		} else {
			System.out.println(n - x + " Images are not present ");
			softAssert.assertTrue(false, +n - x + " Images are not present ");
		}
		
		Log.info("Succesafully Verified the Presence of the Experts Image");
		
		List<WebElement> SendAMessage = getDriver().findElements(By.xpath(sendAMessage));
		int y = SendAMessage.size();
		System.out.println(y);
		int count6 = 0;
		if (y == n) {
			for (WebElement i : SendAMessage) {
				Action.mouseOverElement(getDriver(), i);
				if (i.getText().equals("Send a Message")) {
					Action.isEnabled(getDriver(), i);
					System.out.println(" Send Message is present");
					count6++;
				}
			}
			if (count6 == n) {
				System.out.println("All " + count6 + " Send Message are present");
			} else {
				softAssert.assertTrue(false, n - count5 + " Send Message are not present  ");
			}
		} else {
			System.out.println(n - y + " Send Message are not present ");
			softAssert.assertTrue(false, +n - y + " Send Message are not present ");
		}
		Log.info("Succesafully Verified the Presence of the Experts Send A Message");
		 
		
		List<WebElement> ExpertName = getDriver().findElements(By.xpath(expertName));
		
		
		if(n==ExpertName.size()) {
			int q = 0;
			for(WebElement i : ExpertName) {
			Action.mouseOverElement(getDriver(), i);
				Action.isDisplayed(getDriver(), i);
				
				if(i.getText().equals("")) {
					q++;
					softAssert.assertTrue(false, q + " Name is/are not present");
				}
				else {
					System.out.println(i.getText());
				}
				//WebElement Click1 = getDriver().findElement(By.xpath(click1));
				//Action.click(getDriver(), Click1);
				Thread.sleep(1000);
				
			}
		}
		Log.info("Succesfully Verified the Presence of the name and role");
		
		
		softAssert.assertAll();
	}
	
	
	
	public void sendAMessage() throws InterruptedException {
		WebElement AskOur  =  getDriver().findElement(By.xpath(askour));
		Action.scrollByVisibilityOfElement(getDriver(), AskOur);
		softAssert.assertEquals(AskOur.getText(), "ASK OUR EXPERTS");
		Log.info("Successfully Verified the Ask Our Experts Presence on UI");
		
		List<WebElement> SendAMessage = getDriver().findElements(By.xpath(sendAMessage));
		int y = SendAMessage.size();
		System.out.println(y);
		int count6 = 0;
		if (y == 3) {
			for (WebElement i : SendAMessage) {
				Thread.sleep(2000);
				Action.mouseOverElement(getDriver(), i);
				if (i.getText().equals("Send a Message")) {
					Action.isEnabled(getDriver(), i);
					System.out.println(" Send Message is present");
					count6++;
					i.click();
					Thread.sleep(3000);
					WebElement crossbutton = getDriver().findElement(By.xpath(crossbutton1));
					Thread.sleep(3000);
					crossbutton.click();
					Thread.sleep(5000);
					//System.out.println(i);
				}
			}
			System.out.println(count6);
			if (count6 == 7) {
				System.out.println("All " + count6 + " Send Message are present");
			} else {
				softAssert.assertTrue(false, 3 - count6 + " Send Message are not present  ");
			}
		} else {
			System.out.println(3 - y + " Send Message are not present ");
			softAssert.assertTrue(false, +3 - y + " Send Message are not present ");
		}
		Log.info("Succesafully Verified the Presence of the Experts Send A Message");
	}
	
	String img = "//div[@class='MuiBox-root css-1002pp8']/span/img";
	String aboutUsDesc  = "//p[@class='MuiTypography-root MuiTypography-body1 css-1dlsath']";
	String aboutUS = "//div[@class='MuiTypography-root MuiTypography-body1 css-1ef2l9g']";
	public void aboutUs() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("javascript:window.scrollBy(0,4600)");
        Thread.sleep(3000);
        Log.info("Successfully scrolled to the 0,4600 coordinates");
        WebElement AboutUs = getDriver().findElement(By.xpath(aboutUS));
        Assert.assertTrue(AboutUs.isDisplayed(), "About Us is not deisplayed");
        Log.info("Successfully verified the About US Presence");
        WebElement AboutUsDesc = getDriver().findElement(By.xpath(aboutUsDesc));
        Assert.assertTrue(AboutUsDesc.isDisplayed());
        Log.info("Successfully verified the About US Description Presence");
        WebElement Image = getDriver().findElement(By.xpath(img));
        if(Image.isDisplayed()) {
        	Assert.assertTrue(Image.getAttribute("srcset").contains("amazonaws.com"),"Image is not present");
        	Log.info("Successfully verified the presence of the Image");
        }
        
	}
	String learnMoreBtn = "//div[@class='MuiBox-root css-1hvnrsa']/button";
	String price ="//div[@class='MuiBox-root css-1hvnrsa']/p";
	String date ="//div[@class='MuiBox-root css-12cavdm']/p[2]";
	String courseInstructor = "//div[@class='MuiBox-root css-12cavdm']/p[1]";
	String productname = "//div[@class='MuiBox-root css-qxockv']/div[2]";
	String faceOils = "//div[@class='MuiBox-root css-qxockv']/div[1]";
	String img1 = "//div[@class='MuiBox-root css-ibpw6x']/span/img";
	public void aboveAboutSection() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("javascript:window.scrollBy(0,3600)");
        Thread.sleep(3000);
		
		 WebElement Image = getDriver().findElement(By.xpath(img1));
	        if(Image.isDisplayed()) {
	        	Assert.assertTrue(Image.getAttribute("srcset").contains("shopify.com"),"Image is not present");
	        	Log.info("Successfully verified the presence of the Image");
	        }
	        else {
	        	Assert.assertTrue(false, "Image is not present in aboveAboutUsSection");
	        }
	        WebElement FaceOils = getDriver().findElement(By.xpath(faceOils));
	        Assert.assertTrue(FaceOils.isDisplayed());
	        Log.info("Successfully verified the Face Oils Description Presence");
	        WebElement ProductName = getDriver().findElement(By.xpath(productname));
	        Assert.assertTrue(ProductName.isDisplayed(), "Product Name is not present");
	        String name = ProductName.getText();
	        Log.info("Successfully verified the ProductName Presence");
	        WebElement CourseInstructor = getDriver().findElement(By.xpath(courseInstructor));
	        Assert.assertTrue(CourseInstructor.isDisplayed(), "Course Intructor name is not present");
	        System.out.println(CourseInstructor.getText());
	        Log.info("Successfully verified the Course Intructor name Presence");
	        WebElement Date = getDriver().findElement(By.xpath(date));
	        Assert.assertTrue(Date.isDisplayed(), "Date is not present");
	        System.out.println(Date.getText());
	        Log.info("Successfully verified the Date Presence");
	        WebElement Price = getDriver().findElement(By.xpath(price));
	        Assert.assertTrue(Price.isDisplayed(), "Price is not present");
	        System.out.println(Price.getText());
	        Log.info("Successfully verified the Price Presence");
	        WebElement LearnMoreBtn  = getDriver().findElement(By.xpath(learnMoreBtn));
	        Assert.assertTrue(LearnMoreBtn.isDisplayed(), "Price is not present");
	        System.out.println(LearnMoreBtn.getText());
	        Log.info("Successfully verified the Price Presence");
	      
	        
	}
	
	
	String newsLetter = "//*[name()='svg'][@data-testid = 'ClearIcon']";
	public void NewsletterPopup () {
		WebElement NewsLetter = getDriver().findElement(By.xpath(newsLetter));
		Action.click(getDriver(), NewsLetter);
		getDriver().findElement(By.xpath("//button[normalize-space()='Accept']")).click();
		Log.info("Successfully clicked on the newsLetter");
	}
	
}
