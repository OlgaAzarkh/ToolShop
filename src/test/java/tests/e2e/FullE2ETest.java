//package tests.e2e;
//
//import base.DriverFactory;
//import dto.PaymentMethod;
//import dto.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import pages.LoginPage;
//import tests.ui.AddProductUiTest;
//import utils.UserGenerator;
//
//public class FullE2ETest extends DriverFactory {
//    @Test
//    @DisplayName("Verify logged in user is able to select an item and buy it")
//    public void verifyLoggedInUserIsAbleToBuyAnItem() {
//
//        // Create and login new user
//        User user = UserGenerator.generateUser();
//        LoginPage loginPage = header().openLoginPage()
//                .openSignUpPage()
//                .fillInUserForm(user);
//
//        loginPage.login(user);
//
//        // Go to the home page
//        header().openHomePage();
//
//        // Select and add product
//        AddProductUiTest.selectAndOpenRandomProduct();
//        tryAddToCart(details());
//
//        // Checkout flow
//        checkout()
//                .proceedToTheNextStep()
//                .proceedToTheThirdStep()
//                .selectPaymentMethod(PaymentMethod.CASH_ON_DELIVERY)
//                .clickConfirm()
//                .verifySuccessfulMessageIsPresent()
//                .clickConfirm()
//                .verifySuccessfulMessageIsPresent();
//
//        // Verify cart is not shown in the header
//        Assertions.assertFalse(header().isButtonPresent(header().OPEN_CART_BUTTON));
//    }
//}
