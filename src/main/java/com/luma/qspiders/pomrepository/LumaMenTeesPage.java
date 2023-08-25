package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaMenTeesPage {
	WebDriver driver;

	public LumaMenTeesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[contains(.,'Strike Endurance Tee')]")
	private WebElement enduranceTee;

	@FindBy(xpath = "//a[.='Add to Compare']")
	private WebElement enduranceAddToCompare;

	@FindBy(xpath = "//li[contains(.,'Deion Long-Sleeve EverCool™ Tee')]")
	private WebElement everCoolTee;

	@FindBy(xpath = "//a[.='Add to Compare']")
	private WebElement everCoolAddToCompare;

	@FindBy(xpath = "//strong[text()='Compare Products']/../span")
	private WebElement numOfItemsToCompare;

	@FindBy(xpath = "//a[.='Compare']")
	private WebElement compareOption;

	@FindBy(id = "compare-clear-all")
	private WebElement compareClearAllOption;
	
	@FindBy(xpath = "//button[.='OK']")
	private WebElement permissionForRemoveCompareItems;

	public WebElement getPermissionForRemoveCompareItems() {
		return permissionForRemoveCompareItems;
	}

	public WebElement getEnduranceTee() {
		return enduranceTee;
	}

	public WebElement getEnduranceAddToCompare() {
		return enduranceAddToCompare;
	}

	public WebElement getEverCoolTee() {
		return everCoolTee;
	}

	public WebElement getEverCoolAddToCompare() {
		return everCoolAddToCompare;
	}

	public WebElement getNumOfItemsToCompare() {
		return numOfItemsToCompare;
	}

	public WebElement getCompareOption() {
		return compareOption;
	}

	public WebElement getCompareClearAllOption() {
		return compareClearAllOption;
	}

}
