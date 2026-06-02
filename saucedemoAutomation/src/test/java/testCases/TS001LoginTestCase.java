package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utilities.DataProviders;


public class TS001LoginTestCase extends BaseClass {

    /*
    Test logging in with a valid username and password.
    Test case id : TC_LF_001
     */
    @Test
    public void loginTest() {
        logger.info("****Starting TC_LF_001 test case****");

        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUserName(p.getProperty("valid_userName"));
            loginPage.setPassword(p.getProperty("valid_password"));
            loginPage.clickLogin();

            ProductPage productPage = new ProductPage(driver);
            boolean isTargetPageExists = productPage.isProductPageExists();

            Assert.assertTrue(isTargetPageExists);
        } catch (Exception e) {
            logger.error("Test TC_LF_001 failed", e);
            Assert.fail(e.getMessage());
        }

        logger.info("****Finished TC_LF_001 test case****");
    }

    /*
    Test logging in with a valid username and invalid password.
    Test case id : TC_LF_002
     */
    @Test
    public void invalidLoginTest() {
        logger.info("****Starting TC_LF_002 test case****");
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUserName(p.getProperty("valid_userName"));
            loginPage.setPassword("1234");
            loginPage.clickLogin();

            Assert.assertTrue(loginPage.checkErrorExists());
            System.out.println(loginPage.getErrorMessage());
        } catch (Exception e) {
            logger.error("Test TC_LF_002 failed", e);
            Assert.fail(e.getMessage());
        }
        logger.info("****Finished TC_LF_002 test case****");
    }

    /*
    Test logging in with a valid username and invalid password.
    This is set to failure intentionally. In order to generate failure in extent report
    */
    @Test
    public void loginTestFailure() {
        logger.info("****Starting login test failure test case****");

        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUserName(p.getProperty("valid_userName"));
            loginPage.setPassword("invalid_password");
            loginPage.clickLogin();

            ProductPage productPage = new ProductPage(driver);
            boolean isTargetPageExists = productPage.isProductPageExists();

            Assert.assertTrue(isTargetPageExists);
        } catch (Exception e) {
            logger.error("Test TC_LF_001 failed", e);
            Assert.fail(e.getMessage());
        }

        logger.info("****Finished login test failure test case****");
    }

    @Test(groups = {"DataDriven"}, dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void loginDDT(String userName, String password, String expectedResult){
        logger.info("****Starting Data Driven login test ****");
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.setUserName(userName);
            loginPage.setPassword(password);
            loginPage.clickLogin();

            ProductPage productPage = new ProductPage(driver);
            boolean isTargetPageExists = productPage.isProductPageExists();

            if (expectedResult.equalsIgnoreCase("TRUE")) {
                if (isTargetPageExists) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }

            if (expectedResult.equalsIgnoreCase("FALSE")) {
                if (!isTargetPageExists) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }

        } catch (Exception e) {
            logger.error("Test TC_LF_001 failed", e);
            Assert.fail(e.getMessage());
        }

        logger.info("****Finished Data Driven login test****");
    }
}
