package models;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BasketModel extends Driver {

    WebDriverWait wait;

    public  BasketModel() {
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, 10);
    }

    @FindBy(xpath="//button[@id='addToCart']")
    public WebElement btnAddToCart;

    @FindBy(className="checkoutui-Modal-2iZXl")
    public WebElement btnClose;

    @FindBy(xpath="//button[(@class='add-to-basket button small')][1]")
    public WebElement btnOtherMerchant;

    @FindBy(xpath="//*[@id='shoppingCart' and text()='Sepetim']")
    public WebElement btnBasket;

    @FindBy(className="basket_itemCount_54lDX")
    public  WebElement txtProductNumber;

    @FindBy(xpath="//*[@class='product_name_3Lh3t'][1]")
    public WebElement txtBasketProduct;

    public void elementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickAddToCardButton() {
        elementClickable(btnAddToCart);
        btnAddToCart.click();
        elementClickable(btnClose);
        btnClose.click();
    }

    public void clickOtherMerchantButton() {
        elementClickable(btnOtherMerchant);
        btnOtherMerchant.click();
        elementClickable(btnClose);
        btnClose.click();
    }

    public void scrollBar (int pixel) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0," + pixel + ")");
    }

    public void clickBasketButton(){
        elementClickable(btnBasket);
        btnBasket.click();
    }

    public String checkBasket() {
        elementClickable(txtProductNumber);
        return txtProductNumber.getText();
    }

    public String getBasketProduct() {
        elementClickable(txtBasketProduct);
        return txtBasketProduct.getText();

    }

}
