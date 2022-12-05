package com.dotKonnekt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.base.BaseClass;
import com.dotKonnekt.utility.Log;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.javascript.host.webkitURL;

public class LoginPage extends BaseClass {

	LoginPage loginPage;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "checkedB")
	WebElement rememberMeCheckboxBtn;

	@FindBy(linkText = "Forgot password ?")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//button[normalize-space()='LOG IN']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-body1 css-lmqqn1']")
	WebElement incrtMsg;
	
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-body1 css-1svf6t0']")
	WebElement welcomeMsg;
	
	@FindBy(name = "checkedB")
	WebElement checkbox;
	
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-body1 css-od1sh9']")
	WebElement welcomeDescription;
	
	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	WebElement catchaChbx;
	
	/*
	 * @find(xpath = "//div[@class='MuiBox-root css-dgk9vs']/button") WebElement
	 * menuLists;
	 */
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateTitle() {
	String title =	getDriver().getTitle();
	//System.out.println(LoginPage);
		return title;
	}
	
	
	public boolean login(String uname, String passd) {
		Action.type(username,uname);
		Action.type(password, passd);
		//Action.click(getDriver(), catchaChbx);
		Action.click(getDriver(), loginBtn);
		boolean result = Action.isDisplayed(getDriver(), incrtMsg);
		
		Assert.assertTrue(result);
		return result;
		
	}
	public void validateWelcomeMsg() {
		boolean msgTxt  = Action.isDisplayed(getDriver(), welcomeMsg);
		Assert.assertTrue(msgTxt);
	}
	
	public void verifyingCheckbox() {
		Action.click(getDriver(), checkbox);
		boolean result2 =Action.isSelected(getDriver(), checkbox);
		System.out.println(result2);
	}
	public void validatetext () {
		Log.info("Comparing the Welcome Text on Login Page");
		String actualtxt = getDriver().findElement(By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-od1sh9']")).getText();
		Assert.assertEquals(actualtxt, "Please enter your account details below");
		Log.info("Welcome text successfully found");
	}
}
