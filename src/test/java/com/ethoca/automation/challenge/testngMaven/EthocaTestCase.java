package com.ethoca.automation.challenge.testngMaven;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ethoca.automation.challenge.helpers.Locator;
import com.ethoca.automation.challenge.pages.HomePage;
import com.ethoca.automation.challenge.pages.PaymentPage;

/* Author : Kishan */
/*
 * All the Selenium actions methods related to any Page
 */

public class EthocaTestCase {

	public WebDriver driver;
	public HomePage objHome;
	public PaymentPage objPayment;
	public Locator locator;
	public String expectedDress;
	public String expectedSizeColor;
	public String expectedQuantity;
	public String expectedTotal;
	long randomNumber;

	@BeforeSuite()
	public void chromderiverSetup() {
		// Set chromdriver.exe
		String path = System.getProperty("user.dir");
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", path + "//resources//chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", path + "//resources//chromedriver_windows.exe");
		}
	}

	@BeforeTest()
	public void setupExpectedResults() {

		// Set Chromedriver
		driver = new ChromeDriver();

		// maximize the window
		driver.manage().window().maximize();

		// Go to the URL
		driver.get(Locator.URL);

		// Intialize HomePage
		objHome = new HomePage(driver);

		// Intialize Payment Page
		objPayment = new PaymentPage(driver);

		// Intialize Locator
		locator = new Locator();

		// Expected String Values
		objHome = new HomePage(driver);

		// Intialize Locator
		locator = new Locator();

		// Expected String Values
		expectedDress = "Printed Chiffon Dress";
		expectedSizeColor = "Color : Yellow, Size : M";
		expectedQuantity = "1";
		expectedTotal = "$16.40";

		// Random Number
		randomNumber = Math.round(Math.random() * 10000000);
	}

	@Test
	public void EthocaChallenge() {

		// Wait for Women Section to be visible
		objHome.waitForElement(locator.womenSection);

		try {
			// Hover to Women Section
			objHome.hover(locator.womenSection);

			// Wait for Summer Dresses Link to be visible
			objHome.waitForElement(locator.summerDresses);

			// Click on Summer Dresses
			objHome.click(locator.summerDresses);

			// Wait for Printed Chiffon Dress to be visible
			objHome.waitForElement(locator.productPrintedChiffonDress);

			// Hover to Printed Chiffon Dress
			objHome.hover(locator.productPrintedChiffonDress);

			// Wait for Quick View to be visible
			objHome.waitForElement(locator.productPrintedChiffonDressQuickView);

			// Click on Quick View
			objHome.click(locator.productPrintedChiffonDressQuickView);

			// Switch Frame
			objHome.switchFrames(locator.iFrame);

			// Wait for Add to Cart button to be visible
			objHome.waitForElement(locator.productPrintedChiffonDressAddtoCart);

			// Select M Size
			objHome.select(locator.productPrintedChiffonDressSize, "M");

			// Click on Add to Cart Button
			objHome.click(locator.productPrintedChiffonDressAddtoCart);

			// Wait for Continue Shopping Button to be Visible
			objHome.waitForElement(locator.continueShopping);
			objHome.implicitWait(1);

			// Click on Continue Shopping Button
			objHome.click(locator.continueShopping);

			// Hover on Shopping Cart
			objHome.hover(locator.shoppingCart);

			// Wait for Order Cart to be visible
			objHome.waitForElement(locator.orderCart);

			// Click on Order Cart
			objHome.click(locator.orderCart);

			// Wait for Proceed Checkout to be visible
			objPayment.waitForElement(locator.proceedCheckOut);

			// Click Proceed Checkout
			objPayment.click(locator.proceedCheckOut);

			// Wait for Register Button to be visible
			objPayment.waitForElement(locator.submitCreate);

			// Enter Email id with a random number
			objPayment.enterText(locator.emailCreate, randomNumber + "_kishan@gmail.com");

			// Click Register
			objPayment.click(locator.submitCreate);

			// Fill the details in the form
			// Wait for Submit Button to be visible
			objPayment.waitForElement(locator.submitAccount);

			// Select Gender Radio button | Enter Firstname | Enter Lastname
			objPayment.setUsername("Male", "Kishan", "Patel");

			// Enter Password
			objPayment.enterText(locator.password, "123456");

			// Select Date of Birth
			objPayment.selectDateofBirth("18", "1", "1992");

			// Check Newsletter
			objPayment.click(locator.newsLetter);

			// Check Offers
			objPayment.click(locator.option);

			// Enter Company Name
			objPayment.enterText(locator.companyName, "Ethoca");

			// Enter Address
			objPayment.enterAddress("North York", "Toronto", "Toronto", "5", "12345");

			// Enter Mobile numbers
			objPayment.otherDetails("Hello Everyone", "2264020567", "2264020567");

			// Click submit button
			objPayment.click(locator.submitAccount);

			// Wait for Process Address Button to be visible
			objPayment.waitForElement(locator.processAddress);

			// Click Process Address Button
			objPayment.click(locator.processAddress);

			// Click Terms and Service
			objPayment.click(locator.uniform);

			// Wait for Process Carrier Button to be visible
			objPayment.waitForElement(locator.processCarrier);

			// Click Process Carrier Button
			objPayment.click(locator.processCarrier);

			// GetText of Dress
			String actualDress = objPayment.getText(locator.productPrintedChiffonDressNameText);

			// Verify Dress name
			Assert.assertEquals(expectedDress, actualDress);

			// GetText of Size and Color
			String actualSizeColor = objPayment.getText(locator.productPrintedChiffonDressSizeColorText);

			// Verify Size and Color
			Assert.assertEquals(expectedSizeColor, actualSizeColor);

			// GetText of Quantity
			String actualQuantity = objPayment.getText(locator.productPrintedChiffonDressQuantity);

			// Verify Quantity
			Assert.assertEquals(expectedQuantity, actualQuantity);

			// GetText Total Amount
			String actualTotal = objPayment.getText(locator.productPrintedChiffonDressQuantityOnePrice);

			// Verify Total Amount
			Assert.assertEquals(expectedTotal, actualTotal);
		} // Catch Exception as per the order they occur
		catch (InvalidSelectorException e) {
			System.out.println("Selector is Invalid");
			System.out.println(e.getMessage());
		} catch (ElementNotVisibleException e) {
			System.out.println("Element not visible");
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			System.out.println("Element Not Found");
		} catch (TimeoutException e) {
			System.out.println(e.getMessage());
			System.out.println("WebDriver couldn’t locate the element");
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
			System.out.println("An exceptional case.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterTest()
	public void closeBrowser() {
		// Close the browser
		driver.quit();
	}
}
