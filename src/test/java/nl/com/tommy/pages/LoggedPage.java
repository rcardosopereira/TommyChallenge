package nl.com.tommy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedPage {

    private WebDriver driver;
    private By accountHeader = By.xpath("//div[@data-testid='HeaderMyAccount']");

    public LoggedPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isAccountHeader() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(accountHeader));
        return element != null;
    }

}
