package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.Browser;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean urlContains(String text) {
        try {
            wait.until(ExpectedConditions.urlContains(text));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    protected Browser browser() {
        return new Browser(driver);
    }
}
