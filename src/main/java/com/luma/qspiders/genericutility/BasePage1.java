package com.luma.qspiders.genericutility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.luma.qspiders.pomrepository.LumaCustomerLoginPage;
import com.luma.qspiders.pomrepository.LumaHomePage;
import com.luma.qspiders.pomrepository.LumaHomePageAfterLogin;

public class BasePage1 {
	public WebDriver driver;
	public FileUtility1 fileUtils = new FileUtility1();
	public WebDriverUtility1 webDriverUtils = new WebDriverUtility1();
	
	///@Parameters({"browserName"})
	@BeforeClass()
	
	public void configureBeforeClass() throws IOException {
		String browserName = fileUtils.toReadData("browser");
		String url = fileUtils.toReadData("url");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);

	}

	@BeforeMethod()
	public void configureBeforeMethod() throws IOException {
		webDriverUtils.implicitWaitInMillis(driver);
		LumaHomePage homePage = new LumaHomePage(driver);
		webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedhomepagetitle"));
		homePage.getsigninOption().click();
		webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedcustomerloginpagetitle"));
		webDriverUtils.partialUrl(driver, fileUtils.toReadData("expectedcustomerloginpageurl"));
		LumaCustomerLoginPage loginPage = new LumaCustomerLoginPage(driver);
		loginPage.getEmailTextfield().sendKeys(fileUtils.toReadData("username"));
		loginPage.getPasswordTextfield().sendKeys(fileUtils.toReadData("password"));
		loginPage.getSigninOption().click();

	}

	@AfterMethod()
	public void configureAfterMethod() throws InterruptedException {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		webDriverUtils.implicitWaitInSeconds(driver);
		actions.pause(3000).perform();
		webDriverUtils.elementToBeClickable(driver, homePageAfterLogin.getShowMenuOption()).click();
        actions.pause(3000).perform();
        actions.moveToElement(homePageAfterLogin.getSignoutOption()).pause(2000).click().build().perform();

	}

	@AfterClass()
	public void configureAfterClass() {
		driver.manage().window().minimize();
		driver.quit();

	}

}
