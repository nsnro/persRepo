package SmokeSuite;
import Resources.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SmokeSuite {
    public static String webSite = "https://www.automationexercise.com/";
    public static String chromeDriverPath = "D:\\Learning\\Other\\chromedriver-win64\\chromedriver.exe";

    //Generic locators within the web site to test
    //Main Page
    public static By homeButtonLocator = By.cssSelector(".fa.fa-home");
    public static By productsButtonLocator = By.cssSelector(".material-icons.card_travel");
    public static By cartButtonLocator = By.cssSelector(".fa.fa-shopping-cart");
    public static By loginSignUpButton = By.cssSelector("a[href='/login'");

    //SignUp/Login
    public static By loginForm = By.className("login-form");
    public static By signUpForm = By.className("signup-form");
    public static String signUpFormMessage = "New User Signup!";

    //Account Information
    public static String accountInfoHeader = "Enter Account Information";
    public static By chooseTitleMr = By.cssSelector("input[id='id_gender1']");
    public static By chooseTitleMrs = By.cssSelector("input[id='id_gender2']");
    public static By passwordField = By.cssSelector("input[id='password']");

    public static By birthDay = By.cssSelector("select[id='days']");
    public static By birthMonth = By.cssSelector("select[id='months']");
    public static By birthYear = By.cssSelector("select[id='years']");

    public static By newsletterCheckBox = By.cssSelector("input[id='newsletter']");
    public static By offersCheckBox = By.cssSelector("input[id='optin']");

    public static By firstNameField = By.cssSelector("input[id='first_name']");
    public static By lastNameField = By.cssSelector("input[id='last_name']");
    public static By companyNameField = By.cssSelector("input[id='company']");
    public static By addressField = By.cssSelector("input[id='address1']");
    public static By countryDropDown = By.cssSelector("select[id='country']");
    public static By stateNameField = By.cssSelector("input[id='state']");
    public static By cityNameField = By.cssSelector("input[id='city']");
    public static By zipcodeField = By.cssSelector("input[id='zipcode']");
    public static By mobileNumberField = By.cssSelector("input[id='mobile_number']");
    public static By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    //Post account creation

    public static By continueButton = By.cssSelector("a[data-qa='continue-button']");
    public static String accountCreationConfirmationMsg = "ACCOUNT CREATED!";

    //Post account creation Home page (visible only after being logged in)

    public static String genericLoggedInAsMsg = "Logged in as ";
    public static By loggedInAsButton = By.cssSelector("a:has(.fa-user)");
    public static By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    public static String accountDeletionConfirmationMsg = "ACCOUNT DELETED!";

    @Test
    public void testCase_RegisterUser() {

        //Test Step 1: Launch Browser
        Resources res = new Resources();

        WebDriver browser = res.Initialize(chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser, webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, homeButtonLocator, productsButtonLocator, cartButtonLocator);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
        "Test failed due to either relevant buttons or website not loading correctly (HomePage)");

        //Test Step 4: Locate & click Signup/Login button
        WebElement loginSignUpButtonVis = Resources.findElement(browser, loginSignUpButton);
        if (loginSignUpButtonVis != null)
        {
            loginSignUpButtonVis.click();
        }

        //Test Step 5: Check website is fully loaded and forms are visible, incl. Signup form header message.
        locArgs.clear();
        Collections.addAll(locArgs, loginForm, signUpForm);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (Login/Signup Page)");

        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("div.signup-form h2")), signUpFormMessage), "Sign up header text did not load or changed.");

        //Test Step 6: Locate fields & enter name and e-mail address.
        WebElement nameField = Resources.findElement(browser, By.cssSelector("input[data-qa='signup-name']"));
        WebElement emailField = Resources.findElement(browser, By.cssSelector("input[data-qa='signup-email']"));

        String generatedUserName = Resources.userNameGen();
        String generatedEmail = Resources.testEmailGen();

        Resources.sendKeysOneByOne(nameField, generatedUserName);
        Resources.sendKeysOneByOne(emailField, generatedEmail);

        //Test Step 7: Locate & click sign-up button.
        WebElement signUpButton = Resources.findElement(browser, By.cssSelector("button[data-qa='signup-button']"));
        signUpButton.click();

        //Test Step 8: Check Account Information is visible and website is fully loaded.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("div.login-form b")).toLowerCase(), accountInfoHeader.toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing header text for account info window or page failing to load.");

        //Test Step 9: Locate elements and fill details (Title, Name, Email, Password, Date of birth)
        WebElement chooseMr = Resources.findElement(browser, chooseTitleMr);
        chooseMr.click();

        WebElement enterPassword = Resources.findElement(browser, passwordField);
        Resources.sendKeysOneByOne(enterPassword, "testpassword");

        Resources.dropDownInteract(browser, birthDay, "12");
        Resources.dropDownInteract(browser, birthMonth, "1");
        Resources.dropDownInteract(browser, birthYear, "1997");

        //Test Step 10 & 11: Locate Sign up for newsletter & Received offers checkbox and click them.
        WebElement newsletterBox = Resources.findElement(browser, newsletterCheckBox);
        WebElement offerBox = Resources.findElement(browser, offersCheckBox);

        newsletterBox.click();
        offerBox.click();

        //Test Step 12: Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Resources.sendKeysOneByOne(Resources.findElement(browser, firstNameField), "Burns");
        Resources.sendKeysOneByOne(Resources.findElement(browser, lastNameField), "Mr.");
        Resources.sendKeysOneByOne(Resources.findElement(browser, companyNameField), "Springfield Nuclear Power Plant");
        Resources.sendKeysOneByOne(Resources.findElement(browser, addressField), "Send out the dogs");
        Resources.sendKeysOneByOne(Resources.findElement(browser, stateNameField), "Ohio");
        Resources.sendKeysOneByOne(Resources.findElement(browser, cityNameField), "Springfield");
        Resources.sendKeysOneByOne(Resources.findElement(browser, zipcodeField), "IDK");
        Resources.sendKeysOneByOne(Resources.findElement(browser, mobileNumberField), "6666666666");
        Resources.dropDownInteract(browser, countryDropDown, "United States");

        //Test Step 13: Locate & click the Create Account button.
        WebElement createAccount = Resources.findElement(browser, createAccountButton);
        createAccount.click();

        //Test Step 14: Locate & check that the confirmation message is visible.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("h2[data-qa='account-created']")).toLowerCase(), accountCreationConfirmationMsg.toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing header text at account creation confirmation screen or page failing to load.");

        //Test Step 15: Locate & click the 'Continue' button.
        WebElement accountContinueButton = Resources.findElement(browser, continueButton);
        accountContinueButton.click();

        //Test Step 16: Check that logged in as username is visible.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, loggedInAsButton).toLowerCase(), (genericLoggedInAsMsg + generatedUserName).toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing/incorrect Logged In as username message or page failing to load.");

        //Test Step 17: Locate & click "Delete Account button
        WebElement accountDeleteButton = Resources.findElement(browser, deleteAccountButton);
        accountDeleteButton.click();

        //Test Step 18: Check for confirmation that account deletion is done.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("h2[data-qa='account-deleted']")).toLowerCase(), accountDeletionConfirmationMsg.toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing account deletion confirmation message or page failing to load.");

        //Test Step 19: Locate & click the 'Continue' button.
        WebElement deleteContinueButton = Resources.findElement(browser, continueButton);
        deleteContinueButton.click();

        browser.close();
    }
}
