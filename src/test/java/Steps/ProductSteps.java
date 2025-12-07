package Steps;

import components.Header;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductDetailsPage;

import java.util.Random;

public class ProductSteps {

    private final Header header;
    private final HomePage homePage;
    private final ProductDetailsPage productDetailsPage;
    private final CheckoutPage checkoutPage;
    private final CartPage cartPage;

    public ProductSteps(WebDriver driver) {
        this.header = new Header(driver);
        this.homePage = new HomePage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
        this.cartPage = new CartPage(driver);
    }

    /**
     * Select a random product from the Home Page and open its details page
     *
     * @return name of the selected product
     */
    public String selectAndOpenRandomProduct() {
        int count = homePage.getProductsCount();
        int indexOfProduct = new Random().nextInt(count);
        String productNameOnHome = homePage.getProductNameByIndex(indexOfProduct);
        homePage.openProductByIndex(indexOfProduct);
        return productNameOnHome;
    }

    public void addProductToCart() {
        if (!productDetailsPage.canAddToCart()) {
            System.out.println("Product is OUT OF STOCK — skipping test logic");
            return;
        }

        productDetailsPage.clickAddToCartButton();

        String alertText = productDetailsPage.getAlertText();
        Assertions.assertEquals("Product added to shopping cart.", alertText,
                "Alert text mismatch after adding product to cart");
    }

    public void openTheCart() {
        header.clickCartButton();
    }

    public int getCartQuantity() {
        return header.getCartQuantity();
    }

    public boolean isProductTitleVisible() {
        return productDetailsPage.isProductTitleVisible();
    }

    public boolean isLoginPagePresent() {
        return checkoutPage.isLoginPagePresent();
    }

    public boolean isOnProductPage() {
        return productDetailsPage.urlContains("product");
    }

    public String getProductNameInCart() {
        return cartPage.getProductTitle();
    }

    public String getSelectedProductName() {
        return productDetailsPage.getProductTitle();
    }

    public void proceedToTheFirstCheckOutStep() {
        cartPage.proceedToCheckOut();
    }
}

