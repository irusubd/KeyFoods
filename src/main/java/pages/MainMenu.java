package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MainMenu extends SeleniumWrappers {

	public WebDriver driver;

	public MainMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Online Grocery Shopping Center")
	public WebElement homeLink;
	@FindBy(className = "klbth-icon-shopping-bag")
	public WebElement cartLink;
	@FindBy(linkText = "BLOG")
	public WebElement blogLink;

}
