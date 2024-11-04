package Resources;

import org.openqa.selenium.WebElement;

public class Resources {
	public static String chromeDriverPath = "D:\\Learning\\Selenium\\chromedriver-win64\\chromedriver.exe";
	public static String testedWebSite = "https://weathershopper.pythonanywhere.com/";
	
	public static String testEmail = "testEmail@gmail.com";
	public static String testCard = "4242424242424242";
	public static String testCVC = "111";
	public static String cardDate = "0428";
	public static String zipCode = "301010";
	
	public static void sendKeysOneByOne(WebElement element, String input)
	{
	    for (char character : input.toCharArray()) {
	        element.sendKeys(String.valueOf(character));
	        try {
	            Thread.sleep(100);  // Short delay between keystrokes to mimic human typing
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
