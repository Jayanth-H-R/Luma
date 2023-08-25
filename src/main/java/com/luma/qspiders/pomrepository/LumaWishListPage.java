package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaWishListPage {
	WebDriver driver;

	public LumaWishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Remove This Item']")
	private WebElement removeFromWishlistOption;

	@FindBy(css = "//div[@data-container='product-grid']")
	private WebElement productGrid;

	@FindBy(xpath = "//div[@class='product-item-details']//span[text()='Add to Cart']/..")
	private WebElement addToCartButton;

	@FindBy(xpath = "//strong[text()='My Wish List']/../..//div[@class='empty']")
	private WebElement wishListItems;

	@FindBy(css = "a[class='action showcart']")
	private WebElement cartSymbol;

	@FindBy(xpath = "//div[@class='items-total']/span")
	private WebElement itemsPresentInCart;

	@FindBy(css = "a[title='Remove item']")
	private WebElement deleteProductFromCart;

	@FindBy(xpath = "//button[.='OK']")
	private WebElement permissionToRemoveItem;

	@FindBy(xpath = "//strong[contains(text(),'no items')]")
	private WebElement productRemovedMessage;

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getWishListItems() {
		return wishListItems;
	}

	public WebElement getCartSymbol() {
		return cartSymbol;
	}

	public WebElement getItemsPresentInCart() {
		return itemsPresentInCart;
	}

	public WebElement getDeleteProductFromCart() {
		return deleteProductFromCart;
	}

	public WebElement getPermissionToRemoveItem() {
		return permissionToRemoveItem;
	}

	public WebElement getProductRemovedMessage() {
		return productRemovedMessage;
	}

	public WebElement getProductGrid() {
		return productGrid;
	}

	public WebElement getRemoveFromWishlistOption() {
		return removeFromWishlistOption;
	}

}
