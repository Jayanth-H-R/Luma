package com.luma.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaCustomerLoginPage {
	WebDriver driver;

	public LumaCustomerLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement emailTextfield;

	@FindBy(css = "input[name='login[password]']")
	private WebElement passwordTextfield;

	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement signinOption;

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getSigninOption() {
		return signinOption;
	}

}
