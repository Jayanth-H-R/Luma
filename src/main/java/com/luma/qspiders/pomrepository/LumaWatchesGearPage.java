package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaWatchesGearPage {

	WebDriver driver;

	public LumaWatchesGearPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Activity']")
	private WebElement activityOption;

	@FindBy(partialLinkText = "Gym")
	private WebElement gymOption;

	@FindBy(xpath = "//div[text()='Material']")
	private WebElement materialOption;

	@FindBy(partialLinkText = "Metal")
	private WebElement metalOption;

	@FindBy(xpath = "//a[contains(.,'Clear All')]")
	private WebElement clearAllOption;
	
	@FindBy(xpath = "//strong[text()='Now Shopping by']/..//ol[@class='items']")
	private WebElement selectedFilterItems;

	public WebElement getActivityOption() {
		return activityOption;
	}

	public WebElement getGymOption() {
		return gymOption;
	}

	public WebElement getMaterialOption() {
		return materialOption;
	}

	public WebElement getMetalOption() {
		return metalOption;
	}

	public WebElement getClearAllOption() {
		return clearAllOption;
	}

}
