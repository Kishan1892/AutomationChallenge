package com.ethoca.automation.challenge.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {

	WebDriver driver;
	Actions action;
	Select dropdown;
	WebDriverWait wait;

	public WebUtils(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
	}

	public void click(By summerDresses) {
		driver.findElement(summerDresses).click();
	}

	public void hover(By element) {
		action.moveToElement(driver.findElement(element)).perform();
	}

	public void select(By element, String value) {
		dropdown = new Select(driver.findElement(element));
		dropdown.selectByVisibleText(value);
	}

	public void enterText(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}

	public String getText(By element) {
		return driver.findElement(element).getText();
	}

	public void switchFrames(By element) {
		driver.switchTo().frame(driver.findElement(element));
	}

	public void selectByValue(By element, String value) {
		dropdown = new Select(driver.findElement(element));
		dropdown.selectByValue(value);
	}

	public void waitWithvisibilityOfElementLocated(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}

	public void implicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);		
	}

}
