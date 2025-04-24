package com.jc.randi.ujianm4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CheckoutPage {
    private WebDriver driver;

    private By continueButton = By.xpath("//input[@id='continue']");
    private By finishButton = By.xpath("//button[@id='finish']");
    private By firstNameField = By.xpath("//input[@id='first-name']");
    private By lastNameField = By.xpath("//input[@id='last-name']");
    private By zipCodeField = By.xpath("//input[@id='postal-code']");
    private By paymentInfo = By.className("summary_value_label");
    private By itemTotal = By.className("summary_subtotal_label");
    private By completeHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutInformation(Map<String, String> info) {
        driver.findElement(firstNameField).sendKeys(info.get("First Name"));
        driver.findElement(lastNameField).sendKeys(info.get("Last Name"));
        driver.findElement(zipCodeField).sendKeys(info.get("Zip Code"));
    }

    public void continueToOverview() {
        driver.findElement(continueButton).click();
    }

    public String getPaymentInfo() {
        List<WebElement> infoElements = driver.findElements(paymentInfo);
        return infoElements.get(0).getText();
    }

    public String getShippingInfo() {
        List<WebElement> infoElements = driver.findElements(paymentInfo);
        return infoElements.get(1).getText();
    }

    public String getItemTotal() {
        return driver.findElement(itemTotal).getText();
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText();
    }
}
