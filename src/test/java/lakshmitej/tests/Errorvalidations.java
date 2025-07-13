package lakshmitej.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import lakshmitej.TestComponents.BaseTest;
import lakshmitej.pageobjects.CartPage;
import lakshmitej.pageobjects.CheckoutPage;
import lakshmitej.pageobjects.ConfirmationPage;
import lakshmitej.pageobjects.ProductCatalogue;

public class Errorvalidations extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
        landingpage.loginApplication("luckytej04@gmail.com", "10March198");
        Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
        
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingpage.loginApplication("lakshmitejdudala@gmail.com", "10March1998");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
		 
	}
	
}

