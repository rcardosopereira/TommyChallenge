package nl.com.tommy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private LoginPage loginPage;

    private By acceptCookies = By.xpath("//button[@data-testid='Button-primary']");
    private By closeCountrySwitchPopup = By.xpath("//button[@data-testid='Button-close']");
    private By signInButton = By.xpath("//button[@data-testid='sign-in-button']");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickAcceptCookies() {
        driver.findElement(acceptCookies).click();
    }

    public void clickCloseCountrySwitchPopup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated((closeCountrySwitchPopup)));
        driver.findElement(closeCountrySwitchPopup).click();
    }

    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        loginPage = new LoginPage(driver);
        return loginPage;
    }

}
