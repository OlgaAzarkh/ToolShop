package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Browser;

public class LoginPage extends BasePage {
    private final By registerLink = By.cssSelector("[data-test='register-link']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage openSignUpPage() {
        new Browser(driver, registerLink).click();
        return new SignUpPage(driver);
    }
}
