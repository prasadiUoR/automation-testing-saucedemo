package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ProductPage;

import java.util.Arrays;
import java.util.List;

public class TS003CartTestCase extends BaseClass{

    /*
      Verify multiple products can be added
      Test case id :TC_CF_003
     */
    @Test
    public void verifyMultipleProductsCanBeAdded() {
        logger.info("****Starting TC_CF_003 test case****");
        userLogin();

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        List<String> products = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        );

        for(String product : products){
            productPage.addOrRemoveProduct(product);
        }

        productPage.openCart();

        for(String product : products){
            Assert.assertTrue(
                    cartPage.isProductInCart(product),
                    product + " not found in cart"
            );
        }
        logger.info("****Finished TC_CF_003 test case****");
    }

    /**
     * Verify removing product from inventory page
     * Test case id TC_CF_004
     */
    @Test
    public void verifyRemoveProductFromCart() {
        logger.info("****Starting TC_CF_004 test case****");
        userLogin();

        ProductPage productPage = new ProductPage(driver);

        String product = "Sauce Labs Backpack";

        productPage.addOrRemoveProduct(product);

        Assert.assertTrue(
                productPage.isCartBadgeDisplayed(),
                "Product was not added"
        );

        productPage.addOrRemoveProduct(product);

        Assert.assertFalse(
                productPage.isCartBadgeDisplayed(),
                "Product was not removed from cart"
        );
        logger.info("****Finished TC_CF_004 test case****");
    }

    /**
     * Verify cart page displays selected products
     * Test case id TC_CF_005
     */
    @Test
    public void verifyCartDisplaysSelectedProducts() {
        logger.info("****Starting TC_CF_005 test case****");
        userLogin();

        ProductPage productPage = new ProductPage(driver);

        String product1 = "Sauce Labs Backpack";
        String product2 = "Sauce Labs Bike Light";

        productPage.addOrRemoveProduct(product1);
        productPage.addOrRemoveProduct(product2);

        productPage.openCart();

        CartPage cartPage = new CartPage(driver);

        List<String> cartItems = cartPage.getCartProducts();

        Assert.assertTrue(cartItems.contains(product1), product1 + " not in cart");
        Assert.assertTrue(cartItems.contains(product2), product2 + " not in cart");
        logger.info("****Finished TC_CF_005 test case****");
    }

    /*
    Verify removing product from cart page
    Test case id : TC_CF_006
     */
    @Test
    public void verifyRemoveProductFromCartPage() {
        logger.info("****Starting TC_CF_006 test case****");
        userLogin();

        ProductPage productPage = new ProductPage(driver);

        String product = "Sauce Labs Backpack";

        productPage.addOrRemoveProduct(product);
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isProductInCart(product));

        cartPage.removeProduct(product);

        Assert.assertFalse(cartPage.isProductInCart(product),
                "Product was not removed from cart");

        logger.info("****Finished TC_CF_006 test case****");
    }
}
