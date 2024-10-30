package WeatherShopper;
import Resources.Resources;
import WeatherShopper.Moisturizers;
import WeatherShopper.Sunscreen;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeatherShopperMain {
	
	public static boolean sunscreen = false;
	public static boolean moisturizer = false;

	public static WebDriver initialize()
	{
		System.setProperty("webdriver.chrome.driver", Resources.chromeDriverPath);
		
		WebDriver browser = new ChromeDriver();
		
		return browser;
	}
	
	public static void navigateTo(WebDriver browser, String path)
	{
		browser.navigate().to(path);
	}
	
	public static String obtainTemperature(WebDriver browser, WebDriverWait timeoutWait)
	{
		//Identify temperature once on main page
		String temperature = "Invalid";
		try {
		WebElement temperatureDisplay = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("temperature")));
		if (temperatureDisplay.isDisplayed()) {
			String fullTemperature = temperatureDisplay.getAttribute("innerHTML");
			//Replace the *C from the text, so that we only get the number in string format
			temperature = fullTemperature.replaceAll("<sup>.*?</sup>", "").trim();
			}
		}
		catch (Exception e) {
			System.out.println("No temperature found");
		}
		
		return temperature;
		
	}
	
	public static WebElement chooseButton(String temperature, WebDriverWait timeoutWait)
	{
		try {
			if (Integer.parseInt(temperature) < 19) {
				WebElement moisturizerButton = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/moisturizer']")));
				if (moisturizerButton.isDisplayed()){
					moisturizer = true;
					return moisturizerButton;
				}
			}
			if (Integer.parseInt(temperature) > 34) {
				WebElement sunscreenButton = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/sunscreen']")));
				if (sunscreenButton.isDisplayed()) {
					sunscreen = true;
					return sunscreenButton;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return null;
		
	}
	
	public static void parsePage(WebDriver browser)
	{		
		List<WebElement> products = browser.findElements(By.cssSelector("div.text-center.col-4"));
			 
		for (WebElement product : products) {
			try
			{
				WebElement productName = product.findElement(By.cssSelector("p.font-weight-bold.top-space-10"));
				WebElement productPriceR = product.findElement(By.xpath(".//p[contains(text(), 'Price:')]"));
				String productPrice = productPriceR.getText().replaceAll("[^0-9]+", "").trim();
				if (browser.getTitle().toLowerCase().contains("moisturizer")) {
					Moisturizers moisturizer = new Moisturizers(productName.getText(), Integer.parseInt(productPrice));
				}
				if (browser.getTitle().toLowerCase().contains("sunscreen")) {
					Sunscreen sunscreen = new Sunscreen(productName.getText(), Integer.parseInt(productPrice)); 
				}
			}
			catch (Exception e) {
				System.out.println(e);
				}
			}
	}
	
	public static void determineChoice(WebDriver browser, String keyword)
	{
		if (moisturizer == true)
		{
			int price = 99999;
			String name = "";
			for (Moisturizers moisturizer : Moisturizers.objects)
			{
				if (moisturizer.name.contains(keyword))
				{
					if (moisturizer.price < price)
					{
						name = moisturizer.name;
						price = moisturizer.price;
					}
				}
			}
			addToCart(name, price);
		}
		if (sunscreen == true)
		{
			int price = 99999;
			String name = "";
			for (Sunscreen sunscreen : Sunscreen.objects)
			{
				if (sunscreen.name.contains(keyword))
				{
					if (sunscreen.price < price)
					{
						name = sunscreen.name;
						price = sunscreen.price;
					}
				}
			}
			addToCart(name, price);
		}
	}
	
	public static void addToCart(String name, int price)
	{
		System.out.println(name + price);
	}


	public static void main(String[] args) {
		WebDriver browser = initialize();
		WebDriverWait timeoutWait = new WebDriverWait(browser, Duration.ofSeconds(10));
		
		navigateTo(browser, Resources.testedWebSite);
		String temperature = obtainTemperature(browser, timeoutWait);

		//WebElement button = chooseButton(temperature, timeoutWait);
		try {
		chooseButton(temperature, timeoutWait).click();
		}
		catch(Exception e) {
			System.out.println("Temperature between 19 and 34 degrees. We don't recommend either of those");
		}
		
		//Add products to cart according to exercise request
		
		parsePage(browser);
		if (moisturizer == true)
		{
			determineChoice(browser, "Aloe");
			determineChoice(browser, "Almond");
		}
		if (sunscreen == true)
		{
			determineChoice(browser, "SPF-50");
			determineChoice(browser, "SPF-30");
		}

		browser.close();
		
	}
}
