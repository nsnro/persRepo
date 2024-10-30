package ValetParking;
import Resources.Resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_ValetParking_1 {
	public static WebDriver instantiate()
	{
		System.setProperty("webdriver.chrome.driver", Resources.location);

		WebDriver browser = new ChromeDriver();
		
		browser.get(Resources.website);
		
		return browser;
	}
	//Normal Calculations for Parking Cost Calculator
	public static void main(String[] args) {
		WebDriver testBrowser = instantiate();
		testBrowser.navigate().to("https://old.reddit.com");
	}


}
