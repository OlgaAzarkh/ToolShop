package pages;

import dto.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By registerLink = By.cssSelector("[data-test='register-link']");
    private final By loginButton = By.cssSelector("[data-test='login-submit']");
    private final By emailInput = By.cssSelector("[data-test='email']");
    private final By passwordInput = By.cssSelector("[data-test='password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage openSignUpPage() {
        browser().click(registerLink);
        return new SignUpPage(driver);
    }

    public HomePage clickLoginButton() {
        browser().click(loginButton);
        return new HomePage(driver);
    }

    public AccountPage login(User user) {
        browser().type(user.getEmail(), emailInput);
        browser().type(user.getPassword(), passwordInput);
        browser().click(loginButton);
        return new AccountPage(driver);
    }
}
