package tests;

import com.thoughtworks.gauge.Step;
import models.LoginModel;
import org.junit.Assert;

public class LoginTest {

    LoginModel model;

    public LoginTest() {
        model = new LoginModel();
    }

    @Step("Hepsiburada sitesine gidilir")
    public void getUrl() {
        model.getUrl();
    }

    @Step("Giriş yap veya üye ol butonuna tıklanır")
    public void clickAccountButton() {
        model.clickAccountButton();
    }

    @Step("Açılan menüde Giriş Yap tıklanır")
    public void clickLogin() {
        model.clickLogin();
    }

    @Step("E-posta veya Telefon Numarası <key> girilir")
    public void setUserName(String eMail) {
        model.setUserName(eMail);
    }

    @Step("Giriş yap butonuna tıklanır")
    public void clickLoginButton() {
        model.clickLoginButton();
    }

    @Step("Şifre <key> girilir")
    public void setPassword(String password) {
        model.setPassword(password);
    }

    @Step("Giriş yap butonuna tıklanır ve login olduğu görülür")
    public void clickEmailSelectButton() {
        model.clickEmailSelectButton();
        Assert.assertEquals("test tester",model.checkMyAccount());
    }
}
