package com.luma.qspiders.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility1 {
	

		public void implicitWaitInSeconds(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		public void implicitWaitInMillis(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		}

		public boolean verifyCompleteTitleIs(WebDriver driver, String expectedTitle) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean validation = wait.until(ExpectedConditions.titleIs(expectedTitle));
			return validation;

		}

		public boolean verifyByUrl(WebDriver driver, String expectedUrl) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean validation = wait.until(ExpectedConditions.urlToBe(expectedUrl));
			return validation;

		}
		
		public boolean partialUrl(WebDriver driver,String partialUrl) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean validation = wait.until(ExpectedConditions.urlContains(partialUrl));
			return validation;
		}
		
		public WebDriver controlTransferToWindow(WebDriver driver,String windowId) {
			WebDriver updatedDriver = driver.switchTo().window(windowId);
			return updatedDriver;
			
		}
		
		public WebElement elementToBeClickable(WebDriver driver, WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement	ele=wait.until(ExpectedConditions.elementToBeClickable(element));
			return ele;
		}
		
		public boolean partialTitle(WebDriver driver,String partialTitle) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			boolean validation = wait.until(ExpectedConditions.titleContains(partialTitle));
			return validation;	
		}
		
		public boolean verifyTagText(WebDriver driver,WebElement ele, String tagText) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			boolean validation = wait.until(ExpectedConditions.textToBePresentInElement(ele, tagText));
			return validation;
		}
		
		public WebElement elementIsClickable(WebElement element, WebDriver driver) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement validation = wait.until(ExpectedConditions.elementToBeClickable(element));
			return validation;
		}
		
		
	}

