package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By locator;

    public Browser(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement find() {
        return driver.findElement(locator);
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        find().click();
    }

    public void type (String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        find().clear();
        find().sendKeys(text);
    }

    public String getText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return find().getText();
    }

    public boolean isDisplayed() {
        try {
            return find().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
