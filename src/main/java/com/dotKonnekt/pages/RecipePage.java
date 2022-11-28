package com.dotKonnekt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotKonnekt.base.BaseClass;

public class RecipePage extends BaseClass {

	RecipePage recipePage;
	
	@FindBy(xpath = "//input[@id='free-solo-2-demo']")
	WebElement searchBox;
	
	@FindBy(xpath = "(//img[@alt ='logo'])[3]")
	WebElement cartButton;
	
	@FindBy(xpath = "(//img[@alt='logo'])[1]")
	WebElement imgButton;
	
	public RecipePage() {
		PageFactory.initElements( getDriver(), this);
	}
	
	public String getTitle() {
		String title = getDriver().getTitle();
		return title;
	}
	
}
