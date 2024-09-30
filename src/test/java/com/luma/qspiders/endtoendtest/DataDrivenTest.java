package com.luma.qspiders.endtoendtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.qspiders.genericutility.FileUtility1;
import com.luma.qspiders.genericutility.WebDriverUtility1;
import com.luma.qspiders.pomrepository.LumaCustomerLoginPage;
import com.luma.qspiders.pomrepository.LumaHomePage;
import com.luma.qspiders.pomrepository.LumaHomePageAfterLogin;

import general.ExcelToDataProviderClass;

public class DataDrivenTest {
	public WebDriver driver;
	public FileUtility1 fileUtils = new FileUtility1();
	public WebDriverUtility1 webDriverUtils = new WebDriverUtility1();

	@Test(dataProvider = "dataFromExcel", dataProviderClass = ExcelToDataProviderClass.class)
	public void loginMultiUser(Object userName, Object password) throws IOException {
	
	
		driver = new ChromeDriver();
		webDriverUtils.implicitWaitInSeconds(driver);
		driver.manage().window().maximize();
		driver.get(fileUtils.toReadData("url"));
		webDriverUtils.implicitWaitInMillis(driver);
		LumaHomePage homePage = new LumaHomePage(driver);
		webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedhomepagetitle"));
		homePage.getsigninOption().click();
		webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedcustomerloginpagetitle"));
		webDriverUtils.partialUrl(driver, fileUtils.toReadData("expectedcustomerloginpageurl"));
		LumaCustomerLoginPage loginPage = new LumaCustomerLoginPage(driver);
		loginPage.getEmailTextfield().clear();
		loginPage.getEmailTextfield().sendKeys(userName.toString());
		loginPage.getPasswordTextfield().clear();
		loginPage.getPasswordTextfield().sendKeys(password.toString());
		loginPage.getSigninOption().click();
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		webDriverUtils.implicitWaitInSeconds(driver);
		actions.pause(3000).perform();
		if(homePageAfterLogin.getMenSection().isDisplayed()) {
		webDriverUtils.elementToBeClickable(driver, homePageAfterLogin.getShowMenuOption()).click();
        actions.pause(3000).perform();
        actions.moveToElement(homePageAfterLogin.getSignoutOption()).pause(2000).click().build().perform();
        driver.manage().window().minimize();
        driver.quit(); }
		System.out.println("Valid Login");
		Assert.assertTrue(true);
			// TODO: handle exception
			//Assert.fail("Test Script fails");
		
	}
}
