package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaMensSectionPage {
WebDriver driver;

public LumaMensSectionPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(linkText = "Hoodies & Sweatshirts")
private  WebElement hoodiesSweatShirtsSection;

@FindBy(linkText = "Jackets")
private WebElement jacketsSection;

@FindBy(linkText = "Tees")
private WebElement teesSection;

@FindBy(linkText = "Pants")
private WebElement pantsSection;

@FindBy(linkText = "Shorts")
private WebElement shortsSection;

public WebElement getHoodiesSweatShirtsSection() {
	return hoodiesSweatShirtsSection;
}

public WebElement getJacketsSection() {
	return jacketsSection;
}

public WebElement getTeesSection() {
	return teesSection;
}

public WebElement getPantsSection() {
	return pantsSection;
}

public WebElement getShortsSection() {
	return shortsSection;
}


}
