package tests;

import com.thoughtworks.gauge.Step;
import models.LoginModel;
import models.ProductModel;

public class ProductTest {

    ProductModel model;

    public ProductTest() {
        model = new ProductModel();
    }

    @Step("Arama alanına <key> yazılır")
    public void setSearch(String product) {
        model.setSearch(product);
    }

    @Step("Ara butonuna tıklanır")
    public void clickSearchButton() {
        model.clickSearchButton();
    }

    @Step("Listelenen ürünlerden rastgele bir ürün seçilir")
    public void clickProduct() {
        model.clickProduct();
        model.switchToWindow();
        model.getProductName();
    }
}
