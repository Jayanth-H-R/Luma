package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaGearPage {
WebDriver driver;

public LumaGearPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span/..//a[text()='Watches']")
private WebElement watchesLink;

public WebElement getWatchesLink() {
	return watchesLink;
}

}
