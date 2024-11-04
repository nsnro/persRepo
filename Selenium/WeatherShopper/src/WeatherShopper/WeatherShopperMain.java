package WeatherShopper;
import Resources.Resources;
import WeatherShopper.Moisturizers;
import WeatherShopper.Sunscreen;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	public static Products determineChoice(WebDriver browser, String keyword)
	{
		if (moisturizer == true)
		{
			Moisturizers finalChoice = new Moisturizers("",9999);
			for (Moisturizers moisturizer : Moisturizers.objects)
			{
				if (moisturizer.name.contains(keyword))
				{
					if (moisturizer.price < finalChoice.price)
					{
						finalChoice.name = moisturizer.name;
						finalChoice.price = moisturizer.price;
					}
				}
			}
			addToCart(browser, finalChoice.name, finalChoice.price);
			return finalChoice;
		}
		if (sunscreen == true)
		{
			Sunscreen finalChoice = new Sunscreen("",9999);
			for (Sunscreen sunscreen : Sunscreen.objects)
			{
					if (sunscreen.name.contains(keyword))
					{
						if (sunscreen.price < finalChoice.price)
						{
							finalChoice.name = sunscreen.name;
							finalChoice.price = sunscreen.price;
						}
					}
				}
			addToCart(browser, finalChoice.name, finalChoice.price);
			return finalChoice;
		}
		return null;
	}
	
	public static void addToCart(WebDriver browser, String name, int price)
	{
		WebElement addToCartButton = browser.findElement(By.xpath("//*[@onclick=\"addToCart('" + name + "'," + price + ")\"]"));
		
		addToCartButton.click();
		
	}
	
	public static boolean checkCart(WebDriver browser, List<Products> objectList)
	{
		WebElement cartButton = browser.findElement(By.cssSelector(".thin-text.nav-link"));
		cartButton.click();
		
		WebElement table = browser.findElement(By.cssSelector(".table.table-striped"));
		
		List<WebElement> tableElements = table.findElements(By.xpath("//tbody/tr"));

		Set<WebElement> finalSet = new HashSet<>(tableElements);
		
		objectList.removeIf(prod -> {
		for (WebElement el : finalSet)
		{
			//List<WebElement> finalTable = el.findElements(By.tagName("td"));
			if (el.getText().contains(prod.name) && el.getText().contains(String.valueOf(prod.price)))
			{
				return true;
			}
		}
		return false;
		});
		if (objectList.size() == 0)
		{
			System.out.println("Massive success!");
			return true;
		}
		else
		{
			System.out.println("You are a disgrace...");
			return false;
		}
	}
	
	public static boolean finishOrder(WebDriver browser, WebDriverWait timeoutWait)
	{
		WebElement payButton = browser.findElement(By.className("stripe-button-el"));
		payButton.click();
		
		browser.switchTo().frame("stripe_checkout_app");
		
		WebElement emailAddress = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		if (emailAddress.isDisplayed())
		{
			Resources.sendKeysOneByOne(emailAddress, Resources.testEmail);
		}

		WebElement cardNumber = browser.findElement(By.id("card_number"));
		Resources.sendKeysOneByOne(cardNumber, Resources.testCard);
		
		WebElement expDate = browser.findElement(By.id("cc-exp"));
		Resources.sendKeysOneByOne(expDate, Resources.cardDate);
		
		WebElement cvcNumber = browser.findElement(By.id("cc-csc"));
		Resources.sendKeysOneByOne(cvcNumber, Resources.testCVC);
		
		WebElement zipCode = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billing-zip")));
		if (zipCode.isDisplayed())
		{
			Resources.sendKeysOneByOne(zipCode, Resources.zipCode);
		}

		WebElement finalPayButton = browser.findElement(By.cssSelector(".button.submit"));
		finalPayButton.click();
		return true;
		
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
			List<Products> products = new ArrayList<>();
			products.add(determineChoice(browser, "Aloe"));
			products.add(determineChoice(browser, "Almond"));
			if (checkCart(browser, products))
			{
				finishOrder(browser, timeoutWait);
			}
			
		}
		if (sunscreen == true)
		{
			List<Products> products = new ArrayList<>();
			products.add(determineChoice(browser, "SPF-50"));
			products.add(determineChoice(browser, "SPF-30"));
			if (checkCart(browser, products))
			{
				finishOrder(browser, timeoutWait);
			}
		}

		//browser.close();
		
	}
}
