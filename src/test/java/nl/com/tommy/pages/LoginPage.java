package nl.com.tommy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private LoggedPage loggedPage;

    private By emailInput = By.id("signin-email");
    private By passwordInput = By.id("signin-password");
    private By loginSubmitButton = By.xpath("//button[@data-testid='Button-primary']");
    private By failedLoginMessage = By.xpath("//p[text()='Je gebruikersnaam en wachtwoord matchen niet. Probeer het nog eens.']");

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public void fillInEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillInPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public LoggedPage clickLoginSubmitButton() {
        driver.findElement(loginSubmitButton).click();
        loggedPage = new LoggedPage(driver);
        return loggedPage;
    }

    public boolean isFailedLoginMessageShown() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(failedLoginMessage));
        return element != null;
    }

}