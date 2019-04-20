package com.ethoca.automation.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ethoca.automation.challenge.helpers.Locator;
import com.ethoca.automation.challenge.helpers.WebUtils;

/* Author : Kishan */
/*
 * All the helping methods related to Home Page
 */

public class HomePage {

	public WebDriverWait wait;
	public Locator locator;
	public WebUtils webUtils;
	public PaymentPage objPayment;

	public HomePage(WebDriver driver) {
		locator = new Locator();
		webUtils = new WebUtils(driver);
	}

	public void hover(By element) {
		webUtils.hover(element);
	}

	public void click(By element) {
		webUtils.click(element);
	}

	public void switchFrames(By element) {
		webUtils.switchFrames(element);
	}

	public void select(By element, String value) {
		webUtils.select(element, value);
	}

	public void enterText(By element, String value) {
		webUtils.enterText(element, value);
	}

	public void waitForElement(By locator) {
		webUtils.waitWithvisibilityOfElementLocated(locator);
	}

	public void implicitWait(int seconds) {
		webUtils.implicitWait(seconds);
	}

}
