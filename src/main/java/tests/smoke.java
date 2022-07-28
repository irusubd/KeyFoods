package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class smoke extends BaseTest {

	@Test
	public void checkBlog() {

		app.navigateTo(app.mainMenu.blogLink);
		assertEquals(app.blogPage.countBlogPosts(), 4, "There are not 4 blog posts!");

		SoftAssert sa = new SoftAssert();

		for (int i = 0; i < app.blogPage.countBlogPosts(); i++) {
			String postTitle = app.blogPage.postTitles.get(i).getText();

			app.navigateTo(app.blogPage.postTitles.get(i));

			sa.assertTrue(app.postPage.canComment(), "Can not post comment on: " + postTitle);

			if (app.postPage.canComment()) {
				app.postPage.postComment();
				sa.assertTrue(app.postPage.commentPosted(), "Comment failed on: " + postTitle);
			}
			app.navigateTo(app.mainMenu.blogLink);
		}

		sa.assertAll();

	}

}
