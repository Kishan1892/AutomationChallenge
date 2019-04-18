package com.ethoca.automation.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ethoca.automation.challenge.helpers.Locator;
import com.ethoca.automation.challenge.helpers.WebUtils;

public class HomePage {

	WebDriverWait wait;
	Locator locator;
	WebUtils webUtils;

	public HomePage(WebDriver driver) {
		locator = new Locator();
		webUtils = new WebUtils(driver);
	}

	public void hover(By element) {
		webUtils.hover(element);
	}

	public void click(By summerDresses) {
		webUtils.click(summerDresses);
	}

	public void switchFrames(By element) {
		webUtils.switchFrames(element);
	}

	public void select(By element, String value) {
		webUtils.select(element, value);
	}

	public void selectByValue(By element, String value) {
		webUtils.selectByValue(element, value);
	}

	public void enterText(By element, String value) {
		webUtils.enterText(element, value);
	}

	public void setUsername(String gender, String firstname, String lastname) {

		if (gender.toLowerCase().equals("male")) {
			webUtils.click(locator.male);
		} else if (gender.toLowerCase().equals("female")) {
			webUtils.click(locator.female);
		} else {
			webUtils.click(locator.male);
		}
		enterText(locator.firstname, firstname);
		enterText(locator.lastname, lastname);
	}

	public void selectDateofBirth(String day, String month, String year) {
		selectByValue(locator.day, day);
		selectByValue(locator.month, month);
		selectByValue(locator.year, year);
	}

	public void enterAddress(String address1, String address2, String city, String state, String postal) {
		enterText(locator.address1, address1);
		enterText(locator.address2, address2);
		enterText(locator.city, city);
		selectByValue(locator.state, state);
		enterText(locator.postal, postal);
	}

	public void otherDetails(String other, String phone, String mobilePhone) {
		enterText(locator.other, other);
		enterText(locator.phone, phone);
		enterText(locator.mobilePhone, mobilePhone);
	}

	public String getText(By element) {
		return webUtils.getText(element);
	}

	public void waitForElement(By locator) {
		webUtils.waitWithvisibilityOfElementLocated(locator);
	}

}
