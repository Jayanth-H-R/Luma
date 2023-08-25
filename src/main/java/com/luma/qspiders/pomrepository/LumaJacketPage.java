package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaJacketPage {
	WebDriver driver;

	public LumaJacketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//main[contains(.,'Montana Wind Jacket')]")
	private WebElement montanaJacketLink;

	@FindBy(xpath = "//a[contains(.,'Montana Wind Jacket')]/../..//div[text()='M']")
	private WebElement montanaJacketSize;

	@FindBy(xpath = "//a[contains(.,'Montana Wind Jacket')]/../..//div[@option-label='Green']")
	private WebElement montanaJacketColor;

	@FindBy(xpath = "//a[contains(.,'Montana Wind Jacket')]/../..//span[text()='Add to Cart']")
	private WebElement montanaJacketCart;

	@FindBy(xpath = "//a[@class='action showcart']")
	private WebElement mycart;

	@FindBy(xpath = "//span[text()='View and Edit Cart']")
	private WebElement viewAndEditCart;

	@FindBy(xpath = "//span[text()='Remove']/..")
	private WebElement removeFromCartOption;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getRemoveFromCartOption() {
		return removeFromCartOption;
	}

	public WebElement getMontanaJacketSize() {
		return montanaJacketSize;
	}

	public WebElement getMontanaJacketColor() {
		return montanaJacketColor;
	}

	public WebElement getMontanaJacketCart() {
		return montanaJacketCart;
	}

	public WebElement getMycart() {
		return mycart;
	}

	public WebElement getViewAndEditCart() {
		return viewAndEditCart;
	}

	public WebElement getMontanaJacketLink() {
		return montanaJacketLink;
	}

}
