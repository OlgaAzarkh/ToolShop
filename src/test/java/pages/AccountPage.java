package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }
        public final By MY_ACCOUNT = By.cssSelector("[data-test='page-title']");

    }

