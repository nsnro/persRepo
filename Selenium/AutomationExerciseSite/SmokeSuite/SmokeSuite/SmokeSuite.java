package SmokeSuite;
import Resources.Resources;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SmokeSuite {

    public static class GeneralConfiguration {

        public static String webSite = "https://www.automationexercise.com/";
        public static String chromeDriverPath = "D:\\Learning\\Other\\chromedriver-win64\\chromedriver.exe";
    }

    public static class MainPage {

        public static By homeButton = By.cssSelector(".fa.fa-home");
        public static By productsButton = By.cssSelector(".material-icons.card_travel");
        public static By cartButton = By.cssSelector(".fa.fa-shopping-cart");
        public static By loginSignUp = By.cssSelector("a[href='/login'");
        public static By contactUs = By.cssSelector("a[href='/contact_us']");
        public static By testCases = By.cssSelector("a[href='/test_cases']");
    }

    public static class SignUpLogin {
        public static By loginForm = By.className("login-form");
        public static By loginEmail = By.cssSelector("input[data-qa='login-email']");
        public static By loginPassword = By.cssSelector("input[data-qa='login-password']");
        public static By loginButton = By.cssSelector("button[data-qa='login-button']");

        public static By incorrectLoginLocator = By.cssSelector("p[style='color: red;'");
        public static String incorrectLoginMessage = "Your email or password is incorrect!";

        public static By signUpForm = By.className("signup-form");
        public static By signUpName = By.cssSelector("input[data-qa='signup-name']");
        public static By signUpEmail = By.cssSelector("input[data-qa='signup-email']");
        public static By signUpButton = By.cssSelector("button[data-qa='signup-button']");

        public static By signUpErrorLocator = By.cssSelector("p[style='color: red;'");
        public static String signUpErrorMessage = "Email Address already exist!";

        public static By signUpFormMessageLocator = By.cssSelector("div.signup-form h2");
        public static By logInFormMessageLocator = By.cssSelector("div.login-form h2");

        public static String signUpFormMessage = "New User Signup!";
        public static String loginFormMessage = "Login to your account";
    }

    public static class AccountInfo {
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
    }
    public static class PostAccountCreation {

        public static By continueButton = By.cssSelector("a[data-qa='continue-button']");
        public static String accountCreationConfirmationMsg = "ACCOUNT CREATED!";
    }

    public static class MainPageLoggedIn {

        public static String genericLoggedInAsMsg = "Logged in as ";
        public static String accountDeletionConfirmationMsg = "ACCOUNT DELETED!";

        public static By loggedInAs = By.cssSelector("a:has(.fa-user)");
        public static By deleteAccount = By.cssSelector("a[href='/delete_account']");
        public static By logOut = By.cssSelector("a[href='/logout']");
        public static By continueButton = By.cssSelector("a[data-qa='continue-button']");
    }

    public static class ContactUs {
        public static By contactUsFormHeader = By.cssSelector("div.contact-form h2");
        public static String contactUsFormHeaderMessage = "GET IN TOUCH";

        public static By nameField = By.cssSelector("input[data-qa='name']");
        public static By emailField = By.cssSelector("input[data-qa='email']");
        public static By subjectField = By.cssSelector("input[data-qa='subject']");
        public static By messageBox = By.cssSelector("textarea[data-qa='message']");
        public static By uploadFileButton = By.cssSelector("input[name='upload_file']");
        public static By submitButton = By.cssSelector("input[data-qa='submit-button']");

        public static By confirmationMessageLocator = By.cssSelector("div.status.alert.alert-success");
        public static String confirmationMessage = "Success! Your details have been submitted successfully.";

        public static By homeButton = By.cssSelector("a.btn.btn-success");
    }

    public static class TestCases {
        public static By testCaseListHeader = By.cssSelector("h2.title.text-center");
        public static By testCaseListing = By.cssSelector("h4.panel-title a[data-toggle='collapse']");
        public static String testCaseHeader = "Test Cases";
    }

    public static class Products {
        public static By allProductsHeader = By.cssSelector("div.features_items h2");
        public static String allProductsText = "All Products";

        public static By genericProductsClass = By.cssSelector("div[class='single-products']");
        public static By viewProductButton = By.cssSelector("a[href='/product_details/1']");

        public static By productName = By.cssSelector("div.product-information h2");
        public static By productCategory = By.cssSelector("div.product-information p");
        public static By productPrice = By.cssSelector("div.product-information span>span");
        public static By productAvailability = By.xpath("//div[@class='product-information']//p[b[text()='Availability:']]");
        public static By productCondition = By.xpath("//div[@class='product-information']//p[b[text()='Condition:']]");
        public static By productBrand = By.xpath("//div[@class='product-information']//p[b[text()='Brand:']]");
    }

    public List<String> createUserAccount(WebDriver browser)
    {
        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser, GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");

        //Test Step 4: Locate & click Signup/Login button
        WebElement loginSignUpButtonVis = Resources.findElement(browser, MainPage.loginSignUp);
        if (loginSignUpButtonVis != null)
        {
            loginSignUpButtonVis.click();
        }

        //Test Step 5: Check website is fully loaded and forms are visible, incl. Signup form header message.
        locArgs.clear();
        Collections.addAll(locArgs, SignUpLogin.loginForm, SignUpLogin.signUpForm);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (Login/Signup Page)");

        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.signUpFormMessageLocator), SignUpLogin.signUpFormMessage), "Sign up header text did not load or changed.");

        //Test Step 6: Locate fields & enter name and e-mail address.
        List<String> userDetails = new ArrayList<>();
        WebElement nameField = Resources.findElement(browser, SignUpLogin.signUpName);
        WebElement emailField = Resources.findElement(browser, SignUpLogin.signUpEmail);

        String generatedUserName = Resources.userNameGen();
        String generatedEmail = Resources.testEmailGen();

        userDetails.add(generatedUserName);
        userDetails.add(generatedEmail);

        Resources.sendKeysOneByOne(nameField, generatedUserName);
        Resources.sendKeysOneByOne(emailField, generatedEmail);

        //Test Step 7: Locate & click sign-up button.
        WebElement signUpButton = Resources.findElement(browser, SignUpLogin.signUpButton);
        signUpButton.click();

        //Test Step 8: Check Account Information is visible and website is fully loaded.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("div.login-form b")).toLowerCase(), AccountInfo.accountInfoHeader.toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing header text for account info window or page failing to load.");

        //Test Step 9: Locate elements and fill details (Title, Name, Email, Password, Date of birth)
        WebElement chooseMr = Resources.findElement(browser, AccountInfo.chooseTitleMr);
        chooseMr.click();

        WebElement enterPassword = Resources.findElement(browser, AccountInfo.passwordField);
        Resources.sendKeysOneByOne(enterPassword, "testpassword");
        userDetails.add("testpassword");

        Resources.dropDownInteract(browser, AccountInfo.birthDay, "12");
        Resources.dropDownInteract(browser, AccountInfo.birthMonth, "1");
        Resources.dropDownInteract(browser, AccountInfo.birthYear, "1997");

        //Test Step 10 & 11: Locate Sign up for newsletter & Received offers checkbox and click them.
        WebElement newsletterBox = Resources.findElement(browser, AccountInfo.newsletterCheckBox);
        WebElement offerBox = Resources.findElement(browser, AccountInfo.offersCheckBox);

        newsletterBox.click();
        offerBox.click();

        //Test Step 12: Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.firstNameField), "Burns");
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.lastNameField), "Mr.");
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.companyNameField), "Springfield Nuclear Power Plant");
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.addressField), "Send out the dogs");
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.stateNameField), "Ohio");
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.cityNameField), "Springfield");
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.zipcodeField), "IDK");
        Resources.sendKeysOneByOne(Resources.findElement(browser, AccountInfo.mobileNumberField), "6666666666");
        Resources.dropDownInteract(browser, AccountInfo.countryDropDown, "United States");

        //Test Step 13: Locate & click the Create Account button.
        WebElement createAccount = Resources.findElement(browser, AccountInfo.createAccountButton);
        createAccount.click();

        //Test Step 14: Locate & check that the confirmation message is visible.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("h2[data-qa='account-created']")).toLowerCase(), PostAccountCreation.accountCreationConfirmationMsg.toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing header text at account creation confirmation screen or page failing to load.");

        //Test Step 15: Locate & click the 'Continue' button.
        WebElement accountContinueButton = Resources.findElement(browser, PostAccountCreation.continueButton);
        accountContinueButton.click();

        return userDetails;
    }

    @Test
    public void testCase_RegisterUser() {

        //Test Step 1: Launch Browser
        Resources res = new Resources();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2-15
        List<String> userDetails = createUserAccount(browser);

        //Test Step 16: Check that logged in as username is visible.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, MainPageLoggedIn.loggedInAs).toLowerCase(), (MainPageLoggedIn.genericLoggedInAsMsg + userDetails.get(0)).toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing/incorrect Logged In as username message or page failing to load.");

        //Test Step 17: Locate & click "Delete Account button
        WebElement accountDeleteButton = Resources.findElement(browser, MainPageLoggedIn.deleteAccount);
        accountDeleteButton.click();

        //Test Step 18: Check for confirmation that account deletion is done.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("h2[data-qa='account-deleted']")).toLowerCase(), MainPageLoggedIn.accountDeletionConfirmationMsg.toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing account deletion confirmation message or page failing to load.");

        //Test Step 19: Locate & click the 'Continue' button.
        WebElement deleteContinueButton = Resources.findElement(browser, MainPageLoggedIn.continueButton);
        deleteContinueButton.click();

        browser.close();
    }

    @Test
    public void testCase_CorrectLogin() {

        //Launch Browser
        Resources res = new Resources();

        WebDriver tempBrowser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Precondition
        List<String> userDetails = createUserAccount(tempBrowser);
        tempBrowser.close();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser,GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");


        //Test Step 4: Locate & click the Signup/Login button.
        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");
        WebElement loginButton = Resources.findElement(browser, MainPage.loginSignUp);
        loginButton.click();

        //Test Step 5: Check that forms loaded & "Login to your account" is visible.

        locArgs.clear();
        Collections.addAll(locArgs, SignUpLogin.loginForm, SignUpLogin.signUpForm);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (Login/Signup Page)");

        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.logInFormMessageLocator), SignUpLogin.loginFormMessage), "Log In header text did not load or changed.");

        //Test Step 6: Enter correct e-mail address & password and login.
        WebElement logInNameEl = Resources.findElement(browser, SignUpLogin.loginEmail);
        WebElement logInPasswordEl = Resources.findElement(browser, SignUpLogin.loginPassword);

        Resources.sendKeysOneByOne(logInNameEl, userDetails.get(1));
        Resources.sendKeysOneByOne(logInPasswordEl, userDetails.get(2));

        //Test Step 7: Click LogIn Button
        WebElement logInButton = Resources.findElement(browser, SignUpLogin.loginButton);
        logInButton.click();

        //Test Step 8: Check that logged in as username is visible.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, MainPageLoggedIn.loggedInAs).toLowerCase(), (MainPageLoggedIn.genericLoggedInAsMsg + userDetails.get(0)).toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing/incorrect Logged In as username message or page failing to load.");

        //Test Step 9: Locate & click "Delete Account" button
        WebElement accountDeleteButton = Resources.findElement(browser, MainPageLoggedIn.deleteAccount);
        accountDeleteButton.click();

        //Test Step 10: Check for confirmation that account deletion is done.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, By.cssSelector("h2[data-qa='account-deleted']")).toLowerCase(), MainPageLoggedIn.accountDeletionConfirmationMsg.toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing account deletion confirmation message or page failing to load.");

        //PostCondition: Locate & click the 'Continue' button.
        WebElement deleteContinueButton = Resources.findElement(browser, MainPageLoggedIn.continueButton);
        deleteContinueButton.click();

        browser.close();
    }

    @Test

    public void testCase_IncorrectLogin()
    {
        //Launch Browser
        Resources res = new Resources();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser,GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");


        //Test Step 4: Locate & click the Signup/Login button.
        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");
        WebElement loginButton = Resources.findElement(browser, MainPage.loginSignUp);
        loginButton.click();

        //Test Step 5: Check that forms loaded & "Login to your account" is visible.

        locArgs.clear();
        Collections.addAll(locArgs, SignUpLogin.loginForm, SignUpLogin.signUpForm);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (Login/Signup Page)");

        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.logInFormMessageLocator), SignUpLogin.loginFormMessage), "Log In header text did not load or changed.");

        //Test Step 6: Enter correct e-mail address & password and login.
        WebElement logInNameEl = Resources.findElement(browser, SignUpLogin.loginEmail);
        WebElement logInPasswordEl = Resources.findElement(browser, SignUpLogin.loginPassword);

        Resources.sendKeysOneByOne(logInNameEl, Resources.testEmailGen());
        Resources.sendKeysOneByOne(logInPasswordEl, "testpassword");

        //Test Step 7: Click LogIn Button
        WebElement logInButton = Resources.findElement(browser, SignUpLogin.loginButton);
        logInButton.click();

        //Test Step 8: Check for error
        if(Resources.waitForElement(browser, SignUpLogin.incorrectLoginLocator, 10))
        {
            Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.incorrectLoginLocator), SignUpLogin.incorrectLoginMessage), "Incorrect login message not shown or incorrect.");
        }

        browser.close();
    }

    @Test
    public void testCase_LogOut()
    {
        //Launch Browser
        Resources res = new Resources();

        WebDriver tempBrowser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Precondition
        List<String> userDetails = createUserAccount(tempBrowser);
        tempBrowser.close();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser,GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");


        //Test Step 4: Locate & click the Signup/Login button.
        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");
        WebElement loginButton = Resources.findElement(browser, MainPage.loginSignUp);
        loginButton.click();

        //Test Step 5: Check that forms loaded & "Login to your account" is visible.

        locArgs.clear();
        Collections.addAll(locArgs, SignUpLogin.loginForm, SignUpLogin.signUpForm);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (Login/Signup Page)");

        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.logInFormMessageLocator), SignUpLogin.loginFormMessage), "Log In header text did not load or changed.");

        //Test Step 6: Enter correct e-mail address & password and login.
        WebElement logInNameEl = Resources.findElement(browser, SignUpLogin.loginEmail);
        WebElement logInPasswordEl = Resources.findElement(browser, SignUpLogin.loginPassword);

        Resources.sendKeysOneByOne(logInNameEl, userDetails.get(1));
        Resources.sendKeysOneByOne(logInPasswordEl, userDetails.get(2));

        //Test Step 7: Click LogIn Button
        WebElement logInButton = Resources.findElement(browser, SignUpLogin.loginButton);
        logInButton.click();

        //Test Step 8: Check that logged in as username is visible.
        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, MainPageLoggedIn.loggedInAs).toLowerCase(), (MainPageLoggedIn.genericLoggedInAsMsg + userDetails.get(0)).toLowerCase()) && Resources.isPageLoaded(browser),
                "Test failed either due to missing/incorrect Logged In as username message or page failing to load.");

        //Test Step 9: Locate & click the "LogOut" button.
        WebElement logOutButton = Resources.findElement(browser, MainPageLoggedIn.logOut);
        logOutButton.click();

        //Test Step 10: Check that we the Login/Signup forms are shown
        locArgs.clear();
        Collections.addAll(locArgs, SignUpLogin.loginForm, SignUpLogin.signUpForm);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (Login/Signup Page)");

        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.logInFormMessageLocator), SignUpLogin.loginFormMessage), "Log In header text did not load or changed.");

        browser.close();
    }

    @Test
    public void testCase_CreateExistingAccount()
    {
        //Launch Browser
        Resources res = new Resources();

        WebDriver tempBrowser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Precondition
        List<String> userDetails = createUserAccount(tempBrowser);
        tempBrowser.close();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser,GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");

        //Test Step 4: Locate & click Signup/Login button
        WebElement loginSignUpButtonVis = Resources.findElement(browser, MainPage.loginSignUp);
        if (loginSignUpButtonVis != null)
        {
            loginSignUpButtonVis.click();
        }

        //Test Step 5: Check website is fully loaded and forms are visible, incl. Signup form header message.
        locArgs.clear();
        Collections.addAll(locArgs, SignUpLogin.loginForm, SignUpLogin.signUpForm);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (Login/Signup Page)");

        Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.signUpFormMessageLocator), SignUpLogin.signUpFormMessage), "Sign up header text did not load or changed.");

        //Test Step 6: Locate fields & enter name and e-mail address.
        WebElement nameField = Resources.findElement(browser, SignUpLogin.signUpName);
        WebElement emailField = Resources.findElement(browser, SignUpLogin.signUpEmail);

        Resources.sendKeysOneByOne(nameField, Resources.userNameGen());
        Resources.sendKeysOneByOne(emailField, userDetails.get(1));

        //Test Step 7: Locate & click sign-up button.
        WebElement signUpButton = Resources.findElement(browser, SignUpLogin.signUpButton);
        signUpButton.click();

        //Test Step 8: Check for error
        if(Resources.waitForElement(browser, SignUpLogin.signUpErrorLocator, 10))
        {
            Assert.assertTrue(Objects.equals(Resources.getElementText(browser, SignUpLogin.signUpErrorLocator), SignUpLogin.signUpErrorMessage), "Error for already existing account with e-mail not shown or missing.");
        }

        browser.close();
    }

    @Test
    public void testCase_ContactUsForm()
    {
        //Launch Browser
        Resources res = new Resources();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser, GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");

        //Test Step 4: Locate & click Contact Us form
        WebElement contactUsButton = Resources.findElement(browser, MainPage.contactUs);
        contactUsButton.click();

        //Test Step 5: Check Contact Us Form Header
        WebElement contactUsFormHeader = Resources.findElement(browser, ContactUs.contactUsFormHeader);
        if (contactUsFormHeader.isDisplayed()) {
            Assert.assertTrue(Objects.equals(Resources.getElementText(browser, ContactUs.contactUsFormHeader).toLowerCase(), (ContactUs.contactUsFormHeaderMessage).toLowerCase()) && Resources.isPageLoaded(browser),
                    "Test failed either due to contact us form header not loading or message is another than expected.");
        }

        //Test Step 6: Locate & enter Name, Email, Address, Subject and message.

        WebElement nameField = Resources.findElement(browser, ContactUs.nameField);
        WebElement emailField = Resources.findElement(browser, ContactUs.emailField);
        WebElement subjectField = Resources.findElement(browser, ContactUs.subjectField);
        WebElement textArea = Resources.findElement(browser, ContactUs.messageBox);

        Resources.sendKeysOneByOne(nameField, "SeleniumUser22");
        Resources.sendKeysOneByOne(emailField, "something@example.com");
        Resources.sendKeysOneByOne(subjectField, "This is a test of the Contact Us Form");
        Resources.sendKeysOneByOne(textArea, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.");

        //Test Step 7: Upload file.

        WebElement uploadFileButton = Resources.findElement(browser, ContactUs.uploadFileButton);
        uploadFileButton.sendKeys("D:\\Scripts\\TestFile.txt");

        //Test Step 8: Click submit button.
        WebElement submitButton = Resources.findElement(browser, ContactUs.submitButton);
        submitButton.click();

        //Test Step 9: Click OK on pop up box.
        Alert popUpBox = browser.switchTo().alert();

        popUpBox.accept();

        //Test Step 10: Verify success message.

        if (Resources.waitForElement(browser, ContactUs.confirmationMessageLocator, 10))
        {
            Assert.assertTrue(Objects.equals(Resources.getElementText(browser, ContactUs.confirmationMessageLocator).toLowerCase(), (ContactUs.confirmationMessage).toLowerCase()) && Resources.isPageLoaded(browser),
                    "Test failed either due to contact us form header not loading or message is another than expected.");
        }

        //Test Step 11: Verify Home Button is there and click it
        if (Resources.waitForElement(browser, ContactUs.homeButton, 10))
        {
            WebElement homeButton = Resources.findElement(browser, ContactUs.homeButton);
            homeButton.click();
        }

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");

        browser.close();
    }

    @Test
    public void testCase_TestCasePage()
    {
        //Launch Browser
        Resources res = new Resources();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser, GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");

        //Test Step 4: Locate & click Test Cases button
        WebElement testCasesButton = Resources.findElement(browser, MainPage.testCases);
        testCasesButton.click();

        //Test Step 5: Check page loaded correctly and test cases are visible.
        locArgs.clear();
        Collections.addAll(locArgs, TestCases.testCaseListHeader, TestCases.testCaseListing);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either website not fully loading or test header/test listings missing/incorrect");

        if (Resources.waitForElement(browser, TestCases.testCaseListHeader, 10))
        {
            Assert.assertTrue(Objects.equals(Resources.getElementText(browser, TestCases.testCaseListHeader).toLowerCase(), (TestCases.testCaseHeader).toLowerCase()) && Resources.isPageLoaded(browser),
                    "Test failed either due to test case header not loading or message is another than expected.");
        }

        browser.close();
    }

    @Test
    public void testCase_verifyAllProducts() {
        //Launch Browser
        Resources res = new Resources();

        WebDriver browser = res.Initialize(GeneralConfiguration.chromeDriverPath);

        //Test Step 2: Navigate to website https://www.automationexercise.com/
        Resources.navigateTo(browser, GeneralConfiguration.webSite);

        //Test Step 3: Check website is fully loaded and buttons are visible.
        List<By> locArgs = new ArrayList<>();
        Collections.addAll(locArgs, MainPage.homeButton, MainPage.productsButton, MainPage.cartButton, MainPage.contactUs, MainPage.testCases);

        Assert.assertTrue(Resources.waitForElements(browser, locArgs) && Resources.isPageLoaded(browser),
                "Test failed due to either relevant buttons or website not loading correctly (HomePage)");

        //Test Step 4: Locate & click Test Cases button
        WebElement productsButton = Resources.findElement(browser, MainPage.productsButton);
        productsButton.click();

        //Test Step 5: Check page has loaded & products are visible.
        Assert.assertTrue(Resources.isPageLoaded(browser), "Failed to load products page.");

        //Test Step 6: Products list is visible.
        List<WebElement> products = Resources.findElements(browser, Products.genericProductsClass);
        Assert.assertTrue(products.size() > 2, "Possibly not all products have loaded.");

        //Test Step 7: Locate & click the "View Product" button of the first product.
        WebElement firstElementViewProduct = Resources.findElement(browser, Products.viewProductButton);
        firstElementViewProduct.click();

        //Test Step 8: Check product details are visible
        List<By> productDetails = new ArrayList<>();
        Collections.addAll(productDetails, Products.productName, Products.productCategory, Products.productPrice, Products.productAvailability,
                Products.productCondition, Products.productBrand);

        Assert.assertTrue(Resources.waitForElements(browser, productDetails), "Failed to load all relevant products details");
    }
}
