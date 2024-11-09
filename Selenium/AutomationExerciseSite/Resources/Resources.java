package SuiteResources;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resources {
    public static String webSite = "https://www.automationexercise.com/";
    public static String chromeDriverPath = "D:\\Learning\\Selenium\\chromedriver-win64\\chromedriver.exe";

    //Generic locators within the web site to test
    public static By homeButtonLocator = By.cssSelector(".fa.fa-home");
    public static By productsButtonLocator = By.cssSelector(".material-icons.card_travel");
    public static By cartButtonLocator = By.cssSelector("fa.fa-shopping-cart");

    public static void main(String[] args) {

    }

    public static WebDriver Initialize()
    {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        WebDriver browser = new ChromeDriver();

        return browser;
    }

    public static void navigateTo(WebDriver browser, String path)
    {
        browser.navigate().to(path);
    }

    public static boolean waitForElement(WebDriver browser, By locator, int timeoutTimer)
    {
        WebDriverWait timeoutWait = new WebDriverWait(browser, Duration.ofSeconds(timeoutTimer));
        WebElement webElem = timeoutWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (webElem.isDisplayed())
        {
            return true;
        }
        else
        {
            System.out.println("Error in WaitForElement");
            return false;
        }
    }

    public static WebElement findElement(WebDriver browser, By locator)
    {
        WebElement webElem = browser.findElement(locator);
        if (webElem.isDisplayed())
        {
            return webElem;
        }
        else
        {
            return null;
        }
    }

    public static List<WebElement> findElements(WebDriver browser, By locator, String element)
    {
        List<WebElement> webElem = browser.findElements(locator);
        if (webElem.size() > 0)
        {
            return webElem;
        }
        else
        {
            return null;
        }
    }

}
