package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutFormPage extends BasePage{
    public CheckoutFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCode;

    @FindBy(xpath = "//input[@id=\"continue\"]")
    WebElement continueButton;

    @FindBy(css = "[data-test='error']")
    WebElement errorMessage;

    public void enterCheckoutInfo(
            String fName,
            String lName,
            String zipCode){

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        postalCode.sendKeys(zipCode);
    }

    public void clickContinue(){
        continueButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
