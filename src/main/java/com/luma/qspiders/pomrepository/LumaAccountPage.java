package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaAccountPage {

	WebDriver driver;

	public LumaAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='box box-billing-address']//span[text()='Edit Address']")
	private WebElement EditBillingAdd;

	@FindBy(xpath = "//div[@class='box box-shipping-address']//span[text()='Edit Address']")
	private WebElement EditShippingAdd;

	@FindBy(id = "street_1")
	private WebElement street1Feild;

	@FindBy(id = "city")
	private WebElement cityFeild;

	@FindBy(id = "telephone")
	private WebElement phoneNumberFeild;

	@FindBy(id = "zip")
	private WebElement zipCodeFeild;

	@FindBy(id = "country")
	private WebElement countryDropDown;

	@FindBy(xpath = "//button[@title='Save Address']")
	private WebElement saveAddButton;
	
	public WebElement getStateDropDown() {
		return stateDropDown;
	}

	@FindBy(xpath = "(//a[text()='My Account'])[1]")
	private WebElement myAccountOption;
	
	@FindBy(xpath = "//select[@id='region_id']")
	private WebElement stateDropDown;
	

	public WebElement getMyAccountOption() {
		return myAccountOption;
	}

	public WebElement getEditBillingAdd() {
		return EditBillingAdd;
	}

	public WebElement getEditShippingAdd() {
		return EditShippingAdd;
	}

	public WebElement getStreet1Feild() {
		return street1Feild;
	}

	public WebElement getCityFeild() {
		return cityFeild;
	}

	public WebElement getPhoneNumberFeild() {
		return phoneNumberFeild;
	}

	public WebElement getZipCodeFeild() {
		return zipCodeFeild;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getSaveAddButton() {
		return saveAddButton;
	}

}
