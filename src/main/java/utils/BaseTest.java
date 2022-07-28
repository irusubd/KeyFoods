package utils;

import java.io.File;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseTest extends Driver {

	public static WebDriver driver;
	public String url = ReadPropertiesFile.config.getProperty("url");
	public BasePage app;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) throws MalformedURLException {
		driver = initDriver(browser);
		Log.info("Started suite on: " + browser);
		driver.get(url);
		Log.info("Opened: " + url);
		app = new BasePage();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		Log.info("Closed all browser tabs");
	}

	@AfterMethod(alwaysRun = true)
	public void recordFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
			try {
				Files.copy(picture, new File("screenshots/" + result.getName() + "__" + timeStamp + ".png"));
				System.out.println("Screenshot saved");
			} catch (IOException e) {
				System.out.println("Screenshot NOT saved");
				e.printStackTrace();
			}
		}
	}

}
