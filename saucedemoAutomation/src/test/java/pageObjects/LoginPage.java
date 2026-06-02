package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement txtUserName;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[contains(text(),\"Epic sadface: Username and password do not match a\")]")
    WebElement errorMessage;

    public void setUserName(String username){
        txtUserName.sendKeys(username);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public boolean checkErrorExists(){
        try{
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
