package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaBagsAndGearsPage {
	WebDriver driver;
	
	public LumaBagsAndGearsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='product details product-item-details']//a[contains(.,'Push It Messenger Bag')]")
	private WebElement messengerBag;

	@FindBy(xpath = "//a[.='Add to Wish List']")
	private WebElement addToWishlistOption;
	
	public WebElement getAddToWishlistOption() {
		return addToWishlistOption;
	}

	public WebElement getmessengerBag() {
		return messengerBag;
	}
	
	

}
