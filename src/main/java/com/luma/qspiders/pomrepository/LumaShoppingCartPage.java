package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaShoppingCartPage {
WebDriver driver;

public LumaShoppingCartPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css = "input[class='input-text qty']")
private WebElement itemQuantityBox;

@FindBy(xpath = "//button/span[text()='Update Shopping Cart']")
private WebElement updateCartButton;

@FindBy(xpath = "//a[contains(.,'Remove item')]")
private WebElement removeItemOption;

@FindBy(xpath = "//div[@class='cart-empty']/p")
private WebElement emptyMessageNote;

public WebElement getEmptyMessageNote() {
	return emptyMessageNote;
}

public WebElement getRemoveItemOption() {
	return removeItemOption;
}

public WebElement getItemQuantityBox() {
	return itemQuantityBox;
}

public WebElement getUpdateCartButton() {
	return updateCartButton;
}




}
