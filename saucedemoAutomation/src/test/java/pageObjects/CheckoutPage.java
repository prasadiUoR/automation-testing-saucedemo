package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class=\"title\"]")
    WebElement title;

    @FindBy(xpath = "//button[@id=\"finish\"]")
    WebElement finishButton;

    public String getPageTitle(){
        return title.getText();
    }

    public void completeOrder(){
        finishButton.click();
    }

}
