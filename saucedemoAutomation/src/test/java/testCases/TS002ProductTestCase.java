package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TS002ProductTestCase extends BaseClass {

    /*
    Verify product list is displayed.
    Test case id : TC_PF_001
     */
    @Test
    public void verifyProductList() {
        logger.info("****Starting TC_PF_001 test case****");
        try {
            userLogin();
            ProductPage productPage = new ProductPage(driver);
            Assert.assertTrue(productPage.isProductListDisplayed(), "Product list is not displayed");
        } catch (Exception e) {
            logger.error("Test TC_PF_001 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_PF_001 test case****");
    }

    /*
    Verify product names are visible
    Test case id : TC_PF_002
     */
    @Test
    public void isProductNamesVisible() {
        logger.info("****Starting TC_PF_002 test case****");
        try {
            userLogin();
            ProductPage productPage = new ProductPage(driver);
            Assert.assertTrue(productPage.areProductNamesVisible(), "Product names are not visible");
        } catch (Exception e) {
            logger.error("Test TC_PF_002 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_PF_002 test case****");
    }

    /*
    Verify product sorting by name A-Z
    Test case id :TC_PF_004
     */
    @Test
    public void verifyProductSortAz() {
        logger.info("****Starting TC_PF_004 test case****");
        try {
            userLogin();
            ProductPage productPage = new ProductPage(driver);
            productPage.selectSortOption("Name (A to Z)");

            List<String> productList = productPage.getProductNames();
            List<String> expectedList = new ArrayList<>(productList);

            Collections.sort(expectedList);

            Assert.assertEquals(productList,expectedList,"Products are not sorted in ascending order");
        } catch (Exception e) {
            logger.error("Test TC_PF_004 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_PF_004 test case****");
    }

    /*
    Verify product sorting by name Z-A
    Test case id :TC_PF_005
     */
    @Test
    public void verifyProductSortZa() {
        logger.info("****Starting TC_PF_005 test case****");
        try {
            userLogin();
            ProductPage productPage = new ProductPage(driver);
            productPage.selectSortOption("Name (Z to A)");

            List<String> productList = productPage.getProductNames();
            List<String> expectedList = new ArrayList<>(productList);

            expectedList.sort(Collections.reverseOrder());

            Assert.assertEquals(productList, expectedList, "Products are not sorted in distending order");
        } catch (Exception e) {
            logger.error("Test TC_PF_005 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_PF_005 test case****");
    }

    /*
    Verify product sorting by price low-high
    Test case id :TC_PF_006
     */
    @Test
    public void verifyProductSortPriceLowHigh() {
        logger.info("****Starting TC_PF_006 test case****");
        try {
            userLogin();
            ProductPage productPage = new ProductPage(driver);
            productPage.selectSortOption("Price (low to high)");

            List<Double> productList = productPage.getProductPrices();
            List<Double> expectedList = new ArrayList<>(productList);

            Collections.sort(expectedList);

            Assert.assertEquals(productList, expectedList, "Products are not sorted in prices from low to high");
        } catch (Exception e) {
            logger.error("Test TC_PF_006 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_PF_006 test case****");
    }

    /*
    Verify product sorting by price high-low
    Test case id :TC_PF_006
     */
    @Test
    public void verifyProductSortPriceHighLow() {
        logger.info("****Starting TC_PF_007 test case****");
        try {
            userLogin();
            ProductPage productPage = new ProductPage(driver);
            productPage.selectSortOption("Price (high to low)");

            List<Double> productList = productPage.getProductPrices();
            List<Double> expectedList = new ArrayList<>(productList);

            expectedList.sort(Collections.reverseOrder());

            Assert.assertEquals(productList, expectedList, "Products are not sorted in prices from high to low");
        } catch (Exception e) {
            logger.error("Test TC_PF_007 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_PF_007 test case****");
    }

    /*
    Verify adding product to cart
    Test case id :TC_CF_001
    */
    @Test
    public void verifyAddProductToCart(){
        logger.info("****Starting TC_CF_001 test case****");
        try {
            userLogin();
            ProductPage productPage = new ProductPage(driver);
            productPage.addOrRemoveProduct("Sauce Labs Backpack");

            Assert.assertEquals(productPage.getCartCount(), "1", "Cart count mismatch");
        } catch (Exception e) {
            logger.error("Test TC_CF_001 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_CF_001 test case****");
    }

}
