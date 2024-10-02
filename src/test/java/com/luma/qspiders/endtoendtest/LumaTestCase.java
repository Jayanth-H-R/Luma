package com.luma.qspiders.endtoendtest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.luma.qspiders.genericutility.Basics;
import com.luma.qspiders.pomrepository.LumaAccountPage;
import com.luma.qspiders.pomrepository.LumaBagsAndGearsPage;
import com.luma.qspiders.pomrepository.LumaGearPage;
import com.luma.qspiders.pomrepository.LumaGraysonSweatshirtPage;
import com.luma.qspiders.pomrepository.LumaHomePageAfterLogin;
import com.luma.qspiders.pomrepository.LumaJacketPage;
import com.luma.qspiders.pomrepository.LumaMenTeesPage;
import com.luma.qspiders.pomrepository.LumaMensSectionPage;
import com.luma.qspiders.pomrepository.LumaMontanaJacketPage;
import com.luma.qspiders.pomrepository.LumaShoppingCartPage;
import com.luma.qspiders.pomrepository.LumaSweatshirtPage;
import com.luma.qspiders.pomrepository.LumaWatchesGearPage;
import com.luma.qspiders.pomrepository.LumaWishListPage;

public class LumaTestCase extends Basics {
	@Test(enabled = true)
	public void homePageCheck() throws IOException {
		System.out.println("Logged in Successful");
	}

