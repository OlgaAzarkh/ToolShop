package tests.ui;

import Navigation.Navigator;
import base.DriverFactory;
import components.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SignUpPage;

public class SignUpTest extends DriverFactory {

    @Test
    public void verifySignUpPageOpensViaUi() {
        driver.get("https://practicesoftwaretesting.com");
        SignUpPage signUpPage = new Header(driver).openLoginPage().openSignUpPage();
        Assertions.assertTrue(signUpPage.urlContains("register"));
        Assertions.assertTrue(signUpPage.isRegisterFormVisible());
    }

    @Test
    public void verifySignUpPageOpensViaUrl() {
        SignUpPage signUpPage = new Navigator(driver).openSignUpPageViaUrl();
        Assertions.assertTrue(signUpPage.urlContains("register"));
        Assertions.assertTrue(signUpPage.isRegisterFormVisible());
    }
}
