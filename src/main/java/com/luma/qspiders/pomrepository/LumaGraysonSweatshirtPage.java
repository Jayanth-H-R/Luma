package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaGraysonSweatshirtPage {
	WebDriver driver;
	
	public LumaGraysonSweatshirtPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Size']/..//div[text()='M']")
	private WebElement mSizeOption;
	
	@FindBy(css = "div[option-label='Orange']")
	private WebElement orangeColorOption;
	
	@FindBy(xpath = "//a[.='Add to Wish List']")
	private WebElement addToWishListLink;

	public WebElement getmSizeOption() {
		return mSizeOption;
	}

	public WebElement getOrangeColorOption() {
		return orangeColorOption;
	}

	public WebElement getAddToWishListLink() {
		return addToWishListLink;
	}
	
	

}
