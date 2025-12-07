package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By PRODUCT_TITLE = By.cssSelector("[data-test='product-title']");
    private final By PROCEED_BUTTON = By.cssSelector("[data-test='proceed-1']");

    public CheckoutPage clickProceedButton() {
        browser().click(PROCEED_BUTTON);
        return new CheckoutPage(driver);
    }

    public String getProductTitle() {
        return browser().getText(PRODUCT_TITLE);
    }

    public CheckoutPage proceedToCheckOut() {
        browser().click(PROCEED_BUTTON);
        return new CheckoutPage(driver);
    }

}
