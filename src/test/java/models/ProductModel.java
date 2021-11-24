package models;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductModel extends Driver {

    WebDriverWait wait;
    Random random;
    public String productName;
    public  ProductModel() {
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, 10);
        random = new Random();
    }

    @FindBy(className="desktopOldAutosuggestTheme-input")
    public WebElement txtSearch;

    @FindBy(className="SearchBoxOld-buttonContainer")
    public WebElement btnSearch;

    @FindBy(className="productListContent-item")
    public WebElement productList;

    @FindBy(xpath="//*[@id='product-name'][1]")
    public WebElement txtProductName;


    public void elementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void setSearch(String product) {
        elementClickable(txtSearch);
        txtSearch.sendKeys(product);
    }

    public void clickSearchButton() {
        btnSearch.click();
    }

    public void clickProduct() {
        elementClickable(productList);
        List<WebElement> products = webDriver.findElements(By.className("productListContent-item"));
        int index = random.nextInt(products.size());
        products.get(index).click();
    }

    public void switchToWindow() {
        for(String winHandle : webDriver.getWindowHandles()){ webDriver.switchTo().window(winHandle); }
    }

    public String getProductName() {
        elementClickable(txtProductName);
        productName = txtProductName.getText();
        System.out.println(productName);
        return productName;
    }
}
