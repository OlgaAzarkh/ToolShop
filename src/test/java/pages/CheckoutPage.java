package pages;

import dto.PaymentMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By LOGIN_FORM = By.id("signin-tab");
    private final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("[data-test='proceed-2'");
    private final By PROCEED_TO_THE_THIRD_STEP_BUTTON = By.cssSelector("[data-test='proceed-3'");
    private final By PAYMENT_METHOD_DROPDOWN = By.cssSelector("[data-test='payment-method']");
    private final By CONFIRM_BUTTON = By.cssSelector("[data-test='finish']");
    private final By PAYMENT_SUCCESSFUL_MESSAGE = By.cssSelector("[data-test='payment-success-message']");
    private final By THANKS_FOR_ORDER_MESSAGE = By.cssSelector("[data-test='order-confirmation']");

    public boolean isLoginPagePresent() {
        return browser().isDisplayed(LOGIN_FORM);
    }

    public CheckoutPage proceedToTheNextStep() {
        browser().click(PROCEED_TO_CHECKOUT_BUTTON);
        return this;
    }

    public CheckoutPage proceedToTheThirdStep() {
        browser().click(PROCEED_TO_THE_THIRD_STEP_BUTTON);
        return this;
    }

    public CheckoutPage selectPaymentMethod(PaymentMethod paymentMethod) {
        browser().selectByValue(PAYMENT_METHOD_DROPDOWN, paymentMethod.getValue());
        return this;
    }

    public CheckoutPage clickConfirm() {
        browser().click(CONFIRM_BUTTON);
        return this;
    }

    public CheckoutPage verifySuccessfulMessageIsPresent() {
        browser().isDisplayed(PAYMENT_SUCCESSFUL_MESSAGE);
        return this;
    }

    public CheckoutPage verifyOrderConfirmationIsPresent() {
        browser().isDisplayed(THANKS_FOR_ORDER_MESSAGE);
        return this;
    }

}
