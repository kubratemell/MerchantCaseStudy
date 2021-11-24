package tests;

import com.thoughtworks.gauge.Step;
import models.BasketModel;
import models.ProductModel;
import org.junit.Assert;

public class BasketTest {

    BasketModel model;
    ProductModel productModel;

    public BasketTest() {
        model = new BasketModel();
        productModel = new ProductModel();
    }

    @Step("Seçilen ürün sepete eklenir")
    public void clickAddToCardButton() {
        model.clickAddToCardButton();
    }

    @Step("Farklı bir satıcıdan ürün sepete eklenir")
    public void clickOtherMerchantButton() {
        model.scrollBar(200);
        model.clickOtherMerchantButton();
    }

    @Step("Sepet butonuna tıklanır")
    public void clickBasketButton() {
        model.scrollBar(0);
        model.clickBasketButton();
    }

    @Step("Seçilen ürünlerin sepete doğru olarak eklendiği kontrol edilir")
    public void checkBasket() {
        Assert.assertEquals("2 ürün", model.checkBasket());
    }
}
