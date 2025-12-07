package tests.ui;

import dto.User;
import navigation.Navigator;
import base.DriverFactory;
import components.Header;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.AccountPage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.UserGenerator;
import wrappers.Browser;


@Epic("UI test")
@Feature("Registration")
public class SignUpTest extends DriverFactory {

    @Story("Open sign up page via UI")
    @Test
    public void verifySignUpPageOpensViaUi() {
        SignUpPage signUpPage = new Header(driver).openLoginPage().openSignUpPage();
        Assertions.assertTrue(signUpPage.urlContains("register"));
        Assertions.assertTrue(signUpPage.isRegisterFormVisible());
    }

    @Story("Open sign up page via URL")
    @Test
    public void verifySignUpPageOpensViaUrl() {
        SignUpPage signUpPage = new Navigator(driver).openSignUpPageViaUrl();
        Assertions.assertTrue(signUpPage.urlContains("register"));
        Assertions.assertTrue(signUpPage.isRegisterFormVisible());
    }

    @Story("User Registration")
    @Test
    public void verifyUserRegisteredSuccessfully() {
        SignUpPage signUpPage = new Header(driver).openLoginPage().openSignUpPage();
        Assertions.assertTrue(signUpPage.urlContains("register"));
        Assertions.assertTrue(signUpPage.isRegisterFormVisible());

        User user = UserGenerator.generateUser();

        LoginPage loginPage = signUpPage.fillInUserForm(user);

        Assertions.assertTrue(loginPage.urlContains("login"));
    }

    @Test
    public void verifyUserIsAbleToLoginAfterRegistration() {
        SignUpPage signUpPage = new Header(driver).openLoginPage().openSignUpPage();
        User user = UserGenerator.generateUser();
        LoginPage loginPage = signUpPage.fillInUserForm(user);
        Assertions.assertTrue(loginPage.urlContains("login"));

        loginPage.login(user);

        AccountPage accountPage = new AccountPage(driver);
        Browser browser = new Browser(driver);
        Assertions.assertTrue(browser.isDisplayed(accountPage.MY_ACCOUNT));
    }

    @Story("Negative test")
    @Test
    @DisplayName("Verify user unable to register without First Name")
    public void verifyUserUnableToRegisterWithoutFirstName() {
        SignUpPage signUpPage = new Header(driver).openLoginPage().openSignUpPage();
        User user = UserGenerator.generateUser();
        signUpPage.fillInLastName(user.getLastName())
                .fillInDateOfBirth(user.getDateOfBirth())
                .fillInStreet(user.getStreet())
                .fillInPostalCode(user.getPostalCode())
                .fillInCity(user.getCity())
                .fillInState(user.getState())
                .selectCountry(user.getCountry())
                .fillInPhone(user.getPhone())
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickRegisterButton();

        Browser browser = new Browser(driver);
        Assertions.assertTrue(browser.isDisplayed(signUpPage.firstNameIsRequiredAlert));
    }
    }

