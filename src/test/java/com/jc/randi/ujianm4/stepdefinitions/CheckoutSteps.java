package com.jc.randi.ujianm4.stepdefinitions;

import com.jc.randi.ujianm4.Pages.CartPage;
import com.jc.randi.ujianm4.Pages.CheckoutPage;
import com.jc.randi.ujianm4.Pages.ProductPage;
import com.jc.randi.ujianm4.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CheckoutSteps {
    ProductPage productsPage = new ProductPage(DriverManager.getDriver());
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        productsPage.goToCart();
        cartPage = new CartPage(DriverManager.getDriver());
        cartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage(DriverManager.getDriver());
    }

    @And("I enter checkout information:")
    public void i_enter_checkout_information(Map<String, String> info) throws InterruptedException {
        checkoutPage.enterCheckoutInformation(info);
        Thread.sleep(1000);
    }

    @And("I continue to overview")
    public void i_continue_to_overview() {
        checkoutPage.continueToOverview();
    }

    @Then("I should see payment information")
    public void i_should_see_payment_info() {
        Assert.assertNotNull(checkoutPage.getPaymentInfo());
    }

    @Then("I should see shipping information")
    public void i_should_see_shipping_info() {
        Assert.assertNotNull(checkoutPage.getShippingInfo());
    }

    @Then("I should see item total")
    public void i_should_see_item_total() {
        Assert.assertNotNull(checkoutPage.getItemTotal());
    }

    @When("I finish the checkout")
    public void i_finish_the_checkout() {
        checkoutPage.finishCheckout();
    }

    @Then("I should see the complete page")
    public void i_should_see_complete_page() {
        Assert.assertTrue(checkoutPage.getConfirmationMessage().contains("Thank you"));
    }

    @Then("I should see the confirmation message {string}")
    public void i_should_see_confirmation_message(String message) throws InterruptedException {
        Assert.assertEquals(message, checkoutPage.getConfirmationMessage());
        Thread.sleep(1500);
    }
}