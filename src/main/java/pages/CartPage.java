package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "coupon_code")
	public WebElement couponInputField;
	@FindBy(name = "apply_coupon")
	public WebElement couponApplyButton;
	@FindBy(linkText = "[Remove]")
	public WebElement couponRemoveLink;
	@FindBy(className = "wc-proceed-to-checkout")
	public WebElement checkoutButton;
	@FindBy(xpath = "//td[@data-title='Total']/descendant::span[@class='woocommerce-Price-amount amount']")
	public WebElement priceAmount;

	public Double getTotalPrice() {
		return Double.valueOf(priceAmount.getText().substring(1));
	}

	public void applyCoupon(String coupon) throws InterruptedException {
		couponInputField.sendKeys(coupon);
		couponApplyButton.click();
		waitForElementToBeDisplayed(couponRemoveLink);
	}

}
