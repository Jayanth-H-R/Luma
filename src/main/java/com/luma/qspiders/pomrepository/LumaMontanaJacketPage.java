package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaMontanaJacketPage {
	WebDriver driver;

	public LumaMontanaJacketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Size']/..//div[text()='M']")
	private WebElement mSizeOption;

	@FindBy(css = "div[aria-label='Green']")
	private WebElement greenColorOption;

	@FindBy(id = "product-addtocart-button")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[@class='items-total']/span")
	private WebElement itemsInCart;

	@FindBy(xpath = "//span[text()='Remove']/..")
	private WebElement removeFromCartOption;

	@FindBy(xpath = "//a[@class='action showcart']")
	private WebElement mycart;
	
	@FindBy(xpath = "//button[.='OK']")
	private WebElement permissionOkButton;

	public WebElement getPermissionOkButton() {
		return permissionOkButton;
	}

	public WebElement getRemoveFromCartOption() {
		return removeFromCartOption;
	}

	public WebElement getMycart() {
		return mycart;
	}

	public WebElement getmSizeOption() {
		return mSizeOption;
	}

	public WebElement getGreenColorOption() {
		return greenColorOption;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getItemsInCart() {
		return itemsInCart;
	}

}
