package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }



    public boolean isProductInCart(String productName){

        return !driver.findElements(
                By.xpath("//div[@class='inventory_item_name' and text()='"
                        + productName + "']")
        ).isEmpty();
    }

    public List<String> getCartProducts() {

        return driver.findElements(
                By.className("inventory_item_name")
        ).stream().map(WebElement::getText).toList();
    }

    public void removeProduct(String productName) {

        driver.findElement(
                By.xpath("//div[text()='" + productName +
                        "']/ancestor::div[@class='cart_item']//button")
        ).click();
    }

}
