package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReadPropertiesFile;
import utils.SeleniumWrappers;

public class PostPage extends SeleniumWrappers {

	public WebDriver driver;

	public PostPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Leave a Reply ']")
	public WebElement leaveReplyHeader;
	@FindBy(id = "comment")
	public WebElement commentField;
	@FindBy(id = "author")
	public WebElement nameField;
	@FindBy(id = "email")
	public WebElement emailField;
	@FindBy(id = "submit")
	public WebElement submitbutton;
	@FindBy(xpath = "//div[@class='post-comments']//div[@class='klb-post']//em")
	public WebElement moderationText;

	public boolean canComment() {
		try {
			if (leaveReplyHeader.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void postComment() {
		commentField.sendKeys(RandomStringUtils.randomAlphabetic(32));
		nameField.sendKeys(ReadPropertiesFile.credentials.getProperty("fName"));
		emailField.sendKeys(ReadPropertiesFile.credentials.getProperty("email"));
		submitbutton.click();
	}

	public boolean commentPosted() {
		try {
			if (moderationText.getText().contentEquals(ReadPropertiesFile.messages.getProperty("moderation"))) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
