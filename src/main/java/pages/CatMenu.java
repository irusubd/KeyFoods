package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CatMenu extends SeleniumWrappers {

	public WebDriver driver;

	public CatMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Frozen Foods")
	public WebElement frozenFoods;
	@FindBy(linkText = "Beverages")
	public WebElement beverages;

}
