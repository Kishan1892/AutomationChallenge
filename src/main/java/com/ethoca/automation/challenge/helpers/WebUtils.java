package com.ethoca.automation.challenge.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Author : Kishan */
//Selenium Actions

public class WebUtils {

	public WebDriver driver;
	public Actions action;
	public Select dropdown;
	public WebDriverWait wait;

	public WebUtils(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
	}

	// Selenium Click Method to click an element
	public void click(By summerDresses) {
		driver.findElement(summerDresses).click();
	}

	// Selenium Hover Method to hover an element
	public void hover(By element) {
		action.moveToElement(driver.findElement(element)).perform();
	}

	// Selenium Select Method to select an element from Select Tag by visible text
	public void select(By element, String value) {
		dropdown = new Select(driver.findElement(element));
		dropdown.selectByVisibleText(value);
	}

	// Selenium SendKeys Method to enter text in textfield
	public void enterText(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}

	// Selenium getText to get Text of an element
	public String getText(By element) {
		return driver.findElement(element).getText();
	}

	// Selenium Switch Frame : iFrame
	public void switchFrames(By element) {
		driver.switchTo().frame(driver.findElement(element));
	}

	// Selenium Select Method to select an element from Select Tag by value attribute
	public void selectByValue(By element, String value) {
		dropdown = new Select(driver.findElement(element));
		dropdown.selectByValue(value);
	}

	// Selenium Explicit Wait
	public void waitWithvisibilityOfElementLocated(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}

	// Selenium Implicit Wait
	public void implicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);		
	}

}
