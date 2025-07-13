package lakshmitej.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lakshmitej.AbstractComponents.OrderPage;
import lakshmitej.TestComponents.BaseTest;
import lakshmitej.pageobjects.CartPage;
import lakshmitej.pageobjects.CheckoutPage;
import lakshmitej.pageobjects.ConfirmationPage;
import lakshmitej.pageobjects.Landingpage;
import lakshmitej.pageobjects.ProductCatalogue;

public class SubitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	@Test
	public void submitOrder() throws IOException, InterruptedException {
		//String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingpage.loginApplication("luckytej04@gmail.com", "10March1998");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
	}

  /* @Test(dependsOnMethods= {"submitOrder"})
   public void OrderHistoryTest()
   {
	   ProductCatalogue productCatalogue = landingpage.loginApplication("luckytej04@gmail.com", "10March1998");
	  OrderPage ordersPage = productCatalogue.goToOrdersPage();
	  Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	  
   
   
   }
   
   
   */



}







