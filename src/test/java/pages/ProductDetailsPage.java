package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By ADD_TO_CART_BUTTON = By.cssSelector("[data-test='add-to-cart']");
    private final By PRODUCT_TITLE = By.cssSelector("[data-test='product-name']");
    public final By PRODUCT_ADDED_TO_THE_CART_ALERT = By.cssSelector("[aria-label='Product added to shopping cart.']");
    private final By OUT_OF_STOCK = By.cssSelector("[data-test='out-of-stock']");

    public String getProductName() {
        return browser().getText(PRODUCT_TITLE).trim();
    }

    public boolean isProductTitleVisible() {
        return browser().isDisplayed(PRODUCT_TITLE);
    }

    public ProductDetailsPage clickAddToCartButton() {
        browser().click(ADD_TO_CART_BUTTON);
        return this;
    }

    public boolean isOutOfStock() {
        return browser().isDisplayed(OUT_OF_STOCK);
    }

    public boolean isAddToCardEnabled() {
        WebElement button = browser().find(ADD_TO_CART_BUTTON);
        return button.isEnabled();
    }

    public String getAlertText() {
        return browser().getText(PRODUCT_ADDED_TO_THE_CART_ALERT);
    }

    public boolean canAddToCart() {
        return isAddToCardEnabled() && !isOutOfStock();
    }

    public String getProductTitle() {
        return browser().getText(PRODUCT_TITLE).trim();
    }
}

