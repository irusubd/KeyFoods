package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ReadPropertiesFile;
import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "billing_first_name")
	public WebElement fNameField;
	@FindBy(id = "billing_last_name")
	public WebElement lNameField;
	@FindBy(id = "billing_country")
	public WebElement countryField;
	@FindBy(className = "select2-search__field")
	public WebElement countrySearchField;
	@FindBy(id = "billing_address_1")
	public WebElement addressField;
	@FindBy(id = "billing_city")
	public WebElement cityField;
	@FindBy(id = "billing_state")
	public WebElement stateField;
	@FindBy(id = "billing_postcode")
	public WebElement zipField;
	@FindBy(id = "billing_phone")
	public WebElement phoneField;
	@FindBy(id = "billing_email")
	public WebElement emailField;
	@FindBy(name = "terms")
	public WebElement termsCheckbox;
	@FindBy(id = "place_order")
	public WebElement submitButton;

	public void fillBillingDetails() throws InterruptedException {
		fNameField.sendKeys(ReadPropertiesFile.credentials.getProperty("fName"));
		lNameField.sendKeys(ReadPropertiesFile.credentials.getProperty("lName"));
		new Select(countryField).selectByVisibleText(ReadPropertiesFile.credentials.getProperty("country"));
		addressField.sendKeys(ReadPropertiesFile.credentials.getProperty("address"));
		cityField.sendKeys(ReadPropertiesFile.credentials.getProperty("city"));
		new Select(stateField).selectByVisibleText(ReadPropertiesFile.credentials.getProperty("state"));
		zipField.sendKeys(ReadPropertiesFile.credentials.getProperty("zip"));
		phoneField.sendKeys(ReadPropertiesFile.credentials.getProperty("phone"));
		emailField.sendKeys(ReadPropertiesFile.credentials.getProperty("email"));
	}

}
