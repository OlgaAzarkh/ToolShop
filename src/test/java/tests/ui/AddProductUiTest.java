package tests.ui;

import Steps.ProductSteps;
import base.DriverFactory;
import org.junit.jupiter.api.*;

public class AddProductUiTest extends DriverFactory {

    private int amountAddedToTheCard = 1;
    private ProductSteps productSteps;

    @BeforeEach
    void initSteps() {
        productSteps = new ProductSteps(driver());
    }

    @Test
    @DisplayName("Verify user is able to select a random product and the product page opens")
    public void VerifyUserSelectsAndOpenRandomProductPage() {
        String productNameOnHome = productSteps.selectAndOpenRandomProduct();
        Assertions.assertTrue(productSteps.isOnProductPage(), "URL doesn't contain Product");
        Assertions.assertTrue(productSteps.isProductTitleVisible(), "Product title is not visible on details page");
        Assertions.assertEquals(productNameOnHome, productSteps.getSelectedProductName(), "Product name mismatch between list and details page");
    }

    @Test
    @DisplayName("Verify user is able to add an item to the cart and alert is displaying")
    public void VerifyUserIsAbleToAddAnItemToTheCart() {
        productSteps.selectAndOpenRandomProduct();
        productSteps.addProductToCart();
        Assertions.assertEquals(productSteps.getCartQuantity(), amountAddedToTheCard, "Amount in the card is not 1");
    }

    @Test
    @DisplayName("Verify items in the cart")
    public void verifyItemInTheCardMatch() {
        String productName = productSteps.selectAndOpenRandomProduct();
        productSteps.addProductToCart();
        productSteps.openTheCart();
        Assertions.assertEquals(productName, productSteps.getProductNameInCart(), "Product added doesn't match");
    }

    @Test
    @DisplayName("Verify a user that is not logged in must log in")
    public void verifyUserMustLoginToCheckOut() {
        productSteps.selectAndOpenRandomProduct();
        productSteps.addProductToCart();
        productSteps.openTheCart();
        productSteps.proceedToTheFirstCheckOutStep();
        Assertions.assertTrue(productSteps.isLoginPagePresent());
    }
}