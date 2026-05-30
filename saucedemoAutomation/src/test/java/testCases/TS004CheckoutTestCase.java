package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutCompletePage;
import pageObjects.CheckoutFormPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;

public class TS004CheckoutTestCase extends BaseClass{

    public void addItemAndOpenCheckout(){

        userLogin();
        ProductPage productPage = new ProductPage(driver);
        productPage.addOrRemoveProduct("Sauce Labs Backpack");
        productPage.openCart();
        productPage.checkOut();
    }

    /*
       Verify checkout with valid information
       Test case id : TC_CKF_001
     */
    @Test
    public void verifyCheckoutWithValidInfo(){

        logger.info("****Starting TC_CKF_001 test case****");
        addItemAndOpenCheckout();

        CheckoutFormPage checkoutFormPage =
                new CheckoutFormPage(driver);

        checkoutFormPage.enterCheckoutInfo(
                "Prasadi",
                "Nishshanka",
                "12345"
        );

        checkoutFormPage.clickContinue();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(
                checkoutPage.getPageTitle(),
                "Checkout: Overview"
        );
        logger.info("****Starting TC_CKF_001 test case****");
    }

    /**
     * Verify checkout with empty first name
     * Test case id: TC_CKF_002
     */
    @Test
    public void verifyCheckoutEmptyFirstName(){
        logger.info("****Starting TC_CKF_002 test case****");
        addItemAndOpenCheckout();

        CheckoutFormPage checkoutFormPage =
                new CheckoutFormPage(driver);

        checkoutFormPage.enterCheckoutInfo(
                "",
                "Nishshanka",
                "12345"
        );

        checkoutFormPage.clickContinue();

        Assert.assertEquals(
                checkoutFormPage.getErrorMessage(),
                "Error: First Name is required"
        );
        logger.info("****Starting TC_CKF_002 test case****");
    }

    /**
     * Verify checkout with empty postal code
     * Test case id: TC_CKF_003
     */
    @Test
    public void verifyCheckoutEmptyPostalCode(){
        logger.info("****Starting TC_CKF_003 test case****");
        addItemAndOpenCheckout();

        CheckoutFormPage checkoutFormPage =
                new CheckoutFormPage(driver);

        checkoutFormPage.enterCheckoutInfo(
                "John",
                "Smith",
                ""
        );

        checkoutFormPage.clickContinue();

        Assert.assertEquals(
                checkoutFormPage.getErrorMessage(),
                "Error: Postal Code is required"
        );
        logger.info("****Starting TC_CKF_003 test case****");
    }

    /*
    Verify successful order completion
    Test case id: TC_CKF_004
     */
    @Test
    public void verifySuccessfulOrderCompletion(){
        logger.info("****Starting TC_CKF_004 test case****");
        addItemAndOpenCheckout();

        CheckoutFormPage checkoutFormPage =
                new CheckoutFormPage(driver);

        checkoutFormPage.enterCheckoutInfo(
                "Prasadi",
                "Nishshanka",
                "12345"
        );

        checkoutFormPage.clickContinue();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.completeOrder();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutCompletePage.getPageTitle();

        Assert.assertEquals(checkoutCompletePage.getPageTitle(),
                "Checkout: Complete!");
        logger.info("****Starting TC_CKF_004 test case****");

    }
}
