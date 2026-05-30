package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"app_logo\"]")
    WebElement txtHeading;

    @FindBy(xpath = "//div[@id=\"inventory_container\"]//div//div[@id=\"inventory_container\"]")
    WebElement productList;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNameList;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPriceList;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    WebElement sortByDropDown;

    @FindBy(xpath = "//span[@class=\"shopping_cart_badge\"]")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;

    @FindBy(id = "checkout")
    WebElement checkOutButton;

    public boolean isProductPageExists(){
        try{
            return txtHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProductListDisplayed(){
        try{
            return productList.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areProductNamesVisible(){

        for(WebElement product : productNameList){
            if(product.getText().trim().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void selectSortOption(String selectOption){
        Select select = new Select(sortByDropDown);
        select.selectByVisibleText(selectOption);
    }

    public List<String> getProductNames(){

        List<String> names = new ArrayList<>();

        for(WebElement product : productNameList){
            names.add(product.getText());
        }

        return names;
    }

    public List<Double> getProductPrices(){
        List<Double> prices = new ArrayList<>();

        for (WebElement product : productPriceList){
            String price = product.getText().replace("$","");
            prices.add(Double.parseDouble(price));
        }

        return prices;
    }

    public void addOrRemoveProduct(String productName) {

        driver.findElement(
                By.xpath("//div[text()='" + productName +
                        "']/ancestor::div[@class='inventory_item']//button")
        ).click();
    }

    public String getCartCount(){
       return cartBadge.getText();
    }

    public void openCart() {
        cartButton.click();
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(By.className("shopping_cart_badge")).isEmpty();
    }

    public void checkOut(){
        checkOutButton.click();
    }


}
