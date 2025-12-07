package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public final By PRODUCT_TITLE = By.cssSelector("[data-test='product-name']");

    public String getProductNameByIndex(int index) {
        List<WebElement> products = browser().getAllElements(PRODUCT_TITLE);
        return products.get(index).getText().trim(); //piterPan
    } //text by index

    public ProductDetailsPage openProductByIndex(int index) {
        List<WebElement> products = browser().getAllElements(PRODUCT_TITLE);
        products.get(index).click();
        return new ProductDetailsPage(driver);
    } // opened by text(index)

    public By productByText(String text) {
        return By.xpath
                ("//h5[@data-test='product-name' and normalize-space(text())='"+ text + "']/ancestor::a[contains(@class,'card')]");
    }

    public int getProductsCount() {
        return browser().getAllElements(PRODUCT_TITLE).size();
    }
}


