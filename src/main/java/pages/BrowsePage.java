package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BrowsePage extends SeleniumWrappers {

	public WebDriver driver;

	public BrowsePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "product-title")
	public List<WebElement> listedProducts;
	
	public void addToCart(String productName) throws InterruptedException {
		hoverElement(super.driver.findElement(By.xpath("//h3[@class='product-title']/descendant::a[@title='" + productName + "']")));
		hoverElement(super.driver.findElement(By.linkText("Add to cart")));
		super.driver.findElement(By.linkText("Add to cart")).click();
		
	}

	public void addRandomProductsToCart(int howMany) throws InterruptedException {
		Random rand = new Random();
		for (int i = 0; i < howMany; i++) {
			addToCart(listedProducts.get(rand.nextInt(listedProducts.size())).getText());
		}
	}

}
