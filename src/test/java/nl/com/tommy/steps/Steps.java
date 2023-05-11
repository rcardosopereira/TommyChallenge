package nl.com.tommy.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.com.tommy.pages.HomePage;
import nl.com.tommy.pages.LoggedPage;
import nl.com.tommy.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Steps  {

    private HomePage homePage;
    private LoginPage loginPage;
    private LoggedPage loggedPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-blink-features");
            options.addArguments("--disable-blink-features=AutomationControlled");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public HomePage navigateTo() {
        driver.get("https://nl.tommy.com/");
        homePage = new HomePage(driver);
        return homePage;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        homePage = navigateTo();
        homePage.clickAcceptCookies();
        homePage.clickCloseCountrySwitchPopup();
        loginPage = homePage.clickSignInButton();
    }

    @When("the user enters the email {string}")
    public void the_user_enters_the_email(String email) {
        loginPage.fillInEmail(email);
    }

    @And("the user enters the password {string}")
    public void the_user_enters_the_password(String password) {
        loginPage.fillInPassword(password);
    }

    @And("click in the login button")
    public void click_in_the_login_button() {
        loggedPage = loginPage.clickLoginSubmitButton();
    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() throws InterruptedException {
       Assertions.assertTrue(loggedPage.isAccountHeader());
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() throws InterruptedException {
        Assertions.assertTrue(loginPage.isFailedLoginMessageShown());
    }
}
