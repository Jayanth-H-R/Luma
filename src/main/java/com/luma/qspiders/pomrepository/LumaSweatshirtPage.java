package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaSweatshirtPage {
	WebDriver driver;

	public LumaSweatshirtPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Grayson Crewneck Sweatshirt")
	private WebElement graysonSweatshirt;

	public WebElement getGraysonSweatshirt() {
		return graysonSweatshirt;
	}

}
