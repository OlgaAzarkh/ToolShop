package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import wrappers.Browser;

public class Header {

    protected WebDriver driver;
    private final By loginLink = By.xpath("//a[text()='Sign in']");
    //private final By registerLink = By.xpath("//a[text()='Register']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage () {
        new Browser(driver, loginLink).click();
        return new LoginPage(driver);
    }

//    public SignUpPage openSignUpPage() {
//        new Browser(driver, registerLink);
//        return new SignUpPage();
//    }
}
