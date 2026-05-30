package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class=\"title\"]")
    WebElement title;

    public String getPageTitle(){
        return title.getText();
    }

}
