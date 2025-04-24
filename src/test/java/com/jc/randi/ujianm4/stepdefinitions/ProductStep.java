package com.jc.randi.ujianm4.stepdefinitions;

import com.jc.randi.ujianm4.Pages.LoginPage;
import com.jc.randi.ujianm4.Pages.ProductPage;
import com.jc.randi.ujianm4.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStep {
    ProductPage productsPage = new ProductPage(DriverManager.getDriver());

    @Given("I am logged in with username {string} and password {string}")
    public void i_am_logged_in_with_username_and_password(String username, String password) {
        DriverManager.getDriver().get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }

    @Then("I should see at least one product in the list")
    public void i_should_see_at_least_one_product_in_the_list() throws InterruptedException {
        Assert.assertTrue(productsPage.getProductCount() > 0);
        Thread.sleep(1500);
    }

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Then("the cart should contain the added item")
    public void the_cart_should_contain_the_added_item() throws InterruptedException {
        productsPage.clickCartIcon();
        Thread.sleep(1500);
    }

    @Then("the cart should display {string}")
    public void the_cart_should_display(String expectedItem) {
        System.out.println(productsPage.getNameCart());
        Assert.assertEquals(expectedItem, productsPage.getNameCart());
    }
}
