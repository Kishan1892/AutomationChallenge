package com.ethoca.automation.challenge.helpers;

/* All the locators */

import org.openqa.selenium.By;

public class Locator {
	
	public static final String URL = "http://automationpractice.com";
	
	public By womenSection = By.xpath("//a[@title='Women']");
	
	public By summerDresses = By.xpath("//a[@title='Summer Dresses']");
	
	public By productPrintedChiffonDress = By.xpath("//div[@class='product-image-container']/a[@title='Printed Chiffon Dress']");
	
	public By productPrintedChiffonDressQuickView = By.xpath("//div[a[@title='Printed Chiffon Dress']]/a/span[contains(text(),'Quick view')]");
	
	public By iFrame = By.xpath("//iframe[@class='fancybox-iframe']");
	
	public By productPrintedChiffonDressSize = By.xpath("//select[@id='group_1']");
	
	public By productPrintedChiffonDressAddtoCart = By.xpath("//button[@type='submit']");
	
	public By continueShopping = By.xpath("//span[@title='Continue shopping']");
	
	public By shoppingCart = By.xpath("//a[@title='View my shopping cart']");
	
	public By orderCart = By.id("button_order_cart");
	
	public By proceedCheckOut = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");
	
	public By submitCreate = By.id("SubmitCreate");
	
	public By emailCreate = By.id("email_create");
	
	public By submitAccount = By.id("submitAccount");
	
	public By male = By.id("id_gender1");
	
	public By female = By.id("id_gender2");
	
	public By firstname = By.id("customer_firstname");
	
	public By lastname = By.id("customer_lastname");
	
	public By password = By.id("passwd");
	
	public By day = By.id("days");
	
	public By month = By.id("months");
	
	public By year = By.id("years");
	
	public By newsLetter = By.id("newsletter");
	
	public By option = By.id("optin");
	
	public By companyName = By.id("company");
	
	public By address1 = By.id("address1");
	
	public By address2 = By.id("address2");
	
	public By city = By.id("city");
	
	public By state = By.id("id_state");
	
	public By postal = By.id("postcode");
	
        public By other = By.id("other");

        public By phone = By.id("phone");
    
        public By mobilePhone = By.id("phone_mobile");
    
        public By processAddress = By.xpath("//button[@name='processAddress']");
    
        public By uniform = By.id("uniform-cgv");
    
        public By processCarrier = By.xpath("//button[@name='processCarrier']");
    
        public By productPrintedChiffonDressNameText  = By.xpath("//p[@class='product-name']/a[contains(text(),'Printed Chiffon Dress')]");
    
        public By productPrintedChiffonDressSizeColorText = By.xpath("//td[p[@class='product-name']/a[contains(text(),'Printed Chiffon Dress')]]/small/a");
    
        public By productPrintedChiffonDressQuantity  = By.xpath("//tr[td[p[@class='product-name']/a[contains(text(),'Printed Chiffon Dress')]]]/td[@class='cart_quantity text-center']");
    
        public By productPrintedChiffonDressQuantityOnePrice = By.xpath("//tr[td[p[@class='product-name']/a[contains(text(),'Printed Chiffon Dress')]]]//td[@class='cart_total']");

}
