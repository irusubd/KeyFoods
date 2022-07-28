package utils;

import org.openqa.selenium.WebElement;

import pages.BlogPage;
import pages.BrowsePage;
import pages.CartPage;
import pages.CatMenu;
import pages.CheckoutPage;
import pages.MainMenu;
import pages.OrderPage;
import pages.PostPage;

public class BasePage extends BaseTest {

	public MainMenu mainMenu = new MainMenu(driver);
	public CatMenu catMenu = new CatMenu(driver);
	public BrowsePage browsePage = new BrowsePage(driver);
	public CartPage cartPage = new CartPage(driver);
	public CheckoutPage checkoutPage = new CheckoutPage(driver);
	public OrderPage orderPage = new OrderPage(driver);
	public BlogPage blogPage = new BlogPage(driver);
	public PostPage postPage = new PostPage(driver);

	public SeleniumWrappers se = new SeleniumWrappers(driver);

	public void navigateTo(WebElement element) {
		element.click();
	}

}