	@Test(enabled = true)
	public void menSectionCart() throws IOException, InterruptedException {
		webDriverUtils.implicitWaitInSeconds(driver);
		SoftAssert soft = new SoftAssert();
		Actions actions = new Actions(driver);
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedhomepagetitle")),
				"HomePage tittle found incoorect");
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		homePageAfterLogin.getMenSection().click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedmenpagetitle")),
				"Men Page title found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("expectedmenpageurl")),
				"Menpage Url found incorrect");
		LumaMensSectionPage menSectionPage = new LumaMensSectionPage(driver);
		menSectionPage.getJacketsSection().click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedjacketpagetitle")),
				"Jacket Page title found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("expectedjacketpageurl")),
				"Jacket Page url found incorrect");
		LumaJacketPage jacketPage = new LumaJacketPage(driver);
		jacketPage.getMontanaJacketLink().click();
		LumaMontanaJacketPage montanaJacketPage = new LumaMontanaJacketPage(driver);
		montanaJacketPage.getmSizeOption().click();
		montanaJacketPage.getGreenColorOption().click();
		montanaJacketPage.getAddToCartButton().submit();
		actions.pause(3000).perform();
		webDriverUtils.elementIsClickable(montanaJacketPage.getMycart(), driver).click();
		// actions.click(montanaJacketPage.getMycart()).pause(2000).perform();
		soft.assertEquals(montanaJacketPage.getItemsInCart().getText(), fileUtils.toReadData("jacketcount"));
		// actions.pause(3000).perform();
		actions.moveToElement(montanaJacketPage.getRemoveFromCartOption()).pause(2000).build().perform();
		webDriverUtils.elementIsClickable(montanaJacketPage.getRemoveFromCartOption(), driver).click();
		// actions.click(montanaJacketPage.getRemoveFromCartOption()).pause(2000).perform();
		webDriverUtils.elementIsClickable(montanaJacketPage.getPermissionOkButton(), driver).click();
		// actions.click(montanaJacketPage.getPermissionOkButton()).perform();
		System.out.println("menSectionCart executed");
		soft.assertAll();

	}

	@Test(enabled = true)
	public void searchProductWishlist() throws IOException {
		Actions actions = new Actions(driver);
		webDriverUtils.implicitWaitInSeconds(driver);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedhomepagetitle")),
				"Home page title found incorrect");
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		homePageAfterLogin.getSearchMenu().sendKeys(fileUtils.toReadData("searchproduct"));
		homePageAfterLogin.getSearchMenu().sendKeys(Keys.ENTER);
		actions.pause(2000).perform();
		// String actualTitle = driver.getTitle();
		soft.assertTrue(webDriverUtils.partialTitle(driver, fileUtils.toReadData("sweatshirtpagetitle")),
				"Sweatshirt page title found incorrect");
		LumaSweatshirtPage sweatshirtPage = new LumaSweatshirtPage(driver);
		sweatshirtPage.getGraysonSweatshirt().click();
		LumaGraysonSweatshirtPage graysonSweatshirtPage = new LumaGraysonSweatshirtPage(driver);
		webDriverUtils.elementIsClickable(graysonSweatshirtPage.getmSizeOption(), driver).click();
		webDriverUtils.elementIsClickable(graysonSweatshirtPage.getOrangeColorOption(), driver).click();
		webDriverUtils.elementIsClickable(graysonSweatshirtPage.getAddToWishListLink(), driver).click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("wishlisttitle")),
				"Wishlist page title found incorrect");
		LumaWishListPage wishlistPage = new LumaWishListPage(driver);
		// actions.moveToElement(wishlistPage.getProductGrid()).pause(2000).build().perform();
		//actions.pause(5000).perform();
		webDriverUtils.elementToBeClickable(driver, wishlistPage.getRemoveFromWishlistOption()).click();
		//actions.click(wishlistPage.getRemoveFromWishlistOption()).pause(1000).build().perform();
		soft.assertAll();
		System.out.println("searchProductWishlist executed");
	}

	@Test(enabled = true)
	public void lumaCompareProducts() throws IOException, InterruptedException {
		webDriverUtils.implicitWaitInMillis(driver);
		Actions actions = new Actions(driver);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedhomepagetitle")),
				"Home page title found incorrect");
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		homePageAfterLogin.getMenSection().click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedmenpagetitle")),
				"Expected men page title found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("expectedmenpageurl")),
				"Expected men page url found incorrect");
		LumaMensSectionPage menSectionPage = new LumaMensSectionPage(driver);
		menSectionPage.getTeesSection().click();
		webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("teestitle"));
		webDriverUtils.partialUrl(driver, fileUtils.toReadData("teesurl"));
		LumaMenTeesPage menTeesPage = new LumaMenTeesPage(driver);
		actions.moveToElement(menTeesPage.getEnduranceTee()).pause(2500).click().build().perform();
		actions.moveToElement(menTeesPage.getEnduranceAddToCompare()).pause(2000).build().perform();
		webDriverUtils.elementIsClickable(menTeesPage.getEnduranceAddToCompare(), driver).click();
		//actions.click(menTeesPage.getEnduranceAddToCompare()).pause(1000).build().perform();
		actions.pause(2000).perform();
		driver.navigate().back();
		actions.pause(2000).perform();
		driver.navigate().back();
		actions.pause(2000).perform();
		menTeesPage.getNumOfItemsToCompare().getText().contains(fileUtils.toReadData("firstitemadded"));
		System.out.println(menTeesPage.getNumOfItemsToCompare().getText());
		actions.pause(1500).perform();
		actions.moveToElement(menTeesPage.getEverCoolTee()).pause(2000).click().build().perform();
		actions.moveToElement(menTeesPage.getEverCoolAddToCompare()).pause(2500).build().perform();
		actions.click(menTeesPage.getEverCoolAddToCompare()).pause(2000).build().perform();
		actions.pause(2000).perform();
		driver.navigate().back();
		actions.pause(2000).perform();
		driver.navigate().back();
		actions.pause(2000).perform();
		menTeesPage.getNumOfItemsToCompare().getText().contains(fileUtils.toReadData("seconditemadded"));
		System.out.println(menTeesPage.getNumOfItemsToCompare().getText());
		actions.scrollToElement(menTeesPage.getCompareOption()).pause(2000).build().perform();
		actions.click(menTeesPage.getCompareOption()).perform();
		webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("comparepagetitle"));
		webDriverUtils.partialUrl(driver, fileUtils.toReadData("comparepageurl"));
		actions.pause(2000).perform();
		driver.navigate().back();
		actions.pause(2000).perform();
		actions.click(menTeesPage.getCompareClearAllOption()).pause(2000).build().perform();
		menTeesPage.getPermissionForRemoveCompareItems().click();
		System.out.println("lumaCompareProducts executed");
	}

	@Test(enabled = true)
	public void lumaWishListToCartCheck() throws IOException {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		SoftAssert soft = new SoftAssert();
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		actions.moveToElement(homePageAfterLogin.getGearSection()).pause(5000).build().perform();
		actions.pause(2000).perform();
		actions.moveToElement(homePageAfterLogin.getBagsOption(), 90, 12).pause(2000).click().build().perform();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("bagsandgearspagetitle")),
				"Bags and gears page title found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("bagsandgearspageurl")),
				"Bags and Gears page url found incorrect");
		actions.pause(2500).perform();
		LumaBagsAndGearsPage bagsAndGearPage = new LumaBagsAndGearsPage(driver);
		actions.pause(5000).perform();
		actions.moveToElement(bagsAndGearPage.getmessengerBag()).pause(2000).click().build().perform();
		webDriverUtils.elementToBeClickable(driver, bagsAndGearPage.getAddToWishlistOption()).click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("wishlisttitle")),
				"wishlist page title found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("wishlisturl")),
				"Wishlist page url found incorrrect");
		LumaWishListPage wishListPage = new LumaWishListPage(driver);
		actions.pause(5000).perform();
		actions.scrollToElement(wishListPage.getAddToCartButton()).pause(2000).build().perform();
		webDriverUtils.elementToBeClickable(driver, wishListPage.getAddToCartButton()).click();
		soft.assertEquals(wishListPage.getWishListItems().getText(), fileUtils.toReadData("wishlistempty"));
		actions.pause(3000).perform();
		actions.click(wishListPage.getCartSymbol()).pause(2000).build().perform();
		actions.pause(3000).perform();
		soft.assertEquals(wishListPage.getItemsPresentInCart().getText(), fileUtils.toReadData("bagscount"));
		actions.click(wishListPage.getDeleteProductFromCart()).pause(2000).perform();
		actions.click(wishListPage.getPermissionToRemoveItem()).pause(2000).perform();
		actions.pause(3000).perform();
		System.out.println("LumaWishListToCartCheck executed");

	}

	@Test(enabled = false)
	public void productRemoving() throws IOException {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		SoftAssert soft = new SoftAssert();
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		homePageAfterLogin.getMenSection().click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedmenpagetitle")),
				"Expected men page title found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("expectedmenpageurl")),
				"Expected men page url found incorrect");
		LumaMensSectionPage menSectionPage = new LumaMensSectionPage(driver);
		actions.moveToElement(menSectionPage.getJacketsSection()).pause(2000).click().build().perform();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedjacketpagetitle")),
				"Jacket paget title found incorrect");
		LumaJacketPage jacketPage = new LumaJacketPage(driver);
		actions.moveToElement(jacketPage.getMontanaJacketLink()).pause(3000).build().perform();
		actions.click(jacketPage.getMontanaJacketSize()).pause(2000).build().perform();
		actions.click(jacketPage.getMontanaJacketColor()).pause(2000).perform();
		actions.click(jacketPage.getMontanaJacketCart()).pause(2000).perform();
		actions.pause(5000).perform();
		actions.click(jacketPage.getMycart()).pause(2000).perform();
		actions.pause(3000).perform();
		actions.click(jacketPage.getViewAndEditCart()).pause(2000).perform();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("shoppingcartpagetitle")),
				"Title is not found correct");
		LumaShoppingCartPage shoppingCartPage = new LumaShoppingCartPage(driver);
		actions.moveToElement(shoppingCartPage.getItemQuantityBox()).pause(2000).perform();
		soft.assertEquals(shoppingCartPage.getItemQuantityBox().getAttribute("value"), "1");
		shoppingCartPage.getItemQuantityBox().clear();
		actions.click(shoppingCartPage.getItemQuantityBox()).sendKeys("3").pause(2000).build().perform();
		shoppingCartPage.getUpdateCartButton().click();
		soft.assertEquals(shoppingCartPage.getItemQuantityBox().getAttribute("value"), "3");
		shoppingCartPage.getRemoveItemOption().click();
		soft.assertEquals(shoppingCartPage.getEmptyMessageNote().getText(), "You have no items in your shopping cart.");
		System.out.println("ProductRemoving executed");
	}

	@Test(enabled = false)
	public void lumaApplyFilterToProduct() throws IOException {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		SoftAssert soft = new SoftAssert();
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		homePageAfterLogin.getGearSection().click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("gearpagetitle")),
				"Gear page title found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("gearpageurl")),
				"Gear page url found incorrect");
		LumaGearPage gearPage = new LumaGearPage(driver);
		gearPage.getWatchesLink().click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("watchpagetitle")),
				"Watch page title is found incorrect");
		Assert.assertTrue(webDriverUtils.partialUrl(driver, fileUtils.toReadData("watchpageurl")),
				"Watch page url is found incorrect");
		LumaWatchesGearPage watchesGearPage = new LumaWatchesGearPage(driver);
		actions.pause(2000).perform();
		actions.click(watchesGearPage.getActivityOption()).pause(2000).perform();
		actions.click(watchesGearPage.getGymOption()).pause(2000).perform();
		actions.click(watchesGearPage.getMaterialOption()).pause(2000).perform();
		actions.click(watchesGearPage.getMetalOption()).pause(2000).perform();
		actions.click(watchesGearPage.getClearAllOption()).pause(2000).perform();
		System.out.println("LumaApplyFilterToProduct executed");
	}

	@Test(enabled = false)
	public void lumaPrintPrices() {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		homePageAfterLogin.getMenSection().click();
		LumaMensSectionPage menSectionPage = new LumaMensSectionPage(driver);
		actions.moveToElement(menSectionPage.getJacketsSection()).pause(2000).click().build().perform();
		List<WebElement> prices = driver.findElements(By.className("price"));
		for (int i = 0; i < prices.size(); i++) {
			System.out.println(prices.get(i).getText());
		}
	}

	@Test(enabled = false)
	public void handleHiddenDivPopup() {
		webDriverUtils.implicitWaitInSeconds(driver);
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		Assert.assertEquals(homePageAfterLogin.getHiddenDivPopup().isDisplayed(), true);
		homePageAfterLogin.getHiddenDivPopup().click();
		System.out.println("Hidden division popup handled ");

	}
	
	@Test(enabled = false)
	public void profileSection() throws IOException, InterruptedException {
		webDriverUtils.implicitWaitInSeconds(driver);
		LumaHomePageAfterLogin homePage=new  LumaHomePageAfterLogin(driver);
		homePage.getShowMenuOption().click();
		LumaAccountPage acctPage= new LumaAccountPage(driver);
		acctPage.getMyAccountOption().click();
		webDriverUtils.elementIsClickable(acctPage.getEditBillingAdd(), driver);
		Actions actions=new Actions(driver);
		actions.scrollToElement(acctPage.getEditBillingAdd()).build().perform();
		acctPage.getEditBillingAdd().click();
		acctPage.getStreet1Feild().clear();
		acctPage.getStreet1Feild().sendKeys(fileUtils.toReadData("address"));
		acctPage.getCityFeild().clear();
		acctPage.getCityFeild().sendKeys(fileUtils.toReadData("city"));
		acctPage.getPhoneNumberFeild().clear();
		acctPage.getPhoneNumberFeild().sendKeys(fileUtils.toReadData("phonenumber"));
		Select selectState=new Select(acctPage.getStateDropDown());
		Thread.sleep(5000);
		selectState.selectByIndex(4);
		acctPage.getZipCodeFeild().sendKeys(fileUtils.toReadData("zipcode"));
		Select selectCountry =new Select(acctPage.getCountryDropDown());
		selectCountry.selectByValue("IN");
		Thread.sleep(5000);
		actions.scrollToElement(acctPage.getSaveAddButton()).pause(3000).build().perform();
		acctPage.getSaveAddButton().click();
			
	}
}
