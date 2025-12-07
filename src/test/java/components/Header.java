package components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import wrappers.Browser;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    public final By LOGIN_LINK = By.cssSelector("[data-test='nav-sign-in']");
    public final By OPEN_CART_BUTTON = By.cssSelector("[data-test='nav-cart']");
    public final By CARD_QUANTITY = By.cssSelector("[data-test='cart-quantity']");
    public final By HOME_BUTTON = By.cssSelector("[data-test='nav-home']");

    @Step("Open login page")
    public LoginPage openLoginPage () {
        new Browser(driver).click(LOGIN_LINK);
        return new LoginPage(driver);
    }

    public CartPage clickCartButton() {
        browser().click(OPEN_CART_BUTTON);
        return new CartPage(driver);
    }

    public HomePage openHomePage() {
        waitUntilLoggedInAndAlertClosure(LOGIN_LINK);
        browser().click(HOME_BUTTON);
        return new HomePage(driver);
    }

    public int getCartQuantity() {
        return Integer.parseInt(browser().getText(CARD_QUANTITY));
    }

    public boolean waitUntilLoggedInAndAlertClosure(By locator) {
        try {
            return browser().waitForInvisibility(locator, 10);
        } catch (Exception e) {
            return false;

        }
    }

    public boolean isButtonPresent(By locator) {
        waitUntilLoggedInAndAlertClosure(OPEN_CART_BUTTON);
        return browser().isDisplayed(locator);
    }

}
