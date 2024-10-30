package introductionPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestProject {
	
	public static void login(WebElement loginButton, WebDriverWait timeoutWait)
	{
		loginButton.click();
		
		WebElement userNameField = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
		WebElement passwordField = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password")));

		if (userNameField.isDisplayed() && passwordField.isDisplayed())
		{
			userNameField.click();
			userNameField.sendKeys("");
			
			passwordField.click();
			passwordField.sendKeys("");
		}
		
		//WebElement finalizeLoginButton = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]/auth-flow-modal/div[2]/faceplate-tracker/button")));
		//WebElement finalizeLoginButton = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[rpl=''].login")));
		
		passwordField.sendKeys(Keys.RETURN);
	}
	
	public static void invalidLogin(WebElement loginButton, WebDriverWait timeoutWait)
	{
		
	}
	
	public static void logout(WebDriverWait timeoutWait)
	{
		
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\Selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver browser = new ChromeDriver();
		WebDriverWait timeoutWait = new WebDriverWait(browser, Duration.ofSeconds(10));
		
		browser.get("https://old.reddit.com");
		
		try {
			WebElement loginButton = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-required.login-link")));
			if (loginButton.isDisplayed()) {
				login(loginButton, timeoutWait);
			}
			else
			{
				System.out.println("No login button found on page");
			}
		}
		catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(e.getMessage());
		}
		
		browser.close();
		}
}
