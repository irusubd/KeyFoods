package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers {

	public WebDriver driver;

	public BlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='site-posts']/descendant::h2[@class='entry-title']")
	public List<WebElement> postTitles;

	public int countBlogPosts() {
		return postTitles.size();
	}

}
