package pages;
import dto.CountryCode;
import dto.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Browser;

import java.time.LocalDate;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By REGISTER_FORM = By.cssSelector("[data-test='register-form']");
    private final By FIRST_NAME_INPUT = By.cssSelector("[data-test='first-name']");
    private final By LAST_NAME_INPUT = By.cssSelector("[data-test='last-name']");
    private final By DATE_OF_BIRTH_INPUT = By.cssSelector("[data-test='dob']");
    private final By STREET_INPUT = By.cssSelector("[data-test='street']");
    private final By POSTAL_CODE_INPUT = By.cssSelector("[data-test='postal_code']");
    private final By CITY_INPUT = By.cssSelector("[data-test='city']");
    private final By STATE_INPUT = By.cssSelector("[data-test='state']");
    private final By COUNTRY_DROPDOWN = By.cssSelector("[data-test='country']");
    private final By PHONE_INPUT = By.cssSelector("[data-test='phone']");
    private final By EMAIL_INPUT = By.cssSelector("[data-test='email']");
    private final By PASSWORD_INPUT = By.cssSelector("[data-test='password']");
    private final By REGISTER_BUTTON = By.cssSelector("[data-test='register-submit']");
    public final By firstNameIsRequiredAlert = By.cssSelector("[data-test='first-name-error']");

    @Step("Check registration form is visible")
    public boolean isRegisterFormVisible() {
        return browser().isDisplayed(REGISTER_FORM);
    }

    @Step("Fill in First name: {firstName}")
    public SignUpPage fillInFirstName(String firstName) {
        browser().type(firstName, FIRST_NAME_INPUT);
        return this;
    }

    @Step("Fill in Last name: {lastName}")
    public SignUpPage fillInLastName(String lastName) {
        browser().type(lastName, LAST_NAME_INPUT);
        return this;
    }

    @Step("Fill in DOB: {dateOfBirth}")
    public SignUpPage fillInDateOfBirth(LocalDate dateOfBirth) {
        browser().type(String.valueOf(dateOfBirth), DATE_OF_BIRTH_INPUT);
        return this;
    }

    @Step("Fill in Street: {street}")
    public SignUpPage fillInStreet(String street) {
        browser().type(street, STREET_INPUT);
        return this;
    }

    @Step("Fill in Postal Code: {postalCode}")
    public SignUpPage fillInPostalCode(String postalCode) {
        browser().type(postalCode, POSTAL_CODE_INPUT);
        return this;
    }

    @Step("Fill in City: {city}")
    public SignUpPage fillInCity(String city) {
        browser().type(city, CITY_INPUT);
        return this;
    }

    @Step("Fill in State: {state}")
    public SignUpPage fillInState(String state) {
        browser().type(state, STATE_INPUT);
        return this;
    }

    @Step("Select Country: {country}")
    public SignUpPage selectCountry(CountryCode country) {
        browser().selectByValue(COUNTRY_DROPDOWN, country.name());
        return this;
    }

    @Step("Fill in Phone: {phone}")
    public SignUpPage fillInPhone(String phone) {
        browser().type(phone, PHONE_INPUT);
        return this;
    }

    @Step("Fill in Email address: {email}")
    public SignUpPage fillInEmail(String email) {
        browser().type(email, EMAIL_INPUT);
        return this;
    }

    @Step("Fill in Password: {password}")
    public SignUpPage fillInPassword(String password) {
        browser().type(password, PASSWORD_INPUT);
        return this;
    }

    @Step("Click Register button")
    public LoginPage clickRegisterButton() {
        browser().click(REGISTER_BUTTON);
        return new LoginPage(driver);
    }


    @Step("Fill in registration form and click register")
    public LoginPage fillInUserForm(User user) {
        fillInFirstName(user.getFirstName());
        fillInLastName(user.getLastName());
        fillInDateOfBirth(user.getDateOfBirth());
        fillInStreet(user.getStreet());
        fillInPostalCode(user.getPostalCode());
        fillInCity(user.getCity());
        fillInState(user.getState());
        selectCountry(user.getCountry());
        fillInPhone(user.getPhone());
        fillInEmail(user.getEmail());
        fillInPassword(user.getPassword());
        browser().click(REGISTER_BUTTON);
        return new LoginPage(driver);
    }
}
