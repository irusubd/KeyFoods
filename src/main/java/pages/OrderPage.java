package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class OrderPage extends SeleniumWrappers {

	public WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "woocommerce-notice")
	public WebElement orderMessage;
	@FindBy(xpath = "//li[@class='woocommerce-order-overview__order order']/strong")
	public WebElement orderNoField;

	public String getOrderNumber() {
		return orderNoField.getText();
	}

	public String getOrderMessage() {
		return orderMessage.getText();
	}

}
