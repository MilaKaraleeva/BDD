package prgs.bdd;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Login {

    static WebDriver webDriver;
    static int wait=5;
    static String webUrl = "https://demo.automationtesting.in/SignIn.html";
    static String htmlField;
    static String textToWrite;
    static String elementText;

    @Before
    public static void initiate(){
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            webDriver = new ChromeDriver(chromeOptions);
        } catch (Exception e) {
            System.err.println("Error initializing WebDriver: " + e.getMessage());
        }

    }
    @AfterAll
    public static void tearDown(){
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }

    //Scenario 1
    @When("the user enters a valid email {string}")
    public void the_user_enters_a_valid_email(String validEmail) {
        textToWrite = validEmail;
        htmlField = "/html/body/div/div/div[2]/input";
        WebPageLoad webPageLoad=new WebPageLoad(webDriver,wait);
        String enteredText = webPageLoad.enterTextInField(webUrl, htmlField, textToWrite);
        assert enteredText.equals(validEmail) : "The entered text does not match the expected email!";

    }
    @And("the user enters a valid password {string}")
    public void the_user_enters_a_valid_password(String validPassword) {
        textToWrite = validPassword;
        htmlField = "/html/body/div/div/div[3]/input";
        WebPageLoad webPageLoad=new WebPageLoad(webDriver,wait);
        String enteredText = webPageLoad.enterTextInField(webUrl, htmlField, textToWrite);
        assert enteredText.equals(validPassword) : "The entered text does not match the expected password!";
    }
    @Then("the user is redirected to the homepage")
    public void the_user_is_redirected_to_the_homepage() {

    }


    //Scenario 2
    @When("the user enters an invalid password {string}")
    public void the_user_enters_an_invalid_password(String invalidPassword) {
        textToWrite = invalidPassword;
        htmlField = "/html/body/div/div/div[3]/input";
        WebPageLoad webPageLoad=new WebPageLoad(webDriver,wait);
        String enteredText = webPageLoad.enterTextInField(webUrl, htmlField, textToWrite);
        assert enteredText.equals(invalidPassword) : "The entered text does not match the expected invalid password!";
    }
    @And("the user enters an invalid email {string}")
    public void the_user_enters_an_invalid_email(String invalidEmail) {
        textToWrite = invalidEmail;
        htmlField = "/html/body/div/div/div[2]/input";
        WebPageLoad webPageLoad=new WebPageLoad(webDriver,wait);
        String enteredText = webPageLoad.enterTextInField(webUrl, htmlField, textToWrite);
        assert enteredText.equals(invalidEmail) : "The entered text does not match the expected invalid email!";
    }


    //Scenario 3

    @When("the user enters an empty email")
    public void the_user_enters_an_empty_email() {
        textToWrite = "";
        htmlField = "/html/body/div/div/div[2]/input";
        WebPageLoad webPageLoad=new WebPageLoad(webDriver,wait);
        String enteredText = webPageLoad.enterTextInField(webUrl, htmlField, textToWrite);
        assert enteredText.equals(textToWrite) : "The entered text does not match the empty email!";

    }
    @And("the user enters an empty password")
    public void the_user_enters_an_empty_password() {
        textToWrite = "";
        htmlField = "/html/body/div/div/div[3]/input";
        WebPageLoad webPageLoad=new WebPageLoad(webDriver,wait);
        String enteredText = webPageLoad.enterTextInField(webUrl, htmlField, textToWrite);
        assert enteredText.equals(textToWrite) : "The entered text does not match the empty password!";

    }

    // Steps for all Scenarios
    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        String buttonLocator = "/html/body/div/div/div[4]/a/img";
        WebPageLoad webPageLoad = new WebPageLoad(webDriver, wait);
        webPageLoad.clickButton(webUrl, buttonLocator);
    }

    // Messages
    @Then("an error message {string} is displayed")
    public void an_error_message_is_displayed(String errorMessage) {
        elementText = errorMessage;
        WebPageLoad webPageLoad=new WebPageLoad(webDriver,wait);
        String messageIsPopulated = webPageLoad.isErrorIsGenerated(webUrl);
        assert messageIsPopulated.equals(errorMessage);
    }
    @And("the welcome message {string} is displayed")
    public void the_welcome_message_is_displayed(String string) {

    }




}
