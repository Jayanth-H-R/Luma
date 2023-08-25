package com.luma.qspiders.endtoendtest;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.luma.qspiders.genericutility.Basics;
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
	@Test()
	public void homePageCheck() throws IOException {
		System.out.println("Logged in Successful");
	}

	@Test()
	public void menSectionCart() throws IOException {
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
		actions.click(montanaJacketPage.getMycart()).pause(2000).perform();
		soft.assertEquals(montanaJacketPage.getItemsInCart().getText(), fileUtils.toReadData("jacketcount"));
		actions.pause(3000).perform();
		actions.moveToElement(montanaJacketPage.getRemoveFromCartOption()).pause(2000).build().perform();
		actions.click(montanaJacketPage.getRemoveFromCartOption()).pause(2000).perform();
		actions.click(montanaJacketPage.getPermissionOkButton()).perform();
		soft.assertAll();
		System.out.println("menSectionCart executed");

	}

	@Test()
	public void searchProductWishlist() throws IOException {
		Actions actions = new Actions(driver);
		webDriverUtils.implicitWaitInSeconds(driver);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("expectedhomepagetitle")),
				"Home page title found incorrect");
		LumaHomePageAfterLogin homePageAfterLogin = new LumaHomePageAfterLogin(driver);
		homePageAfterLogin.getSearchMenu().sendKeys(fileUtils.toReadData("searchproduct"));
		homePageAfterLogin.getSearchMenu().sendKeys(Keys.ENTER);
		actions.pause(2000);
		// String actualTitle = driver.getTitle();
		soft.assertTrue(webDriverUtils.partialTitle(driver, fileUtils.toReadData("sweatshirtpagetitle")),
				"Sweatshirt page title found incorrect");
		LumaSweatshirtPage sweatshirtPage = new LumaSweatshirtPage(driver);
		sweatshirtPage.getGraysonSweatshirt().click();
		LumaGraysonSweatshirtPage graysonSweatshirtPage = new LumaGraysonSweatshirtPage(driver);
		graysonSweatshirtPage.getmSizeOption().click();
		graysonSweatshirtPage.getOrangeColorOption().click();
		graysonSweatshirtPage.getAddToWishListLink().click();
		soft.assertTrue(webDriverUtils.verifyCompleteTitleIs(driver, fileUtils.toReadData("wishlisttitle")),
				"Wishlist page title found incorrect");
		LumaWishListPage wishlistPage = new LumaWishListPage(driver);
		// actions.moveToElement(wishlistPage.getProductGrid()).pause(2000).build().perform();
		actions.pause(5000).perform();
		actions.click(wishlistPage.getRemoveFromWishlistOption()).pause(1000).build().perform();
		soft.assertAll();
		System.out.println("searchProductWishlist executed");
	}

	@Test()
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
		actions.click(menTeesPage.getEnduranceAddToCompare()).pause(1000).build().perform();
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

	@Test()
	public void LumaWishListToCartCheck() throws IOException {
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

	@Test()
	public void ProductRemoving() throws IOException {
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

	@Test()
	public void LumaApplyFilterToProduct() throws IOException {
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
}
