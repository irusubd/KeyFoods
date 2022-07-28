package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
	
	public ThreadLocal<WebDriver> driver =  new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) throws MalformedURLException {
		
		switch(browser) {
			
		case "chrome" :
			ChromeOptions optionsChrome =  new ChromeOptions();
			optionsChrome.addArguments("start-maximized");
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), optionsChrome));
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			long chromeId = Thread.currentThread().getId();
			Log.info("Chrome ---> Thread id : " + chromeId);
			
		return driver.get();	
		
		case "MicrosoftEdge" :
			EdgeOptions optionsEdge = new EdgeOptions();
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), optionsEdge));
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			long edgeId = Thread.currentThread().getId();
			System.out.println("Edge ---> Thread id : " + edgeId);
			
		return driver.get();	
		
		default:
			return driver.get();

		}
		
	}
	
	

}