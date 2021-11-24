package models;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginModel extends Driver {

    WebDriverWait wait;

    public LoginModel() {
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, 10);
    }


    @FindBy(id = "myAccount")
    public WebElement btnAccount;

    @FindBy(id = "login")
    public WebElement login;

    @FindBy(id = "txtUserName")
    public WebElement txtUserName;

    @FindBy(id = "btnLogin")
    public WebElement btnLogin;

    @FindBy(id = "txtPassword")
    public WebElement txtPassword;

    @FindBy(id = "btnEmailSelect")
    public WebElement btnEmailSelect;

    @FindBy(className = "sf-OldMyAccount-1k66b")
    public WebElement myAccount;

    public void getUrl() {
        webDriver.get("https://www.hepsiburada.com/");
    }

    public void elementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickAccountButton() {
        btnAccount.click();
    }

    public void clickLogin() {
        elementClickable(login);
        login.click();
    }

    public void setUserName(String eMail) {
        elementClickable(txtUserName);
        txtUserName.sendKeys(eMail);
    }

    public void clickLoginButton() {

        btnLogin.click();
    }

    public void setPassword(String password) {
        elementClickable(txtPassword);
        txtPassword.sendKeys(password);
    }

    public void clickEmailSelectButton() {

        btnEmailSelect.click();
    }

    public String checkMyAccount() {
        elementClickable(myAccount);
        return myAccount.getText();
    }
}
