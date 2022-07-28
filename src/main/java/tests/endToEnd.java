package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import utils.BaseTest;
import utils.Log;
import utils.ReadPropertiesFile;

public class endToEnd extends BaseTest {

	String coupon = ReadPropertiesFile.credentials.getProperty("coupon");

	@Test
	public void placeOrder() throws InterruptedException {

		app.navigateTo(app.catMenu.frozenFoods);
		app.browsePage.addRandomProductsToCart(2);

		app.navigateTo(app.mainMenu.homeLink);

		app.navigateTo(app.catMenu.beverages);
		app.browsePage.addToCart("Coca-Cola – 2 L Bottle");

		app.navigateTo(app.mainMenu.cartLink);
		Double fullPrice = app.cartPage.getTotalPrice();

		app.cartPage.applyCoupon(coupon);
		Double discountPrice = app.cartPage.getTotalPrice();

		assertTrue(discountPrice < fullPrice, "Coupon not applied!");

		app.cartPage.checkoutButton.click();

		app.checkoutPage.fillBillingDetails();
		app.checkoutPage.termsCheckbox.click();
		app.checkoutPage.submitButton.click();

		assertTrue(app.orderPage.getOrderMessage().contains("Your order has been received"),
				"Order has not been placed successfully");
		Log.info(app.orderPage.getOrderMessage() + app.orderPage.getOrderNumber());

	}

}
