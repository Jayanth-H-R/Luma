package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class LumaHomePageAfterLogin {
	WebDriver driver;

	public LumaHomePageAfterLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='panel header']//span[@class='customer-name']")
	private WebElement showMenuOption;

	@FindBy(xpath = "(//div[@class='panel header']//li[@class='authorization-link']/a[contains(.,'Sign Out')])[1]")
	private WebElement signoutOption;

	@FindBy(id = "search")
	private WebElement searchMenu;

	@FindBy(xpath = "//a[.='Men']")
	private WebElement menSection;

	@FindBy(xpath = "//a[.='Women']")
	private WebElement womenSection;

	@FindBy(xpath = "//a[.=\"What's New\"]")
	private WebElement whatsNewSection;

	@FindBy(xpath = "//a[.='Gear']")
	private WebElement gearSection;

	@FindBy(xpath = "//div[@data-block='minicart']//a")
	private WebElement showCartOption;
	
	@FindBy(xpath = "//a[.='Bags']")
	private WebElement bagsOption;

	public WebElement getBagsOption() {
		return bagsOption;
	}

	public WebElement getShowMenuOption() {
		return showMenuOption;
	}

	public WebElement getSignoutOption() {
		return signoutOption;
	}

	public WebElement getSearchMenu() {
		return searchMenu;
	}

	public WebElement getMenSection() {
		return menSection;
	}

	public WebElement getWomenSection() {
		return womenSection;
	}

	public WebElement getWhatsNewSection() {
		return whatsNewSection;
	}

	public WebElement getGearSection() {
		return gearSection;
	}

	public WebElement getShowCartOption() {
		return showCartOption;
	}

}
