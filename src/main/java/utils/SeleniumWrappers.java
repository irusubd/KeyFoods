package utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers {

	public WebDriver driver;

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}

	public void hoverElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void waitForElementToBeDisplayed(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (NoSuchElementException e) {
			throw new TestException("Error");
		}

	}
	
}
