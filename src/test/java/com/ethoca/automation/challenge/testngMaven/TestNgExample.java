package com.ethoca.automation.challenge.testngMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ethoca.automation.challenge.helpers.Locator;
import com.ethoca.automation.challenge.pages.HomePage;


public class TestNgExample {
	
	WebDriver driver;
	HomePage objHome ;
	Locator locator;
	String expectedDress;
	String expectedSizeColor;
	String expectedQuantity;
	String expectedTotal;
	
	@BeforeSuite()
	public void chromderiverSetup(){
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"//resources//chromedriver.exe");
	}
	
	@BeforeTest()
	public void setupExpectedResults() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Locator.URL);
	    objHome = new HomePage(driver);
	    locator = new Locator();
		expectedDress = "Printed Chiffon Dress";
		expectedSizeColor = "Color : Yellow, Size : M";
		expectedQuantity = "1";
		expectedTotal = "$16.40";
	}
	
	@Test
	public void EthocaChallenge() {
		objHome.waitForElement(locator.womenSection);	
		
		objHome.hover(locator.womenSection);
		
		objHome.waitForElement(locator.summerDresses);
		
		objHome.click(locator.summerDresses);
		
		objHome.waitForElement(locator.productPrintedChiffonDress);
		objHome.hover(locator.productPrintedChiffonDress);
		
		objHome.waitForElement(locator.productPrintedChiffonDress);	
		objHome.click(locator.productPrintedChiffonDressQuickView);
		
		objHome.switchFrames(locator.iFrame);
		
		objHome.waitForElement(locator.productPrintedChiffonDressAddtoCart);
		
		objHome.select(locator.productPrintedChiffonDressSize, "M");
			
		objHome.click(locator.productPrintedChiffonDressAddtoCart);
		
		objHome.waitForElement(locator.continueShopping);	
		objHome.click(locator.continueShopping);
		
		objHome.hover(locator.shoppingCart);
			
		objHome.waitForElement(locator.orderCart);
		objHome.click(locator.orderCart);
		
		objHome.waitForElement(locator.proceedCheckOut);
		objHome.click(locator.proceedCheckOut);

		objHome.waitForElement(locator.submitCreate);
		
		objHome.enterText(locator.emailCreate ,Math.round(Math.random()*10000000) +"_kishan@gmail.com");
	
		objHome.click(locator.submitCreate);
		
		// Fill the form	
		objHome.waitForElement(locator.submitAccount);
		objHome.setUsername("Male","Kishan","Patel");
		objHome.enterText(locator.password, "123456");
		
		objHome.selectDateofBirth("18", "1", "1992");
		objHome.click(locator.newsLetter);
		objHome.click(locator.option);

		objHome.enterText(locator.companyName, "Ethoca");

		objHome.enterAddress("North York","Toronto","Toronto", "5", "12345");

		objHome.otherDetails("Hello Everyone", "2264020567", "2264020567");
		objHome.click(locator.submitAccount);	

		objHome.waitForElement(locator.processAddress);
		objHome.click(locator.processAddress);	
		objHome.click(locator.uniform);	
		
		objHome.waitForElement(locator.processCarrier);
		objHome.click(locator.processCarrier);	
		
		String actualDress = objHome.getText(locator.productPrintedChiffonDressNameText);		
		Assert.assertEquals(expectedDress, actualDress);
		
		String actualSizeColor = objHome.getText(locator.productPrintedChiffonDressSizeColorText);	
		Assert.assertEquals(expectedSizeColor, actualSizeColor);
		
		String actualQuantity = objHome.getText(locator.productPrintedChiffonDressQuantity);
		Assert.assertEquals(expectedQuantity, actualQuantity);
		
		String actualTotal = objHome.getText(locator.productPrintedChiffonDressQuantityOnePrice);
		Assert.assertEquals(expectedTotal, actualTotal);			
	}
		
	@AfterTest()
	public void closeBrowser() {
		driver.quit();
	}
}
