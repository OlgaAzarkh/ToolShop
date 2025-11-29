package tests.ui;

import Navigation.Navigator;
import base.DriverFactory;
import components.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTest extends DriverFactory {

    @Test
    public void verifyLoginPageOpens() {
        new Navigator(driver).openHomePageByUrl();
        LoginPage loginPage = new Header(driver).openLoginPage();
        Assertions.assertTrue(loginPage.urlContains("login"));
    }
}
