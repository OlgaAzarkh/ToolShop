package navigation;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class Navigator {
    private final WebDriver driver;
    public Navigator(WebDriver driver) {
        this.driver = driver;
    }

    private static final String BASE_URL = "https://practicesoftwaretesting.com";
    private static final String LOGIN_URL = "https://practicesoftwaretesting.com/auth/login";
    private static final String SIGNUP_URL = "https://practicesoftwaretesting.com/auth/register";


    public HomePage openHomePageByUrl() {
        driver.get(BASE_URL);
        return new HomePage(driver);
    }

    public LoginPage openLogInPageViaUrl() {
        driver.get(LOGIN_URL);
        return new LoginPage(driver);
    }

    public SignUpPage openSignUpPageViaUrl() {
        driver.get(SIGNUP_URL);
        return new SignUpPage(driver);
    }
}
