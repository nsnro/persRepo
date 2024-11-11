package Resources;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resources {


    public static void main(String[] args) {

    }

    public WebDriver Initialize(String chromeDriverPath)
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

    public static List<WebElement> findElements(WebDriver browser, By locator)
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

    public static String getElementText(WebDriver browser, By locator)
    {
        WebElement webElem = browser.findElement(locator);
        if (webElem.isDisplayed())
        {
            return webElem.getText();
        }
        else
        {
            System.out.println("No element or text found");
            return null;
        }

    }

    public static boolean waitForElements(WebDriver browser, By... locArgs)
    {
        boolean passCondition = true;
        for (By loc : locArgs)
        {
            if (!waitForElement(browser, loc, 5))
            {
                return false;
            }
        }
        return passCondition;
    }

    public static boolean waitForElements(WebDriver browser, List<By> locArgs)
    {
        boolean passCondition = true;
        for (By loc : locArgs)
        {
            if (!waitForElement(browser, loc, 5))
            {
                return false;
            }
        }
        return passCondition;
    }


    public static boolean isPageLoaded(WebDriver browser)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) browser;
        return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
    }

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

    public static String userNameGen()
    {
        String prefix = "user";
        int randomNum = new Random().nextInt(10000);  // Generates a number between 0 and 9999
        return prefix + randomNum;
    }

    public static String testEmailGen()
    {
        String randomPart = UUID.randomUUID().toString().substring(0, 8);  // Generates a unique identifier
        String domain = "@example.com";
        return randomPart + domain;
    }

    public static void dropDownInteract(WebDriver browser, By locator, String valueToChoose)
    {
        try {
            Thread.sleep(500);  // Short delay between keystrokes to mimic human typing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement dropDownButton = Resources.findElement(browser, locator);
        Select selectMonth = new Select(dropDownButton);
        selectMonth.selectByValue(valueToChoose);
    }
}
