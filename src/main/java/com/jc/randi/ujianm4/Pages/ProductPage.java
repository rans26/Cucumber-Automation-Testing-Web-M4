package com.jc.randi.ujianm4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;

    private By title = By.className("title");
    private By inventoryItems = By.className("inventory_item");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartItemName = By.xpath("//div[@class='inventory_item_name']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
    }

    public int getProductCount() {
        return driver.findElements(inventoryItems).size();
    }

    public void addProductToCart(String productName) {
        String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public String getNameCart() {
        return driver.findElement(cartItemName).getText();
    }


}
