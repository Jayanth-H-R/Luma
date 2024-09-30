package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaHomePage {
	public WebDriver driver;

	public LumaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='panel header']//a[contains(.,'Sign In')]")
	private WebElement signinOption;

	public WebElement getsigninOption() {
		return signinOption;
	}
}
