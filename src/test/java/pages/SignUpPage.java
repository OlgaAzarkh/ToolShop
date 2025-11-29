package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Browser;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By REGISTER_FORM = By.cssSelector("[data-test='register-form']");

    public boolean isRegisterFormVisible() {
        return new Browser(driver, REGISTER_FORM).isDisplayed();
    }
}
