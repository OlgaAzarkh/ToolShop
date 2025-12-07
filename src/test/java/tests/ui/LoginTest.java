package tests.ui;

import navigation.Navigator;
import base.DriverFactory;
import components.Header;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@Epic("UI test")
@Feature("Log in")
public class LoginTest extends DriverFactory {

    @Story("Open log in page via UI")
    @Test
    @DisplayName("Verify login page opens by clicking log in in the header")
    public void verifyLoginPageOpensViaUi() {
        new Navigator(driver).openHomePageByUrl();
        LoginPage loginPage = new Header(driver).openLoginPage();
        Assertions.assertTrue(loginPage.urlContains("login"));
    }


}
